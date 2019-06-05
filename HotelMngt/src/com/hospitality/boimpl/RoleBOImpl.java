/** RoleBOImpl.java  Dec 3,17
*/

package com.hospitality.boimpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.bo.RoleBO;
import com.hospitality.core.Role;
import com.hospitality.dao.RoleDAO;

/**
* @author  Kishore
*/

@Service("RoleBO")
@Scope(value="prototype")
public class RoleBOImpl implements RoleBO{

	@Autowired
	private RoleDAO roleDAO;
	
	@Override
	public void create(Role Role) {
		try{
			if(StringUtils.isNotBlank(Role.getRoleId())){
				roleDAO.update(Role);
			}else{
				roleDAO.create(Role);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<Role> retrieveList() {
		List<Role> RoleList = null;
		try{
			RoleList = roleDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return RoleList;
	}

	@Override
	public Role retrieveByRoleId(Role role) throws Exception {
		try{
			role = roleDAO.retrieveByRoleId(role);
		}catch(Exception e){
			e.printStackTrace();
		}
		return role;
	}

}
