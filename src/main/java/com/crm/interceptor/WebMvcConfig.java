package com.crm.interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Autowired
	private LoginInterceptor loginInterceptor;

	// 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// addPathPatterns("/**") 表示拦截所有的请求，
		// excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
		 System.out.println("我来拦截规则了");
		 InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
		 loginRegistry.addPathPatterns("/**");
		 loginRegistry.excludePathPatterns("/login"); //判断登录页面
		 //loginRegistry.excludePathPatterns("/loginout"); //退出登录的映射
		 loginRegistry.excludePathPatterns("/code");  //验证码 
		 loginRegistry.excludePathPatterns("/js/**");//静态资源所有
		 loginRegistry.excludePathPatterns("/img/**");//静态资源所有
	}
//	配置静态资源文件夹,放行的东西
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/js/").addResourceLocations("classpath:/js/**");
		registry.addResourceHandler("/img/").addResourceLocations("classpath:/img/**");
	}
}