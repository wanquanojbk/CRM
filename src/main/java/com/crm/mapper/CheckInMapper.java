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
	
	
	
	
}
