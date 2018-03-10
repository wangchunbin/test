package com.wangchunbin.services;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.wangchunbin.entity.Girl;

/**
 * Service层测试
 * 
 * @author WangChunBin
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

	@Autowired
	private GirlService girlService;

	@Test
	public void testGetGirlList() {
		List<Girl> list = girlService.getGirlList();
		Assert.assertFalse(list.size() == 0);
	}

	@Test
	public void testAddGirl() {
	}

	@Test
	public void testFindOneGril() {
	}

	@Test
	public void testUpdateGril() {
	}

	@Test
	public void testDeleteGril() {
	}

	@Test
	public void testFindByAge() {
	}

	@Test
	public void testInsertTwoGirl() {
	}

	@Test
	public void testGetAge() {
	}

}
