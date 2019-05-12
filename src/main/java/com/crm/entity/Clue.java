package com.crm.entity;
//线索表
public class Clue {
private Integer clue_Id;//编号
private String clue_Name;//姓名
private String clue_Sex;//性别
private String clue_Birthday;//出生日期
private String clue_Source;//线索来源
private String clue_IdentityNumber;//身份证号
private String clue_Email;//电子邮件
private String clue_Qq;//QQ
private String clue_Tel;//电话
private String clue_Address;//地区
private Integer clue_Principal;//负责人(咨询师)
private String clue_Creator;//创建人(网络咨询师)
private String clue_CreateTime;//创建时间
private String clue_UpdateTime;//更新时间
private String clue_BginTime;//线索开始时间
private String clue_EndTime;//线索结束时间
private String clue_Remarks;//备注
private Integer clue_Status;//状态(默认为0,0:未分配1:正在跟进,2:已放弃,3:已成为学员)
private Integer clue_Exit1;//预留1
private String clue_Exit2;//预留2
public Integer getClue_Id() {
	return clue_Id;
}
public void setClue_Id(Integer clue_Id) {
	this.clue_Id = clue_Id;
}
public String getClue_Name() {
	return clue_Name;
}
public void setClue_Name(String clue_Name) {
	this.clue_Name = clue_Name;
}
public String getClue_Sex() {
	return clue_Sex;
}
public void setClue_Sex(String clue_Sex) {
	this.clue_Sex = clue_Sex;
}
public String getClue_Birthday() {
	return clue_Birthday;
}
public void setClue_Birthday(String clue_Birthday) {
	this.clue_Birthday = clue_Birthday;
}
public String getClue_Source() {
	return clue_Source;
}
public void setClue_Source(String clue_Source) {
	this.clue_Source = clue_Source;
}
public String getClue_IdentityNumber() {
	return clue_IdentityNumber;
}
public void setClue_IdentityNumber(String clue_IdentityNumber) {
	this.clue_IdentityNumber = clue_IdentityNumber;
}
public String getClue_Email() {
	return clue_Email;
}
public void setClue_Email(String clue_Email) {
	this.clue_Email = clue_Email;
}
public String getClue_Qq() {
	return clue_Qq;
}
public void setClue_Qq(String clue_Qq) {
	this.clue_Qq = clue_Qq;
}
public String getClue_Tel() {
	return clue_Tel;
}
public void setClue_Tel(String clue_Tel) {
	this.clue_Tel = clue_Tel;
}
public String getClue_Address() {
	return clue_Address;
}
public void setClue_Address(String clue_Address) {
	this.clue_Address = clue_Address;
}
public Integer getClue_Principal() {
	return clue_Principal;
}
public void setClue_Principal(Integer clue_Principal) {
	this.clue_Principal = clue_Principal;
}
public String getClue_Creator() {
	return clue_Creator;
}
public void setClue_Creator(String clue_Creator) {
	this.clue_Creator = clue_Creator;
}
public String getClue_CreateTime() {
	return clue_CreateTime;
}
public void setClue_CreateTime(String clue_CreateTime) {
	this.clue_CreateTime = clue_CreateTime;
}
public String getClue_UpdateTime() {
	return clue_UpdateTime;
}
public void setClue_UpdateTime(String clue_UpdateTime) {
	this.clue_UpdateTime = clue_UpdateTime;
}
public String getClue_BginTime() {
	return clue_BginTime;
}
public void setClue_BginTime(String clue_BginTime) {
	this.clue_BginTime = clue_BginTime;
}
public String getClue_EndTime() {
	return clue_EndTime;
}
public void setClue_EndTime(String clue_EndTime) {
	this.clue_EndTime = clue_EndTime;
}
public String getClue_Remarks() {
	return clue_Remarks;
}
public void setClue_Remarks(String clue_Remarks) {
	this.clue_Remarks = clue_Remarks;
}
public Integer getClue_Status() {
	return clue_Status;
}
public void setClue_Status(Integer clue_Status) {
	this.clue_Status = clue_Status;
}
public Integer getClue_Exit1() {
	return clue_Exit1;
}
public void setClue_Exit1(Integer clue_Exit1) {
	this.clue_Exit1 = clue_Exit1;
}
public String getClue_Exit2() {
	return clue_Exit2;
}
public void setClue_Exit2(String clue_Exit2) {
	this.clue_Exit2 = clue_Exit2;
}

public Clue(Integer clue_Id, String clue_Name, String clue_Sex, String clue_Birthday, String clue_Source,
		String clue_IdentityNumber, String clue_Email, String clue_Qq, String clue_Tel, String clue_Address,
		Integer clue_Principal, String clue_Creator, String clue_CreateTime, String clue_UpdateTime,
		String clue_BginTime, String clue_EndTime, String clue_Remarks, Integer clue_Status, Integer clue_Exit1,
		String clue_Exit2) {
	super();
	this.clue_Id = clue_Id;
	this.clue_Name = clue_Name;
	this.clue_Sex = clue_Sex;
	this.clue_Birthday = clue_Birthday;
	this.clue_Source = clue_Source;
	this.clue_IdentityNumber = clue_IdentityNumber;
	this.clue_Email = clue_Email;
	this.clue_Qq = clue_Qq;
	this.clue_Tel = clue_Tel;
	this.clue_Address = clue_Address;
	this.clue_Principal = clue_Principal;
	this.clue_Creator = clue_Creator;
	this.clue_CreateTime = clue_CreateTime;
	this.clue_UpdateTime = clue_UpdateTime;
	this.clue_BginTime = clue_BginTime;
	this.clue_EndTime = clue_EndTime;
	this.clue_Remarks = clue_Remarks;
	this.clue_Status = clue_Status;
	this.clue_Exit1 = clue_Exit1;
	this.clue_Exit2 = clue_Exit2;
}

public Clue() {
	super();
}
@Override
public String toString() {
	return "Clue [clue_Id=" + clue_Id + ", clue_Name=" + clue_Name + ", clue_Sex=" + clue_Sex + ", clue_Birthday="
			+ clue_Birthday + ", clue_Source=" + clue_Source + ", clue_IdentityNumber=" + clue_IdentityNumber
			+ ", clue_Email=" + clue_Email + ", clue_Qq=" + clue_Qq + ", clue_Tel=" + clue_Tel + ", clue_Address="
			+ clue_Address + ", clue_Principal=" + clue_Principal + ", clue_Creator=" + clue_Creator
			+ ", clue_CreateTime=" + clue_CreateTime + ", clue_UpdateTime=" + clue_UpdateTime + ", clue_BginTime="
			+ clue_BginTime + ", clue_EndTime=" + clue_EndTime + ", clue_Remarks=" + clue_Remarks + ", clue_Status="
			+ clue_Status + ", clue_Exit1=" + clue_Exit1 + ", clue_Exit2=" + clue_Exit2 + "]";
}

}
