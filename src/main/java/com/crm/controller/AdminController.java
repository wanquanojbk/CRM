package com.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.crm.entity.PageNation;
import com.crm.entity.Users;
import com.crm.entity.UsersRoles;
import com.crm.service.UsersService;

@Controller
@RequestMapping("/Admin")
public class AdminController {
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/users")
	public String users() {
		return "WeAdmin/admin/users";
	}
	@RequestMapping("/addUser")
	public String addUser(Model model) {
		PageNation roles = usersService.selectAllRoles();
		model.addAttribute("roles",roles.getRows());
		return "WeAdmin/pages/admin/addUser";
	}
	
	@RequestMapping("/usersPage")
	@ResponseBody
	public PageNation usersPage(PageNation pageNation) {
		System.out.println(pageNation);
		return usersService.usersStartPage(pageNation);
	}
	@RequestMapping("/usersIsLockOn")
	@ResponseBody
	public Boolean usersIsLockOn(String ids) {
		return usersService.updateUsersIsLockOn(ids);
	}
	@RequestMapping("/usersIsLockOFF")
	@ResponseBody
	public Boolean usersIsLockOFF(String ids) {
		return usersService.updateUsersIsLockOFF(ids);
	}
	@RequestMapping("/deleteUsers")
	@ResponseBody
	public Boolean deleteUsers(Integer id) {
		return usersService.deleteUsersByUsersId(id);
	}
	@RequestMapping("/add")
	@ResponseBody
	public Boolean addUsers(Users users ,UsersRoles usersRoles) {
		return usersService.insertUsers(users,usersRoles);
	}
	@RequestMapping("/chongzhiUsers")
	@ResponseBody
	public Boolean chongzhiUsers(Users users) {
		return usersService.updateUsersChongZhi(users);
	}
	@RequestMapping("/updateUser")
	public String updateUser(Model model,Integer id) {
		Users yonghu = usersService.selectUsersByUsersId(id);
		model.addAttribute("yonghu",yonghu);
		return "WeAdmin/pages/admin/updateUser";
	}
	@RequestMapping("/update")
	@ResponseBody
	public Boolean updateUsers(Users users) {
		System.out.println("控制层"+users+"-----------------------------------");
		return usersService.updateUsers(users);
	}
	
	@RequestMapping("/assignmentUser")
	public String assignmentUser(Integer users_Id,HttpServletRequest request) {
		request.getSession().setAttribute("id", users_Id);
		return "WeAdmin/pages/admin/assignmentUser";
	}
	@RequestMapping("/roles")
	@ResponseBody
	public List<?> roles() {
		PageNation pageNation = usersService.selectAllRoles();
		return pageNation.getRows();
	}
	
	
	
	@RequestMapping("/role")
	@ResponseBody
	public PageNation role(HttpServletRequest request,Integer id) {
		request.getSession().setAttribute("id", id);
		PageNation pageNation = usersService.selectRolesByUsersId(id);
		return pageNation;
	}
	@RequestMapping("/deleteUsersRoles")
	@ResponseBody
	public Boolean deleteUsersRoles(HttpServletRequest request,String ids) {
		Integer id = (Integer)request.getSession().getAttribute("id");
		Boolean code = usersService.deleteUsersRoles(id, ids);
		return code;
	}
	@RequestMapping("/insertUsersRoles")
	@ResponseBody
	public Boolean insertUsersRoles(HttpServletRequest request,String ids) {
		Integer id = (Integer)request.getSession().getAttribute("id");
		Boolean code = usersService.insertUsersRoles(id, ids);
		return code;
	}
	
	@RequestMapping("/testLoginName")
	@ResponseBody
	public Boolean testLoginName(Users users) {
		Boolean jieGuo=usersService.testLoginName(users);
		return jieGuo;
	}
	@RequestMapping("/testEmail")
	@ResponseBody
	public Boolean testEmail(String email) {
		Boolean jieGuo=usersService.testEmail(email);
		return jieGuo;
	}
	@RequestMapping("/testTel")
	@ResponseBody
	public Boolean testTel(String tel) {
		Boolean jieGuo=usersService.testPhone(tel);
		return jieGuo;
	}
	

	
}
