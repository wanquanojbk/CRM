package com.crm.service;

import com.crm.entity.PageNation;

public interface RolesService {
	/**
	 * 
	 * @param pageNation 分页对象
	 * @return 分页对象
	 */
	public PageNation rolesStartPage(PageNation pageNation);
}
