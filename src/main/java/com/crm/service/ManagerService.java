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
	
	
	/**
	 * 
	 * @param users_Id 根据传入的经理id 来完成自动分配
	 */
	public void openDistribution(int users_Id);
	/**
	 * 
	 * @param users_Id 根据经理id 来判断自动分配的开关
	 * @return
	 */
	public Boolean switchStatus(int users_Id);
	
	/**
	 * 
	 * @param users_Id 根据经理id来修改 开关状态为关
	 * @return
	 */
	public Boolean updateSwitchStatusOFF(int users_Id);
	
	/**
	 * 
	 * @param users_Id 根据经理id来修改 开关状态 为开
	 * @return
	 */
	public Boolean updateSwitchStatusON(int users_Id);
	
	/**
	 * 
	 * @param users_Id
	 */
	public void insetStartFenPei(int users_Id);
	
	/**
	 * 
	 * @param pageNation 根据分页对象查询返回分页对象
	 * @return
	 */
	public PageNation selctUsersCheckIn(PageNation pageNation);
	
	
	/**
	 * 查询该经理下面的员工添加的客户信息，并且是多条件分页查询
	 * @return
	 */
	public PageNation getAllCustomer(PageNation pageNation,HttpSession session);
	
	/**
	 * 
	 * @param clueRows 根据 客户的id 集合 还有  用户id 进行手动分配
	 * @param userId 用户id
	 * @return 执行结果
	 */
	public Boolean startShouDong(Integer[] clueIds,Integer userId);
	
}
