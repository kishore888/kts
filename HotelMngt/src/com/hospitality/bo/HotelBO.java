/** HotelBO.java  Dec 3,17
*/

package com.hospitality.bo;

import java.util.List;

import com.hospitality.core.Hotel;

/**
* @author  Kishore
*/

public interface HotelBO {

	public void create(Hotel Hotel);
	public List<Hotel> retrieveList();
	public Hotel retrieveHotelByUserName(String name) throws Exception;

}
