package com.crm.serviceimpl;

import java.time.LocalTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.CheckIn;
import com.crm.entity.Users;
import com.crm.mapper.CheckInMapper;
import com.crm.mapper.UsersMapper;
import com.crm.service.CheckInService;
@Service
@Transactional
public class CheckInServiceImpl implements CheckInService {
	@Autowired
	private CheckInMapper checkInMapper;
	@Autowired
	private UsersMapper usersMapper;
	@Autowired
	private CheckIn checkIn;
	@Override
	public Boolean startCheckId(HttpSession session) {
		// TODO Auto-generated method stub
		// 1. 获取当前时间，包含毫秒数 -----打印输出----- 21:03:26.315
		LocalTime localTime = LocalTime.now(); 
		Users users = (Users)session.getAttribute("users");
		checkIn.setCheckIn_UserId(users.getUsers_Id());
		checkIn.setCheckIn_Status(2);
		LocalTime localTime2 = localTime.withNano(0);
		checkIn.setCheckIn_WorkingHours(localTime2.toString());
		Integer j = checkInMapper.insertCheck(checkIn);
		Integer i = usersMapper.updateUesrsCheckById(users.getUsers_Id());
		if(i+j==2) {
			return true;
		}
		return false;
	}

}
