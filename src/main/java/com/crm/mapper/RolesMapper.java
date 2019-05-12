package com.crm.mapper;

import java.util.List;

import com.crm.entity.Roles;
import com.crm.entity.PageNation;

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
	

}
