package com.crm.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.Users;
import com.crm.mapper.UsersMapper;
import com.crm.service.SocketService;

@Service
@Transactional
public class SocketServiceImpl implements SocketService {
	@Autowired
	private UsersMapper usersMapper;
	@Override
	public Map<String, Object> getLayIm(HttpSession session) {
		// TODO Auto-generated method stub
		Users users = (Users)session.getAttribute("users");  // 自己
		List<Users> usersList = usersMapper.selectAll();//所有人
		List<Map<String,Object>> friend = new ArrayList<Map<String,Object>>(); // 好友列表
		List<Map<String,Object>> group = new ArrayList<Map<String,Object>>(); // 好友列表
		Map<String,Object> san = new HashMap<String, Object>(); //要返回的
		san.put("groupname", "前端群");
		san.put("id", "101");
		san.put("avatar", "/CRM/img/cat.jpg");
		group.add(san);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String, Object>(); //要返回的
		map.put("code", 0);
		map.put("msg", "");
		Map<String,Object> data = new HashMap<String, Object>(); //封装完放进data
		Map<String,Object> mine =  new HashMap<String, Object>(); //自己的map
		mine.put("username", users.getUsers_LoginName());
		mine.put("id", users.getUsers_Id().toString());
		mine.put("status", "online");
		mine.put("sign", "谁知道呢?");
		mine.put("avatar", "/CRM/img/cat.jpg");
		
		// map  > data  > mine = friend  >list
		Map<String,Object> one = new HashMap<String, Object>();
		one.put("groupname", "吹牛部");
		one.put("id", 1);
		
		for(int i=0;i<usersList.size();i++) {
			if(usersList.get(i).getUsers_Id()!=users.getUsers_Id()) {
				Map<String,Object> two = new HashMap<String, Object>();
				two.put("username", usersList.get(i).getUsers_LoginName());
				two.put("id", usersList.get(i).getUsers_Id().toString());
				two.put("sign", "谁知道呢?");
				two.put("avatar", "/CRM/img/cat.jpg");
				two.put("status", "online");
				list.add(two);
			}
		}
		one.put("list", list);
		friend.add(one);
		data.put("mine", mine);
		data.put("friend", friend);
		data.put("group", group);
		map.put("data", data);
		return map;
	}
	 	
}
