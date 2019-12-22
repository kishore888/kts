/** ReservationController.java  Nov 12,19
*/


package com.hospitality.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hospitality.bo.HotelPaymentGatewayBO;
import com.hospitality.bo.ReservationBO;
import com.hospitality.bo.RoomBO;
import com.hospitality.bo.TransactionBO;
import com.hospitality.core.Hotel;
import com.hospitality.core.HotelPaymentGateway;
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
	
	@Autowired
	private HotelPaymentGatewayBO hotelPaymentGatewayBO;
	
	@Autowired
	private TransactionBO transactionBO;
	
	@RequestMapping(value="bookRoom",method = RequestMethod.GET)
	public ModelAndView book(String reservationId, String roomId, HttpSession session){
		Reservation reservation = null;
		Room room = null;
		Hotel hotel = null;
		List<HotelPaymentGateway> hotelPaymentGatewayList = new ArrayList<>();
		try{
			if(StringUtils.isNotBlank(reservationId)) {
				reservation = reservationBO.retrieveByReservationId(reservationId);
			}
			if(StringUtils.isNotBlank(roomId)) {
				room = roomBO.retrieveById(roomId);
			}
			
			hotel = (Hotel)session.getAttribute("hotelObj");
			hotelPaymentGatewayList = hotelPaymentGatewayBO.retrieveListByHotel(hotel);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("Reservation", "room", room).addObject("reservation", reservation).addObject("hotelPaymentGatewayList", hotelPaymentGatewayList);
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(Reservation reservation, HttpSession session, RedirectAttributes redirectAttributes){
		ModelAndView modelAndView = null;
		Hotel hotel = null;
		try{
			hotel = (Hotel)session.getAttribute("hotelObj");
			reservationBO.create(reservation);
			if(reservation.getPaymentType().equalsIgnoreCase("CASH")) {
				modelAndView = new ModelAndView("redirect:bookRoom?reservationId="+reservation.getReservationId()+"&roomId="+reservation.getRoom().getRoomId());
			}else {
//				create transaction
				transactionBO.createTransaction(reservation, hotel);
				redirectAttributes.addAttribute("reservation", reservation);
				modelAndView = new ModelAndView("redirect:/hotelPaymentGateway/pay?hotelPaymentGatewayId="+reservation.getPaymentType());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return modelAndView;
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
