package com.wangchunbin.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Controller层测试
 * 
 * @author WangChunBin
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testGirlList() throws Exception {
		// 判断返回状态码
		mvc.perform(MockMvcRequestBuilders.get("/girls")).andExpect(MockMvcResultMatchers.status().isOk());
		// 返回内容匹配测试
		//.andExpect(MockMvcResultMatchers.content().string("[{\"id\":10,\"name\":\"MN-3\",\"cupSize\":\"G\",\"age\":21,\"desc\":null},{\"id\":11,\"name\":\"MN-3\",\"cupSize\":\"G\",\"age\":20,\"desc\":null},{\"id\":12,\"name\":\"MN-3\",\"cupSize\":\"G\",\"age\":18,\"desc\":null},{\"id\":13,\"name\":\"MN-3\",\"cupSize\":\"G\",\"age\":18,\"desc\":null}]"));
	}

}
