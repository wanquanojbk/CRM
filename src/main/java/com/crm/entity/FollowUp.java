package com.crm.entity;

public class FollowUp {
private Integer followUp_id;//编号
private String follwUp_Text;//跟进内容
private String follwUp_Type;//记录类型
private String follwUp__Time;//创建时间
private Integer follwUp_Principal;//跟进负责人编号
private Integer follwUp_ClueId;//目标客户id
private String follwUp_Conclusion;//结论
private Integer follwUp_Exit1;//预留1
private String follwUp_Exit2;//预留2
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
public String getFollwUp__Time() {
	return follwUp__Time;
}
public void setFollwUp__Time(String follwUp__Time) {
	this.follwUp__Time = follwUp__Time;
}
public Integer getFollwUp_Principal() {
	return follwUp_Principal;
}
public void setFollwUp_Principal(Integer follwUp_Principal) {
	this.follwUp_Principal = follwUp_Principal;
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
public FollowUp(Integer followUp_id, String follwUp_Text, String follwUp_Type, String follwUp__Time,
		Integer follwUp_Principal, Integer follwUp_ClueId, String follwUp_Conclusion, Integer follwUp_Exit1,
		String follwUp_Exit2) {
	super();
	this.followUp_id = followUp_id;
	this.follwUp_Text = follwUp_Text;
	this.follwUp_Type = follwUp_Type;
	this.follwUp__Time = follwUp__Time;
	this.follwUp_Principal = follwUp_Principal;
	this.follwUp_ClueId = follwUp_ClueId;
	this.follwUp_Conclusion = follwUp_Conclusion;
	this.follwUp_Exit1 = follwUp_Exit1;
	this.follwUp_Exit2 = follwUp_Exit2;
}
public FollowUp() {
	super();
}
@Override
public String toString() {
	return "FollowUp [followUp_id=" + followUp_id + ", follwUp_Text=" + follwUp_Text + ", follwUp_Type=" + follwUp_Type
			+ ", follwUp__Time=" + follwUp__Time + ", follwUp_Principal=" + follwUp_Principal + ", follwUp_ClueId="
			+ follwUp_ClueId + ", follwUp_Conclusion=" + follwUp_Conclusion + ", follwUp_Exit1=" + follwUp_Exit1
			+ ", follwUp_Exit2=" + follwUp_Exit2 + "]";
}


}
