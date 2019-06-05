/** ModuleBOImpl.java  Dec 3,17
*/

package com.hospitality.boimpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.bo.ModuleBO;
import com.hospitality.core.Module;
import com.hospitality.dao.ModuleDAO;

/**
* @author  Kishore
*/

@Service("ModuleBO")
@Scope(value="prototype")
public class ModuleBOImpl implements ModuleBO{

	@Autowired
	private ModuleDAO moduleDAO;
	
	@Override
	public void create(Module module) {
		try{
			if(StringUtils.isNotBlank(module.getModuleId())){
				moduleDAO.update(module);
			}else{
				moduleDAO.create(module);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<Module> retrieveList() {
		List<Module> moduleList = null;
		try{
			moduleList = moduleDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return moduleList;
	}

}
