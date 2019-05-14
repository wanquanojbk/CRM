package com.crm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.Excel.ExcelUtil;
import com.crm.entity.PageNation;
import com.crm.entity.Student;
import com.crm.entity.Users;
import com.crm.service.StudentService;

@Controller
@RequestMapping("/Student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	//这个方法仅仅做页面跳转使用  因为我们的页面相当于是放在webinf里面所以直接访问
	@RequestMapping("/myStudent")
	public String myStudent() {
		return "WeAdmin/student/students";
	}
	
	@RequestMapping("selectStudent")
	@ResponseBody
	public PageNation selectStudent(PageNation pageNation,HttpSession session) {
		
		//1.开启分页传递过来的参数是  page 和 rows  ?  
		//2.就会把rows 传的  10 放入到  pageNation里面的 rows里面
		//#{page},#{row}
		int row = Integer.parseInt((String)pageNation.getRows().get(0));
		pageNation.setPage((pageNation.getPage()-1)*row);
		pageNation.setRow(row);
		Users users = (Users)session.getAttribute("users");
		pageNation.setNum1(users.getUsers_Id());
		return studentService.selectStudent(pageNation, session);
	}
	
	@RequestMapping(value = "writeExcel")
	public void writeExcel(HttpServletResponse response,String ids) throws IOException {
		List<Student> list = studentService.selectAllCheckedStudent(ids);
	    String fileName = "第一个表格";
	    String sheetName = "第一个 sheet";
	    ExcelUtil.writeExcel(response, list, fileName, sheetName, new Student());
	    }
}
