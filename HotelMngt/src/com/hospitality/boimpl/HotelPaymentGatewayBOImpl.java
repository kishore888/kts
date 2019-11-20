/** HotelPaymentGatewayBOImpl.java  Jun 6,19
*/

package com.hospitality.boimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.bo.HotelPaymentGatewayBO;
import com.hospitality.core.Hotel;
import com.hospitality.core.HotelPaymentGateway;
import com.hospitality.dao.HotelPaymentGatewayDAO;

/**
* @author  #Kishore
*/

@Service("HotelPaymentGatewayBO")
@Scope(value="prototype")
public class HotelPaymentGatewayBOImpl implements HotelPaymentGatewayBO{

	@Autowired
	private HotelPaymentGatewayDAO hotelPaymentGatewayDAO;
	
	@Override
	public void create(HotelPaymentGateway hotelPaymentGateway) throws Exception{
		try{
			if(StringUtils.isNotBlank(hotelPaymentGateway.getHotelPaymentGatewayId())){
				hotelPaymentGatewayDAO.update(hotelPaymentGateway);
			}else{
				hotelPaymentGatewayDAO.create(hotelPaymentGateway);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<HotelPaymentGateway> retrieveList() throws Exception{
		List<HotelPaymentGateway> hotelPaymentGatewayList = null;
		try{
			hotelPaymentGatewayList = hotelPaymentGatewayDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return hotelPaymentGatewayList;
	}

	@Override
	public HotelPaymentGateway retrieveById(String hotelPaymentGatewayId) throws Exception {
		HotelPaymentGateway hotelPaymentGateway = null;
		try{
			hotelPaymentGateway = hotelPaymentGatewayDAO.retrieveById(hotelPaymentGatewayId);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return hotelPaymentGateway;
	}

	@Override
	public List<HotelPaymentGateway> retrieveListByHotel(Hotel hotel) throws Exception {
		List<HotelPaymentGateway> hotelPaymentGatewayList = new ArrayList<>();
		try{
			hotelPaymentGatewayList = hotelPaymentGatewayDAO.retrieveListByHotel(hotel);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return hotelPaymentGatewayList;
	}

	@Override
	public HotelPaymentGateway retrieveByHotelPaymentGatewayId(String hotelPaymentGatewayId) throws Exception {
		HotelPaymentGateway hotelPaymentGateway = null;
		try{
			hotelPaymentGateway = hotelPaymentGatewayDAO.retrieveByHotelPaymentGatewayId(hotelPaymentGatewayId);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return hotelPaymentGateway;
	}

	@Override
	public List<HotelPaymentGateway> retrieveActiveGatewayListByHotel(Hotel hotel) throws Exception {
		List<HotelPaymentGateway> hotelPaymentGatewayList = new ArrayList<>();
		try{
			hotelPaymentGatewayList = hotelPaymentGatewayDAO.retrieveActiveGatewayListByHotel(hotel);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return hotelPaymentGatewayList;
	}

}
