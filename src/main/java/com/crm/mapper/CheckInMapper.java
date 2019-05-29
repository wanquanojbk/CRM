package com.crm.mapper;

import java.util.List;

import com.crm.entity.CheckIn;
import com.crm.entity.PageNation;

public interface CheckInMapper {
	/**
	 * 
	 * @param checkIn
	 * @return
	 */
	Integer insertCheck(CheckIn checkIn);
	/**
	 * 
	 * @param checkIn
	 * @return
	 */
	Integer updateCheckedById(CheckIn checkIn);
	
	/**
	 * 
	 * @param pageNation
	 * @return
	 */
	List<CheckIn> selectCheck(PageNation pageNation);
	
	/**
	 * 
	 * @param pageNation 查询方法
	 * @return 查询方法
	 */
	Integer selectCheckCount(PageNation pageNation);
	
	/**
	 * 
	 * @param pageNation 查询出来一个人的详细签到记录
	 * @return
	 */
	List<CheckIn> selectAllCheckInByUsersId(PageNation pageNation);
	/**
	 * 
	 * @param pageNation 查询出来一个人的详细签到记录总条数
	 * @return
	 */
	Integer selectAllCheckInByUsersIdCount(PageNation pageNation);
	
	/**
	 * 
	 * @param PageNation 根据用户id 查询当月签到 次数
	 * @return
	 */
	List<CheckIn> selectYuanGongQianDao(PageNation pageNation);
	/**
	 *  
	 * @param usersId 查询出来所有学生
	 * @return
	 */
	Integer selectYuanGongDangYueQianDao(Integer usersId);
}
