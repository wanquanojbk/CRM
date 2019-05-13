package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.PageNation;
import com.crm.entity.Roles;
import com.crm.service.RolesService;

@Controller
@RequestMapping("/Roles")
public class RolesController {
	@Autowired
	private RolesService rolesService;
	@RequestMapping("/roles")
	public String roles() {
		return "WeAdmin/admin/roles";
	}
	@RequestMapping("/rolesPageNation")
	@ResponseBody
	public PageNation rolesPageNation(PageNation pageNation) {
		System.out.println(pageNation+"------------------------");
		return rolesService.rolesStartPage(pageNation);
	}
	@RequestMapping("/rolesAndModules")
	@ResponseBody
	public Boolean rolesAndModules(String ids,Integer roleId) {
		return  rolesService.rolesAndModules(ids, roleId);
	}
	@RequestMapping("/testRolesName")
	@ResponseBody
	public Boolean testRolesName(Roles roles) {
		return  rolesService.testRolesName(roles);
	}
	@RequestMapping("/insertRoles")
	@ResponseBody
	public Boolean insertRoles(Roles roles) {
		return  rolesService.insertRoles(roles);
	}
	@RequestMapping("/deleteRoles")
	@ResponseBody
	public Boolean deleteRoles(String ids) {
		return  rolesService.deleteRoles(ids);
	}
	
	
}
