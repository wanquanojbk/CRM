package com.crm.service;

import java.util.List;

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
	public Integer addClasses(PageNation pageNation);
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
	 * 	查询学生
	 * @param pageNation
	 * @return pageNation
	 */
	public PageNation selectStudent(PageNation pageNation);
}
