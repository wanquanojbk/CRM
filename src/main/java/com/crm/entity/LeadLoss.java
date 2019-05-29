package com.crm.entity;

import org.springframework.stereotype.Component;

@Component
public class LeadLoss {
private Integer leadLoss_Id;//编号
private String leadLoss_Text;//流失原因
private String leadLoss_Time;//流失开始时间
private Integer leadLoss_ClueId;//流失客户编号
private Integer leadLoss_Exit1;//预留1
private String leadLoss_Exit2;//预留2
private Integer leadLoss_UsersId;//用户id
private String leadLoss_EndTime; //结束时间



public String getLeadLoss_EndTime() {
	return leadLoss_EndTime;
}
public void setLeadLoss_EndTime(String leadLoss_EndTime) {
	this.leadLoss_EndTime = leadLoss_EndTime;
}


public Integer getLeadLoss_UsersId() {
	return leadLoss_UsersId;
}
public void setLeadLoss_UsersId(Integer leadLoss_UsersId) {
	this.leadLoss_UsersId = leadLoss_UsersId;
}
public Integer getLeadLoss_Id() {
	return leadLoss_Id;
}
public void setLeadLoss_Id(Integer leadLoss_Id) {
	this.leadLoss_Id = leadLoss_Id;
}
public String getLeadLoss_Text() {
	return leadLoss_Text;
}
public void setLeadLoss_Text(String leadLoss_Text) {
	this.leadLoss_Text = leadLoss_Text;
}
public String getLeadLoss_Time() {
	return leadLoss_Time;
}
public void setLeadLoss_Time(String leadLoss_Time) {
	this.leadLoss_Time = leadLoss_Time;
}
public Integer getLeadLoss_ClueId() {
	return leadLoss_ClueId;
}
public void setLeadLoss_ClueId(Integer leadLoss_ClueId) {
	this.leadLoss_ClueId = leadLoss_ClueId;
}
public Integer getLeadLoss_Exit1() {
	return leadLoss_Exit1;
}
public void setLeadLoss_Exit1(Integer leadLoss_Exit1) {
	this.leadLoss_Exit1 = leadLoss_Exit1;
}
public String getLeadLoss_Exit2() {
	return leadLoss_Exit2;
}
public void setLeadLoss_Exit2(String leadLoss_Exit2) {
	this.leadLoss_Exit2 = leadLoss_Exit2;
}
public LeadLoss(Integer leadLoss_Id, String leadLoss_Text, String leadLoss_Time, Integer leadLoss_ClueId,
		Integer leadLoss_Exit1, String leadLoss_Exit2) {
	super();
	this.leadLoss_Id = leadLoss_Id;
	this.leadLoss_Text = leadLoss_Text;
	this.leadLoss_Time = leadLoss_Time;
	this.leadLoss_ClueId = leadLoss_ClueId;
	this.leadLoss_Exit1 = leadLoss_Exit1;
	this.leadLoss_Exit2 = leadLoss_Exit2;
}
public LeadLoss() {
	super();
}
@Override
public String toString() {
	return "LeadLoss [leadLoss_Id=" + leadLoss_Id + ", leadLoss_Text=" + leadLoss_Text + ", leadLoss_Time="
			+ leadLoss_Time + ", leadLoss_ClueId=" + leadLoss_ClueId + ", leadLoss_Exit1=" + leadLoss_Exit1
			+ ", leadLoss_Exit2=" + leadLoss_Exit2 + "]";
}



}
