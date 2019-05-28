package com.crm.service;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.crm.entity.Classes;
import com.crm.entity.PageNation;
import com.crm.entity.Student;

public interface StudentService {
	/**
	 * 
	 * @param pageNation 分页查询学生服务层
	 * @param session
	 * @return
	 */
	PageNation selectStudent(PageNation pageNation,HttpSession session);
	/**
	 * 
	 * @param ids 查询指定id的学生
	 * @return
	 */
	List<Student> selectAllCheckedStudent(String ids);
	/**
	 * 
	 * @param session 查询该辅导员下面的所有学生
	 * @return
	 */
	List<Student> slectAll(HttpSession session);
	
	/**
	 * 
	 * @param session 根据自己辅导员的id 查到自己的所有班级
	 * @return
	 */
	List<Classes> selectclass(HttpSession session);
	
	/**
	 * 
	 * @param classid 查询自己某班级的男女生数量
	 * @return
	 */
	Integer[] selectClassStudent(Integer classid);
	/**
	 * 
	 * @param userid 查询自己所有班级学生的男女生数量
	 * @return
	 */
	Integer[] selectAllStudent(Integer userid);
}
