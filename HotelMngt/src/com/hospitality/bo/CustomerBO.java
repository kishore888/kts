/** CustomerBO.java  Nov 12,19
*/

package com.hospitality.bo;

import java.util.List;

import com.hospitality.core.Customer;

/**
* @author  #Kishore
*/

public interface CustomerBO {

	public void create(Customer customer) throws Exception;
	public List<Customer> retrieveList() throws Exception;

}
