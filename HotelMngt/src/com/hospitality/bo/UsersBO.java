/** UserBO.java  Dec 4,17
*/

package com.hospitality.bo;

import java.util.List;

import com.hospitality.core.Users;

/**
* @author  Kishore
*/

public interface UsersBO {

	public void create(Users User);
	public List<Users> retrieveList();
	public Users retrieveByUserName(String userName) throws Exception;

}
