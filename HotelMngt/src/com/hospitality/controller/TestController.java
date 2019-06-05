package com.hospitality.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.core.Department;

@Controller
@RequestMapping("/test/")
public class TestController {

	@RequestMapping(value="rainyAnimation",method = RequestMethod.GET)
	public ModelAndView rainyAnimation(Department department){
		try{
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("RainyAnimation");
	}
}
