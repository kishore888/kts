/** UserBOImpl.java  Dec 4,17
*/

package com.hospitality.boimpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.bo.UsersBO;
import com.hospitality.core.Users;
import com.hospitality.dao.UsersDAO;

/**
* @author  Kishore
*/

@Service("UserBO")
@Scope(value="prototype")
public class UsersBOImpl implements UsersBO{

	@Autowired
	private UsersDAO usersDAO;
	
	@Override
	public void create(Users User) {
		try{
			if(StringUtils.isNotBlank(User.getUserId())){
				usersDAO.update(User);
			}else{
				usersDAO.create(User);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<Users> retrieveList() {
		List<Users> UserList = null;
		try{
			UserList = usersDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return UserList;
	}

	@Override
	public Users retrieveByUserName(String userName) throws Exception {
		Users user = null;
		try{
			user = usersDAO.retrieveByUserName(userName);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return user;
	}

}
