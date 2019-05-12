package com.crm.entity;

import java.util.List;

public class Modules {
	private Integer modules_Id;//模块编号
	private String modules_Name;//模块编号
	private Integer modules_ParentId;//模块编号
	private String modules_Path;//模块编号
	private String modules_Weight;//模块编号
	private Integer modules_Exit1;//模块编号
	private String modules_Exit2;//模块编号
	private List<Roles> roles;//角色集合
	public Modules(Integer modules_Id, String modules_Name, Integer modules_ParentId, String modules_Path,
			String modules_Weight, Integer modules_Exit1, String modules_Exit2, List<Roles> roles) {
		super();
		this.modules_Id = modules_Id;
		this.modules_Name = modules_Name;
		this.modules_ParentId = modules_ParentId;
		this.modules_Path = modules_Path;
		this.modules_Weight = modules_Weight;
		this.modules_Exit1 = modules_Exit1;
		this.modules_Exit2 = modules_Exit2;
		this.roles = roles;
	}
	public Modules() {
		super();
	}
	public Integer getModules_Id() {
		return modules_Id;
	}
	public void setModules_Id(Integer modules_Id) {
		this.modules_Id = modules_Id;
	}
	public String getModules_Name() {
		return modules_Name;
	}
	public void setModules_Name(String modules_Name) {
		this.modules_Name = modules_Name;
	}
	public Integer getModules_ParentId() {
		return modules_ParentId;
	}
	public void setModules_ParentId(Integer modules_ParentId) {
		this.modules_ParentId = modules_ParentId;
	}
	public String getModules_Path() {
		return modules_Path;
	}
	public void setModules_Path(String modules_Path) {
		this.modules_Path = modules_Path;
	}
	public String getModules_Weight() {
		return modules_Weight;
	}
	public void setModules_Weight(String modules_Weight) {
		this.modules_Weight = modules_Weight;
	}
	public Integer getModules_Exit1() {
		return modules_Exit1;
	}
	public void setModules_Exit1(Integer modules_Exit1) {
		this.modules_Exit1 = modules_Exit1;
	}
	public String getModules_Exit2() {
		return modules_Exit2;
	}
	public void setModules_Exit2(String modules_Exit2) {
		this.modules_Exit2 = modules_Exit2;
	}
	public List<Roles> getRoles() {
		return roles;
	}
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "Modules [modules_Id=" + modules_Id + ", modules_Name=" + modules_Name + ", modules_ParentId="
				+ modules_ParentId + ", modules_Path=" + modules_Path + ", modules_Weight=" + modules_Weight
				+ ", modules_Exit1=" + modules_Exit1 + ", modules_Exit2=" + modules_Exit2 + ", roles=" + roles + "]";
	}
}
