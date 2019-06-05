/** UserRoleBOImpl.java  Dec 4,17
*/

package com.hospitality.boimpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.bo.UserRoleBO;
import com.hospitality.core.UserRole;
import com.hospitality.dao.UserRoleDAO;

/**
* @author  Kishore
*/

@Service("UserRoleBO")
@Scope(value="prototype")
public class UserRoleBOImpl implements UserRoleBO{

	@Autowired
	private UserRoleDAO UserRoleDAO;
	
	@Override
	public void create(UserRole UserRole) {
		try{
			if(StringUtils.isNotBlank(UserRole.getUserRoleId())){
				UserRoleDAO.update(UserRole);
			}else{
				UserRoleDAO.create(UserRole);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<UserRole> retrieveList() {
		List<UserRole> UserRoleList = null;
		try{
			UserRoleList = UserRoleDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return UserRoleList;
	}

}
