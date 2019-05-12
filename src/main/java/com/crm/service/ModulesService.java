package com.crm.service;

import java.util.List;
import java.util.Map;

public interface ModulesService {
	/**
	 * 通过用户Id检索当前用户的所有模块
	 * @param users_Id
	 * @return
	 */
	public List<Map<String,Object>> selectByUserId(Integer users_Id);
	
	/**
	 * 
	 * @return 查询所有模块转换成树
	 */
	//public List<Map<String,Object>> selectAllModules();
	
	
	
	public List<Map<String,Object>> selectAllModulesCheckedByRoles(Integer rolesId );
	
	
	
	
}
