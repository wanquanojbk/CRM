package com.crm.serviceimpl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.entity.Clue;
import com.crm.entity.PageNation;
import com.crm.entity.Users;
import com.crm.mapper.ClueMapper;
import com.crm.service.ClueService;

@Service
public class ClueServiceImp implements ClueService {
	
	@Autowired
	private ClueMapper clueMapper;

	@Override
	public PageNation getAll(PageNation pageNation,HttpSession session) {
		// TODO Auto-generated method stub
		Users users =(Users) session.getAttribute("users");
		pageNation.setNum1(users.getUsers_Id());
		Integer row = Integer.parseInt((String) pageNation.getRows().get(0));
		pageNation.setPage((pageNation.getPage()-1)*row);
		pageNation.setRow(row);
		List<Clue> selectClueAll = clueMapper.selectClueAll(pageNation);
		Integer selectClueGetTotal = clueMapper.selectClueGetTotal(pageNation);
		pageNation.setRows(selectClueAll);
		pageNation.setTotal(selectClueGetTotal);
		return pageNation;
	}

	@Override
	public Integer addClue(Clue clue, HttpSession session) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// TODO Auto-generated method stub
		//获取创建人的id
		Users users = (Users) session.getAttribute("users");
		clue.setClue_Creator(users.getUsers_Id());
		clue.setClue_CreateTime(simpleDateFormat.format(new Date()));
		Integer insertClue = clueMapper.insertClue(clue);
		return insertClue;
	}

	@Override
	public PageNation getCustomers(PageNation pageNation, HttpSession session) {
		// TODO Auto-generated method stub
		Users users =(Users) session.getAttribute("users");
		pageNation.setNum1(users.getUsers_Id());
		Integer row = Integer.parseInt((String) pageNation.getRows().get(0));
		pageNation.setPage((pageNation.getPage()-1)*row);
		pageNation.setRow(row);
		List<Clue> selectClueByConsultation = clueMapper.selectClueByConsultation(pageNation);
		Integer selectClueByConsultationCount = clueMapper.selectClueByConsultationCount(pageNation);
		pageNation.setRows(selectClueByConsultation);
		pageNation.setTotal(selectClueByConsultationCount);
		return pageNation;
	}

	@Override
	public List<Clue> getClue(PageNation pageNation, HttpSession session) {
		Users users =(Users) session.getAttribute("users");
		pageNation.setNum1(users.getUsers_Id());
		// TODO Auto-generated method stub
		List<Clue> selectClueByPrincipalId = clueMapper.selectClueByPrincipalId(pageNation);
		return selectClueByPrincipalId;
	}

	@Override
	public Integer updateFangQi(Integer id) {
		// TODO Auto-generated method stub
		Integer updateClueByAbandon = clueMapper.updateClueByAbandon(id);
		return updateClueByAbandon;
	}

	@Override
	public Integer updateChengGong(Integer id) {
		// TODO Auto-generated method stub
		Integer updateClueByComplete = clueMapper.updateClueByComplete(id);
		return updateClueByComplete;
	}

	@Override
	public Integer updateCustomer(Clue clue) {
		// TODO Auto-generated method stub
		Integer updateClueByCustomer = clueMapper.updateClueByCustomer(clue);
		return updateClueByCustomer;
	}

	@Override
	public PageNation getClueByComplete(PageNation pageNation,HttpSession httpsession) {
		Users users =(Users) httpsession.getAttribute("users");
		pageNation.setNum1(users.getUsers_Id()); 
		// TODO Auto-generated method stub
		Integer row = Integer.parseInt((String) pageNation.getRows().get(0));
		pageNation.setPage((pageNation.getPage()-1)*row);
		pageNation.setRow(row);
		List<Clue> selectClueByComplete = clueMapper.selectClueByComplete(pageNation);
		System.out.println(selectClueByComplete);
		Integer selectClueByCompleteCount = clueMapper.selectClueByCompleteCount(pageNation);
		pageNation.setRows(selectClueByComplete);
		pageNation.setTotal(selectClueByCompleteCount);
		return pageNation;
	}

}
