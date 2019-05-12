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
	@Override
	public Integer rolesAndModules(String ids, Integer roles_id) {
		// TODO Auto-generated method stub
		rolesMapper.deleteAllPermissiontbByRolesIdId(roles_id);
		rolesMapper.deleteAllRolePermissiontbByRolesId(roles_id);
		String[] split = ids.split(",");
		Integer[] array = new Integer[split.length];
		for(int i=0;i<split.length;i++) {
			array[i]=Integer.parseInt(split[i]);
		}
		for(int i=0;i<array.length;i++) {
			//先插入权限
			
			
			
			//根据权限返回主键同时插入中间表
		}
		return null;
	}

}
