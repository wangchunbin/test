package com.wangchunbin.services;

import com.dubbo.interfaces.ProviderService;
import org.apache.log4j.Logger;

public class ProviderServiceImpl implements ProviderService {
	private Logger logger = Logger.getLogger(ProviderServiceImpl.class);

	public String sayHello(String name) {
		this.logger.info("Hello," + name + "!!!");
		return "Hello," + name;
	}

}