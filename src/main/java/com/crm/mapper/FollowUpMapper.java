package com.crm.mapper;

import java.util.List;

import com.crm.entity.FollowUp;
import com.crm.entity.PageNation;

public interface FollowUpMapper {
	/**
	 * 多条件分页查询跟踪表
	 * @param pageNation
	 * @return 跟踪表的集合
	 */
	public List<FollowUp> selectFollowUpAll(PageNation pageNation);
	/**
	 * 多条件查询跟踪总数
	 * @param pageNation
	 * @return
	 */
	public Integer selectFollowUpCount(PageNation pageNation);
	/**
	 * 添加跟踪信息
	 * @param pageNation
	 * @return
	 */
	public Integer insertFollowUp(FollowUp followUp);
	/**
	 * 修改客户信息
	 * @param followUp
	 * @return
	 */
	public Integer updFollowUp(FollowUp followUp);
}
