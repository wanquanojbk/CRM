package com.crm.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.Users;
import com.crm.service.UsersService;
import com.crm.util.PasswordEncrypt;
import com.crm.util.Result;

@Controller
public class UsersController {
	@Autowired
	private UsersService usersService;
	@RequestMapping("login")
	public String login(Users users, Model model, HttpServletRequest request,HttpServletResponse response,String yanzhengma,Integer miandenglu) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		String mima = users.getUsers_Password();
		Result result = usersService.selectUsers(users,request);
		String piccode = (String)request.getSession().getAttribute("piccode");
		
		if (result.getSuccess()) {
			if (result.getIsLockout() == 1) {
				if(!piccode.equals(yanzhengma.toLowerCase())) {
					model.addAttribute("msg", "验证码错误");
					request.getSession().removeAttribute("users");
					return "WeAdmin/lo_gin";
				}
				else {
					if(miandenglu!=null) {
						Cookie username = new Cookie("cookie", users.getUsers_LoginName());
						username.setMaxAge(60*60*24*7);
						Cookie password = new Cookie("cookie2", mima);
						password.setMaxAge(60*60*24*7);
						response.addCookie(username);
						response.addCookie(password);
						model.addAttribute("users", result.getUsers());
						return "WeAdmin/main";
					}
					else {
						model.addAttribute("users", result.getUsers());
						return "WeAdmin/main";
					}
					
				}
				
			} else {
					model.addAttribute("msg", result.getMsg());
					return "WeAdmin/lo_gin";
			}

		} else {
			model.addAttribute("msg", result.getMsg());
			return "WeAdmin/lo_gin";
		}

	}

	// 供前台layui拿到welcome页面
	@RequestMapping("welcome")
	public String welcome() {
		return "WeAdmin/pages/welcome";

	}

	// 供前台layui拿到index页面
	@RequestMapping("index")
	public String index() {
		return "WeAdmin/index";

	}
	// 供前台layui拿到index页面
	@RequestMapping("usersIndex")
	public String usersIndex() {
		return "usersIndex";

	}
	/**
	 * 用户在登录时密码出错,点击找回密码时,跳转的页面
	 * @return
	 */
	@RequestMapping("passwordZhaoHui")
	public String passwordZhaoHui() {
		return "WeAdmin/pages/passwordZhaoHui";

	}
	/**
	 * 用户在前台重置密码处点击发送邮箱验证码的方法
	 * @param users
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("zhaoHuiPassword")
	@ResponseBody
	public Result zhaoHuiPassword(Users users) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Result result=usersService.emailRandom(users);
		System.out.println(result);
		return result;
	}
	/**
	 * 用户在输完邮箱验证码和密保信息后在前台点击重置后进入的判断方法
	 * @param users
	 * @param model
	 * @param yanZheng
	 * @param youJianFanHui
	 * @return 辅助类,储存状态和信息,供前台ajax做跳转操作
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("chongZhiPassword")
	@ResponseBody
	public Result chongZhiPassword(Users users,Model model,String yanZheng,String youJianFanHui) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Result result=usersService.chongZhiPassword(users);
		System.out.println(result);
		System.out.println(yanZheng);
		System.out.println(youJianFanHui);
		String jieGuo= PasswordEncrypt.encodeByMd5(yanZheng);
		System.out.println(jieGuo);
		if(result.getSuccess()==true&&jieGuo.equals(youJianFanHui)) {
			model.addAttribute("users", result.getUsers());
			return result;
		}
		else {
			result.setSuccess(false);
			return result;
		}
		
	}
	/**
	 * 跳转最后重置的密码的页面方法
	 * @param users_Id
	 * @param users_LoginName
	 * @param model
	 * @return
	 */
	@RequestMapping("tiaoZhuanChongZhiPassword")
	public String  tiaoZhuanChongZhiPassword(Integer users_Id,String users_LoginName,Model model ){
		System.out.println("------"+users_Id+users_LoginName);
		model.addAttribute("users_Id", users_Id);
		model.addAttribute("users_LoginName", users_LoginName);
		return "WeAdmin/pages/chongZhiPassword";
	}
	/**
	 * 最后修改用户的密码,返回布尔类型的信息
	 * @param users
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("updateChongZhiPassword")
	@ResponseBody
	public Boolean updateChongZhiPassword(Users users) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		Boolean jieGuo=usersService.updateUsersChongZhiPassword(users);
		return jieGuo;
	}
	@RequestMapping("code")
	public void code(HttpServletRequest request,HttpServletResponse response) {
		usersService.code(request, response);
	}
}
