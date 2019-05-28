package com.crm.serviceimpl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.entity.Distribution;
import com.crm.entity.PageNation;
import com.crm.entity.Users;
import com.crm.entity.UsersRoles;
import com.crm.mapper.DistributionMapper;
import com.crm.mapper.RolesMapper;
import com.crm.mapper.UsersMapper;
import com.crm.mapper.UsersRolesMapper;
import com.crm.service.UsersService;
import com.crm.util.PasswordEncrypt;
import com.crm.util.RandomCreate;
import com.crm.util.Result;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersMapper usersMapper;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private RolesMapper rolesMapper;
	@Autowired
	private UsersRolesMapper usersRolesMapper;
	@Autowired
	private DistributionMapper distributionMapper;
	/**
	 * 通过用户名和密码查询用户
	 * 
	 * @param users
	 * @return Boolean 用户存在return： true 反之 return false
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */
	@Override
	public Result selectUsers(Users users,HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		Result result = new Result();
		
		if(users.getUsers_LoginName()!=null) {
			Users user2 = usersMapper.selectUsersByUsersName(users);
			// 如果user2不为空代表用户名实际存在,进入下一级别判断
			if (user2 != null) {
				// 进行MD5加密
				String password = users.getUsers_Password();
				String jieGuo = PasswordEncrypt.encodeByMd5(password);
				users.setUsers_Password(jieGuo);
				Users user = usersMapper.selectUsers(users);
				// 如果user不为空,那么用户名和密码都正确,进入锁定判断
				if (user != null) {
					result.setSuccess(true);
					//String status = user.getUsers_Exit2(); && !"在线".equals(status)
					if (user.getUsers_LsLockout() == 1 ) {
								//如果 不为空 但是又能登录上
							  	Date date = new Date();
						        //设置要获取到什么样的时间
						        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						        //获取String类型的时间
						        String createdate = sdf.format(date);
								user.setUsers_LastLoginTime(createdate);
								usersMapper.updateUserPsdWrongTimeSucessByZero(user);
								//context.setAttribute("token", "登录");
								result.setMsg("登录成功");
								result.setIsLockout(1);
								result.setUsers(user);
								return result;
				      
					} 
					else {
						result.setMsg("目前该用户已经被锁定");
						result.setIsLockout(2);
						return result;
					}

				}
				// 那就是用户名正确,密码不对
				else {
					// 如果错误次数到5次,改变状态
					if (user2.getUsers_PsdWrongTime() == 5) {
						int num = 5;
						user2.setUsers_PsdWrongTime(num);
						user2.setUsers_LsLockout(2);
						usersMapper.updateUsersLockout(user2);
						result.setSuccess(true);
						result.setMsg("该账户已经被锁定");
						result.setIsLockout(2);
						return result;
					}
					// 如果错误次数不到5次,提示密码错误
					else {
						int num = user2.getUsers_PsdWrongTime() + 1;
						user2.setUsers_PsdWrongTime(num);
						user2.setUsers_LsLockout(1);
						usersMapper.updateUsersLockout(user2);
						result.setSuccess(false);
						result.setMsg("<a href='javascript:void(0);' onclick='tiJiao()'>密码错误,点击文本进行重置密码操作 </a>");
						result.setIsLockout(1);
						return result;
					}
				}
			}
			// 那就是用户名不存在
			else {
					result.setSuccess(false);
					result.setMsg("用户名不存在");
					result.setIsLockout(1);
					return result;
			}
		}
		else {
			result.setSuccess(false);
			result.setMsg("欢迎您的登录");
			result.setIsLockout(1);
			return result;
		}
	
	}



	@Override
	public Result emailRandom(Users users) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		Result result = new Result();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("2982756362@qq.com");
		message.setTo(users.getUsers_ProTectEMail());
		message.setSubject("您的重置密码");
		int num = RandomCreate.getRandom();
		message.setText("您好,这是您的邮箱验证码:" + num + "请妥善保管");
		mailSender.send(message);
		result.setSuccess(true);
		String num2 = PasswordEncrypt.encodeByMd5(""+num+"");
		result.setMsg(""+num2+"");
		System.out.println("emailRandom+++++++++++++++++++++++++++++++++++"+result);
		return result;

	}

	@Override
	public Result chongZhiPassword(Users users) {
		// TODO Auto-generated method stub
		Result result = new Result();
		Users user=usersMapper.selectUsersByUsersEmail(users);
		if(user!=null) {
			result.setSuccess(true);
			result.setMsg("成功");
			result.setIsLockout(1);
			result.setUsers(user);
		}
		else {
			result.setSuccess(false);
			result.setMsg("失败");
		}
		return result;
	}

	@Override
	public Boolean updateUsersChongZhiPassword(Users users) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String jieGuo=users.getUsers_Password();
		String jieGuo2=PasswordEncrypt.encodeByMd5(jieGuo);
		users.setUsers_Password(jieGuo2);
		int num=usersMapper.updateUsersChongZhiPassword(users);
		if(num>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public PageNation usersStartPage(PageNation pageNation) {
		// TODO Auto-generated method stub
		Integer row =Integer.parseInt((String)pageNation.getRows().get(0)) ;
		pageNation.setPage((pageNation.getPage()-1)*row);
		pageNation.setRow(row);
		pageNation.setTotal(usersMapper.selectUsersAndIsNotAdminCount(pageNation));
		pageNation.setRows(usersMapper.selectUsersAndIsNotAdmin(pageNation));
		return pageNation;
	}

	@Override
	public Boolean updateUsersIsLockOn(String ids) {
		// TODO Auto-generated method stub
		String[] split = ids.split(",");
		Integer code = 0;
		Integer [] array = new Integer[split.length];
		for (int i = 0; i < array.length; i++) {
			code+=usersMapper.updateUsersIsLockOn(Integer.parseInt(split[i]));
		}
		if(code>0) 
			return true;
		return false;
	}

	@Override
	public Boolean updateUsersIsLockOFF(String ids) {
		String[] split = ids.split(",");
		Integer code = 0;
		Integer [] array = new Integer[split.length];
		for (int i = 0; i < array.length; i++) {
			code+=usersMapper.updateUsersIsLockOFF(Integer.parseInt(split[i]));
		}
		if(code>0) 
			return true;
		return false;
	}

	@Override
	public Boolean deleteUsersByUsersId(Integer id) {
		// TODO Auto-generated method stub
		Integer i = usersMapper.deleteUsersByUsersId(id);
		if(i>0) 
			return true;
		return false;
	}

	@Override
	public Boolean insertUsers(Users users,UsersRoles usersRoles) {
		// TODO Auto-generated method stub
		try {
			users.setUsers_Password(PasswordEncrypt.encodeByMd5(users.getUsers_Password()));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		users.setUsers_Exit1(0);
		if(usersRoles.getUsersRoles_RoleId()==2||usersRoles.getUsersRoles_RoleId()==3) {
			users.setUsers_Exit1(7);
		}
		Integer i = usersMapper.insertUsers(users);
		if(usersRoles.getUsersRoles_RoleId()==5) {
			Distribution distribution = new Distribution();
			distribution.setDistribution_ManagerId(users.getUsers_Id());
			distributionMapper.insertDistribution(distribution);
		}
		
		
		usersRoles.setUsersRoles_UserId(users.getUsers_Id());
		Integer j = usersRolesMapper.insertUsersRoles(usersRoles);
		if(i+j>1)
			return true;
		return false;
	}

	@Override
	public Boolean updateUsersChongZhi(Users users) {
		// TODO Auto-generated method stub
		try {
			users.setUsers_Password(PasswordEncrypt.encodeByMd5("ysd123"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer i = usersMapper.updateUsersChongZhiPassword(users);
		if(i>0)
			return true;
		return false;
	}

	@Override
	public Users selectUsersByUsersId(Integer id) {
		// TODO Auto-generated method stub
		return usersMapper.selectUsersByUsersId(id);
	}

	@Override
	public Boolean updateUsers(Users users) {
		Integer i = usersMapper.updateUsersInfoMation(users);
		if(i>0)
			return true;
		return false;
	}

	@Override
	public PageNation selectAllRoles() {
		// TODO Auto-generated method stub
		PageNation pageNation = new PageNation();
		pageNation.setRows(rolesMapper.selectAllRolesDistinct());
		return pageNation;
	}

	@Override
	public PageNation selectRolesByUsersId(Integer id) {
		// TODO Auto-generated method stub
		PageNation pageNation = new PageNation();
		pageNation.setRows(rolesMapper.selectRolesByUsersId(id));
		return pageNation;
	}

	@Override
	public Boolean deleteUsersRoles(Integer id,String ids) {
		
		 Integer j=0;
		 String[] split = ids.split(","); Integer[] array = new Integer[split.length];
		  for(int i=0;i<array.length;i++) { 
			  
			  array[i]=Integer.parseInt(split[i]);
			  UsersRoles usersRoles = new UsersRoles();
		      usersRoles.setUsersRoles_RoleId(array[i]);
			  usersRoles.setUsersRoles_UserId(id);
			  j+= usersRolesMapper.deleteUsersRoles(usersRoles);
		  }
		
		if(j>0)
			return true;
		return false;
	}

	@Override
	public Boolean insertUsersRoles(Integer id, String ids) {
		// TODO Auto-generated method stub
		Integer j=0;
		String[] split = ids.split(","); Integer[] array = new Integer[split.length];
		
		
		
		
		  for(int i=0;i<array.length;i++) { 
			  array[i]=Integer.parseInt(split[i]);
			  UsersRoles usersRoles = new UsersRoles();
		      usersRoles.setUsersRoles_RoleId(array[i]);
			  usersRoles.setUsersRoles_UserId(id);
			  j+= usersRolesMapper.insertUsersRoles(usersRoles);
		  }
		
		if(j>0)
			return true;
		return false;
	}

	@Override
	public Boolean testLoginName(Users users) {
		// TODO Auto-generated method stub
		Users u = usersMapper.selectUsersByUsersName(users);
		if(u!=null)
			return true;
		return false;
	}

	@Override
	public void code(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("image/jpeg");
        //禁止图像缓存
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
		//原图片大小   116  36
		//图片的宽度    高度      图片的类型
		BufferedImage bImage = new BufferedImage(116, 36, BufferedImage.TYPE_INT_RGB);
		//画一个图片
		Graphics graphics = bImage.getGraphics();
		//背景颜色
		Color color = new Color(255, 255, 255);
		graphics.setColor(color);
		//背景框
		graphics.fillRect(0, 0, 116, 36);
		//内容字符数组
		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		//生成随机数对象
		Random random = new Random();
		//定义两个变量
		//划定一个范围有多长     获得随机数的位置保存起来
		int len = ch.length,index;
		StringBuffer sb = new StringBuffer();//  string a = "123456";
		for(int i = 0;i<4;i++) {
			index = random.nextInt(len);
			//干扰线
			int x = random.nextInt(116);//最远出现的位置(从左往右)
	        int y = random.nextInt(36);//最低出现的位置(从上往下)
	        int xl = random.nextInt(13);//左右偏移值
	        int yl = random.nextInt(15);//上下偏移值
	        //graphics.setColor(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
	        graphics.setColor(new Color(0, 0, 0));
	        graphics.drawLine(x, y, x + xl, y + yl); 
			//所有的颜色都不一样，随机获取字母的颜色
			//graphics.setColor(new Color(random.nextInt(88),random.nextInt(188),random.nextInt(255)));
			//控制字母的位置和间距还有高度
			graphics.drawString(ch[index]+"",(i*25+15),25);
			//保存到stringbuffer里边
			sb.append(ch[index]);
		}
		HttpSession session = request.getSession();			//生成session对象
		session.setAttribute("piccode",sb.toString().toLowerCase());		//把这个东西保存到session里方便后边验证
		System.out.println(sb.toString().toLowerCase());
		//用imgio流写到jsp页面
		try {
			ImageIO.setUseCache(false);
			ImageIO.write(bImage, "JPG", response.getOutputStream());
			ImageIO.setUseCache(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("图片验证码请求");
		
	}

	/*
	 * @Override public Model selectRoles(Users users,Model model) { List<Roles>
	 * roles = rolesMapper.selectAllRolesDistinct();
	 * model.addAttribute("roles",roles); List<Roles> role =
	 * rolesMapper.selectRolesByUsersId(users.getUsers_Id());
	 * model.addAttribute("role",role); return model; }
	 */
	@Override
	public int updatePasswordById(Integer users_Id, String password, String twoPassword) {
		// TODO Auto-generated method stub
		Users users=usersMapper.getOneUsersById(users_Id);
		try {
			//把老密码加密和数据库内的密文对比
			String passwordNew = PasswordEncrypt.encodeByMd5(password);
			//如果相等进行修改
			if(users.getUsers_Password().equals(passwordNew)) {
				//把新密码加密,进行修改
				String passwordNew2 = PasswordEncrypt.encodeByMd5(twoPassword);
				Users newUsers=new Users();
				newUsers.setUsers_Id(users_Id);
				newUsers.setUsers_Password(passwordNew2);
				int num=usersMapper.updateUsersChongZhiPassword(newUsers);
				if(num>0) {
					return 2;
				}
				else {
					return 1;
				}
			}
			else {
				return 0;//代表旧的密码不对
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;//修改失败
	}

	@Override
	public int updateUsersOnlineStatus(Integer usersId) {
		
		return usersMapper.updateUesrsOnline(usersId);
	}

	@Override
	public int updateUsersUnOnlineStatus(Integer usersId) {
		// TODO Auto-generated method stub
		return usersMapper.updateUesrsUnOnline(usersId);
	}



	@Override
	public Boolean testEmail(String email) {
		// TODO Auto-generated method stub
		Users users = usersMapper.selectUsersByEmail(email);
		if(users!=null){
			return true;
		}
		return false;
	}



	@Override
	public Boolean testPhone(String phone) {
		Users users = usersMapper.selectUsersByTel(phone);
		if(users!=null){
			return true;
		}
		return false;
	}
	
}
