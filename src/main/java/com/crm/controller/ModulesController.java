package com.crm.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.Modules;
import com.crm.entity.Users;
import com.crm.service.ModulesService;

@Controller
@RequestMapping("/Module")
public class ModulesController {
@Autowired
private ModulesService modulesService;
@RequestMapping("/selectModules")
public @ResponseBody List<Map<String, Object>> selectModules(HttpSession session) {
	Users users = (Users)session.getAttribute("users");
	List<Map<String, Object>> list = modulesService.selectByUserId(users.getUsers_Id());
	System.out.println("ssssssssssssssssss"+list+"------------------------------");
	//判断map集合是否为空,并添加key给前台做判断
	return list;
}
//@RequestMapping("/selectAllModules")
//public @ResponseBody List<Map<String, Object>> selectAllModules() {
//	
//	List<Map<String, Object>> list=modulesService.selectAllModules();
//	//判断map集合是否为空,并添加key给前台做判断
//	return list;
//}
@RequestMapping("/selectAllModulesByRolesId")
public @ResponseBody List<Map<String, Object>> selectAllModulesByRolesId(Integer id) {
	
	List<Map<String, Object>> list=modulesService.selectAllModulesCheckedByRoles(id);
	//判断map集合是否为空,并添加key给前台做判断
	return list;
}
	
@RequestMapping("/modules")
	public String modules() {
		return "WeAdmin/NewFile";
	}
}
