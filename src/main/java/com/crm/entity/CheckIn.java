package com.crm.entity;

public class CheckIn {
private Integer checkIn_Id;//编号
private Integer checkIn_UserId;//用户编号
private String checkIn_Time;//签到时间
private String checkIn_EndTime;//退签时间
private Integer checkIn_Status;//状态（  1:未签到2：已签到未签退3:已签到已签退)
private String checkIn_WorkingHours;//上班时间存成字符串例如：9:00在前台截取算是否迟到
private Integer checkIn_Late;//是否迟到（默认为0,0:已迟到,1:未迟到)
private Integer checkIn_Exit1;//预留1
private String checkIn_Exit2;//预留2
public Integer getCheckIn_Id() {
	return checkIn_Id;
}
public void setCheckIn_Id(Integer checkIn_Id) {
	this.checkIn_Id = checkIn_Id;
}
public Integer getCheckIn_UserId() {
	return checkIn_UserId;
}
public void setCheckIn_UserId(Integer checkIn_UserId) {
	this.checkIn_UserId = checkIn_UserId;
}
public String getCheckIn_Time() {
	return checkIn_Time;
}
public void setCheckIn_Time(String checkIn_Time) {
	this.checkIn_Time = checkIn_Time;
}
public String getCheckIn_EndTime() {
	return checkIn_EndTime;
}
public void setCheckIn_EndTime(String checkIn_EndTime) {
	this.checkIn_EndTime = checkIn_EndTime;
}
public Integer getCheckIn_Status() {
	return checkIn_Status;
}
public void setCheckIn_Status(Integer checkIn_Status) {
	this.checkIn_Status = checkIn_Status;
}
public String getCheckIn_WorkingHours() {
	return checkIn_WorkingHours;
}
public void setCheckIn_WorkingHours(String checkIn_WorkingHours) {
	this.checkIn_WorkingHours = checkIn_WorkingHours;
}
public Integer getCheckIn_Late() {
	return checkIn_Late;
}
public void setCheckIn_Late(Integer checkIn_Late) {
	this.checkIn_Late = checkIn_Late;
}
public Integer getCheckIn_Exit1() {
	return checkIn_Exit1;
}
public void setCheckIn_Exit1(Integer checkIn_Exit1) {
	this.checkIn_Exit1 = checkIn_Exit1;
}
public String getCheckIn_Exit2() {
	return checkIn_Exit2;
}
public void setCheckIn_Exit2(String checkIn_Exit2) {
	this.checkIn_Exit2 = checkIn_Exit2;
}
public CheckIn(Integer checkIn_Id, Integer checkIn_UserId, String checkIn_Time, String checkIn_EndTime,
		Integer checkIn_Status, String checkIn_WorkingHours, Integer checkIn_Late, Integer checkIn_Exit1,
		String checkIn_Exit2) {
	super();
	this.checkIn_Id = checkIn_Id;
	this.checkIn_UserId = checkIn_UserId;
	this.checkIn_Time = checkIn_Time;
	this.checkIn_EndTime = checkIn_EndTime;
	this.checkIn_Status = checkIn_Status;
	this.checkIn_WorkingHours = checkIn_WorkingHours;
	this.checkIn_Late = checkIn_Late;
	this.checkIn_Exit1 = checkIn_Exit1;
	this.checkIn_Exit2 = checkIn_Exit2;
}
public CheckIn() {
	super();
}
@Override
public String toString() {
	return "Checkin [checkIn_Id=" + checkIn_Id + ", checkIn_UserId=" + checkIn_UserId + ", checkIn_Time=" + checkIn_Time
			+ ", checkIn_EndTime=" + checkIn_EndTime + ", checkIn_Status=" + checkIn_Status + ", checkIn_WorkingHours="
			+ checkIn_WorkingHours + ", checkIn_Late=" + checkIn_Late + ", checkIn_Exit1=" + checkIn_Exit1
			+ ", checkIn_Exit2=" + checkIn_Exit2 + "]";
}

}
