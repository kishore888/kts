/** HotelPaymentGatewayController.java  Jun 6,19
*/


package com.hospitality.controller;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.HotelPaymentGatewayBO;
import com.hospitality.bo.PaymentGatewayBO;
import com.hospitality.bo.TransactionBO;
import com.hospitality.core.Hotel;
import com.hospitality.core.HotelPaymentGateway;
import com.hospitality.core.PaymentGateway;

/**
* @author  #Kishore
*/

@Controller
@RequestMapping("/hotelPaymentGateway/")
public class HotelPaymentGatewayController extends commonController{
	
	@Autowired
	private HotelPaymentGatewayBO hotelPaymentGatewayBO;
	
	@Autowired
	private PaymentGatewayBO paymentGatewayBO;
	
	@Autowired
	private TransactionBO TransactionBO;
	
	@RequestMapping(value="create",method = RequestMethod.GET)
	public ModelAndView showCreateHotelPaymentGateway(HotelPaymentGateway hotelPaymentGateway, HttpSession session){
		List<PaymentGateway> paymentGateways = new ArrayList<>();
		List<HotelPaymentGateway> hotelPaymentGatewayList = new ArrayList<>();
		Hotel hotel = null;
		try{
			hotel = (Hotel)session.getAttribute("hotelObj");
			paymentGateways = paymentGatewayBO.retrieveList();
			hotelPaymentGatewayList = hotelPaymentGatewayBO.retrieveListByHotel(hotel);
			if(StringUtils.isNotBlank(hotelPaymentGateway.getHotelPaymentGatewayId())) {
				hotelPaymentGateway = hotelPaymentGatewayBO.retrieveById(hotelPaymentGateway.getHotelPaymentGatewayId());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("HotelPaymentGateway", "paymentGateways", paymentGateways).addObject("hotelPaymentGatewayList", hotelPaymentGatewayList);
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(HotelPaymentGateway hotelPaymentGateway){
		try{
			hotelPaymentGatewayBO.create(hotelPaymentGateway);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("redirect:create");
	}
	
	@RequestMapping(value="retrieveHotelPaymentGatewayList",method = RequestMethod.GET)
	public ModelAndView retrieveList(HotelPaymentGateway hotelPaymentGateway){
		List<HotelPaymentGateway> hotelPaymentGatewayList = null;
		try{
			hotelPaymentGatewayList = hotelPaymentGatewayBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("hotelPaymentGatewayList").addObject("hotelPaymentGatewayList", hotelPaymentGatewayList);
	}
	
	@RequestMapping(value="retrieveById",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> retrieveById(String hotelPaymentGatewayId){
		HotelPaymentGateway hotelPaymentGateway = null;
		Map<String, Object> response = new HashMap<String, Object>();
		try{
			hotelPaymentGateway = hotelPaymentGatewayBO.retrieveByHotelPaymentGatewayId(hotelPaymentGatewayId);
			response.put("hotelPaymentGateway", hotelPaymentGateway);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value="pay",method = RequestMethod.GET)
	public ModelAndView pay(HotelPaymentGateway hotelPaymentGateway, HttpSession session){
		List<HotelPaymentGateway> hotelPaymentGatewayList = new ArrayList<>();
		Hotel hotel = null;
		ModelAndView modelAndView = null;
		try{
			hotel = (Hotel)session.getAttribute("hotelObj");
			hotelPaymentGatewayList = hotelPaymentGatewayBO.retrieveListByHotel(hotel);
			if(StringUtils.isNotBlank(hotelPaymentGateway.getHotelPaymentGatewayId())) {
				hotelPaymentGateway = hotelPaymentGatewayBO.retrieveById(hotelPaymentGateway.getHotelPaymentGatewayId());
			}
			
//			TransactionBO.create(hotelPaymentGateway);
			if(hotelPaymentGateway.getPaymentGateway().getPaymentGatewayName().equalsIgnoreCase("")) {
				modelAndView = new ModelAndView("redirect:payU");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("RoomPayment", "hotelPaymentGatewayList", hotelPaymentGatewayList);
	}
	
	@RequestMapping(value="payU",method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String payU(HotelPaymentGateway hotelPaymentGateway, HttpSession session, HttpServletResponse response){
		Hotel hotel = null;
		String str = "";
		try{
			hotel = (Hotel)session.getAttribute("hotelObj");
			if(StringUtils.isNotBlank(hotelPaymentGateway.getHotelPaymentGatewayId())) {
				hotelPaymentGateway = hotelPaymentGatewayBO.retrieveById(hotelPaymentGateway.getHotelPaymentGatewayId());
			}
			
			String hashStr = "gtKFFx|PLS-10061-30|600.000|SAU Admission 2014|kishore|kishore@gmail.com|||||||||||eCwWELxi";
//			String[] checksumArr = hashStr.split("|");
			
			byte[] hashseq = hashStr.getBytes();
	        StringBuffer hexString = new StringBuffer();
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.reset();
			md.update(hashseq);
            byte messageDigest[] = md.digest();
            for (int i = 0; i < messageDigest.length; i++) {
                String hex = Integer.toHexString(0xFF & messageDigest[i]);
                if (hex.length() == 1) {
                    hexString.append("0");
                }
                hexString.append(hex);
            }
			
			str = "<html>\n" + 
			"<head>\n" + 
			"</head>\n" + 
			"<body>\n" + 
			"<form id=\"payUSubmit\" action='https://test.payu.in/_payment' method='post'>\n" + 
			"<input type=\"hidden\" name=\"firstname\" value=\"kishore\" />\n" + 
			"<input type=\"hidden\" name=\"lastname\" value=\"\" />\n" + 
			"<input type=\"hidden\" name=\"surl\" value=\"https://www.google.com\" />\n" + 
			"<input type=\"hidden\" name=\"phone\" value=\"9999999999\" />\n" + 
			"<input type=\"hidden\" name=\"key\" value=\"gtKFFx\" />\n" + 
			"<input type=\"hidden\" name=\"hash\" value =\"" +hexString.toString()+ "\" />\n"+
//			"\"c2522a8d561e7c52f7d6b2d46c96b924afac8554313af4b80edef3e237e179bd6e2020e8c5480\n" + 
//			"60306d9fa2cf5c75c35205bcc4b09bcf5b9a9becec8de2952d0\" />\n" + 
			"<input type=\"hidden\" name=\"curl\" value=\"http://www.google.com\" />\n" + 
			"<input type=\"hidden\" name=\"furl\" value=\"https:/www.yahoo.in\" />\n" + 
			"<input type=\"hidden\" name=\"txnid\" value=\"PLS-10061-30\" />\n" + 
			"<input type=\"hidden\" name=\"productinfo\" value=\"SAU Admission 2014\" />\n" + 
			"<input type=\"hidden\" name=\"amount\" value=\"600.000\" />\n" + 
			"<input type=\"hidden\" name=\"email\" value=\"kishore@gmail.com\" />\n" + 
//			"<input type=\"hidden\" name=\"service_provider\" value=\"payu_paisa\" size=\"64\" /> "+
			"<input type= \"submit\" value=\"submit\">\n" + 
			"</form>\n" + 
			"</body></html>"+
			"<script>document.getElementById(\"payUSubmit\").submit();</script>";
		}catch(Exception e){
			e.printStackTrace();
		}
		return str;
	}
	
}
