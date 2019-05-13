package com.crm.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.entity.Modules;
import com.crm.mapper.ModulesMapper;
import com.crm.service.ModulesService;

@Service
public class ModulesServiceImpl implements ModulesService{
@Autowired
private ModulesMapper modulesMapper;

@Override
public List<Map<String,Object>> selectByUserId(Integer users_Id) {
	List<Map<String,Object>> a = new ArrayList<Map<String,Object>>();
	
	List<Modules> list = modulesMapper.selectByUserId(users_Id);//查出来该用户下所有模块
	for(int i=0;i<list.size();i++) {
		//说明是顶层节点
		Map<String,Object> map = new HashMap<String, Object>();
		
		if(list.get(i).getModules_ParentId()==0) {
			//把顶层节点往里面放 查出该节点下面的子节点
			map.put("id",list.get(i).getModules_Id());
			map.put("text", list.get(i).getModules_Name());
			map.put("children", test(list.get(i),list));
		}
		if(list.get(i).getModules_ParentId()==0) {
			a.add(map);
		}
	}	
	
	return a;	
 }
	/**
	   * 左侧登录树辅助方法
	 * @param modules
	 * @param dingjilist
	 * @return
	 */
	public List<Map<String,Object>> test(Modules modules,List<Modules> alllist) {//子循环
		List<Map<String,Object>> hehe = new ArrayList<Map<String,Object>>();
		List<Modules> list = modulesMapper.selectLeafNode(modules);//查该模块下下面的子模块
		List<Modules> herher = new ArrayList<Modules>();
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<alllist.size();j++) {
				if(alllist.get(j).getModules_Id()==list.get(i).getModules_Id()) {
					herher.add(list.get(i));
				}
			}
		}
	
		Map<String,Object> haha =null;
		if(herher!=null) {
			for(int i=0;i<herher.size();i++) {
				haha = new HashMap<String, Object>();
				haha.put("id",herher.get(i).getModules_Id());
				haha.put("text", herher.get(i).getModules_Name());
				Map<String,Object> attributes = new HashMap<String, Object>();
				attributes.put("url", herher.get(i).getModules_Path());
				attributes.put("parent", herher.get(i).getModules_ParentId());
				attributes.put("weight", herher.get(i).getModules_Weight());
			    haha.put("attributes", attributes);
				//多一个children
				if(!modulesMapper.selectLeafNode(herher.get(i)).toString().equals("[]")) {
					haha.put("children", test(herher.get(i),alllist));
				}
				hehe.add(haha);
				
			}
		}
		return hehe;
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public List<Map<String, Object>> selectAllModules() {
//		List<Map<String,Object>> a = new ArrayList<Map<String,Object>>();
//	
//		List<Modules> list = modulesMapper.selectAllModules();
//		for(int i=0;i<list.size();i++) {
//			//说明是顶层节点
//			Map<String,Object> map = new HashMap<String, Object>();
//			if(list.get(i).getModules_ParentId()==0) {
//				//把顶层节点往里面放 查出该节点下面的子节点
//				map.put("id",list.get(i).getModules_Id());
//				map.put("text", list.get(i).getModules_Name());
//				map.put("children", test(list.get(i)));
//			}
//			if(list.get(i).getModules_ParentId()==0) {
//				a.add(map);
//			}
//			
//		}	
//		
//		return a;	
//	}
	
	
	
	
	
	
	
		
		//子方法
		public List<Map<String,Object>> ceshi(Modules modules,List<Modules> dingjilist) {//子循环
			List<Map<String,Object>> hehe = new ArrayList<Map<String,Object>>();
			List<Modules> list = modulesMapper.selectLeafNode(modules);//查该模块下下面的子模块
			
			Map<String,Object> haha =null;
			
			if(list!=null) {
				for(int i=0;i<list.size();i++) {
					haha = new HashMap<String, Object>();
					haha.put("id",list.get(i).getModules_Id());
					haha.put("text", list.get(i).getModules_Name());
					//多一个children
					for(int j=0;j<dingjilist.size();j++) {
						if(list.get(i).getModules_Id()==dingjilist.get(j).getModules_Id()) {
							haha.put("checked", true);
						}
					}
					if(haha.containsKey("checked")==false) {
						haha.put("checked", false);
					}
					if(!modulesMapper.selectLeafNode(list.get(i)).toString().equals("[]")) {
							haha.put("children", ceshi(list.get(i),dingjilist));
					}
					
					hehe.add(haha);
					
						//for(int j=0;j<?;j++) {//这个?放的是除顶层节点的所有需要的节点长度
							//if(list.get(i).getModules_Id()==?) {这个?是放节点的
								
							//}	
						//}
						
				}
			}
			return hehe;
		}
		
		
	@Override   //父方法
	public List<Map<String, Object>> selectAllModulesCheckedByRoles(Integer rolesId) {
		List<Modules> roleList = modulesMapper.selectModulesByRoleId(rolesId);
	
		List<Map<String,Object>> a = new ArrayList<Map<String,Object>>();
		List<Modules> list = modulesMapper.selectAllModules();;//查出所有模块
		for(int i=0;i<list.size();i++) {
			//说明是顶层节点
			Map<String,Object> map = new HashMap<String, Object>();
			if(list.get(i).getModules_ParentId()==0){
				//把顶层节点往里面放 查出该节点下面的子节点
				map.put("id",list.get(i).getModules_Id());
				map.put("text", list.get(i).getModules_Name());
				map.put("checked", false);
				map.put("children", ceshi(list.get(i),roleList));
			}
			if(list.get(i).getModules_ParentId()==0) {
					a.add(map);
			}
		}	
		
		return a;	
		
	}
}
