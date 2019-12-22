/** HotelFinancialYearBO.java  Dec 8,19
*/

package com.hospitality.bo;

import java.util.List;

import com.hospitality.core.HotelFinancialYear;

/**
* @author  #Kishore
*/

public interface HotelFinancialYearBO {

	public void create(HotelFinancialYear hotelFinancialYear) throws Exception;
	public List<HotelFinancialYear> retrieveList() throws Exception;

}
