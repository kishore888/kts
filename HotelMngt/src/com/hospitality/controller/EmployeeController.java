/** EmployeeController.java  Oct 31,17
*/


package com.hospitality.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.EmployeeBO;
import com.hospitality.core.Employee;

/**
* @author  Kishore
*/

@Controller
@RequestMapping("/employee/")
public class EmployeeController {
	
	@Autowired
	private EmployeeBO EmployeeBO;
	
			
	@RequestMapping(value="showCreateEmployee",method = RequestMethod.GET)
	public ModelAndView showCreateEmployee(){
		try{
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateEmployee");
	}
	
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(Employee Employee){
		try{
			EmployeeBO.create(Employee);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateEmployee").addObject("Employee", Employee);
	}
	
	@RequestMapping(value="retrieveEmployeeList",method = RequestMethod.GET)
	public ModelAndView retrieveList(Employee Employee){
		List<Employee> EmployeeList = null;
		try{
			EmployeeList = EmployeeBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("EmployeeList").addObject("EmployeeList", EmployeeList);
	}
	
}
