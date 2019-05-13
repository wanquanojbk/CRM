package com.crm.entity;
//班级表
public class Classes {
	private Integer classes_Id;// 编号
	private String classes_Name;// 班级名称
	private String classes_CreateTime;// 班级创建时间
	private String classes_CounselorId;//班级辅导员编号
	private String classes_SchoolYear;//学年如（五年制、三年制)
	private String classes_Campus;//校区编号
	private String classes_Status;//班级状态
	private Integer classes_Exit1;//预留1
	private String classes_Exit2;//预留2
	private Users users;
	public Integer getClasses_Id() {
		return classes_Id;
	}
	public void setClasses_Id(Integer classes_Id) {
		this.classes_Id = classes_Id;
	}
	public String getClasses_Name() {
		return classes_Name;
	}
	public void setClasses_Name(String classes_Name) {
		this.classes_Name = classes_Name;
	}
	public String getClasses_CreateTime() {
		return classes_CreateTime;
	}
	public void setClasses_CreateTime(String classes_CreateTime) {
		this.classes_CreateTime = classes_CreateTime;
	}
	public String getClasses_CounselorId() {
		return classes_CounselorId;
	}
	public void setClasses_CounselorId(String classes_CounselorId) {
		this.classes_CounselorId = classes_CounselorId;
	}
	public String getClasses_SchoolYear() {
		return classes_SchoolYear;
	}
	public void setClasses_SchoolYear(String classes_SchoolYear) {
		this.classes_SchoolYear = classes_SchoolYear;
	}
	public String getClasses_Campus() {
		return classes_Campus;
	}
	public void setClasses_Campus(String classes_Campus) {
		this.classes_Campus = classes_Campus;
	}
	public String getClasses_Status() {
		return classes_Status;
	}
	public void setClasses_Status(String classes_Status) {
		this.classes_Status = classes_Status;
	}
	public Integer getClasses_Exit1() {
		return classes_Exit1;
	}
	public void setClasses_Exit1(Integer classes_Exit1) {
		this.classes_Exit1 = classes_Exit1;
	}
	public String getClasses_Exit2() {
		return classes_Exit2;
	}
	public void setClasses_Exit2(String classes_Exit2) {
		this.classes_Exit2 = classes_Exit2;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "Classes [classes_Id=" + classes_Id + ", classes_Name=" + classes_Name + ", classes_CreateTime="
				+ classes_CreateTime + ", classes_CounselorId=" + classes_CounselorId + ", classes_SchoolYear="
				+ classes_SchoolYear + ", classes_Campus=" + classes_Campus + ", classes_Status=" + classes_Status
				+ ", classes_Exit1=" + classes_Exit1 + ", classes_Exit2=" + classes_Exit2 + ", users=" + users + "]";
	}
	public Classes(Integer classes_Id, String classes_Name, String classes_CreateTime, String classes_CounselorId,
			String classes_SchoolYear, String classes_Campus, String classes_Status, Integer classes_Exit1,
			String classes_Exit2, Users users) {
		super();
		this.classes_Id = classes_Id;
		this.classes_Name = classes_Name;
		this.classes_CreateTime = classes_CreateTime;
		this.classes_CounselorId = classes_CounselorId;
		this.classes_SchoolYear = classes_SchoolYear;
		this.classes_Campus = classes_Campus;
		this.classes_Status = classes_Status;
		this.classes_Exit1 = classes_Exit1;
		this.classes_Exit2 = classes_Exit2;
		this.users = users;
	}
	public Classes() {
		super();
	}
	
}
