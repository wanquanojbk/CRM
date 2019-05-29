package com.crm.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.Classes;
import com.crm.entity.PageNation;
import com.crm.entity.Student;
import com.crm.entity.Users;
import com.crm.mapper.CampusMapper;
import com.crm.service.CampusService;
@Service
@Transactional
public class CampusServiceImpl implements CampusService {
	
	@Autowired
	private CampusMapper campusMapper;
	
	@Autowired
	private Student student;
	
	@Autowired
	private Classes classes;

	@Override
	public PageNation selectClasses(PageNation pageNation) {
		row(pageNation);
		pageNation.setRows(campusMapper.selectClasses(pageNation));
		pageNation.setTotal(campusMapper.countClasses(pageNation));
		return pageNation;
	}
	
	@Override
	@Transactional
	public Integer addClasses(Classes classes) {
		return campusMapper.addClasses(classes);
	}
	
	@Override
	@Transactional
	public Integer UpdateClasses(Classes classes) {
		return campusMapper.UpdateClasses(classes);
	}

	@Override
	@Transactional
	public Integer DeleteClasses(PageNation pageNation) {
		return campusMapper.DeleteClasses(pageNation);
	}
	
	@Override
	public PageNation selectUsers(PageNation pageNation) { 
		row(pageNation);
		pageNation.setRows(campusMapper.selectUsers(pageNation));
		pageNation.setTotal(campusMapper.countUsers(pageNation));
		return pageNation;
	}
	
	@Override
	public Map selectUsersStudent(PageNation pageNation) {
		List<Users> users =campusMapper.selectUsersStudent();
		List<Classes> classes = campusMapper.selectClasses(pageNation);
		Map<String,Object> tb = new HashMap<String, Object>();
		
		Map<String,Object> tooltip = new HashMap<String, Object>();
		tooltip.put("trigger","item");
		tooltip.put("formatter","{a} <br/>{b}: {c} ({d}%)");
		tb.put("tooltip",tooltip);
		
		Map<String,Object> legend = new HashMap<String, Object>();
		legend.put("orient","vertical");
		legend.put("x","left");
		tb.put("legend",legend);
		
		List series=new ArrayList();
		Map<String,Object> series1 = new HashMap<String, Object>();
		series1.put("name","辅导员:学生");
		series1.put("type","pie");
		series1.put("selectedMode","single");
		List radius=new ArrayList();
		radius.add(0);
		radius.add("30%");
		series1.put("radius",radius);
		
		Map<String,Object> label = new HashMap<String, Object>();
		Map<String,Object> normal11 = new HashMap<String, Object>();
		normal11.put("position","inner");
		label.put("normal",normal11);
		series1.put("label",label);
		
		Map<String,Object> labelLine = new HashMap<String, Object>();
		Map<String,Object> normal12 = new HashMap<String, Object>();
		normal12.put("show",false);
		labelLine.put("normal",normal12);
		series1.put("labelLine",labelLine);
		
		List data11=new ArrayList();
		
		for(int i=0;i<users.size();i++) {
			Map<String,Object> data12 = new HashMap<String, Object>();
			data12.put("value",users.get(i).getStudent().getStudent_Exit1());
			data12.put("name",users.get(i).getUsers_LoginName());
			data11.add(data12);
		}
		series1.put("data",data11);
		series.add(series1);
		
		Map<String,Object> series2 = new HashMap<String, Object>();
		series2.put("name","班级:学生");
		series2.put("type","pie");
		List radius1=new ArrayList();
		radius1.add("40%");
		radius1.add("55%");
		series2.put("radius",radius1);
		
		Map<String,Object> label1 = new HashMap<String, Object>();
		Map<String,Object> norma21 = new HashMap<String, Object>();
		norma21.put("formatter","{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}");
		norma21.put("backgroundColor","#eee");
		norma21.put("borderColor","#aaa");
		norma21.put("borderWidth",1);
		norma21.put("borderRadius",4);
		
		Map<String,Object> rich = new HashMap<String, Object>();
		Map<String,Object> a = new HashMap<String, Object>();
		a.put("color","#999");
		a.put("lineHeight",22);
		a.put("align","center");
		rich.put("a",a);
		
		Map<String,Object> hr = new HashMap<String, Object>();
		hr.put("borderColor","#aaa");
		hr.put("width","100%");
		hr.put("borderWidth",0.5);
		hr.put("height",0);
		rich.put("hr",hr);
		
		Map<String,Object> b = new HashMap<String, Object>();
		b.put("fontSize",16);
		b.put("lineHeight",33);
		rich.put("b",b);
		
		Map<String,Object> per = new HashMap<String, Object>();
		per.put("color","#eee");
		per.put("backgroundColor","#334455");
		List padding=new ArrayList();
		padding.add(2);
		padding.add(4);
		per.put("padding",padding);
		per.put("borderRadius",2);
		rich.put("per",per);
		norma21.put("rich", rich);
		label1.put("normal",norma21);
		series2.put("label",label1);
		
		List data21=new ArrayList();
		
		for(int i=0;i<users.size();i++) {
			for(int j=0;j<classes.size();j++) {
				if(classes.get(j).getUsers()!=null) {
					if(users.get(i).getUsers_Id()==classes.get(j).getUsers().getUsers_Id()) {
						Map<String,Object> data22 = new HashMap<String, Object>();
						data22.put("value",classes.get(j).getStudent().getStudent_Exit1());
						data22.put("name",classes.get(j).getClasses_Name());
						data21.add(data22);
					}
				}
			}
		}
		series2.put("data",data21);
		series.add(series2);
		tb.put("series",series);
		return tb;
	}

	@Override
	public PageNation selectStudent(PageNation pageNation) {
		row(pageNation);
		pageNation.setRows(campusMapper.selectStudent(pageNation));
		pageNation.setTotal(campusMapper.countStudent(pageNation));
		return pageNation;
	}
	
	@Override
	public Integer UpdateStudent(Student student) {
		return campusMapper.UpdateStudent(student);
	}
	@Override
	public Boolean selectStudentFL(PageNation pageNation){
		row(pageNation);
		pageNation.setNum2(1);//selectClasses用的
		List<Student> countStudentFL=campusMapper.countStudentFL();//查询未分班的人数和班级数 
		for(int i=0;i<countStudentFL.size();i++) {//这层循环用以分班类别
			double rs=countStudentFL.get(i).getStudent_Exit1();//当前专业学生数
			double bjs=Math.ceil(rs/30);//准备分几个班(向上取整)
			double bjrs=Math.ceil(rs/bjs);//每班分几人(向上取整)
			pageNation.setText1(countStudentFL.get(i).getStudent_Remarks());//获取当前专业
			for(int j=0;j<bjs;j++) {//这层循环用以分当前类别班的下标
				List<Student> selectStudentFL=campusMapper.selectStudentFL(pageNation);//查询当前专业未分配的学生
				classes.setClasses_Name(date()+countStudentFL.get(i).getStudent_Remarks()+(j+1));
				classes.setClasses_CounselorId(0);
				campusMapper.addClasses(classes);//添加班级
				for(int s=0;s<bjrs;s++) {
					if(s<selectStudentFL.size()) {
						student.setStudent_Id(selectStudentFL.get(s).getStudent_Id());
						student.setStudent_ClassId(classes.getClasses_Id());
						campusMapper.UpdateStudent(student);
					}else {
						break;
					}
				}
			}
		}
		return true;
	};
	
	public PageNation row(PageNation pageNation) {
		if(pageNation.getPage()!=null) {
			Integer row =Integer.parseInt((String)pageNation.getRows().get(0));
			pageNation.setRow(row);
			pageNation.setPage((pageNation.getPage()-1)*row);
		}
		return pageNation;
	}
	public String date(){
		SimpleDateFormat df = new SimpleDateFormat("yy");//设置日期格式
		String i=df.format(new Date());//new Date()为获取当前系统时间
		return i;
	}
	
}
