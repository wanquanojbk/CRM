package com.crm.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.PageNation;
import com.crm.entity.Users;
import com.crm.entity.UsersRoles;
import com.crm.util.Result;

public interface UsersService {
/**
 * CRM系统登录方法,将页面用户名和密码传入
 * @param users
 * @return 为一个登录辅助类,有成功,信息,和是否锁定等参数
 * @throws UnsupportedEncodingException 
 * @throws NoSuchAlgorithmException 
 */
	public Result selectUsers(Users users,HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException;
	/**
	 * 通过用户对象中的邮件信息给发送一个随机数
	 * @param users
	 * @return 辅助类
	 */
	public Result emailRandom(Users users)throws NoSuchAlgorithmException, UnsupportedEncodingException;
	/**
	 * 传入重置密码的对象返回辅助类用来进行最后的重置密码的操作
	 * @param users
	 * @return
	 */
	public Result chongZhiPassword(Users users);
	/**
	 * 完成最后一步的用户密码重置
	 * 
	 * @param users
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public Boolean updateUsersChongZhiPassword(Users users)throws NoSuchAlgorithmException, UnsupportedEncodingException;
	/**
	 * 
	 * @param pageNation 传入分页对象,返回一个分页参数全部ok的分页对象
	 * @return
	 */
	public PageNation usersStartPage(PageNation pageNation);
	/**
	 * 批量锁定
	 * @param ids
	 * @return
	 */
	public Boolean updateUsersIsLockOn(String ids);
	/**
	 * 批量解锁
	 * @param ids
	 * @return
	 */
	public Boolean updateUsersIsLockOFF(String ids);
	/**
	 * 
	 * @param id 根据id删除
	 * @return 删除的结果
	 */
	public Boolean deleteUsersByUsersId(Integer id);
	/**
	 * 
	 * @param users 添加用户
	 * @return 受影响行数
	 */
	public Boolean insertUsers(Users users,UsersRoles usersRoles);
	/**
	 * 
	 * @param users 根据用户进行重置密码
	 * @return 受影响行数
	 */
	public Boolean updateUsersChongZhi(Users users);
	
	/**
	 * 
	 * @param id 根据id修改
	 * @return 查找的users
	 */
	public Users  selectUsersByUsersId(Integer id);
	
	/**
	 * 
	 * @param users 修改用户
	 * @return
	 */
	public Boolean updateUsers(Users users);
	/**
	 * 
	 * @return 所有的角色
	 * 
	 */
	public PageNation selectAllRoles();
	/**
	 * 
	 * @param id
	 * @return
	 */
	public PageNation selectRolesByUsersId(Integer id);
	/**
	 * 
	 * @param id 用户编号
	 * @param ids 角色数组
	 * @return
	 */
	public Boolean deleteUsersRoles(Integer id,String ids);
	/**
	 * 
	 * @param id 用户编号
	 * @param ids 角色数组
	 * @return
	 */
	public Boolean insertUsersRoles(Integer id,String ids);
	/**
	 * 
	 * @param users 根据用户信息 判断该用户的用户名是否重复,决定能否继续添加
	 * @return 能或者不能
	 */
	public Boolean testLoginName(Users users);
	
	
	public void code(HttpServletRequest request,HttpServletResponse response);
	
}
