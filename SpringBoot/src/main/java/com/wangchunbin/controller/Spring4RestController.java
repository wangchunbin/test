package com.wangchunbin.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Spring4RestController {

	@RequestMapping(value = "/getMapData", method = RequestMethod.POST)
	public Map<String, String> getMapData() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "wangzhe");
		map.put("age", "23");
		return map;
	}

	@RequestMapping(value = "/say/{msg}", method = RequestMethod.GET)
	public String say(@PathVariable("msg") String msg) {
		return "say:" + msg;
	}

	@RequestMapping(value = "/getMsgById", method = RequestMethod.POST)
	public String getMsgById(@RequestParam(value="id",required=false,defaultValue="1000") Integer id) {
		return "id:" + id;
	}

}
