package com.crm.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.crm.entity.Dynamic;
import com.crm.entity.Users;

@Service
public interface DynamicService {
	/**
	 * 添加动态信息
	 * @param dynamic
	 * @return
	 */
	Integer insertDynamic(Dynamic dynamic,HttpSession session);
	/**
	 * 查询所有用户的id和姓名
	 * @return
	 */
	List<Users> selectUsersAll();
}
