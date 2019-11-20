/** HotelPaymentGatewayBO.java  Jun 6,19
*/

package com.hospitality.bo;

import java.util.List;

import com.hospitality.core.Hotel;
import com.hospitality.core.HotelPaymentGateway;

/**
* @author  #Kishore
*/

public interface HotelPaymentGatewayBO {

	public void create(HotelPaymentGateway hotelPaymentGateway) throws Exception;
	public List<HotelPaymentGateway> retrieveList() throws Exception;
	public HotelPaymentGateway retrieveById(String hotelPaymentGatewayId) throws Exception;
	public List<HotelPaymentGateway> retrieveListByHotel(Hotel hotel) throws Exception;
	public HotelPaymentGateway retrieveByHotelPaymentGatewayId(String hotelPaymentGatewayId) throws Exception;
	public List<HotelPaymentGateway> retrieveActiveGatewayListByHotel(Hotel hotel) throws Exception;

}
