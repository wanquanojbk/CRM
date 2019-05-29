package com.crm.serviceimpl;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.CheckIn;
import com.crm.entity.Clue;
import com.crm.entity.Distribution;
import com.crm.entity.PageNation;
import com.crm.entity.Users;
import com.crm.mapper.CheckInMapper;
import com.crm.mapper.ClueMapper;
import com.crm.mapper.DistributionMapper;
import com.crm.mapper.UsersMapper;
import com.crm.service.ManagerService;
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	private UsersMapper UsersMapper;
	@Autowired
	private CheckInMapper checkInMapper;
	@Autowired
	private CheckIn checkIn;
	@Autowired
	private ClueMapper clueMapper;
	
	@Autowired
	private DistributionMapper distributionMapper;
	@Override
	public PageNation allEmployee(PageNation pageNation,HttpSession session) {
		// TODO Auto-generated method stub
		Users attribute = (Users)session.getAttribute("users");
		Integer row =Integer.parseInt((String)pageNation.getRows().get(0)) ;
		pageNation.setPage((pageNation.getPage()-1)*row);
		pageNation.setRow(row);
		pageNation.setNum6(attribute.getUsers_Id());
		pageNation.setRows(checkInMapper.selectCheck(pageNation));
		pageNation.setTotal(checkInMapper.selectCheckCount(pageNation));
		return pageNation;
	}
	@Override
	public List<?> checkEmployee(HttpSession session) {
		// TODO Auto-generated method stub
		Users attribute = (Users)session.getAttribute("users");
		return UsersMapper.selectCheckedUsers(attribute.getUsers_Id());
	}
	@Override
	public Boolean checkedEmployee(String ids) {
		String[] split = ids.split(",");
		int j=0;
		for (int i = 0; i < split.length; i++) {
			j+=UsersMapper.updateUsersCheckedById(Integer.parseInt(split[i]));
			checkIn.setCheckIn_UserId(Integer.parseInt(split[i]));
			j+=checkInMapper.updateCheckedById(checkIn);
		}
		if(j>0)
			return true;
		return false;
	}
	@Override
	public List<Clue> shoudong(HttpSession session) {
		Users attribute = (Users)session.getAttribute("users");
		return clueMapper.selectAllUnFenPeiClue(attribute.getUsers_Id());
	}
	@Override
	public void openDistribution(int users_Id) {
		//已经签到的咨询师总数 并且按照人数最少的升序排 之后按权重降序排
		List<Users> zxsList = UsersMapper.selectCheckedZiXunShi(users_Id);
		//待分配的学生集合
		List<Clue> clueList = clueMapper.selectManagerUnDistribution(users_Id);
		
		//如果 咨询师不为空 并且 未分配客户不为空 执行下列代码
		
		
		//开关状态
		Boolean switchStatus = switchStatus(users_Id);
		//如果为开的话
		if(switchStatus) {
			if(zxsList.size()==1 && clueList.size()>0) {
				for(int i=0;i<clueList.size();i++) {
					Clue  clue= clueList.get(i);
					clue.setClue_Principal(zxsList.get(0).getUsers_Id());
					clue.setClue_Status(1);
					clue.setClue_BginTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm")));
					clueMapper.updateFenPei(clue);
					//进行用户表count字段的添加
					UsersMapper.updateUserClueCount(zxsList.get(i).getUsers_Id());
				}
			}
			
			
			if(zxsList.size()>1 && clueList.size()>0) {
				int count =0;	//用来计算总数
				int renshu = 0; //用来计算人数差
				for(int i=0;i<zxsList.size();i++) {
					if(i<zxsList.size()-1) {
						//就是第一个比第二个少多少个人
						renshu = zxsList.get(i+1).getUsers_Count()-zxsList.get(i).getUsers_Count();
						//如果人数一样那么说明第一个肯定比第二个权限大所以多分给他一个
						if(renshu==0) {
							renshu = 1; 
						}
					}
					//重新查询
					if(i==zxsList.size()-1) {
						i=-1;
						clueList= clueMapper.selectManagerUnDistribution(users_Id);
						continue;
					}
					//开始分配
					for(int j=0;j<renshu;j++) {
						Clue  clue= new Clue();
						clue.setClue_Id(clueList.get(count).getClue_Id());
						clue.setClue_Principal(zxsList.get(i).getUsers_Id());
						clue.setClue_Status(1);
						clue.setClue_BginTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm")));
						clueMapper.updateFenPei(clue);
						//进行用户表count字段的添加
						UsersMapper.updateUserClueCount(zxsList.get(i).getUsers_Id());
						//计数变量一直加
						count++;
						//如果变量加到后边 和 待分配的客户数量一样 那么说明分完了 直接跳出
						if(count == clueList.size()) {
							break;
						}
					}
					//如果变量加到后边 和 待分配的客户数量一样 那么说明分完了 直接跳出
					if(count == clueList.size()) {
						break;
					}
				}
			}
		}
		
		
		
		
		//已经签到的咨询师总数 并且按照人数最少的优先排 之后按权重
//		List<Users> zxsList = UsersMapper.selectCheckedZiXunShi(users_Id);
//				//待分配的学生集合
//		List<Clue> clueList = clueMapper.selectManagerUnDistribution(users_Id);
//		System.out.println(zxsList+"--------------------------------------------------");
//		
//		//存储咨询师添加的人数
//		int[] zxsAddCountArray = new int[zxsList.size()];
//		
//		//储存咨询师id的数组
//		int[] zxsIdArray = new int[zxsList.size()];
//	
//		
//		//存储咨询师空闲的数组
//		int[] zxsKongXianArray = new int[zxsList.size()];
//		//权限值总和
//		int weightSum = 0; 
//		//空闲值总和
//		int kongxianzhi =0;
//		//格式化 把数字等放入这个对象 会被转化
//		DecimalFormat df = new DecimalFormat("0.00");
//		//格式化 把数字等放入这个对象 会被转化
//		DecimalFormat df1 = new DecimalFormat("0");
//		//该经理手下的网络咨询师录入的 所有待分配的目标客户总数
//		Integer weifenpeiCount = clueMapper.selectManagerUnDistributionCount(users_Id);
//		//记录数据的变量
//		int jishu = weifenpeiCount;
//		//循环完之后计算出来 咨询师的权重值的 总数
//		for(int i=0;i<zxsList.size();i++) {
//			weightSum += zxsList.get(i).getUsers_Weight();
//		}
//		//算出空闲值 并且分别放入数组
//		for(int j=0;j<zxsList.size();j++) {
//			//获取用户id
//			int usersId = zxsList.get(j).getUsers_Id();
//			//往数组里面存
//			zxsIdArray[j] = usersId;
//			
//			//该咨询师所有客户
//			List<Clue> allClueList = clueMapper.selectAllClueByZiXunShiId(usersId);
//			//所有客户的总量
//			int zongRenShu = allClueList.size();
//			//该咨询师正在跟的
//			List<Clue> okClueList = clueMapper.selectAllOKClueByZiXunShiId(usersId);
//			//该咨询师正在跟的客户总量
//			int okRenShu = okClueList.size();
//			//转换后的 但不是最终的
//			String num = df1.format((float) zongRenShu -(float) okRenShu );
//			//空闲值
//			int kongxian = Integer.parseInt(num);
//			//添加到空限值数组中
//			System.out.println(kongxian+"第一个循环生成空闲值");
//			zxsKongXianArray[j] = kongxian;
//		}
//		//下一步准备冒泡排序  把空闲值和用户id 全部冒泡
//		//外层循环 length -1
//		for(int i=0;i< zxsKongXianArray.length-1;i++) {
//			System.out.println("进入第一个冒泡排序");
//			//里层循环 -1 -i
//			for(int j=0;j<zxsKongXianArray.length-1-i;j++) {
//				//如果 前面的后面的小
//				if(zxsKongXianArray[j] < zxsKongXianArray[j+1]) {
//					System.out.println(1);
//					//用变量存储小值
//					int temp = zxsKongXianArray[j];
//					
//					//把大的值放到前面
//					zxsKongXianArray[j] = zxsKongXianArray[j+1];
//					//把原来大的 换成小的
//					zxsKongXianArray[j+1] = temp;
//					//把用户id 也赋给变量
//					System.out.println(zxsKongXianArray[j]+"空闲值");
//					int temps = zxsIdArray[j];
//					
//					//因为用户的id也要 冒泡排序 不冒泡
//					zxsIdArray[j] = zxsIdArray[j+1];
//					zxsIdArray[j+1] = temps;
//					System.out.println(zxsIdArray[j]+"咨询师id");
//				}
//			}
//		}
//		
//		List<Clue> clueList = clueMapper.selectManagerUnDistribution(users_Id);
//		Clue clue = new Clue();
//		int h = 0;
//		
//		for(int i = 0;i<zxsKongXianArray.length;i++) {
//			System.out.println(zxsKongXianArray[i]+"kong");
//			System.out.println(zxsIdArray[i]+"id");
//			System.out.println(zxsAddCountArray[i]+"人数");
//		}
//		
//				for (int l = 0; l < zxsKongXianArray.length; l++) {
//			
//						for (int ll = 0; ll < zxsKongXianArray[l]; ll++) {
//							if (jishu < 1) {
//								break;
//							} else if (zxsKongXianArray[l] == 0) {
//								continue;
//							} else {
//								System.out.println(zxsIdArray[l]+"咨询师里面的某一位");
//								
//								
//								//获取里面的对象
//								clue = clueList.get(h);
//								//设置里面的 咨询师id
//								clue.setClue_Principal(zxsIdArray[l]);
//								//设置里面的 状态 已分配
//								clue.setClue_Status(1);
//								//设置为当前时间
//								clue.setClue_BginTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm")));
//								//设置修改 
//								clueMapper.updateFenPei(clue);
////								disM.xiaohui(clue);
//								//往上加
//								h++;
//								//记数字往下减
//								jishu--;
//								System.out.println(zxsIdArray[l] + "ids1");
//								System.out.println(h + "h1");
//							}
//			
//						}
//			
//					}
//		
//				System.out.println("人数是：" + jishu);
//				int[] erids = new int[zxsList.size()];
//				
//				for (int d = 0; d < zxsList.size(); d++) {
//					int listid = zxsList.get(d).getUsers_Id();// 获取咨询师的id并添加到数组；
//					erids[d] = listid;
//					int x = zxsList.get(d).getUsers_Weight();
//					String xxx = df.format((float) jishu / (float) 100);
//					double xx = Double.parseDouble(xxx);
//					String yyy = df.format((float) x / (float) weightSum * (float) 100 * (float) xx);
//					double yy = Double.parseDouble(yyy);
//					int y = (int) Math.ceil(yy);
//		
//					zxsAddCountArray[d] = y;
//				}
//				
//				for (int y = 0; y < zxsAddCountArray.length - 1; y++) {
//					for (int u = 0; u < zxsAddCountArray.length - 1 - y; u++) {
//						if (zxsAddCountArray[u] < zxsAddCountArray[u + 1]) {
//							int temp = zxsAddCountArray[u];
//							zxsAddCountArray[u] = zxsAddCountArray[u + 1];
//							zxsAddCountArray[u + 1] = temp;
//							int temps = erids[u];
//							erids[u] = erids[u + 1];
//							erids[u + 1] = temps;
//						}
//					}
//				}
//				
//				for (int y = 0; y < zxsAddCountArray.length; y++) {
//					for (int o = 0; o < y; o++) {
//						if (jishu < 1) {
//							break;
//						} else {
//							clue = clueList.get(h);
//							clue.setClue_Principal(erids[y]);
//							clue.setClue_Status(2);
//							clue.setClue_BginTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm")));
//							clueMapper.updateFenPei(clue);
//		                    //disM.xiaohui(clue);
//							h++;
//							jishu--;
//							System.out.println(erids[y] + "ids2");
//							System.out.println(h + "h2");
//						}
//		
//					}
//		
//				}
		
		
		
//		Clue clue = new Clue();;
//		int h = 0;
//		List<Users> usersList = clueMapper.findUsersByUsersId(users_Id);// 咨询师总数
//		int[] principalCount = new int[usersList.size()];// 存储添加人数
//		int[] principalArr = new int[usersList.size()]; // 存储咨询师id
//		int[] kongXianZhi = new int[usersList.size()]; // 存储每个咨询师的空闲值
//		int weightSUM = 0; // 权重值总和
//		int kxzhe = 0; // 记录空闲值总和
//		DecimalFormat df = new DecimalFormat("0.00");
//		DecimalFormat df1 = new DecimalFormat("0");
//		int ren = clueMapper.findIdleClueCountByUsersId(users_Id);// 未分配人数总和
//		int jishu = ren; // 再写一个值记数用
//		for (int i = 0; i < usersList.size(); i++) {
//			weightSUM += usersList.get(i).getUsers_Weight(); // 记录权重总和；
//		}
//		for (int j = 0; j < usersList.size(); j++) {
//			int listid = usersList.get(j).getUsers_Id();// 获取咨询师的id并添加到数组；
//			principalArr[j] = listid;
////				Users users=new Users();
////				users.setUsers_Id(listid);
//			// 已经有的 客户
//			List<Clue> yiYouClue = clueMapper.getClueByPrincipal(listid);
//			int zongYouRenShu = yiYouClue.size();
//			// 分给你的	
////				Users xyrs=new Users();
////				xyrs.setUsers_Id(listid);
//			// 正在跟的 状态未1的
//			List<Student> xianYouList = studentMapper.getStudentByCreator(listid);
//			Integer xianYouRenShu = xianYouList.size();
//
//			String num = df1.format((float) zongYouRenShu - (float) xianYouRenShu);
//			int xy = Integer.parseInt(num);
//			kongXianZhi[j] = xy; // 得到每个咨询师的空闲值并添加到数组
//		}
//		//冒泡排序
//		for (int i = 0; i < kongXianZhi.length - 1; i++) {
//			for (int j = 0; j < kongXianZhi.length - 1 - i; j++) {
//				if (kongXianZhi[j] < kongXianZhi[j + 1]) {
//					int temp = kongXianZhi[j];
//					kongXianZhi[j] = kongXianZhi[j + 1];
//					kongXianZhi[j + 1] = temp;
//					int temps = principalArr[j];
//					principalArr[j] = principalArr[j + 1];
//					principalArr[j + 1] = temps;
//				}
//			}
//		}
//		//经理手下所有未分配客户
//		List<Clue> clueList = clueMapper.findIdleClueByUsersId(users_Id);
//		Clue clue = new Clue();
//		int h = 0;
//
//		for (int gg = 0; gg < kongXianZhi.length; gg++) {
//			System.out.println(kongXianZhi[gg] + "kong");
//			System.out.println(principalCount[gg] + "vars");
//			System.out.println(principalArr[gg] + "id");
//		}
//
//		for (int l = 0; l < kongXianZhi.length; l++) {
//
//			for (int ll = 0; ll < kongXianZhi[l]; ll++) {
//				if (jishu < 1) {
//					break;
//				} else if (kongXianZhi[l] == 0) {
//					continue;
//				} else {
//					clue = clueList.get(h);
//					clue.setClue_Principal(principalArr[l]);
//					clue.setClue_Status(2);
//					clue.setClue_BginTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm")));
//					clueMapper.updateClueStatus(clue);
////					disM.xiaohui(clue);
//					h++;
//					jishu--;
//					System.out.println(principalArr[l] + "ids1");
//					System.out.println(h + "h1");
//				}
//
//			}
//
//		}
//
//		System.out.println("人数是：" + jishu);
//		int[] erids = new int[usersList.size()];
//
//		for (int d = 0; d < usersList.size(); d++) {
//			int listid = usersList.get(d).getUsers_Id();// 获取咨询师的id并添加到数组；
//			erids[d] = listid;
//			int x = usersList.get(d).getUsers_Weight();
//			String xxx = df.format((float) jishu / (float) 100);
//			double xx = Double.parseDouble(xxx);
//			String yyy = df.format((float) x / (float) weightSUM * (float) 100 * (float) xx);
//			double yy = Double.parseDouble(yyy);
//			int y = (int) Math.ceil(yy);
//
//			principalCount[d] = y;
//		}
//
//		for (int y = 0; y < principalCount.length - 1; y++) {
//			for (int u = 0; u < principalCount.length - 1 - y; u++) {
//				if (principalCount[u] < principalCount[u + 1]) {
//					int temp = principalCount[u];
//					principalCount[u] = principalCount[u + 1];
//					principalCount[u + 1] = temp;
//					int temps = erids[u];
//					erids[u] = erids[u + 1];
//					erids[u + 1] = temps;
//				}
//			}
//		}
//		
//		for (int y = 0; y < principalCount.length; y++) {
//			for (int o = 0; o < [y]; o++) {
//				if (jishu < 1) {
//					break;
//				} else {
//					clue = clueList.get(h);
//					clue.setClue_Principal(erids[y]);
//					clue.setClue_Status(2);
//					clue.setClue_BginTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm")));
//					clueMapper.updateClueStatus(clue);
//                    //disM.xiaohui(clue);
//					h++;
//					jishu--;
//					System.out.println(erids[y] + "ids2");
//					System.out.println(h + "h2");
//				}
//
//			}
//
//		}

		// TODO Auto-generated method stub
		
		
		
		
		
		
	
	}
	@Override
	public Boolean switchStatus(int users_Id) {
		// TODO Auto-generated method stub
		Distribution distribution = distributionMapper.selectDistributionByManagerId(users_Id);
		if(distribution.getDistribution_Status())
			return true;
		return false;
	}
	@Override
	public Boolean updateSwitchStatusOFF(int users_Id) {
		int off = distributionMapper.updateSwitchStatusOFF(users_Id);
		if(off>0)
			return true;
		return false;
	}
	@Override
	public Boolean updateSwitchStatusON(int users_Id) {
		int off = distributionMapper.updateSwitchStatusON(users_Id);
		if(off>0)
			return true;
		return false;
	}
	@Override
	public void insetStartFenPei(int users_Id) {
		// TODO Auto-generated method stub
		Users user = UsersMapper.selectUsersByUsersId(users_Id);
		Integer i = user.getUsers_Exit1();
		Distribution status = distributionMapper.selectDistributionByManagerId(i);
		if(status.getDistribution_Status()) {
			openDistribution(i);
		}
	}
	@Override
	public PageNation selctUsersCheckIn(PageNation pageNation) {
		// TODO Auto-generated method stub
		Integer row =Integer.parseInt((String)pageNation.getRows().get(0)) ;
		pageNation.setPage((pageNation.getPage()-1)*row);
		pageNation.setRow(row);
		pageNation.setTotal(checkInMapper.selectAllCheckInByUsersIdCount(pageNation));
		pageNation.setRows(checkInMapper.selectAllCheckInByUsersId(pageNation));
		return pageNation;
	}
	@Override
	public PageNation getAllCustomer(PageNation pageNation, HttpSession session) {
		// TODO Auto-generated method stub
		Users users = (Users)session.getAttribute("users");
		pageNation.setNum1(users.getUsers_Id());
		Integer row =Integer.parseInt((String)pageNation.getRows().get(0)) ;
		pageNation.setPage((pageNation.getPage()-1)*row);
		pageNation.setRow(row);
		List<Clue> selectManagersCheckCustomers = clueMapper.selectManagersCheckCustomers(pageNation);
		Integer selectManagersCheckCustomersCount = clueMapper.selectManagersCheckCustomersCount(pageNation);
		pageNation.setRows(selectManagersCheckCustomers);
		pageNation.setTotal(selectManagersCheckCustomersCount);
		return pageNation;
	
	}
	@Override
	public Boolean startShouDong(Integer[] clueIds, Integer userId) {
		// TODO Auto-generated method stub
	
		for(int i=0;i<clueIds.length;i++) {
			Clue clue = clueMapper.selectClueById(clueIds[i]);
			clue.setClue_Principal(userId);
			clue.setClue_Status(1);
			clue.setClue_BginTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm")));
			clueMapper.updateFenPei(clue);
			UsersMapper.updateUserClueCount(userId);
		}
		return true;
	}
	
	
//	public void zidongfenpwei() {
//		// TODO Auto-generated method stub
//		List<Users> list=disM.quanzhong();//咨询师总数
//		int[] vars = new int[list.size()];//存储添加人数
//		int[] ids=new int[list.size()];		//存储咨询师id
//		int[] kongxianzhi=new int[list.size()]; //存储每个咨询师的空闲值
//		int he=0;									//权重值总和
//		int kxzhe=0;                          //记录空闲值总和
//		DecimalFormat df=new DecimalFormat("0.00");
//		DecimalFormat df1=new DecimalFormat("0");
//		int ren=disM.weifenpeicount();			//未分配人数总和
//		int jishu=ren;							//再写一个值记数用
//		
//		
//		for (int i = 0; i < list.size(); i++) {
//			he+=list.get(i).getUsers_Weight();	//记录权重总和；
//		}
//		for (int j = 0; j < list.size(); j++) {
//			int listid=list.get(j).getUsers_Id();//获取咨询师的id并添加到数组；
//				ids[j]=listid;
//				
//				Users yurs=new Users();
//				yurs.setUsers_Id(listid);
//				List<Student> listyiyou=disM.yiyourenshu(yurs);
//				int yiyourenshu=listyiyou.size();
//				
//				Users xyrs=new Users();
//				xyrs.setUsers_Id(listid);
//				List<Student> listxianyou=disM.xiangenzongzhi(xyrs);
//				Integer xianyourenshu=listxianyou.size();
//				
//				String huan= df1.format((float)yiyourenshu-(float)xianyourenshu);
//				int xy=Integer.parseInt(huan);
//				kongxianzhi[j]=xy;			//得到每个咨询师的空闲值并添加到数组
//
//			 
//			
//			}
//	
//	
//		
//		for(int i=0;i<kongxianzhi.length-1;i++){
//		       for(int j=0;j<kongxianzhi.length-1-i;j++){
//		           if(kongxianzhi[j]<kongxianzhi[j+1]){
//		               int temp = kongxianzhi[j];
//		               kongxianzhi[j] = kongxianzhi[j+1];
//		               kongxianzhi[j+1] = temp;
//		               int temps=ids[j];
//		               ids[j] = ids[j+1];
//		               ids[j+1] = temps;
//		           }
//		}
//		}
//		
//		List<Student> stu= disM.weifenpei();
//		Student stug=new Student();
//		int h=0;
//		
//		for (int gg = 0; gg < kongxianzhi.length; gg++) {
//			System.out.println(kongxianzhi[gg]+"kong");
//			System.out.println(vars[gg]+"vars");
//			System.out.println(ids[gg]+"id");
//		}
//		
//	for (int l = 0; l < kongxianzhi.length; l++) {
//		
//			for (int ll = 0; ll < kongxianzhi[l] ; ll++) {
//				if(jishu<1){
//					break;
//				}else
//				if(kongxianzhi[l]==0){
//					continue;
//				}else{
//					stug=stu.get(h);
//					
//					
//					stug.setStudent_Counselor(ids[l]);
//					disM.fenpei(stug);
//					disM.xiaohui(stug);
//					h++;
//					jishu--;
//					System.out.println(ids[l]+"ids1");
//					System.out.println(h+"h1");
//					
//				}
//				
//				
//			}
//		
//		}
//	
//	
//	System.out.println("人数是："+jishu);
//	int[] erids=new int[list.size()];
//	
//	for (int d = 0; d < list.size(); d++) {
//		int listid=list.get(d).getUsers_Id();//获取咨询师的id并添加到数组；
//		erids[d]=listid;
//		
//		int x=list.get(d).getUsers_Weight();
//		String xxx=df.format((float)jishu/(float)100);
//		double xx=Double.parseDouble(xxx);
//		String yyy=df.format((float)x/(float)he*(float)100*(float)xx);
//		double yy=Double.parseDouble(yyy);
//		int y=(int) Math.ceil(yy);
//		
//		vars[d]=y;
//	}
//			
//	for(int y=0;y<vars.length-1;y++){
//	       for(int u=0;u<vars.length-1-y;u++){
//	           if(vars[u]<vars[u+1]){
//	               int temp = vars[u];
//	               vars[u] = vars[u+1];
//	               vars[u+1] = temp;
//	               int temps=erids[u];
//	               erids[u] = erids[u+1];
//	               erids[u+1] = temps;
//	           }
//	}
//	}
//	
//			
//			
//			for (int y = 0; y <vars.length ; y++) { 
//				for (int o = 0; o < vars[y]; o++) {
//						if(jishu<1){
//						break;
//					}else{
//						stug=stu.get(h);
//						stug.setStudent_Counselor(erids[y]);
//						disM.fenpei(stug);
//						disM.xiaohui(stug);
//						h++;
//						jishu--;
//						System.out.println(erids[y]+"ids2");
//						System.out.println(h+"h2"); 
//						
//					}
//					
//					
//				}
//				
//			}
//			
//		
//	}
	
	

}
