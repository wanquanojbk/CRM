package com.crm.mapper;

import java.util.List;

import com.crm.entity.PageNation;
import com.crm.entity.Users;

public interface UsersMapper {

	/**
	 * 通过用户名和密码和查询用户
	 * 
	 * @param users
	 * @return
	 */
	public Users selectUsers(Users users);

	/**
	 * 通过用户名查询用户是否存在
	 * 
	 * @param users
	 * @return
	 */
	public Users selectUsersByUsersName(Users users);

	/**
	 * 用户密码错误后修改密码的错误次数和锁定状态
	 * 
	 * @param users
	 * @return
	 */
	public Integer updateUsersLockout(Users users);

	/**
	 * 用户登录成功后修改失败次数为初始值(0)的方法,以及修改最后登录时间
	 * 
	 * @param users
	 * @return
	 */
	public Integer updateUserPsdWrongTimeSucessByZero(Users users);

	/**
	 * 根据用户的用户名,用户邮箱,手机号进行查找返回用户
	 * 
	 * @param users
	 * @return
	 */
	public Users selectUsersByUsersEmail(Users users);

	/**
	 * 修改用户的重置密码,这个方法的调用代表重置密码的流程到此结束
	 * @param users
	 * @return
	 */
	public Integer updateUsersChongZhiPassword(Users users);
	
	/**
	   * 查询不是管理员的用户
	 * @return
	 */
	public List<Users> selectUsersAndIsNotAdmin(PageNation pageNation);
	/**
	 * 查询不是管理员的用户的总数
	 * @return
	 */
	public Integer selectUsersAndIsNotAdminCount(PageNation pageNation);
	
	/**
	 * 
	 * @param users 根据实体类的用户信息 进行修改用户信息
	 * @return 受影响行数
	 */
	public Integer updateUsersInfoMation(Users users);
	/**
	 * 
	 * @param usersId 根据id进行锁定
	 * @return 受影响行数
	 */
	public Integer updateUsersIsLockOn(Integer usersId);
	
	/**
	 * 
	 * @param usersId 根据id进行解锁
	 * @return 受影响行数
	 */
	public Integer updateUsersIsLockOFF(Integer usersId);
	/**
	 * 
	 * @param usersId 根据客户id进行删除
	 * @return 受影响行数
	 */
	public Integer deleteUsersByUsersId(Integer usersId);
	/**
	 * 
	 * @param users 添加学生
	 * @return 受影响行数
	 */
	public Integer insertUsers(Users users);
	
	/**
	 * 根据id查询该用户
	 * @param usersId 用户id
	 * @return 该用户
	 */
	public Users selectUsersByUsersId(Integer usersId);
	
	
}
