package com.crm.service;


import javax.servlet.http.HttpSession;

import com.crm.entity.PageNation;

public interface StudentService {
	
	PageNation selectStudent(PageNation pageNation,HttpSession session);
	
}
