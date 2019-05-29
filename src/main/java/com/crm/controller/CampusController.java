package com.crm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.Classes;
import com.crm.entity.PageNation;
import com.crm.entity.Student;
import com.crm.entity.Users;
import com.crm.service.CampusService;

@Controller
@RequestMapping("/Campus")
public class CampusController {
	
	@Autowired
	private CampusService campusService;
	/**
	 * 	查询班级
	 * @param pageNation
	 * @return PageNation
	 */
	@RequestMapping("/selectClass")
	@ResponseBody
	public PageNation selectClass(PageNation pageNation){
		return campusService.selectClasses(pageNation);
	}
	/**
	 * 	查询班级
	 * @param pageNation
	 * @return List
	 */
	@RequestMapping("/selectClassList")
	@ResponseBody
	public List<?> selectClassList(PageNation pageNation){
		return campusService.selectClasses(pageNation).getRows();
	}
	/**
	 * 	添加班级
	 * @param pageNation
	 * @return Integer
	 */
	@RequestMapping("/addClass")
	@ResponseBody
	public Integer addClass(Classes classes){
		return campusService.addClasses(classes);
	}
	/**
	 * 	修改班级
	 * @param classes
	 * @return Integer
	 */
	@RequestMapping("/UpdateClass")
	@ResponseBody 
	public Integer UpdateClass(Classes classes) {
		return campusService.UpdateClasses(classes);
	}
	/**
	 * 	删除班级
	 * @param pageNation
	 * @return Integer
	 */
	@RequestMapping("/DeleteClasses")
	@ResponseBody
	public Integer DeleteClasses(PageNation pageNation) {
		return campusService.DeleteClasses(pageNation);
	}
	
	@RequestMapping("/campus")
	public String CampusClass() {
		return "WeAdmin/campus/campus";
	}
	/*----------------------------------这是分割线----------------------------------*/
	/**
	 * 	查询辅导员
	 * @param pageNation
	 * @return PageNation
	 */
	@RequestMapping("/selectUsers")
	@ResponseBody
	public PageNation selectUsers(PageNation pageNation){
		return campusService.selectUsers(pageNation);
	}
	@RequestMapping("/selectUsersStudent")
	@ResponseBody
	public Map selectUsersStudent(PageNation pageNation){
		return campusService.selectUsersStudent(pageNation);
	}
	/**
	 * 	查询辅导员
	 * @param pageNation
	 * @return List
	 */
	@RequestMapping("/selectUsersList")
	@ResponseBody
	public List<?> selectUsersList(PageNation pageNation){
		PageNation Users=campusService.selectUsers(pageNation);
		return Users.getRows();
	}
	
	@RequestMapping("/users")
	public String Campususers() {
		return "WeAdmin/campus/users";
	}
	/*----------------------------------这是分割线----------------------------------*/
	/**
	 *  查询学生
	 * @param pageNation
	 * @return PageNation
	 */
	@RequestMapping("/SelectStudent")
	@ResponseBody
	public PageNation SelectStudent(PageNation pageNation) {
		return campusService.selectStudent(pageNation);
	}
	/**
	 *  修改学生
	 * @param student
	 * @return Integer
	 */
	@RequestMapping("/UpdateStudent")
	@ResponseBody
	public Integer UpdateStudent(Student student) {
		return campusService.UpdateStudent(student);
	}
	
	/**
	 * 分量
	 * @return List<Student>
	 */
	@RequestMapping("/selectStudentFL")
	@ResponseBody
	public Boolean selectStudentFL(PageNation pageNation){
		return campusService.selectStudentFL(pageNation);
	};
	
	@RequestMapping("/student")
	public String CampusStudent() {
		return "WeAdmin/campus/student";
	}
}
