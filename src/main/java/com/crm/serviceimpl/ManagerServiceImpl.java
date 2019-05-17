package com.crm.serviceimpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.CheckIn;
import com.crm.entity.Clue;
import com.crm.entity.PageNation;
import com.crm.entity.Users;
import com.crm.mapper.CheckInMapper;
import com.crm.mapper.ClueMapper;
import com.crm.mapper.UsersMapper;
import com.crm.service.ManagerService;
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	private UsersMapper UsersMapper;
	@Autowired
	private CheckInMapper checkInMapper;
	@Autowired
	private CheckIn checkIn;
	@Autowired
	private ClueMapper clueMapper;
	
	@Override
	public PageNation allEmployee(PageNation pageNation,HttpSession session) {
		// TODO Auto-generated method stub
		Users attribute = (Users)session.getAttribute("users");
		Integer row =Integer.parseInt((String)pageNation.getRows().get(0)) ;
		pageNation.setPage((pageNation.getPage()-1)*row);
		pageNation.setRow(row);
		pageNation.setNum6(attribute.getUsers_Id());
		pageNation.setRows(checkInMapper.selectCheck(pageNation));
		pageNation.setTotal(checkInMapper.selectCheckCount(pageNation));
		return pageNation;
	}
	@Override
	public List<?> checkEmployee(HttpSession session) {
		// TODO Auto-generated method stub
		Users attribute = (Users)session.getAttribute("users");
		return UsersMapper.selectCheckedUsers(attribute.getUsers_Id());
	}
	@Override
	public Boolean checkedEmployee(String ids) {
		String[] split = ids.split(",");
		int j=0;
		for (int i = 0; i < split.length; i++) {
			j+=UsersMapper.updateUsersCheckedById(Integer.parseInt(split[i]));
			checkIn.setCheckIn_UserId(Integer.parseInt(split[i]));
			j+=checkInMapper.updateCheckedById(checkIn);
		}
		if(j>0)
			return true;
		return false;
	}
	@Override
	public List<Clue> shoudong(HttpSession session) {
		Users attribute = (Users)session.getAttribute("users");
		return clueMapper.selectAllUnFenPeiClue(attribute.getUsers_Id());
	}

}
