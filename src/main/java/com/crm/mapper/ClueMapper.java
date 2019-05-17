package com.crm.mapper;

import java.util.List;

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
}
