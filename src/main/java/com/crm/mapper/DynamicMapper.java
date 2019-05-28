package com.crm.mapper;

import java.util.List;

import com.crm.entity.Dynamic;

public interface DynamicMapper {
	/**
	 * 添加动态信息
	 * @param dynamic
	 * @return
	 */
	Integer insertDynamic(Dynamic dynamic);
	
	
	List<Dynamic> selectMySelfWeiDuMessage(Integer usersId);
	
	/**
	 * 
	 * @param dynamic_Id 修改信息状态
	 * @return
	 */
	Integer uapateStatus(Integer dynamic_Id);
}
