package com.crm.service;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.crm.entity.PageNation;
import com.crm.entity.Student;

public interface StudentService {
	
	PageNation selectStudent(PageNation pageNation,HttpSession session);
	
	List<Student> selectAllCheckedStudent(String ids);
	
	List<Student> slectAll(HttpSession session);
}
