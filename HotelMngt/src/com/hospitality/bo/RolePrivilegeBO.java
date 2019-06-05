/** RolePrivilegeBO.java  Dec 3,17
*/

package com.hospitality.bo;

import java.util.List;

import com.hospitality.core.RolePrivilege;

/**
* @author  Kishore
*/

public interface RolePrivilegeBO {

	public void create(RolePrivilege RolePrivilege);
	public List<RolePrivilege> retrieveList();

}
