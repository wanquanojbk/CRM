package com.crm.mapper;

import com.crm.entity.UsersRoles;

public interface UsersRolesMapper {
	/**
	 * 
	 * @param usersRoles 根据用户角色进行添加
	 * @return
	 */
	public Integer insertUsersRoles(UsersRoles usersRoles);
	/**
	 * 
	 * @param usersRoles 删除角色
	 * @return
	 */
	public Integer deleteUsersRoles(UsersRoles usersRoles);
}
