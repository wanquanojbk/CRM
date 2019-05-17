package com.crm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.Classes;
import com.crm.entity.PageNation;
import com.crm.mapper.CampusMapper;
import com.crm.service.CampusService;
@Service
@Transactional
public class CampusServiceImpl implements CampusService {
	
	@Autowired
	private CampusMapper campusMapper;

	@Override
	public PageNation selectClasses(PageNation pageNation) {
		row(pageNation);
		pageNation.setRows(campusMapper.selectClasses(pageNation));
		pageNation.setTotal(campusMapper.countClasses(pageNation));
		return pageNation;
	}
	
	@Override
	@Transactional
	public Integer addClasses(PageNation pageNation) {
		return campusMapper.addClasses(pageNation);
	}
	
	@Override
	@Transactional
	public Integer UpdateClasses(Classes classes) {
		return campusMapper.UpdateClasses(classes);
	}

	@Override
	@Transactional
	public Integer DeleteClasses(PageNation pageNation) {
		return campusMapper.DeleteClasses(pageNation);
	}
	
	@Override
	public PageNation selectUsers(PageNation pageNation) { 
		row(pageNation);
		pageNation.setRows(campusMapper.selectUsers(pageNation));
		pageNation.setTotal(campusMapper.countUsers(pageNation));
		return pageNation;
	}

	@Override
	public PageNation selectStudent(PageNation pageNation) {
		row(pageNation);
		pageNation.setRows(campusMapper.selectStudent(pageNation));
		pageNation.setTotal(campusMapper.countStudent(pageNation));
		return pageNation;
	}
	
	public PageNation row(PageNation pageNation) {
		if(pageNation.getPage()!=null) {
			Integer row =Integer.parseInt((String)pageNation.getRows().get(0));
			pageNation.setRow(row);
			pageNation.setPage((pageNation.getPage()-1)*row);
		}
		return pageNation;
	}


}
