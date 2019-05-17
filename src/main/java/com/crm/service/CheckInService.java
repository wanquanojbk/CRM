package com.crm.service;

import javax.servlet.http.HttpSession;

public interface CheckInService {
	/**
	 * @param session 传递过去的session值
	 * @return
	 */
	public Boolean startCheckId(HttpSession session);
}	
