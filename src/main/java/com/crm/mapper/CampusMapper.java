package com.crm.mapper;

import java.util.List;

import com.crm.entity.Classes;
import com.crm.entity.PageNation;
import com.crm.entity.Student;
import com.crm.entity.Users;

public interface CampusMapper {
	/**
	 * 	查询当前教导主任所管班级
	 * @param pageNation
	 * @return Classes
	 */
	public List<Classes> selectClasses(PageNation pageNation);
	/**
	 * 	查询当前教导主任所管班级总数
	 * @param pageNation
	 * @return Integer
	 */
	public Integer countClasses(PageNation pageNation);
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
	 * @param pageNation
	 * @return
	 */
	public Integer DeleteClasses(PageNation pageNation);
	/**
	 * 	查询辅导员
	 * @param pageNation
	 * @return Users
	 */
	public List<Users> selectUsers(PageNation pageNation);
	/**
	 * 	查询辅导员学生数
	 * @return
	 */
	public List<Users> selectUsersStudent();
	/**
	 * 	查询辅导员总数
	 * @param pageNation
	 * @return Integer
	 */
	public Integer countUsers(PageNation pageNation);
	/**
	 *	 查询学生
	 * @param pageNation
	 * @return Student
	 */
	public List<Student> selectStudent(PageNation pageNation);
	/**
	 * 	查询学生总数
	 * @param pageNation
	 * @return Integer
	 */
	public Integer countStudent(PageNation pageNation);
	/**
	 * 	修改学生
	 * @param student
	 * @return Integer
	 */
	public Integer UpdateStudent(Student student);
	/**
	 * 查询未分班的学生
	 * @return List<Student>
	 */
	public List<Student> selectStudentFL(PageNation pageNation);
	/**
	 * 查询student_Remarks人数
	 * @return List<Student>
	 */
	public List<Student> countStudentFL();
}
