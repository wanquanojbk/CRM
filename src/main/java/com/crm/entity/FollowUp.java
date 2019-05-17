package com.crm.entity;

import org.springframework.stereotype.Component;

@Component
public class FollowUp {
private Integer followUp_id;//编号
private String follwUp_Text;//跟进内容
private String follwUp_Type;//跟进方式
private String follwUp_Time;//创建时间
private String follwUp_FirstVisitTime;//首访时间
private String follwUp_Door;//是否上门
private String follwUp_DoorTime;//上门时间
private String follwUp_ReturnVisit;//是否回访
private String follwUp_ReturnVisitTim;//回访时间
private String follwUp_ReturnVisitSituation;//回访情况
private Integer follwUp_Principal;//跟进负责人编号
private String follwUp_EndTim;//跟进结束时间
private Integer follwUp_ClueId;//目标客户id
private String follwUp_Conclusion;//结论
private Integer follwUp_Exit1;//预留1
private String follwUp_Exit2;//预留2
private Clue clue;//维护字段
public Integer getFollowUp_id() {
	return followUp_id;
}
public void setFollowUp_id(Integer followUp_id) {
	this.followUp_id = followUp_id;
}
public String getFollwUp_Text() {
	return follwUp_Text;
}
public void setFollwUp_Text(String follwUp_Text) {
	this.follwUp_Text = follwUp_Text;
}
public String getFollwUp_Type() {
	return follwUp_Type;
}
public void setFollwUp_Type(String follwUp_Type) {
	this.follwUp_Type = follwUp_Type;
}
public String getFollwUp_Time() {
	return follwUp_Time;
}
public void setFollwUp_Time(String follwUp_Time) {
	this.follwUp_Time = follwUp_Time;
}
public String getFollwUp_FirstVisitTime() {
	return follwUp_FirstVisitTime;
}
public void setFollwUp_FirstVisitTime(String follwUp_FirstVisitTime) {
	this.follwUp_FirstVisitTime = follwUp_FirstVisitTime;
}
public String getFollwUp_Door() {
	return follwUp_Door;
}
public void setFollwUp_Door(String follwUp_Door) {
	this.follwUp_Door = follwUp_Door;
}
public String getFollwUp_DoorTime() {
	return follwUp_DoorTime;
}
public void setFollwUp_DoorTime(String follwUp_DoorTime) {
	this.follwUp_DoorTime = follwUp_DoorTime;
}
public String getFollwUp_ReturnVisit() {
	return follwUp_ReturnVisit;
}
public void setFollwUp_ReturnVisit(String follwUp_ReturnVisit) {
	this.follwUp_ReturnVisit = follwUp_ReturnVisit;
}
public String getFollwUp_ReturnVisitTim() {
	return follwUp_ReturnVisitTim;
}
public void setFollwUp_ReturnVisitTim(String follwUp_ReturnVisitTim) {
	this.follwUp_ReturnVisitTim = follwUp_ReturnVisitTim;
}
public String getFollwUp_ReturnVisitSituation() {
	return follwUp_ReturnVisitSituation;
}
public void setFollwUp_ReturnVisitSituation(String follwUp_ReturnVisitSituation) {
	this.follwUp_ReturnVisitSituation = follwUp_ReturnVisitSituation;
}
public Integer getFollwUp_Principal() {
	return follwUp_Principal;
}
public void setFollwUp_Principal(Integer follwUp_Principal) {
	this.follwUp_Principal = follwUp_Principal;
}
public String getFollwUp_EndTim() {
	return follwUp_EndTim;
}
public void setFollwUp_EndTim(String follwUp_EndTim) {
	this.follwUp_EndTim = follwUp_EndTim;
}
public Integer getFollwUp_ClueId() {
	return follwUp_ClueId;
}
public void setFollwUp_ClueId(Integer follwUp_ClueId) {
	this.follwUp_ClueId = follwUp_ClueId;
}
public String getFollwUp_Conclusion() {
	return follwUp_Conclusion;
}
public void setFollwUp_Conclusion(String follwUp_Conclusion) {
	this.follwUp_Conclusion = follwUp_Conclusion;
}
public Integer getFollwUp_Exit1() {
	return follwUp_Exit1;
}
public void setFollwUp_Exit1(Integer follwUp_Exit1) {
	this.follwUp_Exit1 = follwUp_Exit1;
}
public String getFollwUp_Exit2() {
	return follwUp_Exit2;
}
public void setFollwUp_Exit2(String follwUp_Exit2) {
	this.follwUp_Exit2 = follwUp_Exit2;
}
public Clue getClue() {
	return clue;
}
public void setClue(Clue clue) {
	this.clue = clue;
}
public FollowUp(Integer followUp_id, String follwUp_Text, String follwUp_Type, String follwUp_Time,
		String follwUp_FirstVisitTime, String follwUp_Door, String follwUp_DoorTime, String follwUp_ReturnVisit,
		String follwUp_ReturnVisitTim, String follwUp_ReturnVisitSituation, Integer follwUp_Principal,
		String follwUp_EndTim, Integer follwUp_ClueId, String follwUp_Conclusion, Integer follwUp_Exit1,
		String follwUp_Exit2, Clue clue) {
	super();
	this.followUp_id = followUp_id;
	this.follwUp_Text = follwUp_Text;
	this.follwUp_Type = follwUp_Type;
	this.follwUp_Time = follwUp_Time;
	this.follwUp_FirstVisitTime = follwUp_FirstVisitTime;
	this.follwUp_Door = follwUp_Door;
	this.follwUp_DoorTime = follwUp_DoorTime;
	this.follwUp_ReturnVisit = follwUp_ReturnVisit;
	this.follwUp_ReturnVisitTim = follwUp_ReturnVisitTim;
	this.follwUp_ReturnVisitSituation = follwUp_ReturnVisitSituation;
	this.follwUp_Principal = follwUp_Principal;
	this.follwUp_EndTim = follwUp_EndTim;
	this.follwUp_ClueId = follwUp_ClueId;
	this.follwUp_Conclusion = follwUp_Conclusion;
	this.follwUp_Exit1 = follwUp_Exit1;
	this.follwUp_Exit2 = follwUp_Exit2;
	this.clue = clue;
}
public FollowUp() {
	super();
}
@Override
public String toString() {
	return "FollowUp [followUp_id=" + followUp_id + ", follwUp_Text=" + follwUp_Text + ", follwUp_Type=" + follwUp_Type
			+ ", follwUp_Time=" + follwUp_Time + ", follwUp_FirstVisitTime=" + follwUp_FirstVisitTime
			+ ", follwUp_Door=" + follwUp_Door + ", follwUp_DoorTime=" + follwUp_DoorTime + ", follwUp_ReturnVisit="
			+ follwUp_ReturnVisit + ", follwUp_ReturnVisitTim=" + follwUp_ReturnVisitTim
			+ ", follwUp_ReturnVisitSituation=" + follwUp_ReturnVisitSituation + ", follwUp_Principal="
			+ follwUp_Principal + ", follwUp_EndTim=" + follwUp_EndTim + ", follwUp_ClueId=" + follwUp_ClueId
			+ ", follwUp_Conclusion=" + follwUp_Conclusion + ", follwUp_Exit1=" + follwUp_Exit1 + ", follwUp_Exit2="
			+ follwUp_Exit2 + ", clue=" + clue + "]";
}
	
	


}
