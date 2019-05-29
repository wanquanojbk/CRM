package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.crm.entity.LeadLoss;
import com.crm.service.LeadLossService;

@Controller
@RequestMapping("/LeadLoss")
public class LeadLossController {
	@Autowired
	private LeadLossService leadLossService;
	@RequestMapping("/leadLossClue")
	public Boolean insertLeadLossService(Integer clueId) {
		LeadLoss leadLoss = new LeadLoss();
		leadLoss.setLeadLoss_ClueId(clueId);
		return leadLossService.insertLeadLoss(leadLoss);
	}
}
