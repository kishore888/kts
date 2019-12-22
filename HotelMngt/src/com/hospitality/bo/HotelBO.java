/** HotelBO.java  Dec 3,17
*/

package com.hospitality.bo;

import java.util.List;

import com.hospitality.core.Hotel;
import com.hospitality.core.PaymentAccount;

/**
* @author  Kishore
*/

public interface HotelBO {

	public void create(Hotel Hotel);
	public List<Hotel> retrieveList();
	public Hotel retrieveHotelByUserName(String name) throws Exception;
	public String generateBillNo(Hotel hotel, PaymentAccount paymentAccount) throws Exception;

}
