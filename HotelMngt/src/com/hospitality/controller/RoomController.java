package com.hospitality.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.HotelPaymentGatewayBO;
import com.hospitality.bo.HotelPlanMasterBO;
import com.hospitality.bo.PaymentAccountBO;
import com.hospitality.bo.RoomBO;
import com.hospitality.bo.RoomTypeBO;
import com.hospitality.core.Hotel;
import com.hospitality.core.HotelPaymentGateway;
import com.hospitality.core.HotelPlanMaster;
import com.hospitality.core.PaymentAccount;
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
	
	@Autowired
	private HotelPaymentGatewayBO hotelPaymentGatewayBO;
	
	@Autowired
	private PaymentAccountBO paymentAccountBO;
	
	@RequestMapping(value="create",method = RequestMethod.GET)
	public ModelAndView showCreateRoom(String roomId, HttpSession session){
		Room room = null;
		Hotel hotel = null;
		List<RoomType> roomTypeList = null;
		List<HotelPlanMaster> hotelPlanMasterList = new ArrayList<>();
		List<PaymentAccount> paymentAccountList = new ArrayList<>();
		try{
			hotel = (Hotel)session.getAttribute("hotelObj");
			if(StringUtils.isNotBlank(roomId)) {
				room = roomBO.retrieveByRoomId(roomId);
			}
			roomTypeList = roomTypeBO.retrieveListByYear();
			hotelPlanMasterList = hotelPlanMasterBO.retrieveListByYear();
			paymentAccountList = paymentAccountBO.retrieveListByHotel(hotel);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateRoom", "roomTypeList", roomTypeList).addObject("room", room).addObject("hotelPlanMasterList", hotelPlanMasterList).addObject("paymentAccountList", paymentAccountList);
	}
	
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(Room room){
		try{
			roomBO.create(room);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("redirect:create?roomId="+room.getRoomId());
	}
	
	@RequestMapping(value="retrieveRoomList",method = RequestMethod.GET)
	public ModelAndView retrieveList(Hotel hotel, HttpSession session){
		List<Room> roomList = new ArrayList<>();
		List<HotelPaymentGateway> hotelPaymentGatewayList = new ArrayList<>();
		try{
			if(hotel == null) {
				hotel = (Hotel)session.getAttribute("hotelObj");
			}else if(StringUtils.isBlank(hotel.getHotelId())) {
				hotel = (Hotel)session.getAttribute("hotelObj");
			}
			roomList = roomBO.retrieveRoomList(hotel);
			hotelPaymentGatewayList = hotelPaymentGatewayBO.retrieveActiveGatewayListByHotel(hotel);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("RoomList", "roomList", roomList).addObject("hotelPaymentGatewayList", hotelPaymentGatewayList);
	}
	
	@RequestMapping(value="retrieveRoomListServersideDatatable",method = RequestMethod.GET)
	public ModelAndView retrieveRoomListServersideDatatable(DataTableDTO dataTable, HttpSession session){
		List<Room> roomList = new ArrayList<>();
		Hotel hotel = null;
		try{
			hotel = (Hotel)session.getAttribute("hotelObj");
			roomList = roomBO.retrieveRoomList(hotel);
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
