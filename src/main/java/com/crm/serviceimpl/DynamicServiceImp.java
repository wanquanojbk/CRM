package com.crm.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.Dynamic;
import com.crm.entity.Users;
import com.crm.mapper.DynamicMapper;
import com.crm.mapper.UsersMapper;
import com.crm.service.DynamicService;

@Service
@Transactional
public class DynamicServiceImp implements DynamicService {
	
	@Autowired
	private DynamicMapper dynamicMapper;
	@Autowired
	private UsersMapper usersMapper;

	@Override
	public Integer insertDynamic(Dynamic dynamic,HttpSession session) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//新增动态信息
		Users users = (Users) session.getAttribute("users");
		dynamic.setDynamic_Creator(users.getUsers_Id());//用户id
		dynamic.setDynamic_CreateTime(simpleDateFormat.format(new Date()));//时间
		// TODO Auto-generated method stub
		Integer insertDynamic = dynamicMapper.insertDynamic(dynamic);
		System.out.println(insertDynamic+"--------------");
		return insertDynamic;
	}

	@Override
	public List<Users> selectUsersAll() {
		
		List<Users> selectUsersAll = usersMapper.selectUsersAll();
		// TODO Auto-generated method stub
		return selectUsersAll;
	}

}
