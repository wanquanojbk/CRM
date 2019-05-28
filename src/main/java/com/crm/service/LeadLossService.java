package com.crm.service;

import com.crm.entity.LeadLoss;

public interface LeadLossService {
	/**
	 * 
	 * @param leadLoss 添加一个流失记录
	 * @return
	 */
	public Boolean insertLeadLoss(LeadLoss leadLoss);
}
