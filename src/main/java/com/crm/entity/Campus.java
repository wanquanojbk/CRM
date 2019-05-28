package com.crm.entity;

import org.springframework.stereotype.Component;

//校区表
@Component
public class Campus {
private Integer campus_Id;//编号
private String campus_Name;//校区名称
private String campus_CreateTime;//校区创建时间
private Integer campus_DeanId;//教导主任编号
private String campus_Status;//校区状态
private Integer campus_Exit1;//备用1
private String campus_Exit2;//备用2
public Integer getCampus_Id() {
	return campus_Id;
}
public void setCampus_Id(Integer campus_Id) {
	this.campus_Id = campus_Id;
}
public String getCampus_Name() {
	return campus_Name;
}
public void setCampus_Name(String campus_Name) {
	this.campus_Name = campus_Name;
}
public String getCampus_CreateTime() {
	return campus_CreateTime;
}
public void setCampus_CreateTime(String campus_CreateTime) {
	this.campus_CreateTime = campus_CreateTime;
}
public Integer getCampus_DeanId() {
	return campus_DeanId;
}
public void setCampus_DeanId(Integer campus_DeanId) {
	this.campus_DeanId = campus_DeanId;
}
public String getCampus_Status() {
	return campus_Status;
}
public void setCampus_Status(String campus_Status) {
	this.campus_Status = campus_Status;
}
public Integer getCampus_Exit1() {
	return campus_Exit1;
}
public void setCampus_Exit1(Integer campus_Exit1) {
	this.campus_Exit1 = campus_Exit1;
}
public String getCampus_Exit2() {
	return campus_Exit2;
}
public void setCampus_Exit2(String campus_Exit2) {
	this.campus_Exit2 = campus_Exit2;
}
public Campus(Integer campus_Id, String campus_Name, String campus_CreateTime, Integer campus_DeanId,
		String campus_Status, Integer campus_Exit1, String campus_Exit2) {
	super();
	this.campus_Id = campus_Id;
	this.campus_Name = campus_Name;
	this.campus_CreateTime = campus_CreateTime;
	this.campus_DeanId = campus_DeanId;
	this.campus_Status = campus_Status;
	this.campus_Exit1 = campus_Exit1;
	this.campus_Exit2 = campus_Exit2;
}
public Campus() {
	super();
}
@Override
public String toString() {
	return "Campus [campus_Id=" + campus_Id + ", campus_Name=" + campus_Name + ", campus_CreateTime="
			+ campus_CreateTime + ", campus_DeanId=" + campus_DeanId + ", campus_Status=" + campus_Status
			+ ", campus_Exit1=" + campus_Exit1 + ", campus_Exit2=" + campus_Exit2 + "]";
}



}
