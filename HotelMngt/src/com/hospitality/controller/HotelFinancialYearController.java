/** HotelFinancialYearController.java  Dec 8,19
*/


package com.hospitality.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.HotelFinancialYearBO;
import com.hospitality.core.HotelFinancialYear;

/**
* @author  #Kishore
*/

@Controller
@RequestMapping("/hotelFinancialYear/")
public class HotelFinancialYearController extends commonController{
	
	@Autowired
	private HotelFinancialYearBO hotelFinancialYearBO;
	
	@RequestMapping(value="showCreateHotelFinancialYear",method = RequestMethod.GET)
	public ModelAndView showCreateHotelFinancialYear(){
		try{
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateHotelFinancialYear");
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(HotelFinancialYear hotelFinancialYear){
		try{
			hotelFinancialYearBO.create(hotelFinancialYear);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateHotelFinancialYear").addObject("hotelFinancialYear", hotelFinancialYear);
	}
	
	@RequestMapping(value="retrieveHotelFinancialYearList",method = RequestMethod.GET)
	public ModelAndView retrieveList(HotelFinancialYear hotelFinancialYear){
		List<HotelFinancialYear> hotelFinancialYearList = new ArrayList<>();
		try{
			hotelFinancialYearList = hotelFinancialYearBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("hotelFinancialYearList").addObject("hotelFinancialYearList", hotelFinancialYearList);
	}
	
}
