package com.crm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.entity.PageNation;
import com.crm.mapper.RolesMapper;
import com.crm.service.RolesService;

@Service
public class RolesServiceImpl  implements RolesService{
	@Autowired
	private RolesMapper rolesMapper;
	@Override
	public PageNation rolesStartPage(PageNation pageNation) {
		// TODO Auto-generated method stub
		Integer row =Integer.parseInt((String)pageNation.getRows().get(0));
		pageNation.setRow(row);
		pageNation.setPage((pageNation.getPage()-1)*row);
		pageNation.setRows(rolesMapper.selectAllRoles(pageNation));
		pageNation.setTotal(rolesMapper.selectAllRolesCount(pageNation));
		return pageNation;
	}

}
