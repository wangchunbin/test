package com.wangchunbin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangchunbin.dao.GirlRepository;
import com.wangchunbin.entity.Girl;
import com.wangchunbin.exception.GirlException;
import com.wangchunbin.util.ResultEnum;

@Service
public class GirlService {

	@Autowired
	private GirlRepository girlRepository;

	public GirlRepository getGirlRepository() {
		return girlRepository;
	}

	public void setGirlRepository(GirlRepository girlRepository) {
		this.girlRepository = girlRepository;
	}

	public List<Girl> getGirlList() {
		return girlRepository.findAll();
	}

	public Girl addGirl(Girl girl) {
		return girlRepository.save(girl);
	}

	public Girl findOneGril(Integer id) {
		return girlRepository.findOne(id);
	}

	public Girl updateGril(Girl girl) {
		return girlRepository.save(girl);
	}

	public void deleteGril(Integer id) {
		girlRepository.delete(id);
	}

	public List<Girl> findByAge(Integer age) {
		return girlRepository.findByAge(age);
	}

	@Transactional
	public void insertTwoGirl() {
		Girl g1 = new Girl();
		g1.setAge(19);
		g1.setCupSize("D");
		g1.setName("MN-4");
		girlRepository.save(g1);
		Girl g2 = new Girl();
		g2.setAge(18);
		g2.setCupSize("FF");
		g2.setName("MN-5");
		girlRepository.save(g2);
	}

	public void getAge(Integer id) throws Exception {
		Girl girl = girlRepository.findOne(id);
		int age = girl.getAge();
		if (age < 10) {
			throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
		} else if (age >= 0 && age < 16) {
			throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
		} else if (age >= 16) {
			throw new GirlException(ResultEnum.HIGH_SCHOOL);
		}
	}
}
