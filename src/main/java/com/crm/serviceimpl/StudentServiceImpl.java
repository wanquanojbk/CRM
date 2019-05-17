package com.crm.serviceimpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.PageNation;
import com.crm.entity.Student;
import com.crm.entity.Users;
import com.crm.mapper.StudentMapper;
import com.crm.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;
	@Override
	public PageNation selectStudent(PageNation pageNation,HttpSession session) {
		// TODO Auto-generated method stub
		Integer selectCount = studentMapper.selectCount(pageNation);
		List<Student> selectStudent = studentMapper.selectStudent(pageNation);
		pageNation.setTotal(selectCount);
		pageNation.setRows(selectStudent);
		System.out.println(selectCount);
		System.out.println(selectStudent);
		return pageNation;
	}
	@Override
	public List<Student> selectAllCheckedStudent(String ids) {
		// TODO Auto-generated method stub
		System.out.println(ids+"-------------------------.............................................");
		String[] split = ids.split(",");
		System.out.println(split+"-------------------------");
		Integer[] array =new Integer[split.length];
		for(int i=0;i<array.length;i++) {
			System.out.println(split[i]);
			array[i] = Integer.parseInt(split[i]);
		}
		List<Student> list = studentMapper.selectAllCheckedStudent(array);
		return list;
	}
	@Override
	public List<Student> slectAll(HttpSession session) {
		// TODO Auto-generated method stub
		Users users =(Users) session.getAttribute("users");
		List<Student> list = studentMapper.selectAll(users.getUsers_Id());
		return list;
	}
	

}
