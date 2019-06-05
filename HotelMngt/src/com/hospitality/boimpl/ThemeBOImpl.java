/** ThemeBOImpl.java  Jan 7,18
*/

package com.hospitality.boimpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.bo.ThemeBO;
import com.hospitality.core.Theme;
import com.hospitality.dao.ThemeDAO;

/**
* @author  Kishore
*/

@Service("ThemeBO")
@Scope(value="prototype")
public class ThemeBOImpl implements ThemeBO{

	@Autowired
	private ThemeDAO themeDAO;
	
	@Override
	public void create(Theme theme) {
		try{
			if(StringUtils.isNotBlank(theme.getThemeId())){
				themeDAO.update(theme);
			}else{
				themeDAO.create(theme);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<Theme> retrieveList() {
		List<Theme> themeList = null;
		try{
			themeList = themeDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return themeList;
	}

	@Override
	public Theme retrieveByThemeId(String themeId) throws Exception {
		Theme theme = null;
		try{
			theme = themeDAO.retrieveByThemeId(themeId);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return theme;
	}

}
