package com.hospitality.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.HotelBO;
import com.hospitality.bo.UsersBO;
import com.hospitality.core.Hotel;
import com.hospitality.core.Users;

@Controller
@RequestMapping("/")
public class UsersController {

	@Autowired
	private HotelBO hotelBO;
	
	@Autowired
	private UsersBO usersBO;
	
//	@RequestMapping(value="dashboard",method = RequestMethod.GET)
//	public ModelAndView checkLogin(){
//		try{
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return new ModelAndView("dashboard");
//	}
	
	@RequestMapping(value="dashboard",method = RequestMethod.GET)
	public ModelAndView checkLogin(Principal principal, HttpSession httpSession){
		Users user = null;
		Hotel hotel = null;
		try{
			hotel = hotelBO.retrieveHotelByUserName(principal.getName());
			httpSession.setAttribute("hotelObj", hotel);
			user = usersBO.retrieveByUserName(principal.getName());
			httpSession.setAttribute("userObj", user);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("dashboard", "userName", principal.getName());
	}
	
	@RequestMapping(value="login",method = RequestMethod.GET)
	public ModelAndView login(){
		String msg = "";
		try{
//			msg = "Invalid Credentials";
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="logout",method = RequestMethod.GET)
	public ModelAndView logout(){
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("login");
	}
}
