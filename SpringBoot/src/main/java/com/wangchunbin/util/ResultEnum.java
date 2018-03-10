package com.wangchunbin.util;

public enum ResultEnum {
	
	UNKOWN_ERROR(-1,"未知错误！"),
	SUCCESS(0,"success"),
	PRIMARY_SCHOOL(100,"你可能在上小学！"),
	MIDDLE_SCHOOL(200,"你可能在上初中！"),
	HIGH_SCHOOL(300,"你可能在上高中！！");
	
	private Integer code;
	private String msg;

	private ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
