package com.wangchunbin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.wangchunbin.entity.Girl;

public interface GirlRepository extends JpaRepository<Girl, Integer> ,JpaSpecificationExecutor<Girl>{
	// 方法名规则：findBy+属性且首字母大写
	public List<Girl> findByAge(Integer age);

}
