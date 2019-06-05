/** RoleBO.java  Dec 3,17
*/

package com.hospitality.bo;

import java.util.List;

import com.hospitality.core.Role;

/**
* @author  Kishore
*/

public interface RoleBO {

	public void create(Role Role);
	public List<Role> retrieveList();
	public Role retrieveByRoleId(Role role) throws Exception;

}
