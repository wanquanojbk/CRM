package com.crm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.Dynamic;
import com.crm.entity.Users;
import com.crm.service.DynamicService;

@Controller
@RequestMapping(value = "/Dynamic")
public class DynamicController {
	
	@Autowired
	private DynamicService dynamicService;
	
	@RequestMapping(value = "/selectUsersAll")
	@ResponseBody
	public List<Users> selectUsersAll(HttpSession session){
		List<Users> selectUsersAll = dynamicService.selectUsersAll();
		System.out.println(selectUsersAll);
		return selectUsersAll;
	}
	@RequestMapping(value = "/addDynamic")
	@ResponseBody
	public Integer addDynamic(Dynamic dynamic,HttpSession session) {
		Integer insertDynamic = dynamicService.insertDynamic(dynamic,session);
		return insertDynamic;
	}
}
