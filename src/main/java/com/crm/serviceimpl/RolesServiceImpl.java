package com.crm.serviceimpl;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.PageNation;
import com.crm.entity.Permissiontb;
import com.crm.entity.RolePermissiontb;
import com.crm.entity.Roles;
import com.crm.mapper.RolesMapper;
import com.crm.service.RolesService;

@Service
@Transactional
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
	public Boolean rolesAndModules(String ids, Integer roles_id) {
		// TODO Auto-generated method stub
		rolesMapper.deleteAllPermissiontbByRolesIdId(roles_id);
		rolesMapper.deleteAllRolePermissiontbByRolesId(roles_id);
		String[] split = ids.split(",");
		Integer[] array = new Integer[split.length];
		for(int i=0;i<split.length;i++) {
			array[i]=Integer.parseInt(split[i]);
		}
		int j=0;
		for(int i=0;i<array.length;i++) {
			//先插入权限
			System.out.println(array[i]);
			Permissiontb permissiontb = new Permissiontb();
			permissiontb.setPermissiontb_Value("所有权限");
			permissiontb.setPermissiontb_Module("测试跟进");
			permissiontb.setPermissiontb_Name("测试");
			permissiontb.setPermissiontb_ModuleId(array[i]);
			System.out.println(permissiontb.getPermissiontb_Id());
			j+=rolesMapper.insertPermissiontb(permissiontb);
			RolePermissiontb rolePermissiontb =new RolePermissiontb();
			rolePermissiontb.setRolePermissiontb_RoleId(roles_id);
			rolePermissiontb.setRolePermissiontb_PermissionId(permissiontb.getPermissiontb_Id());
			j+=rolesMapper.insertRolePermissiontb(rolePermissiontb);
			//根据权限返回主键同时插入中间表
		}
		if(j%2==0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	@Override
	public Boolean testRolesName(Roles roles) {
		Roles role = rolesMapper.selectRolesByRolesName(roles);
		if(role!=null) {
			return true;
		}
		return false;
	}
	@Override
	public Boolean insertRoles(Roles roles) {
		Integer i = rolesMapper.insertRoles(roles);
		if(i>0)
			return true;
		return false;
	}
	@Override
	public Boolean deleteRoles(String ids) {
		// TODO Auto-generated method stub
		String[] split = ids.split(",");
		int j=0;
		for (int i = 0; i < split.length; i++) {
			j+=rolesMapper.deleteRoles(Integer.parseInt(split[i]));
		}
		if(j>0)
			return true;
		return false;
	}

}
