package com.crm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.Clue;
import com.crm.entity.LeadLoss;
import com.crm.mapper.ClueMapper;
import com.crm.mapper.LeadLossMapper;
import com.crm.service.LeadLossService;
@Service
@Transactional
public class LeadLossServiceImpl implements LeadLossService {
	 @Autowired
	 private LeadLossMapper leadLossMapper;
	 @Autowired
	 private ClueMapper clueMapper;
	@Override
	public Boolean insertLeadLoss(LeadLoss leadLoss) {
		Clue clue = clueMapper.selectClueById(leadLoss.getLeadLoss_ClueId());
		leadLoss.setLeadLoss_Time(clue.getClue_BginTime());
		leadLoss.setLeadLoss_Text("放弃");
		leadLoss.setLeadLoss_UsersId(clue.getClue_Principal());
		int insertLeadLoss = leadLossMapper.insertLeadLoss(leadLoss);
		if(insertLeadLoss>0)
			return true;
		return false;
	}

}
