package com.crm.mapper;

import java.util.List;

import com.crm.entity.Classes;
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
	
	public List<Student> selectAll(Integer usersId);
	
	
	public List<Student> selectAllCheckedStudent(Integer[] ids);
	/**
	 * 在业务员点击完成的时候，student表要有该学生的信息
	 * @param student
	 * @return
	 */
	public Integer insertStudent(Student student);
	
	
	/**
	 * 查询所有性别为男的学生总数
	 * @param sex
	 * @return
	 */
	public Integer selectboy(Integer userid);
	/**
	 * 查询所有性别为的学生总数
	 * @param sex
	 * @return
	 */
	public Integer selectgirl(Integer userid);
	/**
	 * 查询所有学生
	 * @return
	 */
	public Integer selectAllStudent(Integer userid);
	/**
	 * 查询该id所有男生
	 * @param userid
	 * @return
	 */
	public Integer selectAllBoy(Integer userid);
	
	/**
	 * 查询该id下所有的班级
	 * @param id
	 * @return
	 */
	public List<Classes> selectClass(Integer classid);	
	
	
	
}
