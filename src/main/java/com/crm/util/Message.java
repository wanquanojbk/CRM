package com.crm.util;

public class Message {
	private String username;
	private String id;
	private String type;
	private String content;
	private Integer cid;
	private Boolean mine;
	private String fromid;
	private Long timestamp;
	private String avatar;
	
	
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getUsername() {
		return username;
	}
	public String getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	public String getContent() {
		return content;
	}
	public Integer getCid() {
		return cid;
	}
	public Boolean getMine() {
		return mine;
	}
	public String getFromid() {
		return fromid;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public void setMine(Boolean mine) {
		this.mine = mine;
	}
	public void setFromid(String fromid) {
		this.fromid = fromid;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		
		
		return "{username:" + "\""+username+"\"" + ", id:" + "\""+id+"\"" + ", type:" + "\""+type+"\"" + ", content:" + "\""+content+"\"" + ", cid:"
				+ cid + ", mine:" +mine + ", fromid:" + "\""+fromid+"\"" + ", timestamp:" + timestamp + ", avatar:" + "\""+avatar+"\""
				+ "}";
	}
	
	
	
	
}
