/** ElementStyleController.java  Jan 7,18
*/


package com.hospitality.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.ElementStyleBO;
import com.hospitality.core.ElementStyle;

/**
* @author  Kishore
*/

@Controller
@RequestMapping("/elementStyle/")
public class ElementStyleController {
	
	@Autowired
	private ElementStyleBO ElementStyleBO;
	
	@RequestMapping(value="showCreateElementStyle",method = RequestMethod.GET)
	public ModelAndView showCreateElementStyle(){
		try{
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateElementStyle");
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(ElementStyle ElementStyle){
		try{
			ElementStyleBO.create(ElementStyle);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateElementStyle").addObject("ElementStyle", ElementStyle);
	}
	
	@RequestMapping(value="retrieveElementStyleList",method = RequestMethod.GET)
	public ModelAndView retrieveList(ElementStyle ElementStyle){
		List<ElementStyle> ElementStyleList = null;
		try{
			ElementStyleList = ElementStyleBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("ElementStyleList").addObject("ElementStyleList", ElementStyleList);
	}
	
}
