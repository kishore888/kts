/** PaymentDetailsController.java  Nov 28,19
*/


package com.hospitality.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.PaymentDetailsBO;
import com.hospitality.core.PaymentDetails;

/**
* @author  #Kishore
*/

@Controller
@RequestMapping("/paymentDetails/")
public class PaymentDetailsController extends commonController{
	
	@Autowired
	private PaymentDetailsBO paymentDetailsBO;
	
	@RequestMapping(value="showCreatePaymentDetails",method = RequestMethod.GET)
	public ModelAndView showCreatePaymentDetails(){
		try{
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreatePaymentDetails");
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(PaymentDetails paymentDetails){
		try{
			paymentDetailsBO.create(paymentDetails);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreatePaymentDetails").addObject("paymentDetails", paymentDetails);
	}
	
	@RequestMapping(value="retrievePaymentDetailsList",method = RequestMethod.GET)
	public ModelAndView retrieveList(PaymentDetails paymentDetails){
		List<PaymentDetails> paymentDetailsList = new ArrayList<>();
		try{
			paymentDetailsList = paymentDetailsBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("paymentDetailsList").addObject("paymentDetailsList", paymentDetailsList);
	}
	
}
