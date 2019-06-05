/** ThemeController.java  Jan 7,18
*/


package com.hospitality.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.ThemeBO;
import com.hospitality.core.Theme;

/**
* @author  Kishore
*/

@Controller
@RequestMapping("/theme/")
public class ThemeController {
	
	@Autowired
	private ThemeBO themeBO;
	
	@RequestMapping(value="showCreateTheme",method = RequestMethod.GET)
	public ModelAndView showCreateTheme(Theme theme){
		try{
			if(StringUtils.isNotBlank(theme.getThemeId())) {
				theme = themeBO.retrieveByThemeId(theme.getThemeId());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateTheme").addObject("theme", theme);
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(Theme theme){
		try{
			themeBO.create(theme);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("redirect:CreateTheme?themeId="+theme.getThemeId());
	}
	
	@RequestMapping(value="retrieveThemeList",method = RequestMethod.GET)
	public ModelAndView retrieveList(Theme theme){
		List<Theme> themeList = null;
		try{
			themeList = themeBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("ThemeList").addObject("themeList", themeList);
	}
	
}
