package com.crm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.Clue;
import com.crm.entity.PageNation;
import com.crm.service.ClueService;

@Controller
@RequestMapping("/Consultant")
public class ClueController {
	///CRM/Student/myStudent
	@Autowired
	private ClueService clueService;
	
	/*跳转到我的客户页面*/
	@RequestMapping("/myCustomer")
	public String myCustomer() {
		return "WeAdmin/clue/clues";
	}
	/*跳转到查看客户的页面*/
	@RequestMapping("/ViewCustomers")
	public String ViewCustomers() {
		return "WeAdmin/clue/ViewCustomers";
	}
	/*多条件分页查询哪个网路咨询师录入的客户信息*/
	@RequestMapping(value="/getAll")
	@ResponseBody
	public PageNation getAll(PageNation pageNation,HttpSession session) {
		PageNation all = clueService.getAll(pageNation, session);
		return all;
	}
	/*添加客户的控制器*/
	@RequestMapping(value="/addClue")
	@ResponseBody
	public Integer addClue(Clue clue,HttpSession session) {
		Integer addClue = clueService.addClue(clue, session);
		return addClue;
	}
	@RequestMapping(value="/getCustomers")
	@ResponseBody
	public PageNation getCustomers(PageNation pageNation,HttpSession session) {
		PageNation customers = clueService.getCustomers(pageNation, session);
		return customers;
	}
	/*得到咨询师下边的客户name值和id*/
	@RequestMapping(value="/getClue")
	@ResponseBody
	public List<Clue> getClue(PageNation pageNation,HttpSession session){
		List<Clue> clue = clueService.getClue(pageNation, session);
		return clue;
	}
	@RequestMapping(value="/updateFangQi")
	@ResponseBody
	public Integer updateFangQi(Integer id) {
		Integer updateFangQi = clueService.updateFangQi(id);
		return updateFangQi;
	}
	@RequestMapping(value="/updateWanCheng")
	@ResponseBody
	public Integer updateWanCheng(Integer id) {
		Integer updateChengGong = clueService.updateChengGong(id);
		return updateChengGong;
	}
	@RequestMapping(value="/updateCustomer")
	@ResponseBody
	public Integer updateCustomer(Clue clue) {
		Integer updateCustomer = clueService.updateCustomer(clue);
		return updateCustomer;
	}
	@RequestMapping(value="/getByComplete")
	@ResponseBody
	public PageNation getByComplete(PageNation pageNation,HttpSession httpsession){
		PageNation clueByComplete = clueService.getClueByComplete(pageNation,httpsession);
		return clueByComplete;
	}
}
