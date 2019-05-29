package com.crm.entity;

import org.springframework.stereotype.Component;

@Component
public class Permissiontb {
	private Integer permissiontb_Id;//权限编号
	private String permissiontb_Value;//权限值
	private String permissiontb_Module;//权限模块
	private String permissiontb_Name;//权限名
	private Integer permissiontb_ModuleId; //关联模块Id
	private Integer permissiontb_Exit1;//预留字段1
	private String permissiontb_Exit2;//预留字段2
	public Integer getPermissiontb_Id() {
		return permissiontb_Id;
	}
	public void setPermissiontb_Id(Integer permissiontb_Id) {
		this.permissiontb_Id = permissiontb_Id;
	}
	public String getPermissiontb_Value() {
		return permissiontb_Value;
	}
	public void setPermissiontb_Value(String permissiontb_Value) {
		this.permissiontb_Value = permissiontb_Value;
	}
	public String getPermissiontb_Module() {
		return permissiontb_Module;
	}
	public void setPermissiontb_Module(String permissiontb_Module) {
		this.permissiontb_Module = permissiontb_Module;
	}
	public String getPermissiontb_Name() {
		return permissiontb_Name;
	}
	public void setPermissiontb_Name(String permissiontb_Name) {
		this.permissiontb_Name = permissiontb_Name;
	}
	public Integer getPermissiontb_ModuleId() {
		return permissiontb_ModuleId;
	}
	public void setPermissiontb_ModuleId(Integer permissiontb_ModuleId) {
		this.permissiontb_ModuleId = permissiontb_ModuleId;
	}
	public Integer getPermissiontb_Exit1() {
		return permissiontb_Exit1;
	}
	public void setPermissiontb_Exit1(Integer permissiontb_Exit1) {
		this.permissiontb_Exit1 = permissiontb_Exit1;
	}
	public String getPermissiontb_Exit2() {
		return permissiontb_Exit2;
	}
	public void setPermissiontb_Exit2(String permissiontb_Exit2) {
		this.permissiontb_Exit2 = permissiontb_Exit2;
	}
	public Permissiontb(Integer permissiontb_Id, String permissiontb_Value, String permissiontb_Module,
			String permissiontb_Name, Integer permissiontb_ModuleId, Integer permissiontb_Exit1,
			String permissiontb_Exit2) {
		super();
		this.permissiontb_Id = permissiontb_Id;
		this.permissiontb_Value = permissiontb_Value;
		this.permissiontb_Module = permissiontb_Module;
		this.permissiontb_Name = permissiontb_Name;
		this.permissiontb_ModuleId = permissiontb_ModuleId;
		this.permissiontb_Exit1 = permissiontb_Exit1;
		this.permissiontb_Exit2 = permissiontb_Exit2;
	}
	public Permissiontb() {
		super();
	}
	@Override
	public String toString() {
		return "Permissiontb [permissiontb_Id=" + permissiontb_Id + ", permissiontb_Value=" + permissiontb_Value
				+ ", permissiontb_Module=" + permissiontb_Module + ", permissiontb_Name=" + permissiontb_Name
				+ ", permissiontb_ModuleId=" + permissiontb_ModuleId + ", permissiontb_Exit1=" + permissiontb_Exit1
				+ ", permissiontb_Exit2=" + permissiontb_Exit2 + "]";
	}
	
}
