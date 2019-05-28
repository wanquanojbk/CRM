package com.crm.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.crm.service.SocketService;
import com.crm.util.Result;
import com.crm.util.WebSocketService;

@Controller
@RequestMapping("/checkcenter")
public class CheckCenterController {
	@Autowired
	private SocketService socketService;
	
	@RequestMapping("/getLayIm")
	@ResponseBody
	public Map<String, Object> getLayIm(HttpSession session){
		return socketService.getLayIm(session);
	}
	
	//页面请求
	@RequestMapping("/socket/{cid}")
	public ModelAndView socket(@PathVariable String cid) {
		System.out.println("------------------------------------------进入");
		ModelAndView mav=new ModelAndView("/socket");
		mav.addObject("cid", cid);
		return mav;
	}
	//推送数据接口
	
	@RequestMapping("/socket/push/{cid}")
	@ResponseBody
	public Result pushToWeb(@PathVariable String cid,String message) {  
		Result result = new Result();
		try {
			WebSocketService.sendInfo(message,cid);
			result.setMsg(message);
		} catch (IOException e) {
			e.printStackTrace();
		}  
		return result;
	} 
	@RequestMapping("/jump")
	public String jump() {
		return "WeAdmin/test";
	}
} 