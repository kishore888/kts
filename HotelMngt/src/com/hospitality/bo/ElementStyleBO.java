/** ElementStyleBO.java  Jan 7,18
*/

package com.hospitality.bo;

import java.util.List;

import com.hospitality.core.ElementStyle;

/**
* @author  Kishore
*/

public interface ElementStyleBO {

	public void create(ElementStyle ElementStyle);
	public List<ElementStyle> retrieveList();

}
