package com.crm.service;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.crm.entity.Clue;
import com.crm.entity.PageNation;

public interface ClueService {
	/**
	 * 	得到所有的方法，多条件分页查询还有查询总数
	 * @param pageNation
	 * @return
	 */
	public PageNation getAll(PageNation pageNation,HttpSession session);
	
	/**
	 * 添加客户信息
	 * @return
	 */
	public Integer addClue(Clue clue,HttpSession session);
	/**
	 * 得到咨询师下面的客户信息
	 * @param pageNation
	 * @param session
	 * @return
	 */
	public PageNation getCustomers(PageNation pageNation,HttpSession session);
	/**
	 * 得到咨询师下边的客户name和id
	 * @param pageNation
	 * @param session
	 * @return
	 */
	public List<Clue> getClue(PageNation pageNation,HttpSession session);
	/**
	 * 修改放弃
	 * @param id
	 * @return
	 */
	public Integer updateFangQi(Integer id,HttpSession session);
	/**
	 * 修改成功
	 * @param id
	 * @return
	 */
	public Integer updateChengGong(Integer id,HttpSession session);
	/**
	 * 修改客户
	 * @param clue
	 * @return
	 */
	public Integer updateCustomer(Clue clue);
	/**
	 * 查询网络咨询师已完成的客户信息
	 * @param id
	 * @return
	 */
	public PageNation getClueByComplete(PageNation pageNation,HttpSession httpsession);
	/**
	 * 根据创建人id查询客户信息
	 * @param httpsession
	 * @return
	 */
	public List<Clue> selectAll(HttpSession httpsession);
	/**
	 * 根据选中客户id查询数据
	 * @param id
	 * @return
	 */
	public List<Clue> selectClueByid(String id);
	
	/**
	 * 
	 * @param usersId 根据用户id 查询 该 用户的流失率
	 * @return
	 */
	public Double selectZXSLoss(Integer usersId);
	/**
	 * 导出excel表格是网络咨询师下边的客户
	 * @return
	 */
	public List<Clue> selectClueByAll(HttpSession session);
	/**
	 * 
	 * @param session 根据自己id 查询出来自己所有客户
	 * @return
	 */
	public List<Clue> selectClueByPrincipal(HttpSession session);
	
	/**
	 * 
	 * @param session 客户的统计图
	 * @return
	 */
	public Integer[] selectClueEcharts(HttpSession session);
	
}
