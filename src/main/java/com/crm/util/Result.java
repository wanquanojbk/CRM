package com.crm.util;

import com.crm.entity.Users;

/**
 * 这个类用于登录信息的公共类
 * 
 * @author ChirsGod
 *
 */
public class Result {
	private Boolean success;// 成功状态
	private String msg;// 写入信息
	private Integer isLockout;// 用于登录用户是否锁定的状态
	private Users users;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getIsLockout() {
		return isLockout;
	}

	public void setIsLockout(Integer isLockout) {
		this.isLockout = isLockout;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Result(Boolean success, String msg, Integer isLockout, Users users) {
		super();
		this.success = success;
		this.msg = msg;
		this.isLockout = isLockout;
		this.users = users;
	}

	public Result() {
		super();
	}

	@Override
	public String toString() {
		return "Result [success=" + success + ", msg=" + msg + ", isLockout=" + isLockout + ", users=" + users + "]";
	}

	
}
