package com.crm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.Clue;
import com.crm.entity.PageNation;
import com.crm.entity.Users;
import com.crm.service.CheckInService;
import com.crm.service.ManagerService;

@Controller
@RequestMapping("/Manager")
public class ManagerController {
	@Autowired
	private ManagerService managerService;
	@Autowired
	private CheckInService checkInService;
	@RequestMapping("/checkIn")
	public String checkIn() {
		return "WeAdmin/manager/employee";
	}
	/*显示客户操作页面*/
	@RequestMapping("/allCustomer")
	public String allCustomer(){
		return "WeAdmin/clue/CustomerOperation";
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
	@RequestMapping("/selectQianDao")
	@ResponseBody
	public Integer selectQianDao(Integer usersId) {
		return checkInService.selectYuanGongQianDao(usersId);
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
	@RequestMapping("/zidong")
	@ResponseBody
	public void startZiDong(HttpSession session) {
		Users user = (Users)session.getAttribute("users");
		managerService.openDistribution(user.getUsers_Id());
	}
	@RequestMapping("/selectStatus")
	@ResponseBody
	public Boolean selectStaus(HttpSession session) {
		Users user = (Users)session.getAttribute("users");
		return managerService.switchStatus(user.getUsers_Id());
	}
	@RequestMapping("/changeStatusOFF")
	@ResponseBody
	public Boolean changeStatusOFF(HttpSession session) {
		Users user = (Users)session.getAttribute("users");
		return managerService.updateSwitchStatusOFF(user.getUsers_Id());
	}
	@RequestMapping("/changeStatusON")
	@ResponseBody
	public Boolean changeStatusON(HttpSession session) {
		Users user = (Users)session.getAttribute("users");
		Boolean code = managerService.updateSwitchStatusON(user.getUsers_Id());
		managerService.openDistribution(user.getUsers_Id());
		return code;
	}
	
	
	@RequestMapping("/insetStartFenPei")
	@ResponseBody
	public void insetStartFenPei(HttpSession session) {
		Users user = (Users)session.getAttribute("users");
		managerService.insetStartFenPei(user.getUsers_Id());
	}
	@RequestMapping("/selctUsersCheckIn")
	@ResponseBody
	public PageNation selctUsersCheckIn(PageNation pageNation) {
		return managerService.selctUsersCheckIn(pageNation);
	}
	
	
	/*客户操作页面的多条件查询所有客户信息和负责人信息*/
	@RequestMapping("/getAllCustomer")
	@ResponseBody
	public PageNation getAllCustomer(PageNation pageNation,HttpSession session) {
		PageNation allCustomer = managerService.getAllCustomer(pageNation, session);
		return allCustomer;
	}
	
	@RequestMapping("/ShouDong")
	@ResponseBody
	public Boolean ShouDong(@RequestParam(value = "clueIds[]") Integer[] clueIds,Integer userId) {
		return managerService.startShouDong(clueIds, userId);
	}
}
