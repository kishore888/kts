/** UserRoleBO.java  Dec 4,17
*/

package com.hospitality.bo;

import java.util.List;

import com.hospitality.core.UserRole;

/**
* @author  Kishore
*/

public interface UserRoleBO {

	public void create(UserRole UserRole);
	public List<UserRole> retrieveList();

}
