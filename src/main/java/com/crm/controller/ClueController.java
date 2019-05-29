package com.crm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.Clue;
import com.crm.entity.PageNation;
import com.crm.excel.ExcelUtil;
import com.crm.service.ClueService;

import cn.hutool.http.HttpResponse;

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
	public Integer updateFangQi(Integer id,HttpSession session) {
		Integer updateFangQi = clueService.updateFangQi(id,session);
		return updateFangQi;
	}
	@RequestMapping(value="/updateWanCheng")
	@ResponseBody
	public Integer updateWanCheng(Integer id,HttpSession session) {
		Integer updateChengGong = clueService.updateChengGong(id,session);
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
	/*查询所有客户信息,并导出excel表格*/
	@RequestMapping(value="/getClueByAll")
	@ResponseBody
	public void getClueByAll(HttpSession httpsession,HttpServletResponse response) throws IOException {
		List<Clue> selectAll = clueService.selectAll(httpsession);
		String fileName = "所有客户";
		String SheetName = "第一个Sheet";
		ExcelUtil.writeExcel(response, selectAll, fileName, SheetName, new Clue());
	}
	/*导出选中的客户信息*/
	@RequestMapping(value="/getClueById")
	@ResponseBody
	public void getClueById(HttpServletResponse response,String ids) throws IOException {
		List<Clue> selectAll = clueService.selectClueByid(ids);
		String fileName = "选中客户";
		String SheetName = "第一个Sheet";
		ExcelUtil.writeExcel(response, selectAll, fileName, SheetName, new Clue());
	}
	
	@RequestMapping(value="/selectZXSLoss")
	@ResponseBody
	public Double selectZXSLoss(Integer usersId) {
		return clueService.selectZXSLoss(usersId);
	}
	@RequestMapping(value="/selectClueByAll")
	@ResponseBody
	public void selectClueByAll(HttpSession session,HttpServletResponse response){
		List<Clue> selectAll = clueService.selectClueByAll(session);
		String fileName = "所有客户";
		String SheetName = "第一个Sheet";
		ExcelUtil.writeExcel(response, selectAll, fileName, SheetName, new Clue());
	}
	@RequestMapping(value="/getClueByPrincipal")
	@ResponseBody
	public void getClueByPrincipal(HttpSession session,HttpServletResponse response) {
		List<Clue> selectAll = clueService.selectClueByPrincipal(session);
		String fileName = "所有客户";
		String SheetName = "第一个Sheet";
		ExcelUtil.writeExcel(response, selectAll, fileName, SheetName, new Clue());
	}
	@RequestMapping(value="/clueEcharts")
	@ResponseBody
	public Integer[] clueEcharts(HttpSession session) {
		return clueService.selectClueEcharts(session);
	}
}
