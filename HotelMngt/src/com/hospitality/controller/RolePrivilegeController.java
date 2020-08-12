/** RolePrivilegeController.java  Dec 3,17
*/


package com.hospitality.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.RolePrivilegeBO;
import com.hospitality.core.RolePrivilege;

/**
* @author  Kishore
*/

@Controller
@RequestMapping("/rolePrivilege/")
public class RolePrivilegeController {
	
	@Autowired
	private RolePrivilegeBO RolePrivilegeBO;
	
	@RequestMapping(value="showCreateRolePrivilege",method = RequestMethod.GET)
	public ModelAndView showCreateRolePrivilege(){
		try{
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateRolePrivilege");
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(RolePrivilege RolePrivilege){
		try{
			RolePrivilegeBO.create(RolePrivilege);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateRolePrivilege").addObject("RolePrivilege", RolePrivilege);
	}
	
	@RequestMapping(value="retrieveRolePrivilegeList",method = RequestMethod.GET)
	public ModelAndView retrieveList(RolePrivilege RolePrivilege){
		List<RolePrivilege> RolePrivilegeList = null;
		try{
			RolePrivilegeList = RolePrivilegeBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("RolePrivilegeList").addObject("RolePrivilegeList", RolePrivilegeList);
	}
	
}
