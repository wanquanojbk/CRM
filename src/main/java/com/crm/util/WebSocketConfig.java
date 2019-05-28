package com.crm.util;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import com.crm.mapper.DynamicMapper;
import com.crm.mapper.UsersMapper;
   //表示配置 一般带这个东西 都是 配置到springboot里面
@Configuration
public class WebSocketConfig {
	@Bean  
    public ServerEndpointExporter serverEndpointExporter() {  
        return new ServerEndpointExporter();  
    }  
	@Autowired
	public void setMessageService(UsersMapper usresMapper,DynamicMapper dynamicMapper) {
		 WebSocketService.usersMapper = usresMapper;
		 WebSocketService.dynamicMapper=dynamicMapper;
	}
	
}