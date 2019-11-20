/** CustomerController.java  Nov 12,19
*/


package com.hospitality.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.CustomerBO;
import com.hospitality.core.Customer;

/**
* @author  #Kishore
*/

@Controller
@RequestMapping("/customer/")
public class CustomerController extends commonController{
	
	@Autowired
	private CustomerBO customerBO;
	
	@RequestMapping(value="showCreateCustomer",method = RequestMethod.GET)
	public ModelAndView showCreateCustomer(){
		try{
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateCustomer");
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(Customer customer){
		try{
			customerBO.create(customer);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateCustomer").addObject("customer", customer);
	}
	
	@RequestMapping(value="retrieveCustomerList",method = RequestMethod.GET)
	public ModelAndView retrieveList(Customer customer){
		List<Customer> customerList = new ArrayList<>();
		try{
			customerList = customerBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("customerList").addObject("customerList", customerList);
	}
	
}
