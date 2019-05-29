package com.crm.entity;

import java.util.List;

public class Users {
	private Integer users_Id;//用户编号
	private String users_LoginName;//用户登录名
	private String users_Password;//用户登陆密码
	private Integer users_LsLockout;//是否锁定
	private String users_LastLoginTime;//最后一次登录时间
	private String users_CreateTime;//账户创立时间
	private Integer users_PsdWrongTime;//密码错误次数
	private String users_LockTime;//被锁定时间
	private String users_ProTectEMail;//密保邮箱
	private String users_ProtectTel;//密保手机号
	private Integer users_Exit1;//预留字段1
	private String users_Exit2;//预留字段2
	private Integer users_CheckInStatus;//签到状态
	private List<Roles> roles;//角色集合
	private Integer users_Weight;
	private Integer users_Count;  //咨询师客户总数
	private Classes classes;//班级
	private Student student;
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Integer getUsers_Count() {
		return users_Count;
	}
	public void setUsers_Count(Integer users_Count) {
		this.users_Count = users_Count;
	}
	public Integer getUsers_Weight() {
		return users_Weight;
	}
	public void setUsers_Weight(Integer users_Weight) {
		this.users_Weight = users_Weight;
	}
	public Integer getUsers_Id() {
		return users_Id;
	}
	public void setUsers_Id(Integer users_Id) {
		this.users_Id = users_Id;
	}
	public String getUsers_LoginName() {
		return users_LoginName;
	}
	public void setUsers_LoginName(String users_LoginName) {
		this.users_LoginName = users_LoginName;
	}
	public String getUsers_Password() {
		return users_Password;
	}
	public void setUsers_Password(String users_Password) {
		this.users_Password = users_Password;
	}
	public Integer getUsers_LsLockout() {
		return users_LsLockout;
	}
	public void setUsers_LsLockout(Integer users_LsLockout) {
		this.users_LsLockout = users_LsLockout;
	}
	public String getUsers_LastLoginTime() {
		return users_LastLoginTime;
	}
	public void setUsers_LastLoginTime(String users_LastLoginTime) {
		this.users_LastLoginTime = users_LastLoginTime;
	}
	public String getUsers_CreateTime() {
		return users_CreateTime;
	}
	public void setUsers_CreateTime(String users_CreateTime) {
		this.users_CreateTime = users_CreateTime;
	}
	public Integer getUsers_PsdWrongTime() {
		return users_PsdWrongTime;
	}
	public void setUsers_PsdWrongTime(Integer users_PsdWrongTime) {
		this.users_PsdWrongTime = users_PsdWrongTime;
	}
	public String getUsers_LockTime() {
		return users_LockTime;
	}
	public void setUsers_LockTime(String users_LockTime) {
		this.users_LockTime = users_LockTime;
	}
	public String getUsers_ProTectEMail() {
		return users_ProTectEMail;
	}
	public void setUsers_ProTectEMail(String users_ProTectEMail) {
		this.users_ProTectEMail = users_ProTectEMail;
	}
	public String getUsers_ProtectTel() {
		return users_ProtectTel;
	}
	public void setUsers_ProtectTel(String users_ProtectTel) {
		this.users_ProtectTel = users_ProtectTel;
	}
	public Integer getUsers_Exit1() {
		return users_Exit1;
	}
	public void setUsers_Exit1(Integer users_Exit1) {
		this.users_Exit1 = users_Exit1;
	}
	public String getUsers_Exit2() {
		return users_Exit2;
	}
	public void setUsers_Exit2(String users_Exit2) {
		this.users_Exit2 = users_Exit2;
	}
	public Integer getUsers_CheckInStatus() {
		return users_CheckInStatus;
	}
	public void setUsers_CheckInStatus(Integer users_CheckInStatus) {
		this.users_CheckInStatus = users_CheckInStatus;
	}
	public List<Roles> getRoles() {
		return roles;
	}
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	public Users(Integer users_Id, String users_LoginName, String users_Password, Integer users_LsLockout,
			String users_LastLoginTime, String users_CreateTime, Integer users_PsdWrongTime, String users_LockTime,
			String users_ProTectEMail, String users_ProtectTel, Integer users_Exit1, String users_Exit2,
			Integer users_CheckInStatus, List<Roles> roles, Classes classes) {
		super();
		this.users_Id = users_Id;
		this.users_LoginName = users_LoginName;
		this.users_Password = users_Password;
		this.users_LsLockout = users_LsLockout;
		this.users_LastLoginTime = users_LastLoginTime;
		this.users_CreateTime = users_CreateTime;
		this.users_PsdWrongTime = users_PsdWrongTime;
		this.users_LockTime = users_LockTime;
		this.users_ProTectEMail = users_ProTectEMail;
		this.users_ProtectTel = users_ProtectTel;
		this.users_Exit1 = users_Exit1;
		this.users_Exit2 = users_Exit2;
		this.users_CheckInStatus = users_CheckInStatus;
		this.roles = roles;
		this.classes = classes;
	}
	public Users() {
		super();
	}
	@Override
	public String toString() {
		return "Users [users_Id=" + users_Id + ", users_LoginName=" + users_LoginName + ", users_Password="
				+ users_Password + ", users_LsLockout=" + users_LsLockout + ", users_LastLoginTime="
				+ users_LastLoginTime + ", users_CreateTime=" + users_CreateTime + ", users_PsdWrongTime="
				+ users_PsdWrongTime + ", users_LockTime=" + users_LockTime + ", users_ProTectEMail="
				+ users_ProTectEMail + ", users_ProtectTel=" + users_ProtectTel + ", users_Exit1=" + users_Exit1
				+ ", users_Exit2=" + users_Exit2 + ", users_CheckInStatus=" + users_CheckInStatus + ", roles=" + roles
				+", classes"+classes+"]";
	}
	
	
}
