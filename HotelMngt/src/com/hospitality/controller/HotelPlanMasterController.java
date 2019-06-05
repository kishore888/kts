package com.hospitality.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.HotelPlanMasterBO;
import com.hospitality.core.HotelPlanMaster;

@Controller
@RequestMapping("/hotelPlanMaste/")
public class HotelPlanMasterController {

	@Autowired
	private HotelPlanMasterBO hotelPlanMasterBO;
	
	@RequestMapping(value="showCreatePlan",method = RequestMethod.GET)
	public ModelAndView showCreateRoom(){
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreatePlan");
	}
	
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(HotelPlanMaster hotelPlanMaster){
		try{
			hotelPlanMasterBO.create(hotelPlanMaster);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreatePlan");
	}
	
	@RequestMapping(value="retrieveHotelPlanMasterList",method = RequestMethod.GET)
	public ModelAndView retrieveList(HotelPlanMaster hotelPlanMaster){
		List<HotelPlanMaster> hotelPlanMasterList = null;
		try{
			hotelPlanMasterList = hotelPlanMasterBO.retrieveListByYear();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("HotelPlanMasterList").addObject("hotelPlanMasterList", hotelPlanMasterList);
	}
	
}
