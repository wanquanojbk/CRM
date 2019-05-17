package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.Classes;
import com.crm.entity.PageNation;
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
	 * @return
	 */
	@RequestMapping("/selectClass")
	@ResponseBody
	public PageNation selectClass(PageNation pageNation){
		return campusService.selectClasses(pageNation);
	}
	/**
	 * 	查询辅导员
	 * @param pageNation
	 * @return
	 */
	@RequestMapping("/selectUsers")
	@ResponseBody
	public List<?> selectUsers(PageNation pageNation){
		PageNation Users=campusService.selectUsers(pageNation);
		return Users.getRows();
	}
	/**
	 * 	添加班级
	 * @param pageNation
	 * @return
	 */
	@RequestMapping("/addClass")
	@ResponseBody
	public Integer addClass(PageNation pageNation){
		return campusService.addClasses(pageNation);
	}
	@RequestMapping("/UpdateClass")
	@ResponseBody
	public Integer UpdateClass(Classes classes) {
		return campusService.UpdateClasses(classes);
	}
	@RequestMapping("/ClassSelectStudent")
	@ResponseBody
	public PageNation ClassSelectStudent(PageNation pageNation) {
		return campusService.selectStudent(pageNation);
	}
	@RequestMapping("/DeleteClasses")
	@ResponseBody
	public Integer DeleteClasses(PageNation pageNation) {
		return campusService.DeleteClasses(pageNation);
	}
	
	@RequestMapping("/campus")
	public String CampusClass() {
		return "WeAdmin/campus/campus";
	}
}
