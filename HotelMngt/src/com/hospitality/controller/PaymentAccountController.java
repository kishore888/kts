/** PaymentAccountController.java  Dec 8,19
*/


package com.hospitality.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.HotelPaymentGatewayBO;
import com.hospitality.bo.PaymentAccountBO;
import com.hospitality.core.Hotel;
import com.hospitality.core.HotelPaymentGateway;
import com.hospitality.core.PaymentAccount;

/**
* @author  #Kishore
*/

@Controller
@RequestMapping("/paymentAccount/")
public class PaymentAccountController extends commonController{
	
	@Autowired
	private PaymentAccountBO paymentAccountBO;
	
	@Autowired
	private HotelPaymentGatewayBO hotelPaymentGatewayBO;
	
	@RequestMapping(value="create",method = RequestMethod.GET)
	public ModelAndView showCreatePaymentAccount(String paymentAccountId, HttpSession session){
		List<HotelPaymentGateway> hotelPaymentGatewayList = new ArrayList<>();
		Hotel hotel = null;
		PaymentAccount paymentAccount = null;
		List<PaymentAccount> paymentAccountList = new ArrayList<>();
		try{
			hotel = (Hotel)session.getAttribute("hotelObj");
			if(StringUtils.isNotBlank(paymentAccountId)) {
				paymentAccount = paymentAccountBO.retrieveById(paymentAccountId);
			}
			hotelPaymentGatewayList = hotelPaymentGatewayBO.retrieveListByHotel(hotel);
			paymentAccountList = paymentAccountBO.retrieveListByHotel(hotel);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreatePaymentAccount", "hotelPaymentGatewayList", hotelPaymentGatewayList).addObject("paymentAccount", paymentAccount).addObject("paymentAccountList", paymentAccountList);
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(PaymentAccount paymentAccount){
		try{
			paymentAccountBO.create(paymentAccount);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("redirect:create?paymentAccountId="+paymentAccount.getPaymentAccountId());
	}
	
	@RequestMapping(value="delete",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> delete(PaymentAccount paymentAccount){
		Map<String, Object> response = new HashMap<String, Object>();
		try{
			paymentAccountBO.delete(paymentAccount);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
//	@RequestMapping(value="retrieveList",method = RequestMethod.GET)
//	public ModelAndView retrieveList(PaymentAccount paymentAccount, HttpSession session){
//		List<PaymentAccount> paymentAccountList = new ArrayList<>();
//		Hotel hotel = null;
//		try{
//			hotel = (Hotel)session.getAttribute("hotelObj");
//			paymentAccountList = paymentAccountBO.retrieveListByHotel(hotel);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return new ModelAndView("PaymentAccountList", "paymentAccountList", paymentAccountList);
//	}
	
}
