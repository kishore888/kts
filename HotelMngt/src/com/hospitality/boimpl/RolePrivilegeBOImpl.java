/** RolePrivilegeBOImpl.java  Dec 3,17
*/

package com.hospitality.boimpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.bo.RolePrivilegeBO;
import com.hospitality.core.RolePrivilege;
import com.hospitality.dao.RolePrivilegeDAO;

/**
* @author  Kishore
*/

@Service("RolePrivilegeBO")
@Scope(value="prototype")
public class RolePrivilegeBOImpl implements RolePrivilegeBO{

	@Autowired
	private RolePrivilegeDAO RolePrivilegeDAO;
	
	@Override
	public void create(RolePrivilege RolePrivilege) {
		try{
			if(StringUtils.isNotBlank(RolePrivilege.getRolePrivilegeId())){
				RolePrivilegeDAO.update(RolePrivilege);
			}else{
				RolePrivilegeDAO.create(RolePrivilege);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<RolePrivilege> retrieveList() {
		List<RolePrivilege> RolePrivilegeList = null;
		try{
			RolePrivilegeList = RolePrivilegeDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return RolePrivilegeList;
	}

}
