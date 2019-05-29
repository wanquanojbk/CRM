package com.crm.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

public interface SocketService {
	/**
	 * @param session 查询出来layIm的
	 * @return
	 */
	public Map<String, Object> getLayIm(HttpSession session);
}
