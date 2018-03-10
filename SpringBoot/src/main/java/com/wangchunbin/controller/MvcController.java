package com.wangchunbin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangchunbin.config.Configuration;

@Controller
public class MvcController {

	@Autowired
	private Configuration configuration;

	@Value("${server.context-path}")
	private String contextpath;

	@RequestMapping(value = "/getConfigurationInfo", method = RequestMethod.GET)
	@ResponseBody
	public String getConfigurationInfo() {
		return configuration.toString() + " : " + contextpath;
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello() {
		return "hello";
	}

}
