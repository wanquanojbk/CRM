package com.crm.entity;

public class RolePermissiontb {
	private Integer rolePermissiontb_Id;//角色权限编号
	private Integer rolePermissiontb_RoleId;//角色编号
	private Integer rolePermissiontb_PermissionId;//权限编号
	private Integer rolePermissiontb_Exit1;//预留字段1
	private String rolePermissiontb_Exit2;//预留字段2
	public RolePermissiontb(Integer rolePermissiontb_Id, Integer rolePermissiontb_RoleId,
			Integer rolePermissiontb_PermissionId, Integer rolePermissiontb_Exit1, String rolePermissiontb_Exit2) {
		super();
		this.rolePermissiontb_Id = rolePermissiontb_Id;
		this.rolePermissiontb_RoleId = rolePermissiontb_RoleId;
		this.rolePermissiontb_PermissionId = rolePermissiontb_PermissionId;
		this.rolePermissiontb_Exit1 = rolePermissiontb_Exit1;
		this.rolePermissiontb_Exit2 = rolePermissiontb_Exit2;
	}
	public RolePermissiontb() {
		super();
	}
	public Integer getRolePermissiontb_Id() {
		return rolePermissiontb_Id;
	}
	public void setRolePermissiontb_Id(Integer rolePermissiontb_Id) {
		this.rolePermissiontb_Id = rolePermissiontb_Id;
	}
	public Integer getRolePermissiontb_RoleId() {
		return rolePermissiontb_RoleId;
	}
	public void setRolePermissiontb_RoleId(Integer rolePermissiontb_RoleId) {
		this.rolePermissiontb_RoleId = rolePermissiontb_RoleId;
	}
	public Integer getRolePermissiontb_PermissionId() {
		return rolePermissiontb_PermissionId;
	}
	public void setRolePermissiontb_PermissionId(Integer rolePermissiontb_PermissionId) {
		this.rolePermissiontb_PermissionId = rolePermissiontb_PermissionId;
	}
	public Integer getRolePermissiontb_Exit1() {
		return rolePermissiontb_Exit1;
	}
	public void setRolePermissiontb_Exit1(Integer rolePermissiontb_Exit1) {
		this.rolePermissiontb_Exit1 = rolePermissiontb_Exit1;
	}
	public String getRolePermissiontb_Exit2() {
		return rolePermissiontb_Exit2;
	}
	public void setRolePermissiontb_Exit2(String rolePermissiontb_Exit2) {
		this.rolePermissiontb_Exit2 = rolePermissiontb_Exit2;
	}
	@Override
	public String toString() {
		return "RolePermissiontb [rolePermissiontb_Id=" + rolePermissiontb_Id + ", rolePermissiontb_RoleId="
				+ rolePermissiontb_RoleId + ", rolePermissiontb_PermissionId=" + rolePermissiontb_PermissionId
				+ ", rolePermissiontb_Exit1=" + rolePermissiontb_Exit1 + ", rolePermissiontb_Exit2="
				+ rolePermissiontb_Exit2 + "]";
	}
}
