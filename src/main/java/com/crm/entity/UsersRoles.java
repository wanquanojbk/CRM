package com.crm.entity;

public class UsersRoles {
	private Integer usersRoles_Id;//用户角色编号
	private Integer usersRoles_UserId;//用户编号
	private Integer usersRoles_RoleId;//角色编号
	private Integer usersRoles_Exit1;//预留字段1
	private String usersRoles_Exit2;//预留字段2
	public UsersRoles(Integer usersRoles_Id, Integer usersRoles_UserId, Integer usersRoles_RoleId,
			Integer usersRoles_Exit1, String usersRoles_Exit2) {
		super();
		this.usersRoles_Id = usersRoles_Id;
		this.usersRoles_UserId = usersRoles_UserId;
		this.usersRoles_RoleId = usersRoles_RoleId;
		this.usersRoles_Exit1 = usersRoles_Exit1;
		this.usersRoles_Exit2 = usersRoles_Exit2;
	}
	public UsersRoles() {
		super();
	}
	public Integer getUsersRoles_Id() {
		return usersRoles_Id;
	}
	public void setUsersRoles_Id(Integer usersRoles_Id) {
		this.usersRoles_Id = usersRoles_Id;
	}
	public Integer getUsersRoles_UserId() {
		return usersRoles_UserId;
	}
	public void setUsersRoles_UserId(Integer usersRoles_UserId) {
		this.usersRoles_UserId = usersRoles_UserId;
	}
	public Integer getUsersRoles_RoleId() {
		return usersRoles_RoleId;
	}
	public void setUsersRoles_RoleId(Integer usersRoles_RoleId) {
		this.usersRoles_RoleId = usersRoles_RoleId;
	}
	public Integer getUsersRoles_Exit1() {
		return usersRoles_Exit1;
	}
	public void setUsersRoles_Exit1(Integer usersRoles_Exit1) {
		this.usersRoles_Exit1 = usersRoles_Exit1;
	}
	public String getUsersRoles_Exit2() {
		return usersRoles_Exit2;
	}
	public void setUsersRoles_Exit2(String usersRoles_Exit2) {
		this.usersRoles_Exit2 = usersRoles_Exit2;
	}
	@Override
	public String toString() {
		return "UsersRoles [usersRoles_Id=" + usersRoles_Id + ", usersRoles_UserId=" + usersRoles_UserId
				+ ", usersRoles_RoleId=" + usersRoles_RoleId + ", usersRoles_Exit1=" + usersRoles_Exit1
				+ ", usersRoles_Exit2=" + usersRoles_Exit2 + "]";
	}
}
