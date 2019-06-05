/** EmailBO.java  Dec 31,17
*/

package com.hospitality.bo;

import java.util.List;

import com.hospitality.core.Email;

/**
* @author  Kishore
*/

public interface EmailBO {

	public void create(Email Email);
	public List<Email> retrieveList();
	public List<Email> retrieveEmailListByEmailId(String emailId) throws Exception;
	public void sendEmail(Email email) throws Exception;

}
