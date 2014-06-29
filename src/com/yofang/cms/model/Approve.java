package com.yofang.cms.model;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * @author hsh
 *
 */
/**
 * @author hsh
 *
 */
@Table("MANAGE_APPROVE")
public class Approve implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	/** 审批人 */
	private String approveName;
	/** 角色 */
	private String roleName;
	/** 审批节点 */
	private int approveState;
	/** 审批时间 */
	private Date approveTime;
	/** 审批是否通过 1:通过 2：不通过 3：代表这条记录流程启动时，申请定金支付*/
	private int isPass;
	/** 审批内容 */
	private String approveRemark;
	
	/** 跟客户表一对多关系 */
	private Integer customerId;
	@One(target=Customer.class, field="customerId")
	private Customer customer;
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getApproveName() {
		return approveName;
	}
	public void setApproveName(String approveName) {
		this.approveName = approveName;
	}
	public String getApproveRemark() {
		return approveRemark;
	}
	public void setApproveRemark(String approveRemark) {
		this.approveRemark = approveRemark;
	}
	public int getIsPass() {
		return isPass;
	}
	public void setIsPass(int isPass) {
		this.isPass = isPass;
	}
	public int getApproveState() {
		return approveState;
	}
	public void setApproveState(int approveState) {
		this.approveState = approveState;
	}
	public Date getApproveTime() {
		return approveTime;
	}
	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
