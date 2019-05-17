package com.crm.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.crm.entity.Clue;
import com.crm.entity.PageNation;

public interface ManagerService {
	/**
	 * 
	 * @param pageNation 根据传入的pageNation和session对象返回查询好的分页对象
	 * @param session
	 * @return
	 */
	public PageNation allEmployee(PageNation pageNation,HttpSession session);
	/**
	 * 
	 * @param session 传入的session对象
	 * @return 实际上是一个用户集合
	 */
	public List<?> checkEmployee(HttpSession session);
	
	/**
	 * 
	 * @param ids 根据传入的id数组进行退签
	 * @return
	 */
	public Boolean checkedEmployee(String ids);
	
	/**
	 * 
	 * @param session 根据session的用户id 
	 * @return
	 */
	public List<Clue> shoudong(HttpSession session);
}
