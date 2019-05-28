package com.crm.mapper;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.crm.entity.Clue;
import com.crm.entity.PageNation;

public interface ClueMapper {
	/**
	 * 查询出来经理所有的未分配客户
	 * @return
	 */
	public List<Clue> selectAllUnFenPeiClue(Integer id);
	/**
	 * 多条件分页查询所有
	 * 只能查看网络咨询师自己添加的信息
	 * @param pageNation分页参数
	 * @return	返回clue集合
	 */
	List<Clue> selectClueAll(PageNation pageNation);
	/**
	 * 多条件查询网络咨询师总数
	 * @param pageNation
	 * @return 分页总数
	 */
	Integer selectClueGetTotal(PageNation pageNation);
	/**
	 * 添加客户方法
	 * @param clue
	 * @return 返回受影响行数
	 */
	Integer insertClue(Clue clue);
	/**
	 * 多条件分页查询分配给咨询师的客户信息
	 * 
	 * @param pageNation
	 * @return List<Clue>
	 */
	List<Clue> selectClueByConsultation(PageNation pageNation);
	/**
	 * 多条件分页查询分配给咨询师的客户信息的总数
	 * @param pageNation
	 * @return Integer
	 */
	Integer selectClueByConsultationCount(PageNation pageNation);
	/**
	 * 根据负责人id查到客户的id值和name值
	 * @return
	 */
	List<Clue> selectClueByPrincipalId(PageNation pageNation);
	/**
	 * 修改状态为完成状态
	 * @return
	 */
	Integer updateClueByComplete(Integer id);
	/**
	 * 修改状态为放弃状态
	 * @return
	 */
	Integer updateClueByAbandon(Integer id);
	/**
	 * 修改客户信息
	 * @return
	 */
	Integer updateClueByCustomer(Clue clue);
	/**
	 * 查看咨询师完成的客户信息
	 * @param id
	 * @return
	 */
	List<Clue> selectClueByComplete(PageNation pageNation);
	/**
	 * 查看咨询师的完成总数
	 * @param pageNation
	 * @return
	 */
	Integer selectClueByCompleteCount(PageNation pageNation);
	
	/**
	 * 
	 * @param usersId 根据经理id 查询手下空闲的待分配的客户数
	 * @return
	 */
	Integer selectManagerUnDistributionCount(Integer usersId);
	/**
	 * 
	 * @param usersId 根据经理id 拿到手下空闲的待分配的客户
	 * @return
	 */
	List<Clue> selectManagerUnDistribution(Integer usersId);
	
	/**
	 * 
	 * @param usersId 根据咨询师id 查到分到自己所有的客户 包括已完成 包括 未完成
	 * @return
	 */
	List<Clue> selectAllClueByZiXunShiId(Integer usersId);
	
	/**
	 * 
	 * @param usersId 根据咨询师id 查询出来所有的已经完成的人数
	 * @return
	 */
	List<Clue> selectAllOKClueByZiXunShiId(Integer usersId);
	
	/**
	 * 
	 * @param clue 根据 客户信息 进行 修改
	 * @return
	 */
	Integer updateFenPei(Clue clue);
	
	/**
	 * 
	 * @param usersId 根据经理id 查询 出来 所有的 未分配的 还有  需要二次分配的
	 * @return
	 */
	List<Clue> selectAllNeedHeaderFenpeiClues(Integer usersId);
	/**
	 * 查看该经理下的网络咨询师添加的客户信息，并且多条件分页查看信息
	 * @return List<Clue>
	 */
	List<Clue> selectManagersCheckCustomers(PageNation pageNation);
	/**
	 * 查看该经理下的网络咨询师添加的客户信息，并且多条件查询总数
	 * @return
	 */
	Integer selectManagersCheckCustomersCount(PageNation pageNation);
	/**
	 * 根据id查看客户信息
	 * @param id
	 * @return
	 */
	Clue selectClueById(Integer id);
	/**
	 * 导出excel表格所有的数据
	 * @param clue
	 * @return
	 */
	List<Clue> selectAll(Integer id);
	/**
	 * 根据根据选中id导出excel表格
	 * @return
	 */
	List<Clue> selectByidList(Integer[] id);
	/**
	 * 
	 * @param usersId 查询用户
	 * @return
	 */
	Double selectZXSLoss(Integer usersId);
	/**
	 * 导出excel表格是,根据网络咨询师自己的id导出excel表格全部的
	 * @return
	 */
	List<Clue> selectClueByAll(Integer id);
	/**
	 * 根据负责人id导出excel表格
	 * @param session
	 * @return
	 */
	List<Clue> selectClueByPrincipal(Integer id);
	
	
	/**
	 * 
	 * @param id 用户id
	 * @return 查询出来自己的 所有客户的总数
	 */
	Integer selectMyClueCount(Integer id);
	/**
	 * 
	 * @param id 用户id
	 * @return 查询出来自己 所有女的客户数量
	 */
	Integer selectMyClueGirl(Integer id);
	
	/**
	 * 
	 * @param id 用户id
	 * @return 查询出来自己 所有放弃的客户数量
	 */
	Integer selectMyClueLoss(Integer id);
	
	/**
	 * 
	 * @param id 用户id
	 * @return 查询出来自己 所正在跟进的客户数量
	 */
	Integer selectMyclueIng(Integer id);
}
