/** PaymentController.java  Nov 28,19
*/


package com.hospitality.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.PaymentBO;
import com.hospitality.core.Payment;

/**
* @author  #Kishore
*/

@Controller
@RequestMapping("/payment/")
public class PaymentController extends commonController{
	
	@Autowired
	private PaymentBO paymentBO;
	
	@RequestMapping(value="showCreatePayment",method = RequestMethod.GET)
	public ModelAndView showCreatePayment(){
		try{
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreatePayment");
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(Payment payment){
		try{
			paymentBO.create(payment);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreatePayment").addObject("payment", payment);
	}
	
	@RequestMapping(value="retrievePaymentList",method = RequestMethod.GET)
	public ModelAndView retrieveList(Payment payment){
		List<Payment> paymentList = new ArrayList<>();
		try{
			paymentList = paymentBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("paymentList").addObject("paymentList", paymentList);
	}
	
}
