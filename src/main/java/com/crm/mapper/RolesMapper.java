package com.crm.mapper;

import java.util.List;

import com.crm.entity.Roles;
import com.crm.entity.Modules;
import com.crm.entity.PageNation;
import com.crm.entity.Permissiontb;
import com.crm.entity.RolePermissiontb;

public interface RolesMapper {
	/**
	 * @param UsersId 根据用户id查到该用户的所有角色
	 * @return 角色集合
	 */
	List<Roles> selectRolesByUsersId(Integer UsersId);
	/**
	 * @param 
	 * @return 数据库所有不重名的角色
	 */
	List<Roles> selectAllRolesDistinct();
	/**
	 * 
	 * @param pageNation 分页对象
	 * @return 所有数据
	 */
	List<Roles> selectAllRoles(PageNation pageNation);
	/**
	 * 
	 * @param pageNation 分页对象
	 * @return 数据库所有不重名的角色的条数
	 */
	Integer selectAllRolesCount(PageNation pageNation);
	/**
	 * 根据角色 进行添加
	 * @param roles  角色
	 * @return 受影响行数
	 */
	Integer insertRoles(Roles roles);
	/**
	 * 根据角色id进行删除返回受影响行数
	 * @param roles_Id 角色id
	 * @return 受影响行数
	 */
	Integer deleteRoles(Integer roles_Id);
	/**
	 * 根据角色 进行修改
	 * @param roles 角色
	 * @return 受影响行数
	 */
	Integer updateRoles(Roles roles);
	
	/**
	 * 
	 * @param roles 根据roles里面name查出来有没有重名的角色
	 * @return 查询出来的角色
	 */
	Roles selectRolesByRolesName(Roles roles);
	/**
	 * 
	 * @param rolesId 根据角色id 删除所有和该模块关联的权限数据
	 * @return 受影响行数
	 */
	Integer deleteAllPermissiontbByRolesIdId(Integer rolesId);
	
	/**
	 * 
	 * @param rolesId 根据角色id 删除所有和该角色的中间表数据
	 * @return 受影响行数
	 */
	Integer deleteAllRolePermissiontbByRolesId(Integer rolesId);
	
	/**
	 * 
	 * @param permissiontb 插入权限
	 * @return
	 */
	Integer insertPermissiontb(Permissiontb permissiontb);
	
	/**
	 * 
	 * @param rolePermissiontb 插入权限角色中间表
	 * @return
	 */
	Integer insertRolePermissiontb(RolePermissiontb rolePermissiontb);
	
	
}
