package com.crm.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;


import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.crm.entity.Dynamic;
import com.crm.entity.Users;
import com.crm.mapper.DynamicMapper;
import com.crm.mapper.UsersMapper;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;


@ServerEndpoint("/websocket/{sid}")
@RestController
public class WebSocketService {
	
	
	//自动注入
	 static UsersMapper usersMapper;
	 //记录用户id的变量
	 private  int id =0;
	
	 static DynamicMapper dynamicMapper;
	
	
	static Log log=LogFactory.get(WebSocketService.class);
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocketService> webSocketSet = new CopyOnWriteArraySet<WebSocketService>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //接收sid
    private String sid="";
    /**
     * 连接建立成功调用的方法
     * @throws IOException 
     * @throws ParseException */
    @OnOpen
    public void onOpen(Session session,@PathParam("sid") String sid) throws IOException, ParseException {
    	this.id = Integer.parseInt(sid);
    	this.session = session;
    	webSocketSet.add(this);
    	addOnlineCount(); 
    	log.info("有新窗口开始监听:"+sid+",当前在线人数为" + getOnlineCount());
        this.sid=sid;
        //通过自己id查看 有没有 发给自己并且自己未读的消息
    	List<Dynamic> myselfMessage = dynamicMapper.selectMySelfWeiDuMessage(this.id);
    	//如果 是有的话
    	if(myselfMessage!=null&& !"[]".equals(myselfMessage.toString())) {
    		for(int i=0;i<myselfMessage.size();i++) {
    			String content = myselfMessage.get(i).getDynamic_Text();
    			Users users = usersMapper.selectUsersById(myselfMessage.get(i).getDynamic_Creator());
    			String avatar = "/CRM/img/cat.jpg";
    			String username = users.getUsers_LoginName();
    			System.out.println(myselfMessage.get(i).getDynamic_CreateTime().toString()+"--------------");
    			long mills = getTimeLong(myselfMessage.get(i).getDynamic_CreateTime());
    			String code = username +","+avatar+","+myselfMessage.get(i).getDynamic_Creator() +","+mills+","+content;
    			dynamicMapper.uapateStatus(myselfMessage.get(i).getDynamic_Id());
    			sendInfo(code, sid);
    		}
    	}
    	else {
    		 try {
            	 sendMessage("连接成功");
            } catch (IOException e) {
                log.error("websocket IO异常");
            }
    	}
    	
       
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        //数据库里面修改状态
        usersMapper.updateUesrsUnOnline(this.id);
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
        
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * @throws IOException 
     * @throws ParseException */
    @OnMessage
    public void onMessage(String message, Session session) throws IOException, ParseException {
    	
    	log.info("收到来自窗口"+sid+"的信息:"+message);
    	
    	
    	
//    	try {
//			sendInfo(message, "1");
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
    	
    
    
    	chatMessage(message);
//        //群发消息
//        for (WenSocketService item : webSocketSet) {
//            try {
//                item.sendMessage(message);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    
    public void chatMessage(String message) throws IOException {
    	JSONObject json = JSON.parseObject(message);
    	JSONObject data = json.getJSONObject("data");
    	JSONObject mine = data.getJSONObject("mine");
    	JSONObject to = data.getJSONObject("to");
    	String username = mine.getString("username");
    	String avatar = mine.getString("avatar");
    	String id = mine.getString("id");
    	String content = mine.getString("content");
    	String fromid = to.getString("id");
    	long mills = System.currentTimeMillis();
//    	Map<String,Object> map = new HashMap<String, Object>();
//    	Map<String,Object> map2 = new HashMap<String, Object>();
//    	map.put("type", "chatMessage");
//    	map2.put("username", username);
//    	map2.put("avatar", avatar);
//    	map2.put("id", id);
//    	map2.put("type", type);
//    	map2.put("content", content);
//    	map2.put("mine", "false");
//    	map2.put("fromid", id);
//    	map2.put("timestamp", mills);
//    	map.put("hhhhh", map2);
    	
    	Message xiaoxi = new Message();
    	
    	xiaoxi.setAvatar(avatar);
    	xiaoxi.setCid(0);
    	xiaoxi.setContent(content);
    	xiaoxi.setFromid(id);
    	xiaoxi.setId(id);
    	xiaoxi.setType("friend");
    	xiaoxi.setMine(false);
    	xiaoxi.setUsername(username);
    	xiaoxi.setTimestamp(mills);
    	
    	String code = username +","+avatar+","+ id+","+mills+","+content;
    	//Gson gson = new Gson();
    	System.out.println(code+"----------------");
    	 for (WebSocketService item : webSocketSet) {
    		 //如果在线
    		 if(item.sid.equals(fromid)) {
    			 sendInfo(code,fromid);
    		 }
    		 //如果不在线 记录到数据库里面
    		 else {
    			 //添加到数据库里面的信息
    			 Dynamic dynamic = new Dynamic();
    			 dynamic.setDynamic_Creator(Integer.parseInt(id));
    			 dynamic.setDynamic_Recipients(Integer.parseInt(fromid));
    			 dynamic.setDynamic_Text(content);
    			 LocalDateTime localDateTime = LocalDateTime.now();
    			 dynamic.setDynamic_CreateTime(localDateTime.toString());
    			 dynamic.setDynamic_Status(0);
    			 dynamicMapper.insertDynamic(dynamic);
    		 }
    	 }
    }
    
	/**
	 * 
	 * @param session
	 * @param error
	 */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }
	/**
	 * 实现服务器主动推送
	 */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    /**
     * 群发自定义消息
     * */
    public static void sendInfo(String message,@PathParam("sid") String sid) throws IOException {
    	log.info("推送消息到窗口"+sid+"，推送内容:"+message);
        for (WebSocketService item : webSocketSet) {
            try {
            	//这里可以设定只推送给这个sid的，为null则全部推送
            	if(sid==null) {
            		item.sendMessage(message);
            	}else if(item.sid.equals(sid)){
            		item.sendMessage(message);
            	}
            } catch (IOException e) {
                continue;
            }
        }
    }
    

    

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
    	WebSocketService.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
    	WebSocketService.onlineCount--;
    }
    
    
    public long getTimeLong(String dateStr) throws ParseException{
//      DateTimeFormatter strToDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//      TemporalAccessor dateTemporal = strToDateFormatter.parse(dateStr);
//      LocalDate date = LocalDate.from(dateTemporal);
    	//2019-05-26  2112 
    	//1.把前半段截取 转换成  localDate   后半段截取 换成   localTime 
    	SimpleDateFormat ssss = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	Date parse = ssss.parse(dateStr);
    	long time2 = parse.getTime();      //毫秒数
    	return time2;
//    	DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");  // 当前日期 格式
//    	DateTimeFormatter ofPattern2 = DateTimeFormatter.ofPattern("hh:mm:ss");  //当前时间 格式
//    	LocalDateTime dangqian = LocalDateTime.parse(dateStr);  //数据库的时间  转成 完整当前时间
//    	String format = dangqian.format(ofPattern);  //字符串的当前日期
//    	String format2 = dangqian.format(ofPattern2);  //字符串的时间
//    	//String localDate = dateStr.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        LocalDate localDate = LocalDate.parse(format);  //当前日期
//        LocalTime time = LocalTime.parse(format2);
//        long l = LocalDateTime.of(localDate, time).toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
       
    }
}
