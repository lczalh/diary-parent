package com.diary.commons.commonrequestparameter;

import javax.validation.constraints.NotEmpty;


public class DiaryCommonRequestParameter {
	/*
	 * APP名称
	 */
	@NotEmpty(message = "应用名称不能为空")
	private String appName;
	
	/*
	 * APP版本号
	 */
	@NotEmpty(message = "APP版本号不能为空")
	private String appVersion;
	
	/*
	 * 加密方式
	 */
	@NotEmpty(message = "加密方式不能为空")
	private String encryption;
	
	/*
	 * 格式
	 */
	@NotEmpty(message = "数据格式不能为空")
	private String format;
	
	/*
	 * appKey
	 */
	@NotEmpty(message = "appKey不能为空")
	private String appKey;
	
	/*
	 * ticket
	 */
	@NotEmpty(message = "ticket不能为空")
	private String ticket;

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getEncryption() {
		return encryption;
	}

	public void setEncryption(String encryption) {
		this.encryption = encryption;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "DiaryCommonRequestParameter [appName=" + appName + ", appVersion=" + appVersion + ", encryption="
				+ encryption + ", format=" + format + ", appKey=" + appKey + ", ticket=" + ticket + "]";
	}
	
	
}
