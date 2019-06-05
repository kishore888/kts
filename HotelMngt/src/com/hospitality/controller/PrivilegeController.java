/** PrivilegeController.java  Dec 3,17
*/


package com.hospitality.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.ModuleBO;
import com.hospitality.bo.PrivilegeBO;
import com.hospitality.core.Module;
import com.hospitality.core.Privilege;

/**
* @author  Kishore
*/

@Controller
@RequestMapping("/privilege/")
public class PrivilegeController {
	
	@Autowired
	private PrivilegeBO privilegeBO;
	
	@Autowired
	private ModuleBO moduleBO;
	
	@RequestMapping(value="showCreatePrivilege",method = RequestMethod.GET)
	public ModelAndView showCreatePrivilege(Privilege privilege){
		List<Privilege> privilegeList = new ArrayList<>();
		List<Module> moduleList = new ArrayList<>();
		try{
			if(StringUtils.isNotBlank(privilege.getPrivilegeId())) {
				privilege = privilegeBO.retrieveByPrivilegeId(privilege.getPrivilegeId());
			}
			privilegeList = privilegeBO.retrieveList();
			moduleList = moduleBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreatePrivilege").addObject("privilege", privilege).addObject("privilegeList", privilegeList).addObject("moduleList", moduleList);
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(Privilege privilege){
		try{
			privilegeBO.create(privilege);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("redirect:showCreatePrivilege?privilegeId="+privilege.getPrivilegeId());
	}
	
	@RequestMapping(value="retrievePrivilegeList",method = RequestMethod.GET)
	public ModelAndView retrieveList(Privilege privilege){
		List<Privilege> privilegeList = null;
		try{
			privilegeList = privilegeBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("PrivilegeList").addObject("privilegeList", privilegeList);
	}
	
}
