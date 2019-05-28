package com.crm.service;

import java.util.List;
import java.util.Map;

import com.crm.entity.Classes;
import com.crm.entity.PageNation;
import com.crm.entity.Student;
import com.crm.entity.Users;

public interface CampusService {
	/**
	 * 	查询班级
	 * @param pageNation
	 * @return pageNation
	 */
	public PageNation selectClasses(PageNation pageNation);
	/**
	 * 	添加班级
	 * @param pageNation
	 * @return
	 */
	public Integer addClasses(Classes classes);
	/**
	 * 	修改班级
	 * @param pageNation
	 * @return
	 */
	public Integer UpdateClasses(Classes classes);
	/**
	 * 	删除班级
	 * @param id
	 * @return
	 */
	public Integer DeleteClasses(PageNation pageNation);
	/**
	 * 	查询辅导员
	 * @param pageNation
	 * @return pageNation
	 */
	public PageNation selectUsers(PageNation pageNation);
	/**
	 * 	图表
	 * @return
	 */
	public Map selectUsersStudent(PageNation pageNation);
	/**
	 * 	查询学生
	 * @param pageNation
	 * @return pageNation
	 */
	public PageNation selectStudent(PageNation pageNation);
	/**
	 * 	修改学生
	 * @param student
	 * @return Integer
	 */
	public Integer UpdateStudent(Student student);
	/**
	 * 分量
	 * @return List<Student>
	 */
	public Boolean selectStudentFL(PageNation pageNation);
}
