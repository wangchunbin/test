package com.wangchunbin.util;

public class SpringConfigTestBean {
	
	public void init() {
		System.out.println("SpringConfigTestBean(使用@ImportResource注解，测试spirngboot 加载spirng xml配置文件，验证第三方框架整合) init...");
	}

	public void destory() {
		System.out.println("SpringConfigTestBean(使用@ImportResource注解，测试spirngboot 加载spirng xml配置文件，验证第三方框架整合) destory...");
	}
	
}
