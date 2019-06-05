/** PrivilegeBOImpl.java  Dec 3,17
*/

package com.hospitality.boimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.bo.PrivilegeBO;
import com.hospitality.core.Privilege;
import com.hospitality.dao.PrivilegeDAO;

/**
* @author  Kishore
*/

@Service("PrivilegeBO")
@Scope(value="prototype")
public class PrivilegeBOImpl implements PrivilegeBO{

	@Autowired
	private PrivilegeDAO privilegeDAO;
	
	@Override
	public void create(Privilege privilege) {
		try{
			if(StringUtils.isNotBlank(privilege.getPrivilegeId())){
				privilegeDAO.update(privilege);
			}else{
				privilegeDAO.create(privilege);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<Privilege> retrieveList() {
		List<Privilege> privilegeList = new ArrayList<>();
		try{
			privilegeList = privilegeDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return privilegeList;
	}

	@Override
	public Privilege retrieveByPrivilegeId(String privilegeId) throws Exception {
		Privilege privilege = null;
		try{
			privilege = privilegeDAO.retrieveByPrivilegeId(privilegeId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return privilege;
	}

}
