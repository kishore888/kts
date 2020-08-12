/** TransactionDetailsController.java  Dec 29,19
*/


package com.hospitality.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.TransactionDetailsBO;
import com.hospitality.core.TransactionDetails;

/**
* @author  #Kishore
*/

@Controller
@RequestMapping("/transactionDetails/")
public class TransactionDetailsController extends commonController{
	
	@Autowired
	private TransactionDetailsBO transactionDetailsBO;
	
	@RequestMapping(value="create",method = RequestMethod.GET)
	public ModelAndView showCreateTransactionDetails(){
		try{
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateTransactionDetails");
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(TransactionDetails transactionDetails){
		try{
			transactionDetailsBO.create(transactionDetails);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateTransactionDetails").addObject("transactionDetails", transactionDetails);
	}
	
	@RequestMapping(value="retrieveTransactionDetailsList",method = RequestMethod.GET)
	public ModelAndView retrieveList(TransactionDetails transactionDetails){
		List<TransactionDetails> transactionDetailsList = new ArrayList<>();
		try{
			transactionDetailsList = transactionDetailsBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("transactionDetailsList").addObject("transactionDetailsList", transactionDetailsList);
	}
	
}
