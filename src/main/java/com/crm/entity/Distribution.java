package com.crm.entity;

public class Distribution {
	private Integer distribution_Id;//分配id
	
	private Integer distribution_ManagerId;//关联经理的用户id
	
	private Boolean distribution_Status;//自动分配的开启状态
	
	private Integer distribution_Ext1;//备用字段
	
	private String distribution_Ext2;//备用字段
	
	public Integer getDistribution_Id() {
		return distribution_Id;
	}

	public Integer getDistribution_ManagerId() {
		return distribution_ManagerId;
	}

	public Boolean getDistribution_Status() {
		return distribution_Status;
	}

	public Integer getDistribution_Ext1() {
		return distribution_Ext1;
	}

	public String getDistribution_Ext2() {
		return distribution_Ext2;
	}

	public void setDistribution_Id(Integer distribution_Id) {
		this.distribution_Id = distribution_Id;
	}

	public void setDistribution_ManagerId(Integer distribution_ManagerId) {
		this.distribution_ManagerId = distribution_ManagerId;
	}

	public void setDistribution_Status(Boolean distribution_Status) {
		this.distribution_Status = distribution_Status;
	}

	public void setDistribution_Ext1(Integer distribution_Ext1) {
		this.distribution_Ext1 = distribution_Ext1;
	}

	public void setDistribution_Ext2(String distribution_Ext2) {
		this.distribution_Ext2 = distribution_Ext2;
	}
	
	
}
