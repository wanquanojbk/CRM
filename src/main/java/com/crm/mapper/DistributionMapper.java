package com.crm.mapper;

import com.crm.entity.Distribution;

public interface DistributionMapper {
	/**
	 * 
	 * @param id 根据经理id来进行 查询数据
	 * @return
	 */
	public Distribution selectDistributionByManagerId(Integer id);
	
	/**
	 * 
	 * @param usersId
	 * @return
	 */
	public int updateSwitchStatusOFF(int usersId);
	/**
	 * 
	 * @param usersId
	 * @return
	 */
	public int updateSwitchStatusON(int usersId);
	
	/**
	 * 
	 * @param distribution 为经理新添加一个开关
	 * @return
	 */
	public int insertDistribution(Distribution distribution);
}
