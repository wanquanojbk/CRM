package com.crm.controller;

import java.util.List;
import java.util.Map;

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
	System.out.println(users+"-------------------------------------------------");
	List<Map<String, Object>> list = modulesService.selectByUserId(users.getUsers_Id());
	System.out.println("ssssssssssssssssss"+list+"------------------------------");
	//判断map集合是否为空,并添加key给前台做判断
	return list;
}
@RequestMapping("/selectAllModules")
public @ResponseBody List<Map<String, Object>> selectAllModules() {
	
	List<Map<String, Object>> list=modulesService.selectAllModules();
	//判断map集合是否为空,并添加key给前台做判断
	return list;
}
@RequestMapping("/selectAllModulesByRolesId")
public @ResponseBody List<Map<String, Object>> selectAllModulesByRolesId(Integer id) {
	
	List<Map<String, Object>> list=modulesService.selectAllModulesCheckedByRoles(id);
	//判断map集合是否为空,并添加key给前台做判断
	return list;
}
	
	@RequestMapping("/modules")
	public String modules() {
		return "WeAdmin/admin/modules";
	}
	@RequestMapping("/addModule")
	@ResponseBody
	public Boolean addModule(Modules modules) {
		return modulesService.insertModules(modules);
	}
	@RequestMapping("/updateModule")
	@ResponseBody
	public Boolean updateModule(Modules modules) {
		return modulesService.updateModules(modules);
	}
	@RequestMapping("/deleteModule")
	@ResponseBody
	public Boolean deleteModuleModule(Integer id) {
		Modules module = new Modules();
		module.setModules_Id(id);
		return modulesService.deleteModules(module);
	}
	@RequestMapping("/selectModuleName")
	@ResponseBody
	public Boolean selectModuleName(Modules modules) {
		return modulesService.selectModulesByModuleName(modules);
	}
	
	@RequestMapping("/selectParent")
	@ResponseBody
	public Boolean testParent(Modules modules) {
		return modulesService.selectParentModuleByName(modules);
	}
	
	@RequestMapping("/insertParentModule")
	@ResponseBody
	public Boolean insertParentModule(Modules modules) {
		System.out.println(modules+"---------------");
		return modulesService.insertParentModules(modules);
	}
}
