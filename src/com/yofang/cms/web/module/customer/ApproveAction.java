package com.yofang.cms.web.module.customer;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.yofang.cms.manage.ManagerService;
import com.yofang.cms.model.Approve;
import com.yofang.cms.model.Customer;
import com.yofang.cms.model.User;
import com.yofang.cms.service.ApproveService;
import com.yofang.cms.service.CustomerService;

/**
 * 后台管理员渠道管理
 * @author gaozp
 */
@IocBean(scope = "request")
@At("/approve")
public class ApproveAction {
	
	@Inject
	private CustomerService customerService;
	@Inject
	private ApproveService approveService;
	
	@At("/save")
	@Aop({"operateLogInterceptor"})
	public View saveApprove(HttpServletRequest request
			,HttpServletResponse response
			,@Param("customerId") Integer customerId
			,@Param("isPass") int isPass
			,@Param("approveRemark") String approveRemark
			){
		Customer customer = customerService.getById(customerId);
		//当前节点
		int currentApproveState = customer.getApproveState();
		//下一个审批节点
		int nextApproveState = Customer.getNextApproveState(currentApproveState);
		User user = ManagerService.getUser(request);
		
		if (nextApproveState==Customer.APPROVESTATE_END) {
			customer.setState(Customer.STATE_FOLLOW_END);
		}
		customer.setApproveState(nextApproveState);
		//更新客户信息状态
		customerService.updateEntity(customer);
		
		//保存到审批表
		Approve approve = new Approve();
		approve.setApproveState(currentApproveState);
		approve.setApproveName(user.getRealName());
		approve.setApproveRemark(approveRemark);
		approve.setApproveTime(new Date());
		approve.setCustomerId(customerId);
		approve.setIsPass(isPass);
		approve.setRoleName(user.getRole().getName());
		approveService.saveEntity(approve);
		
		String logDesc = Customer.getApproveName(currentApproveState);
		if (isPass == 1 ) {
			logDesc += "审批通过";
		} else if(isPass == 2) {
			logDesc += "审批不通过";
		}
		request.setAttribute("logDesc",logDesc);
		
		try {
			response.sendRedirect(request.getContextPath() + "/customer/tofollow?customerId="+customerId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 已付定金提交确认--审批流程启动
	 * @param request
	 * @param customerId
	 * @return
	 */
	@At("/sdeposit")
	@Aop({"operateLogInterceptor"})
	public View submitDepositApply(HttpServletRequest request, HttpServletResponse response,@Param("customerId") Integer customerId){
		Customer customer = customerService.getById(customerId);
		customer.setState(Customer.STATE_FOLLOW_APPROVAL);
		customer.setApproveState(Customer.getNextApproveState(Customer.APPROVESTATE_DEPOSITAPPLY)); //审批流程启动
		customerService.updateEntity(customer);
		
		User user = ManagerService.getUser(request);
		//保存到审批表
		Approve approve = new Approve();
		approve.setApproveState(Customer.APPROVESTATE_DEPOSITAPPLY);
		approve.setApproveName(user.getRealName());
		approve.setApproveRemark("客户已支付定金，请审批");
		approve.setApproveTime(new Date());
		approve.setCustomerId(customerId);
		approve.setIsPass(3);
		approve.setRoleName(user.getRole().getName());
		approveService.saveEntity(approve);
		
		request.setAttribute("logDesc",customer.getRealName() + "客户已付定金,申请确认");
		try {
			response.sendRedirect(request.getContextPath() + "/customer/tofollow?customerId="+customer.getId());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
