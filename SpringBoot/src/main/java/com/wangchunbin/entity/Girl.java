package com.wangchunbin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

@Entity
public class Girl {
	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private String cupSize;
	
	@Min(value = 18)
	private Integer age;

	@Transient
	private String desc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCupSize() {
		return cupSize;
	}

	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Girl [id=" + id + ", name=" + name + ", cupSize=" + cupSize + ", age=" + age + ", desc=" + desc + "]";
	}

}
