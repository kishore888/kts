package com.hospitality.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.RoomTypeBO;
import com.hospitality.core.RoomType;

@Controller
@RequestMapping("/roomType/")
public class RoomTypeController {
//	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private RoomTypeBO roomTypeBO;
	
	@RequestMapping(value="showCreateRoomType",method = RequestMethod.GET)
	public ModelAndView showCreateRoom(){
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("showCreateRoomType");
	}
	
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(RoomType roomType){
		try{
			roomTypeBO.create(roomType);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("redirect:showCreateRoomType");
	}
	
	@RequestMapping(value="retrieveList",method = RequestMethod.GET)
	public ModelAndView retrieveList(RoomType roomType){
		List<RoomType> roomTypeList = null;
		try{
			roomTypeList = roomTypeBO.retrieveListByYear();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("RoomTypeList").addObject("roomTypeList", roomTypeList);
	}

}
