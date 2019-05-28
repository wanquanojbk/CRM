package com.crm.interceptor;

import java.net.InetAddress;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.crm.entity.Users;
@Component
public class LoginInterceptor implements HandlerInterceptor {
	// 在业务处理器处理请求之前被调用
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
/*		Cookie[] cookies = request.getCookies();
		for(int i=0;i<cookies.length;i++) {
			if(cookies[i].)
		}
		UUID randomUUID = UUID.randomUUID();*/
		HttpSession session = request.getSession();
		
		System.out.println(session.getId());
		System.out.println(InetAddress.getLocalHost().toString()+"-----------------");
		System.out.println("进入登录拦截器");
//		 这里的User是登陆时放入session的
		Users users = (Users) session.getAttribute("users");
		String piccode = (String)session.getAttribute("piccode");
		// 如果session中没有user，表示没登陆
		if (users != null && piccode !=null && !"".equals(piccode) ) {
			// 这个方法返回false表示忽略当前请求，如果一个用户调用了需要登陆才能使用的接口，如果他没有登陆这里会直接忽略掉
			// 当然你可以利用response给用户返回一些提示信息，告诉他没登陆
			return true;
		}
		else {
			//model.addAttribute("msg", "请先进行登录操作!");
			response.sendRedirect("/CRM/login");
			return false;
		}
	}
	
	
	
	

	// 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
	}
	// 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
	}
}
