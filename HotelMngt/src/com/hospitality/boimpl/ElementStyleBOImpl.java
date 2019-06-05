/** ElementStyleBOImpl.java  Jan 7,18
*/

package com.hospitality.boimpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.bo.ElementStyleBO;
import com.hospitality.core.ElementStyle;
import com.hospitality.dao.ElementStyleDAO;

/**
* @author  Kishore
*/

@Service("ElementStyleBO")
@Scope(value="prototype")
public class ElementStyleBOImpl implements ElementStyleBO{

	@Autowired
	private ElementStyleDAO ElementStyleDAO;
	
	@Override
	public void create(ElementStyle ElementStyle) {
		try{
			if(StringUtils.isNotBlank(ElementStyle.getElementStyleId())){
				ElementStyleDAO.update(ElementStyle);
			}else{
				ElementStyleDAO.create(ElementStyle);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<ElementStyle> retrieveList() {
		List<ElementStyle> ElementStyleList = null;
		try{
			ElementStyleList = ElementStyleDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return ElementStyleList;
	}

}
