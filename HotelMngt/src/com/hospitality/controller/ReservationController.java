/** ReservationController.java  Nov 12,19
*/


package com.hospitality.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.ReservationBO;
import com.hospitality.bo.RoomBO;
import com.hospitality.core.Reservation;
import com.hospitality.core.Room;

/**
* @author  #Kishore
*/

@Controller
@RequestMapping("/reservation/")
public class ReservationController extends commonController{
	
	@Autowired
	private ReservationBO reservationBO;
	
	@Autowired
	private RoomBO roomBO;
	
	@RequestMapping(value="bookRoom",method = RequestMethod.GET)
	public ModelAndView book(String reservationId, String roomId){
		Reservation reservation = null;
		Room room = null;
		try{
			if(StringUtils.isNotBlank(reservationId)) {
				reservation = reservationBO.retrieveByReservationId(reservationId);
			}
			if(StringUtils.isNotBlank(roomId)) {
				room = roomBO.retrieveById(roomId);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("Reservation", "room", room).addObject("reservation", reservation);
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(Reservation reservation){
		try{
			reservationBO.create(reservation);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("redirect:bookRoom?reservationId="+reservation.getReservationId()+"&roomId="+reservation.getRoom().getRoomId());
	}
	
	@RequestMapping(value="retrieveReservationList",method = RequestMethod.GET)
	public ModelAndView retrieveList(Reservation reservation){
		List<Reservation> reservationList = new ArrayList<>();
		try{
			reservationList = reservationBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("reservationList").addObject("reservationList", reservationList);
	}
	
}
