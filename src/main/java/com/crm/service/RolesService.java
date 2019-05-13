package com.crm.service;

import com.crm.entity.PageNation;
import com.crm.entity.Roles;

public interface RolesService {
	/**
	 * 
	 * @param pageNation 分页对象
	 * @return 分页对象
	 */
	public PageNation rolesStartPage(PageNation pageNation);
	
	/**
	 * 
	 * @param ids
	 * @param roles_id
	 * @return
	 */
	public Boolean rolesAndModules(String ids,Integer roles_id);
	
	/**
	 * 
	 * @param roles 根据角色查询是否重名
	 * @return 
	 */
	public Boolean testRolesName(Roles roles);
	
	/**
	 * 
	 * @param roles 添加角色
	 * @return
	 */
	public Boolean insertRoles(Roles roles);
	
	/**
	 * 
	 * @param ids id组成的数组
	 * @return 结果
	 */
	public Boolean deleteRoles(String ids);
}
