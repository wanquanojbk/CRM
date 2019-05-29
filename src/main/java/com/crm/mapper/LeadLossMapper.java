package com.crm.mapper;

import com.crm.entity.LeadLoss;

public interface LeadLossMapper {
	/**
	 * 
	 * @param leadLoss 添加一个流失记录
	 * @return
	 */
	public int insertLeadLoss(LeadLoss leadLoss);
}
