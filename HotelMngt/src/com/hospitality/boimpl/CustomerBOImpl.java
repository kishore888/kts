/** CustomerBOImpl.java  Nov 12,19
*/

package com.hospitality.boimpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.bo.CustomerBO;
import com.hospitality.core.Customer;
import com.hospitality.dao.CustomerDAO;

/**
* @author  #Kishore
*/

@Service("CustomerBO")
@Scope(value="prototype")
public class CustomerBOImpl implements CustomerBO{

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public void create(Customer customer) {
		try{
			if(StringUtils.isNotBlank(customer.getCustomerId())){
				customerDAO.update(customer);
			}else{
				customerDAO.create(customer);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> retrieveList() {
		List<Customer> customerList = null;
		try{
			customerList = customerDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return customerList;
	}

	@Override
	public Customer retrieveById(String customerId) throws Exception {
		Customer customer = null;
		try{
			customer = customerDAO.retrieveById(customerId);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return customer;
	}

}
