package com.crm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.service.CheckInService;

@Controller
@RequestMapping("/CheckIn")
public class CheckInController {
		@Autowired
		private CheckInService checkInService;
	
		@RequestMapping("/startCheck")
		@ResponseBody
		public Boolean startCheck(HttpSession session) {
			return checkInService.startCheckId(session);
		}
}
