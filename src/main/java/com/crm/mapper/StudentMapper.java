package com.crm.mapper;

import java.util.List;

import com.crm.entity.PageNation;
import com.crm.entity.Student;

public interface StudentMapper {
	
	/**
	 *  查询所有学生
	 * @param pageNation
	 * @return
	 */
	public List<Student> selectStudent(PageNation pageNation);
	
	/**
	 * 
	   *   总条数
	 * @param pageNation
	 * @return
	 */
	public Integer selectCount(PageNation pageNation);
	
	
	
	public List<Student> selectAllCheckedStudent(Integer[] ids);
	
}
