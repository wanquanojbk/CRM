package com.crm.service;

import javax.servlet.http.HttpSession;

import com.crm.entity.FollowUp;
import com.crm.entity.PageNation;

public interface FollowUpService {
	/**
	 * 多条件分页查询所有
	 * @param pageNation
	 * @param session
	 * @return PageNation
	 */
	public PageNation getFollowUp(PageNation pageNation,HttpSession session);
	/**
	 * 添加跟踪信息
	 * @param followUp
	 * @param session
	 * @return
	 */
	public Integer addFollowUp(FollowUp followUp,HttpSession session);
	/**
	 * 修改客户信息
	 * @param followUp
	 * @return
	 */
	public Integer updFollowUp(FollowUp followUp);
}
