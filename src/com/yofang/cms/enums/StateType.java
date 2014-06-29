package com.yofang.cms.enums;

public enum StateType {
	/**
	 * 状态类型
	 */
	NEWCUSTOMER("新客户",1),
	APPOINTED("已预约",2),
	WATCHED("已看房",3),
	CUSTOMER_CONFIRM("已确认",4),
	DEPOSIT_PAID("已交定金",5),
	PURCHASED ("已购房",6),
	REPLYFROM1("已申请，待批…",7),
	REPLYFROM2("已申请，待批…",8),
	GRANTED("已发放",9);
	//状态名称
	private String name;
	//状态顺序
	private int value;
	
	private StateType(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
