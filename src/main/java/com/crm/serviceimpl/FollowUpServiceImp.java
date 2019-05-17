package com.crm.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.entity.FollowUp;
import com.crm.entity.PageNation;
import com.crm.entity.Users;
import com.crm.mapper.FollowUpMapper;
import com.crm.service.FollowUpService;
@Service
public class FollowUpServiceImp implements FollowUpService {
	@Autowired
	private FollowUpMapper followUpMapper;
	@Override
	public PageNation getFollowUp(PageNation pageNation, HttpSession session) {
		Users users =(Users) session.getAttribute("users");
		pageNation.setNum1(users.getUsers_Id());
		// TODO Auto-generated method stub
		Integer row = Integer.parseInt((String) pageNation.getRows().get(0));
		pageNation.setPage((pageNation.getPage()-1)*row);
		pageNation.setRow(row);
		List<FollowUp> selectFollowUpAll = followUpMapper.selectFollowUpAll(pageNation);
		System.out.println(selectFollowUpAll);
		Integer selectFollowUpCount = followUpMapper.selectFollowUpCount(pageNation);
		pageNation.setRows(selectFollowUpAll);
		pageNation.setTotal(selectFollowUpCount);
		return pageNation;
	}
	@Override
	public Integer addFollowUp(FollowUp followUp, HttpSession session) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Users users =(Users) session.getAttribute("users");
		followUp.setFollwUp_Principal(users.getUsers_Id());
		followUp.setFollwUp_Time(sdf.format(new Date()));
		// TODO Auto-generated method stub
		Integer insertFollowUp = followUpMapper.insertFollowUp(followUp);
		return insertFollowUp;
	}
	@Override
	public Integer updFollowUp(FollowUp followUp) {
		// TODO Auto-generated method stub
		return followUpMapper.updFollowUp(followUp);
	}
}
