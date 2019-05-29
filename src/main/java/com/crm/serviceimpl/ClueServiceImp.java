package com.crm.serviceimpl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.Clue;
import com.crm.entity.Distribution;
import com.crm.entity.PageNation;
import com.crm.entity.Student;
import com.crm.entity.Users;
import com.crm.mapper.ClueMapper;
import com.crm.mapper.DistributionMapper;
import com.crm.mapper.StudentMapper;
import com.crm.mapper.UsersMapper;
import com.crm.service.ClueService;
import com.crm.service.ManagerService;


@Service
@Transactional
public class ClueServiceImp implements ClueService {
	
	@Autowired
	private ClueMapper clueMapper;
	@Autowired
	private UsersMapper usersMapper;
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private DistributionMapper distributionMapper;
	@Autowired
	private ManagerService managerService;
	@Override
	public PageNation getAll(PageNation pageNation,HttpSession session) {
		// TODO Auto-generated method stub
		Users users =(Users) session.getAttribute("users");
		pageNation.setNum1(users.getUsers_Id());
		Integer row = Integer.parseInt((String) pageNation.getRows().get(0));
		pageNation.setPage((pageNation.getPage()-1)*row);
		pageNation.setRow(row);
		List<Clue> selectClueAll = clueMapper.selectClueAll(pageNation);
		Integer selectClueGetTotal = clueMapper.selectClueGetTotal(pageNation);
		pageNation.setRows(selectClueAll);
		pageNation.setTotal(selectClueGetTotal);
		return pageNation;
	}

	@Override
	public Integer addClue(Clue clue, HttpSession session) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// TODO Auto-generated method stub
		//获取创建人的id
		Users users = (Users) session.getAttribute("users");
		clue.setClue_Creator(users.getUsers_Id());
		clue.setClue_CreateTime(simpleDateFormat.format(new Date()));
		Integer insertClue = clueMapper.insertClue(clue);
		return insertClue;
	}

	@Override
	public PageNation getCustomers(PageNation pageNation, HttpSession session) {
		// TODO Auto-generated method stub
		Users users =(Users) session.getAttribute("users");
		pageNation.setNum1(users.getUsers_Id());
		Integer row = Integer.parseInt((String) pageNation.getRows().get(0));
		pageNation.setPage((pageNation.getPage()-1)*row);
		pageNation.setRow(row);
		List<Clue> selectClueByConsultation = clueMapper.selectClueByConsultation(pageNation);
		Integer selectClueByConsultationCount = clueMapper.selectClueByConsultationCount(pageNation);
		pageNation.setRows(selectClueByConsultation);
		pageNation.setTotal(selectClueByConsultationCount);
		return pageNation;
	}

	@Override
	public List<Clue> getClue(PageNation pageNation, HttpSession session) {
		Users users =(Users) session.getAttribute("users");
		pageNation.setNum1(users.getUsers_Id());
		// TODO Auto-generated method stub
		List<Clue> selectClueByPrincipalId = clueMapper.selectClueByPrincipalId(pageNation);
		return selectClueByPrincipalId;
	}

	@Override
	public Integer updateFangQi(Integer id,HttpSession session) {
		Users users =(Users) session.getAttribute("users");
		// TODO Auto-generated method stub
		Integer updateClueByAbandon = clueMapper.updateClueByAbandon(id);
		usersMapper.updatefangqi(users.getUsers_Id());
		return updateClueByAbandon;
	}

	@Override
	public Integer updateChengGong(Integer id,HttpSession session) {
		Student stu = new Student();
		Clue selectClueById = clueMapper.selectClueById(id);
		stu.setStudent_Name(selectClueById.getClue_Name());
		stu.setStudent_Sex(selectClueById.getClue_Sex());
		stu.setStudent_Birthday(selectClueById.getClue_Birthday());
		stu.setStudent_Source(selectClueById.getClue_Source());
		stu.setStudent_IdentityNumber(selectClueById.getClue_IdentityNumber());
		stu.setStudent_Email(selectClueById.getClue_Email());
		stu.setStudent_Qq(selectClueById.getClue_Qq());
		stu.setStudent_Tel(selectClueById.getClue_Tel());
		stu.setStudent_Address(selectClueById.getClue_Address());
		stu.setStudent_Creator(selectClueById.getClue_Creator());
		stu.setStudent_Remarks(selectClueById.getClue_Direction());
		Users users =(Users) session.getAttribute("users");
		// TODO Auto-generated method stub
		Integer updateClueByComplete = clueMapper.updateClueByComplete(id);
		usersMapper.updatewancheng(users.getUsers_Id());
		studentMapper.insertStudent(stu);
		
		Users user = usersMapper.selectUsersByUsersId(users.getUsers_Id());
		Distribution distribution = distributionMapper.selectDistributionByManagerId(user.getUsers_Exit1());
		
		Boolean distribution_Status = distribution.getDistribution_Status();
		if(distribution_Status) {
			managerService.openDistribution(user.getUsers_Exit1());
		}
		
		return updateClueByComplete;
	}

	@Override
	public Integer updateCustomer(Clue clue) {
		// TODO Auto-generated method stub
		Integer updateClueByCustomer = clueMapper.updateClueByCustomer(clue);
		return updateClueByCustomer;
	}

	@Override
	public PageNation getClueByComplete(PageNation pageNation,HttpSession httpsession) {
		Users users =(Users) httpsession.getAttribute("users");
		pageNation.setNum1(users.getUsers_Id()); 
		// TODO Auto-generated method stub
		Integer row = Integer.parseInt((String) pageNation.getRows().get(0));
		pageNation.setPage((pageNation.getPage()-1)*row);
		pageNation.setRow(row);
		List<Clue> selectClueByComplete = clueMapper.selectClueByComplete(pageNation);
		System.out.println(selectClueByComplete);
		Integer selectClueByCompleteCount = clueMapper.selectClueByCompleteCount(pageNation);
		pageNation.setRows(selectClueByComplete);
		pageNation.setTotal(selectClueByCompleteCount);
		return pageNation;
	}
	@Override
	public List<Clue> selectAll(HttpSession httpsession) {
		Users users =(Users) httpsession.getAttribute("users");
		// TODO Auto-generated method stub
		List<Clue> selectAll = clueMapper.selectAll(users.getUsers_Id());
		return selectAll;
	}
	@Override
	public List<Clue> selectClueByid(String id) {
		// TODO Auto-generated method stub
		String[] split= id.split(",");
		Integer[] integer = new Integer[split.length];
		for(int i=0;i<split.length;i++) {
			integer[i]=Integer.parseInt(split[i]);
		}
		List<Clue> selectByidList = clueMapper.selectByidList(integer);
		System.out.println(selectByidList+"---------------------------------");
		return selectByidList;
	}

	@Override
	public Double selectZXSLoss(Integer usersId) {
		// TODO Auto-generated method stub
		Double selectZXSLoss = clueMapper.selectZXSLoss(usersId);
		return selectZXSLoss;
	}

	@Override
	public List<Clue> selectClueByAll(HttpSession session) {
		Users users =(Users) session.getAttribute("users");
		// TODO Auto-generated method stub
		List<Clue> selectClueByAll = clueMapper.selectClueByAll(users.getUsers_Id());
		return selectClueByAll;
	}

	@Override
	public List<Clue> selectClueByPrincipal(HttpSession session) {
		Users users =(Users) session.getAttribute("users");
		// TODO Auto-generated method stub
		List<Clue> selectClueByPrincipal = clueMapper.selectClueByPrincipal(users.getUsers_Id());
		return selectClueByPrincipal;
	}

	@Override
	public Integer[] selectClueEcharts(HttpSession session) {
		// TODO Auto-generated method stub
		Integer[] suzu = new Integer[4];
		Users users =(Users) session.getAttribute("users");
		Integer count = clueMapper.selectMyClueCount(users.getUsers_Id());
		suzu[0]=count;
		Integer girl = clueMapper.selectMyClueGirl(users.getUsers_Id());
		suzu[1]=girl;
		Integer ing = clueMapper.selectMyclueIng(users.getUsers_Id());
		suzu[2]=ing;
		Integer loss = clueMapper.selectMyClueLoss(users.getUsers_Id());
		suzu[3]=loss;
		return suzu;
	}

}
