/** HotelBOImpl.java  Dec 3,17
*/

package com.hospitality.boimpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.bo.HotelBO;
import com.hospitality.core.FinancialYear;
import com.hospitality.core.Hotel;
import com.hospitality.core.PaymentAccount;
import com.hospitality.dao.FinancialYearDAO;
import com.hospitality.dao.HotelDAO;

/**
* @author  Kishore
*/

@Service("HotelBO")
@Scope(value="prototype")
public class HotelBOImpl implements HotelBO{

	@Autowired
	private HotelDAO hotelDAO;
	
	@Autowired
	private FinancialYearDAO financialYearDAO;
	
	@Override
	public void create(Hotel hotel) {
		try{
			if(StringUtils.isNotBlank(hotel.getHotelId())){
				hotelDAO.update(hotel);
			}else{
				hotelDAO.create(hotel);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<Hotel> retrieveList() {
		List<Hotel> hotelList = null;
		try{
			hotelList = hotelDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return hotelList;
	}

	@Override
	public Hotel retrieveHotelByUserName(String name) throws Exception {
		Hotel hotel = null;
		try{
			hotel = hotelDAO.retrieveHotelByUserName(name);
		}catch(Exception e){
			e.printStackTrace();
		}
		return hotel;
	}

	@Override
	public String generateBillNo(Hotel hotel, PaymentAccount paymentAccount) throws Exception {
		String billNo = "";
		FinancialYear financialYear = null;
		try{
			financialYear = financialYearDAO.retrieveById(hotel.getCurrentFinancialYearId());
			billNo = "HMT"+paymentAccount.getCode()+financialYear.getYearName().replace("-", "")+paymentAccount.getBillCount();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return billNo;
	}

}
