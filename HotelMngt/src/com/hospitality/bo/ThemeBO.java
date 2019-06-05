/** ThemeBO.java  Jan 7,18
*/

package com.hospitality.bo;

import java.util.List;

import com.hospitality.core.Theme;

/**
* @author  Kishore
*/

public interface ThemeBO {

	public void create(Theme Theme);
	public List<Theme> retrieveList();
	public Theme retrieveByThemeId(String themeId) throws Exception;

}
