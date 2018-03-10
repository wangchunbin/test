package com.wangchunbin.aop;

import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class ApplicationAspect {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationAspect.class);

	@Before(value = "execution(* com.wangchunbin.controller.*.*(..))")
	public void controllerBeforeLog(JoinPoint jp) {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = servletRequestAttributes.getRequest();
		// 请求路径
		logger.info("请求路径：" + request.getRequestURL());
		// 请求方法
		logger.info("请求方法：" + request.getMethod());
		// IP
		logger.info("请求IP：" + request.getRemoteAddr());
		// 类方法
		logger.info("类方法：" + jp.getTarget().getClass() + ":" + jp.getSignature().getName());
		// 请求参数
		logger.info("请求参数：" + "参数个数"+(jp.getArgs()!=null&&jp.getArgs().length>0?jp.getArgs().length:"0")+(jp.getArgs()!=null&&jp.getArgs().length>0?(",第一个参数"+jp.getArgs()[0].toString()):""));
	}
	
	@AfterReturning(value="execution(* com.wangchunbin.controller.*.*(..))",returning="returnVal")
	public void controllerAfterReturningLog(Object returnVal){
		logger.info("返回值："+returnVal);
	}

}
