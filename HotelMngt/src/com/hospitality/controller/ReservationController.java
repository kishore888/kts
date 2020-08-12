/** ReservationController.java  Nov 12,19
*/


package com.hospitality.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hospitality.bo.CustomerBO;
import com.hospitality.bo.HotelPaymentGatewayBO;
import com.hospitality.bo.ReservationBO;
import com.hospitality.bo.RoomBO;
import com.hospitality.bo.TransactionBO;
import com.hospitality.core.Customer;
import com.hospitality.core.Hotel;
import com.hospitality.core.HotelPaymentGateway;
import com.hospitality.core.PaymentAccount;
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
	private CustomerBO customerBO;
	
	@Autowired
	private HotelPaymentGatewayBO hotelPaymentGatewayBO;
	
	@RequestMapping(value="bookRoom",method = RequestMethod.GET)
	public ModelAndView book(String customerId, String[] reservationIds, @RequestParam(name = "roomIds", required=false) String[] roomIds, HttpSession session){
		Hotel hotel = null;
		Customer customer = null;
		List<HotelPaymentGateway> hotelPaymentGatewayList = new ArrayList<>();
		List<String> reservationIdList = new ArrayList<>();
		List<Reservation> reservationList = new ArrayList<>();
		List<Room> roomList = new ArrayList<>();
		PaymentAccount paymentAccount = null;
		try{
			if(StringUtils.isNotBlank(customerId)) {
				customer = customerBO.retrieveById(customerId);
			}
			if(reservationIds != null) {
				reservationIdList = Arrays.asList(reservationIds);
				reservationList = reservationBO.retrieveListByIds(reservationIdList);
			}
			if(reservationList.isEmpty() && roomIds != null) {
				List<String> roomIdList = Arrays.asList(roomIds);
				roomList = roomBO.retrieveListByIds(roomIdList);
				for (Room room : roomList) {
					Reservation reservation = new Reservation();
					reservation.setRoom(room);
					reservationList.add(reservation);
					if(paymentAccount == null) {
						paymentAccount = room.getPaymentAccount();
					}
				}
			}
			
			hotel = (Hotel)session.getAttribute("hotelObj");
			hotelPaymentGatewayList = hotelPaymentGatewayBO.retrieveListByHotel(hotel);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("Reservation", "reservationList", reservationList).addObject("customer", customer).addObject("hotelPaymentGatewayList", hotelPaymentGatewayList).addObject("paymentAccount", paymentAccount);
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(Customer customer, HttpSession session, RedirectAttributes redirectAttributes){
		ModelAndView modelAndView = null;
		String reservationIds = "";
		try{
			customer = reservationBO.create(customer);
			if(customer.getTotalAmount() <= 0) {
				modelAndView = new ModelAndView("redirect:bookRoom?customerId="+customer.getCustomerId()+"&reservationIds="+reservationIds);
			}else if(customer.getPaymentType().equalsIgnoreCase("CASH")) {
				modelAndView = new ModelAndView("redirect:bookRoom?customerId="+customer.getCustomerId()+"&reservationIds="+reservationIds);
			}else {
				redirectAttributes.addFlashAttribute("customer", customer);
				modelAndView = new ModelAndView("redirect:/hotelPaymentGateway/pay?reservationIds="+reservationIds+"&hotelPaymentGatewayId="+customer.getPaymentType());
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
