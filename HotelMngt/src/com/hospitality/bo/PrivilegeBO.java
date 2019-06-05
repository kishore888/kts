/** PrivilegeBO.java  Dec 3,17
*/

package com.hospitality.bo;

import java.util.List;

import com.hospitality.core.Privilege;

/**
* @author  Kishore
*/

public interface PrivilegeBO {

	public void create(Privilege Privilege);
	public List<Privilege> retrieveList();
	public Privilege retrieveByPrivilegeId(String privilegeId) throws Exception;

}
