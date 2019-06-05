package com.hospitality.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.HotelPlanMasterBO;
import com.hospitality.bo.RoomBO;
import com.hospitality.bo.RoomTypeBO;
import com.hospitality.core.Hotel;
import com.hospitality.core.HotelPlanMaster;
import com.hospitality.core.Room;
import com.hospitality.core.RoomType;
import com.hospitality.dto.DataTableDTO;


@Controller
@RequestMapping("/room/")
public class RoomController {
	
	@Autowired
	private RoomBO roomBO;
	
	@Autowired
	private RoomTypeBO roomTypeBO;
	
	@Autowired
	private HotelPlanMasterBO hotelPlanMasterBO;
	
	@RequestMapping(value="showCreateRoom",method = RequestMethod.GET)
	public ModelAndView showCreateRoom(){
		List<RoomType> roomTypeList = null;
		List<HotelPlanMaster> hotelPlanMasterList = null;
		try{
			roomTypeList = roomTypeBO.retrieveListByYear();
			hotelPlanMasterList = hotelPlanMasterBO.retrieveListByYear();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("showCreateRoom").addObject("roomTypeList", roomTypeList).addObject("hotelPlanMasterList", hotelPlanMasterList);
	}
	
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(Room room){
		try{
			roomBO.create(room);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("showCreateRoom").addObject("room", room);
	}
	
	@RequestMapping(value="retrieveRoomList",method = RequestMethod.GET)
	public ModelAndView retrieveList(Room room){
		List<Room> roomList = null;
		try{
			roomList = roomBO.retrieveRoomList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("RoomList").addObject("roomList", roomList);
	}
	
	@RequestMapping(value="retrieveRoomListServersideDatatable",method = RequestMethod.GET)
	public ModelAndView retrieveRoomListServersideDatatable(DataTableDTO dataTable){
		List<Room> roomList = null;
		try{
			roomList = roomBO.retrieveRoomList();
//			roomList = roomBO.retrieveRoomListServersideDatatable();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("ServersideRoomList").addObject("roomList", roomList);
	}
	
	@RequestMapping(value="retrieveRoomListServersideDatatableAjax",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> retrieveRoomsServersideDatatableAjax(@RequestBody DataTableDTO dataTable, HttpSession httpSession){
		List<Room> roomList = null;
		Map<String, Object> roomMap = new HashMap<>();
		Hotel hotel = null;
		try{
			hotel = (Hotel) httpSession.getAttribute("hotel");
//			roomList = roomBO.retrieveRoomList();
			roomMap = roomBO.retrieveRoomsServersideDatatable(dataTable, hotel);
		}catch(Exception e){
			e.printStackTrace();
		}
		return roomMap;
	}
	
}
