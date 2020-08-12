/** UserRoleController.java  Dec 4,17
*/


package com.hospitality.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.UserRoleBO;
import com.hospitality.core.UserRole;

/**
* @author  Kishore
*/

@Controller
@RequestMapping("/userRole/")
public class UserRoleController {
	
	@Autowired
	private UserRoleBO UserRoleBO;
	
	@RequestMapping(value="showCreateUserRole",method = RequestMethod.GET)
	public ModelAndView showCreateUserRole(){
		try{
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateUserRole");
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(UserRole UserRole){
		try{
			UserRoleBO.create(UserRole);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateUserRole").addObject("UserRole", UserRole);
	}
	
	@RequestMapping(value="retrieveUserRoleList",method = RequestMethod.GET)
	public ModelAndView retrieveList(UserRole UserRole){
		List<UserRole> UserRoleList = null;
		try{
			UserRoleList = UserRoleBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("UserRoleList").addObject("UserRoleList", UserRoleList);
	}
	
}
