/** ReservationBO.java  Nov 12,19
*/

package com.hospitality.bo;

import java.util.List;

import com.hospitality.core.Customer;
import com.hospitality.core.Reservation;

/**
* @author  #Kishore
*/

public interface ReservationBO {

	public Customer create(Customer customer) throws Exception;
	public List<Reservation> retrieveList() throws Exception;
	public Reservation retrieveByReservationId(String reservationId) throws Exception;
	public List<Reservation> retrieveListByIds(List<String> reservationIdList) throws Exception;

}
