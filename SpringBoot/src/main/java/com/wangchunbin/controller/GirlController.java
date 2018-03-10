package com.wangchunbin.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wangchunbin.entity.Girl;
import com.wangchunbin.services.GirlService;
import com.wangchunbin.util.Result;
import com.wangchunbin.util.ResultEnum;
/**
 * 
 * @author WangChunBin
 *
 */
@RestController
public class GirlController {

	@Autowired
	private GirlService girlService;

	public GirlService getGirlService() {
		return girlService;
	}

	public void setGirlService(GirlService girlService) {
		this.girlService = girlService;
	}

	/**
	 * 查询所有女生列表
	 * 
	 * @return
	 */
	@GetMapping(value = "/girls")
	public List<Girl> girlList() {
		return girlService.getGirlList();
	}

	/**
	 * 添加一个女生 封装返回值
	 * 
	 * @param girl
	 * @return
	 */
	@PostMapping(value = "/girls")
	public Result<Girl> girlAdd(@Valid Girl girl, BindingResult br) {
		Result<Girl> result = new Result<Girl>();
		// 表单验证
		if (br.hasErrors()) {
			StringBuffer errorInfo = new StringBuffer();
			List<FieldError> list = br.getFieldErrors();
			if (list != null && list.size() > 0) {
				for (FieldError fe : list) {
					errorInfo.append(fe.getField() + ":" + fe.getDefaultMessage() + " ");
				}
			}
			result.setCode(-1);
			result.setData(null);
			result.setMsg(errorInfo.toString());
		} else {
			result.setCode(ResultEnum.SUCCESS.getCode());
			result.setData(girlService.addGirl(girl));
			result.setMsg(ResultEnum.SUCCESS.getMsg());
		}
		return result;
	}

	/**
	 * 查询一个女生
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/girls/{id}")
	public Girl girlFindOne(@PathVariable(value = "id") Integer id) {
		return girlService.findOneGril(id);
	}

	/**
	 * 更新一个女生
	 * 
	 * @param girl
	 * @return
	 */
	@PutMapping(value = "/girls")
	public Girl girlUpdate(Girl girl) {
		return girlService.updateGril(girl);
	}

	/**
	 * 删除一个女生
	 * 
	 * @param id
	 */
	@DeleteMapping(value = "/girls/{id}")
	public void girlDelete(@PathVariable(value = "id") Integer id) {
		girlService.deleteGril(id);
	}

	/**
	 * 通过年龄查询女生列表
	 * 
	 * @param age
	 * @return
	 */
	@GetMapping(value = "/girls/age/{age}")
	public List<Girl> girlFindByAge(@PathVariable(value = "age") Integer age) {
		return girlService.findByAge(age);
	}

	/**
	 * 插入两个，模拟测试事务
	 */
	@GetMapping(value = "/girls/two")
	public void insertTwo() {
		girlService.insertTwoGirl();
	}

	/**
	 * 获取年龄段上学级别 统一异常管理
	 * 
	 * @param id
	 * @throws Exception
	 */
	@GetMapping(value = "/girls/getAge/{id}")
	public void getAge(@PathVariable(value = "id") Integer id) throws Exception {
		girlService.getAge(id);
	}

}
