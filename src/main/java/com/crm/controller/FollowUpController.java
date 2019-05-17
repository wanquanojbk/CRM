package com.crm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.PageNation;
import com.crm.service.FollowUpService;
import com.crm.entity.FollowUp;

@Controller
@RequestMapping(value="/FollowUp")
public class FollowUpController {
	
	@Autowired
	private FollowUpService followUpService;
	//跳转页面
	
	/*跳转到我的跟踪页面*/
	@RequestMapping("/MyFollowUp")
	public String FollowUp() {
		return "WeAdmin/followUp/FollowUp";
	}
	
	@RequestMapping(value="/getAll")
	@ResponseBody
	public PageNation getAll(PageNation pageNation,HttpSession session) {
		PageNation followUp = followUpService.getFollowUp(pageNation, session);
		return followUp;
	}
	@RequestMapping(value="/addFollowUp")
	@ResponseBody
	public Integer addFollowUp(FollowUp followUp,HttpSession session) {
		Integer addFollowUp = followUpService.addFollowUp(followUp, session);
		return addFollowUp;
	}
	
	@RequestMapping(value="/updFollowUp")
	@ResponseBody
	public Integer updFollowUp(FollowUp followUp) {
		
		return followUpService.updFollowUp(followUp);
	}
	
}
