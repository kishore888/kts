/** HotelController.java  Dec 3,17
*/


package com.hospitality.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospitality.bo.FinancialYearBO;
import com.hospitality.bo.HotelBO;
import com.hospitality.core.FinancialYear;
import com.hospitality.core.Hotel;

/**
* @author  Kishore
*/

@Controller
@RequestMapping("/hotel/")
public class HotelController {
	
	@Autowired
	private HotelBO hotelBO;
	
	@Autowired
	private FinancialYearBO financialYearBO;
	
	@RequestMapping(value="create",method = RequestMethod.GET)
	public ModelAndView showCreateHotel(HttpSession httpSession){
		Hotel hotel = null;
		List<FinancialYear> financialYearList = new ArrayList<>();
		try{
			hotel = (Hotel) httpSession.getAttribute("hotelObj");
			financialYearList = financialYearBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateHotel", "hotel", hotel).addObject("financialYearList", financialYearList);
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(Hotel hotel, HttpSession httpSession){
		try{
			hotelBO.create(hotel);
			httpSession.setAttribute("hotelObj", hotel);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("redirect:create?hotelId="+hotel.getHotelId());
	}
	
	@RequestMapping(value="retrieveHotelList",method = RequestMethod.GET)
	public ModelAndView retrieveList(Hotel hotel){
		List<Hotel> hotelList = null;
		try{
			hotelList = hotelBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("HotelList").addObject("hotelList", hotelList);
	}
	
	@RequestMapping(value="requestToOtherApp",method = RequestMethod.GET)
	public ModelAndView requestToOtherApp(Hotel hotel){
		List<Hotel> hotelList = null;
		try{
			ObjectMapper mapper = new ObjectMapper();
			HttpClient httpClient = HttpClients.custom()
					            .setDefaultRequestConfig(RequestConfig.custom()
					            .setCookieSpec(CookieSpecs.STANDARD)
					            .build())
					            .build();
			
		    HttpPost httpPost = new HttpPost("http://www.example.com");
			String json = "jsonSTr";
		    StringEntity entity = new StringEntity(json, "UTF8");
		    httpPost.setEntity(entity);
		    httpPost.setHeader("Accept", "application/json");
		    httpPost.setHeader("Content-type", "application/json");
		    HttpResponse response = httpClient.execute(httpPost);
//		    hotel = mapper.readValue(response.getEntity().getContent(), Hotel.class);
		    
//		    type 2
//		    CloseableHttpClient client = HttpClients.createDefault();
//		    HttpPost httpPost = new HttpPost("http://www.example.com");
//		 
//		    String json = "{"id":1,"name":"John"}";
//		    StringEntity entity = new StringEntity(json);
//		    httpPost.setEntity(entity);
//		    httpPost.setHeader("Accept", "application/json");
//		    httpPost.setHeader("Content-type", "application/json");
//		 
//		    CloseableHttpResponse response = client.execute(httpPost);
//		    assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
//		    client.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("HotelList").addObject("hotelList", hotelList);
	}
	
	@RequestMapping(value="processRequestOfOtherApp",method = RequestMethod.GET)
	@ResponseBody
	public void processRequestOfOtherApp(@RequestParam (value="hotelId", required=false) String hotelId,@RequestParam @DateTimeFormat(pattern="dd/MM/yyyy") Date date, HttpServletRequest request){
		String jsonData = "";
		try{
			jsonData = IOUtils.toString(request.getInputStream(), "UTF-8");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="discount",method = RequestMethod.GET)
	public ModelAndView discount(String userType, Integer amount){
		Hotel hotel = null;
		int start = 1000;
		int end = 3000;
		int discountedAmount=0;
		try{
			if(userType.equalsIgnoreCase("Standard")) {
				if(amount>1000 && amount <3000){
					int remainder = amount%1000;
					discountedAmount=amount-(remainder*10/100);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateHotel").addObject("hotel", hotel);
	}
	
}
