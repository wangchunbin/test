package com.wangchunbin.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangchunbin.util.Result;

/**
 * 统一异常管理类
 * 
 * @author WangChunBin
 *
 */
@ControllerAdvice
public class ControllerExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result<Object> handler(Exception exception) {
		Result<Object> result = new Result<Object>();
		// 判断是否是GirlException实例
		if (exception instanceof GirlException) {
			GirlException girlException = (GirlException) exception;
			result.setCode(girlException.getCode());
			result.setMsg(girlException.getMessage());
		} else {
			result.setCode(-1);
			result.setMsg(exception.getMessage());
			logger.error(exception.getMessage(), exception);
		}
		return result;
	}

}
