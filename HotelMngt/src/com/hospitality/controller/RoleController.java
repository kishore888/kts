/** RoleController.java  Dec 3,17
*/


package com.hospitality.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.RoleBO;
import com.hospitality.core.Role;

/**
* @author  Kishore
*/

@Controller
@RequestMapping("/role/")
public class RoleController {
	
	@Autowired
	private RoleBO roleBO;
	
	@RequestMapping(value="showCreateRole",method = RequestMethod.GET)
	public ModelAndView showCreateRole(Role role){
		try{
			if(StringUtils.isNotBlank(role.getRoleId())) {
				role = roleBO.retrieveByRoleId(role);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateRole").addObject("role", role);
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(Role role){
		try{
			roleBO.create(role);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("redirect:showCreateRole?roleId="+role.getRoleId()).addObject("role", role);
	}
	
	@RequestMapping(value="retrieveRoleList",method = RequestMethod.GET)
	public ModelAndView retrieveList(Role role){
		List<Role> roleList = null;
		try{
			roleList = roleBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("RoleList").addObject("roleList", roleList);
	}
	
}
