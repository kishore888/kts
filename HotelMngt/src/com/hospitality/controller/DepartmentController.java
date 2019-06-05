/** DepartmentController.java  Oct 31,17
*/


package com.hospitality.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.DepartmentBO;
import com.hospitality.core.Department;

/**
* @author  Kishore
*/

@Controller
@RequestMapping("/department/")
public class DepartmentController {
	
	@Autowired
	private DepartmentBO departmentBO;
	
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(Department department){
		try{
			departmentBO.create(department);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateRoom").addObject("department", department);
	}
	
	@RequestMapping(value="retrieveRoomList",method = RequestMethod.GET)
	public ModelAndView retrieveList(Department department){
		List<Department> departmentList = null;
		try{
			departmentList = departmentBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("departmentList").addObject("departmentList", departmentList);
	}
	
}
