package com.crm.mapper;

import java.util.List;

import com.crm.entity.Modules;

public interface ModulesMapper {
/**
 * 通过用户Id检索当前用户的所有模块
 * @param users_Id
 * @return
 */
public List<Modules> selectByUserId(Integer users_Id);




/**
 * 根据一个module对象查出这个对象到底是不是最底层的节点
* @param modules 模块对象
* @return 
*/
public List<Modules> selectLeafNode(Modules modules);

/**
 * 查询所有模块
 * @return
 */
public List<Modules> selectAllModules();


/**
 * 
 * @param RolesId 根据角色id 查询出来所有模块
 * @return 集合
 */
List<Modules> selectModulesByRoleId(Integer RolesId);


Modules selectModules(Integer modulesId);

}
