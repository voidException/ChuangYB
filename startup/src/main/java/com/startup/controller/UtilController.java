package com.startup.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.startup.service.UtilService;
import com.startup.vo.BaseVo;


@Controller
@RequestMapping(value="/util")
public class UtilController {
	
	@Resource
	UtilService utilService;
	
	@RequestMapping(value="/cleanCache", method=RequestMethod.GET)
	public @ResponseBody BaseVo cleanCache(int password) {
		BaseVo baseVo = new BaseVo();
		if(password == 123456) {
			baseVo.setError(1);
			baseVo.setErrorMessage("清除缓存成功");
			utilService.reload();
		} else {
			baseVo.setError(0);
			baseVo.setErrorMessage("清除缓存失败");
		}
		return baseVo;
	}
}
