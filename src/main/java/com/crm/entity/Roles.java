package com.crm.entity;

import java.util.List;

public class Roles {
	private Integer roles_Id;//角色编号
	private String roles_Name;//角色名称
	private Integer roles_Exit1;//预留字段1
	private String roles_Exit2;//预留字段2
	private List<Users> users;//用户集合
	private List<Modules> modules;//模块集合

	public Roles(Integer roles_Id, String roles_Name, Integer roles_Exit1, String roles_Exit2, List<Users> users,
			List<Modules> modules) {
		super();
		this.roles_Id = roles_Id;
		this.roles_Name = roles_Name;
		this.roles_Exit1 = roles_Exit1;
		this.roles_Exit2 = roles_Exit2;
		this.users = users;
		this.modules = modules;
	}
	public Roles() {
		super();
	}
	public Integer getRoles_Id() {
		return roles_Id;
	}
	public void setRoles_Id(Integer roles_Id) {
		this.roles_Id = roles_Id;
	}
	public String getRoles_Name() {
		return roles_Name;
	}
	public void setRoles_Name(String roles_Name) {
		this.roles_Name = roles_Name;
	}
	public Integer getRoles_Exit1() {
		return roles_Exit1;
	}
	public void setRoles_Exit1(Integer roles_Exit1) {
		this.roles_Exit1 = roles_Exit1;
	}
	public String getRoles_Exit2() {
		return roles_Exit2;
	}
	public void setRoles_Exit2(String roles_Exit2) {
		this.roles_Exit2 = roles_Exit2;
	}
	public List<Users> getUsers() {
		return users;
	}
	public void setUsers(List<Users> users) {
		this.users = users;
	}
	
	public List<Modules> getModules() {
		return modules;
	}
	public void setModules(List<Modules> modules) {
		this.modules = modules;
	}
	@Override
	public String toString() {
		return "Roles [roles_Id=" + roles_Id + ", roles_Name=" + roles_Name + ", roles_Exit1=" + roles_Exit1
				+ ", roles_Exit2=" + roles_Exit2 + ", users=" + users + ", modules=" + modules + "]";
	}
}
