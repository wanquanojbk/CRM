package com.crm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.Clue;
import com.crm.entity.PageNation;
import com.crm.service.ManagerService;

@Controller
@RequestMapping("/Manager")
public class ManagerController {
	@Autowired
	private ManagerService managerService;
	@RequestMapping("/checkIn")
	public String checkIn() {
		return "WeAdmin/manager/employee";
	}
	@RequestMapping("/allEmployee")
	@ResponseBody
	public PageNation allEmployee(PageNation pageNation,HttpSession session) {
		return managerService.allEmployee(pageNation, session);
	}
	@RequestMapping("/checkEmployee")
	@ResponseBody
	public List<?> checkEmployee(HttpSession session) {
		return managerService.checkEmployee(session);
	}
	@RequestMapping("/startChecked")
	@ResponseBody
	public Boolean startChecked(String ids) {
		return managerService.checkedEmployee(ids);
	}
	//--------------------------------------------------------------------上边是签到
	
	@RequestMapping("/weight")
	public String startAutoFenLiang() {
		return "WeAdmin/manager/fenliang";
	}
	@RequestMapping("/shoudong")
	@ResponseBody
	public List<Clue> shoudong(HttpSession session){
		return managerService.shoudong(session);
	}
	
	
}
