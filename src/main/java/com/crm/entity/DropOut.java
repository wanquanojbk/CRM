package com.crm.entity;

public class DropOut {
private Integer dropOut_Id;//编号
private String dropOut_Text;//退学原因
private String dropOut_Time;//退学时间
private Integer dropOut_StudentId;//退学学生编号
private Integer dropOut_Exit1;//预留1
private String dropOut_Exit2;//预留2
public Integer getDropOut_Id() {
	return dropOut_Id;
}
public void setDropOut_Id(Integer dropOut_Id) {
	this.dropOut_Id = dropOut_Id;
}
public String getDropOut_Text() {
	return dropOut_Text;
}
public void setDropOut_Text(String dropOut_Text) {
	this.dropOut_Text = dropOut_Text;
}
public String getDropOut_Time() {
	return dropOut_Time;
}
public void setDropOut_Time(String dropOut_Time) {
	this.dropOut_Time = dropOut_Time;
}
public Integer getDropOut_StudentId() {
	return dropOut_StudentId;
}
public void setDropOut_StudentId(Integer dropOut_StudentId) {
	this.dropOut_StudentId = dropOut_StudentId;
}
public Integer getDropOut_Exit1() {
	return dropOut_Exit1;
}
public void setDropOut_Exit1(Integer dropOut_Exit1) {
	this.dropOut_Exit1 = dropOut_Exit1;
}
public String getDropOut_Exit2() {
	return dropOut_Exit2;
}
public void setDropOut_Exit2(String dropOut_Exit2) {
	this.dropOut_Exit2 = dropOut_Exit2;
}
public DropOut(Integer dropOut_Id, String dropOut_Text, String dropOut_Time, Integer dropOut_StudentId,
		Integer dropOut_Exit1, String dropOut_Exit2) {
	super();
	this.dropOut_Id = dropOut_Id;
	this.dropOut_Text = dropOut_Text;
	this.dropOut_Time = dropOut_Time;
	this.dropOut_StudentId = dropOut_StudentId;
	this.dropOut_Exit1 = dropOut_Exit1;
	this.dropOut_Exit2 = dropOut_Exit2;
}
public DropOut() {
	super();
}
@Override
public String toString() {
	return "DropOut [dropOut_Id=" + dropOut_Id + ", dropOut_Text=" + dropOut_Text + ", dropOut_Time=" + dropOut_Time
			+ ", dropOut_StudentId=" + dropOut_StudentId + ", dropOut_Exit1=" + dropOut_Exit1 + ", dropOut_Exit2="
			+ dropOut_Exit2 + "]";
}


}
