/** HotelFinancialYearBOImpl.java  Dec 8,19
*/

package com.hospitality.boimpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.bo.HotelFinancialYearBO;
import com.hospitality.core.HotelFinancialYear;
import com.hospitality.dao.HotelFinancialYearDAO;

/**
* @author  #Kishore
*/

@Service("HotelFinancialYearBO")
@Scope(value="prototype")
public class HotelFinancialYearBOImpl implements HotelFinancialYearBO{

	@Autowired
	private HotelFinancialYearDAO hotelFinancialYearDAO;
	
	@Override
	public void create(HotelFinancialYear hotelFinancialYear) {
		try{
			if(StringUtils.isNotBlank(hotelFinancialYear.getHotelFinancialYearId())){
				hotelFinancialYearDAO.update(hotelFinancialYear);
			}else{
				hotelFinancialYearDAO.create(hotelFinancialYear);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<HotelFinancialYear> retrieveList() {
		List<HotelFinancialYear> hotelFinancialYearList = null;
		try{
			hotelFinancialYearList = hotelFinancialYearDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return hotelFinancialYearList;
	}

}
