package com.wangchunbin.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 使用java类配置spring bean
 * 
 * @author WangChunBin
 *
 */
@Configuration
public class JavaConfigBean {

	@Bean(value = "jcb")
	@Scope("singleton")
	public JavaConfigBean testBean() {
		System.out.println("使用@Configuration和@Bean注解，加载生成spring bean！");
		return new JavaConfigBean();
	}

}
