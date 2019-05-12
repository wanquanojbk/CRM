package com.crm.interceptor;

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
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler,Model model)
			throws Exception {
		// 每一个项目对于登陆的实现逻辑都有所区别，我这里使用最简单的Session提取User来验证登陆。
		HttpSession session = request.getSession();
//		 这里的User是登陆时放入session的
		Users users = (Users) session.getAttribute("users");
		System.out.println(users+"------------------------------------------------------------------Session");
		// 如果session中没有user，表示没登陆
		if (users != null) {
			// 这个方法返回false表示忽略当前请求，如果一个用户调用了需要登陆才能使用的接口，如果他没有登陆这里会直接忽略掉
			// 当然你可以利用response给用户返回一些提示信息，告诉他没登陆
			return true;
		}
		else {
			model.addAttribute("msg", "请先进行登录操作!");
			request.getRequestDispatcher("WeAdmin/login").forward(request, response);
			return false;
		}
	}

	// 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
	}
	// 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
	}
}
