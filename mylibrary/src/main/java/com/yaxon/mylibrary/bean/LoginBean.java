package com.yaxon.mylibrary.bean;

/**
 * 登录应答数据类
 */
public class LoginBean  {

	private long uid;
	private String userMobile;
	private String name;
	private String userName;
	private int type;
	public int rc;
	public String errMsg;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getRc() {
		return rc;
	}

	public void setRc(int rc) {
		this.rc = rc;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	@Override
	public String toString() {
		return "LoginBean{" +
				"uid=" + uid +
				", userMobile='" + userMobile + '\'' +
				", name='" + name + '\'' +
				", userName='" + userName + '\'' +
				", type=" + type +
				", rc=" + rc +
				", errMsg='" + errMsg + '\'' +
				'}';
	}
}
