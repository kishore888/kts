/** ModuleController.java  Dec 3,17
*/


package com.hospitality.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.ModuleBO;
import com.hospitality.core.Module;

/**
* @author  Kishore
*/

@Controller
@RequestMapping("/module/")
public class ModuleController {
	
	@Autowired
	private ModuleBO moduleBO;
	
	@RequestMapping(value="showCreateModule",method = RequestMethod.GET)
	public ModelAndView showCreateModule(){
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateModule");
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(Module module){
		try{
			moduleBO.create(module);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("redirect:showCreateModule").addObject("module", module);
	}
	
	@RequestMapping(value="retrieveModuleList",method = RequestMethod.GET)
	public ModelAndView retrieveList(Module module){
		List<Module> moduleList = null;
		try{
			moduleList = moduleBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("ModuleList").addObject("moduleList", moduleList);
	}
	
}
