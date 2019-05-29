package com.crm.entity;


import org.springframework.stereotype.Component;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

//线索表
@Component
public class Clue extends BaseRowModel {
@ExcelProperty(value ="客户编号",index=0)
private Integer clue_Id;//编号
@ExcelProperty(value ="客户姓名",index=1)
private String clue_Name;//姓名
@ExcelProperty(value ="性别",index=2)
private String clue_Sex;//性别
@ExcelProperty(value ="年龄",index=3)
private Integer clue_Age;//年龄
@ExcelProperty(value ="出生日期",index=4)
private String clue_Birthday;//出生日期
@ExcelProperty(value ="学历",index=5)
private String clue_Education;//学历
@ExcelProperty(value ="课程方向",index=6)
private String clue_Direction;//课程方向
@ExcelProperty(value ="线索来源",index=7)
private String clue_Source;//线索来源
@ExcelProperty(value ="身份证号",index=8)
private String clue_IdentityNumber;//身份证号
@ExcelProperty(value ="电子邮箱",index=9)
private String clue_Email;//电子邮箱
@ExcelProperty(value ="QQ号",index=10)
private String clue_Qq;//QQ
@ExcelProperty(value ="微信号",index=11)
private String clue_WeChat;//微信号
@ExcelProperty(value ="电话号",index=12)
private String clue_Tel;//电话
@ExcelProperty(value ="地区",index=13)
private String clue_Address;//地区
@ExcelProperty(value ="负责人",index=14)
private Integer clue_Principal;//负责人(咨询师)
@ExcelProperty(value ="创建人",index=15)
private Integer clue_Creator;//创建人(网络咨询师)
@ExcelProperty(value ="创建时间",index=16)
private String clue_CreateTime;//创建时间
@ExcelProperty(value ="更新时间",index=17)
private String clue_UpdateTime;//更新时间
@ExcelProperty(value ="线索开始时间",index=18)
private String clue_BginTime;//线索开始时间
@ExcelProperty(value ="线索结束时间",index=19)
private String clue_EndTime;//线索结束时间
@ExcelProperty(value ="备注",index=20)
private String clue_Remarks;//备注
@ExcelProperty(value ="状态",index=21)
private Integer clue_Status;//状态(默认为0,0:未分配1:正在跟进,2:已放弃,3:已成为学员)
private Integer clue_Exit1;//预留1
private String clue_Exit2;//预留2

private Users users;	//维护用户的字段

public Users getUsers() {
	return users;
}
public void setUsers(Users users) {
	this.users = users;
}
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
public Integer getClue_Age() {
	return clue_Age;
}
public void setClue_Age(Integer clue_Age) {
	this.clue_Age = clue_Age;
}
public String getClue_Birthday() {
	return clue_Birthday;
}
public void setClue_Birthday(String clue_Birthday) {
	this.clue_Birthday = clue_Birthday;
}
public String getClue_Education() {
	return clue_Education;
}
public void setClue_Education(String clue_Education) {
	this.clue_Education = clue_Education;
}
public String getClue_Direction() {
	return clue_Direction;
}
public void setClue_Direction(String clue_Direction) {
	this.clue_Direction = clue_Direction;
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
public String getClue_WeChat() {
	return clue_WeChat;
}
public void setClue_WeChat(String clue_WeChat) {
	this.clue_WeChat = clue_WeChat;
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
public Integer getClue_Creator() {
	return clue_Creator;
}
public void setClue_Creator(Integer clue_Creator) {
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
public Clue() {
	super();
}
public Clue(Integer clue_Id, String clue_Name, String clue_Sex, Integer clue_Age, String clue_Birthday,
		String clue_Education, String clue_Direction, String clue_Source, String clue_IdentityNumber, String clue_Email,
		String clue_Qq, String clue_WeChat, String clue_Tel, String clue_Address, Integer clue_Principal,
		Integer clue_Creator, String clue_CreateTime, String clue_UpdateTime, String clue_BginTime, String clue_EndTime,
		String clue_Remarks, Integer clue_Status, Integer clue_Exit1, String clue_Exit2) {
	super();
	this.clue_Id = clue_Id;
	this.clue_Name = clue_Name;
	this.clue_Sex = clue_Sex;
	this.clue_Age = clue_Age;
	this.clue_Birthday = clue_Birthday;
	this.clue_Education = clue_Education;
	this.clue_Direction = clue_Direction;
	this.clue_Source = clue_Source;
	this.clue_IdentityNumber = clue_IdentityNumber;
	this.clue_Email = clue_Email;
	this.clue_Qq = clue_Qq;
	this.clue_WeChat = clue_WeChat;
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
@Override
public String toString() {
	return "Clue [clue_Id=" + clue_Id + ", clue_Name=" + clue_Name + ", clue_Sex=" + clue_Sex + ", clue_Age=" + clue_Age
			+ ", clue_Birthday=" + clue_Birthday + ", clue_Education=" + clue_Education + ", clue_Direction="
			+ clue_Direction + ", clue_Source=" + clue_Source + ", clue_IdentityNumber=" + clue_IdentityNumber
			+ ", clue_Email=" + clue_Email + ", clue_Qq=" + clue_Qq + ", clue_WeChat=" + clue_WeChat + ", clue_Tel="
			+ clue_Tel + ", clue_Address=" + clue_Address + ", clue_Principal=" + clue_Principal + ", clue_Creator="
			+ clue_Creator + ", clue_CreateTime=" + clue_CreateTime + ", clue_UpdateTime=" + clue_UpdateTime
			+ ", clue_BginTime=" + clue_BginTime + ", clue_EndTime=" + clue_EndTime + ", clue_Remarks=" + clue_Remarks
			+ ", clue_Status=" + clue_Status + ", clue_Exit1=" + clue_Exit1 + ", clue_Exit2=" + clue_Exit2 + ", users="
			+ users + "]";
}

}
