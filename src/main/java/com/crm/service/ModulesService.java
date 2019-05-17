package com.crm.service;

import java.util.List;
import java.util.Map;

import com.crm.entity.Modules;

public interface ModulesService {
	/**
	 * 通过用户Id检索当前用户的所有模块
	 * @param users_Id
	 * @return
	 */
	public List<Map<String,Object>> selectByUserId(Integer users_Id);
	
	
	


	public List<Map<String,Object>> selectAllModules();
	
	
	
	public List<Map<String,Object>> selectAllModulesCheckedByRoles(Integer rolesId );
	
	
	/**
	 * 
	 * @param modules 添加模块
	 * @return
	 */
	Boolean insertModules(Modules modules);
	/**
	 * 
	 * @param modules 模块
	 * @return
	 */
	Boolean deleteModules(Modules modules);

	/**
	 * 
	 * @param modules 修改模块
	 * @return
	 */
	Boolean updateModules(Modules modules);

	/**
	 * 
	 * @param modules 查询模块根据模块
	 * @return
	 */
	Boolean selectModulesByModuleName(Modules modules);
	
	
	
	/*
	 * 
	 * 角色表         角色权限中间表          权限表           模块表  
	 * 		   
	 * 
	 * 角色表         角色模块中间表                    模块表  
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	
}
