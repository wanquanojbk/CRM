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
		//是否迟到  如果迟到 为 1 不迟到 为 0 默认为0
		boolean isNow=LocalTime.now().isAfter(LocalTime.of(8,00,00));
		if (isNow) {
			//设置状态为迟到
			checkIn.setCheckIn_Late(1);
		}
		// 否则就是未迟到
		else {
			checkIn.setCheckIn_Late(0);
		}
		
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
	@Override
	public Integer selectYuanGongQianDao(Integer usersId) {
		Integer yuangong = checkInMapper.selectYuanGongDangYueQianDao(usersId);
		return yuangong;
	}

}
