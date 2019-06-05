/** HotelController.java  Dec 3,17
*/


package com.hospitality.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.HotelBO;
import com.hospitality.core.Hotel;

/**
* @author  Kishore
*/

@Controller
@RequestMapping("/hotel/")
public class HotelController {
	
	@Autowired
	private HotelBO hotelBO;
	
	@RequestMapping(value="showCreateHotel",method = RequestMethod.GET)
	public ModelAndView showCreateHotel(HttpSession httpSession){
		Hotel hotel = null;
		try{
			hotel = (Hotel) httpSession.getAttribute("hotel");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateHotel").addObject("hotel", hotel);
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(Hotel hotel){
		try{
			hotelBO.create(hotel);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("redirect:showCreateHotel?hotelId="+hotel.getHotelId());
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
	
}
