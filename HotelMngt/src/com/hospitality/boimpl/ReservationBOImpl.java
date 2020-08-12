/** ReservationBOImpl.java  Nov 12,19
*/

package com.hospitality.boimpl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.bo.ReservationBO;
import com.hospitality.core.Customer;
import com.hospitality.core.Reservation;
import com.hospitality.dao.CustomerDAO;
import com.hospitality.dao.ReservationDAO;
import com.hospitality.dao.TransactionDAO;

/**
* @author  #Kishore
*/

@Service("ReservationBO")
@Scope(value="prototype")
public class ReservationBOImpl implements ReservationBO{

	@Autowired
	private ReservationDAO reservationDAO;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public Customer create(Customer customer) throws Exception{
		try{
			String base64String = customer.getCustomerImage();
	        if(StringUtils.isNotBlank(base64String)) {
				String[] strings = base64String.split(",");
		        String extension;
		        switch (strings[0]) {//check image's extension
		            case "data:image/jpeg;base64":
		                extension = "jpeg";
		                break;
		            case "data:image/png;base64":
		                extension = "png";
		                break;
		            default://should write cases for more images types
		                extension = "jpg";
		                break;
		        }
		        //convert base64 string to binary data
		        byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);
		        String path = "C:\\Users\\KISHORE\\Desktop\\test_image." + extension;
		        File file = new File(path);
		        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
	            outputStream.write(data);
	            outputStream.close();
		        
	            customer.setPath(path);
	        }
            
	        if(StringUtils.isNotBlank(customer.getCustomerId())) {
	        	customerDAO.update(customer);
	        }else {
	        	customerDAO.create(customer);
	        }
	        
	        for(Reservation reservation : customer.getReservationList()) {
				if(StringUtils.isNotBlank(reservation.getReservationId())){
					reservationDAO.update(reservation);
				}else{
					reservation.setCustomer(customer);
					reservationDAO.create(reservation);
				}
	        }
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return customer;
	}

	@Override
	public List<Reservation> retrieveList() {
		List<Reservation> reservationList = new ArrayList<Reservation>();
		try{
			reservationList = reservationDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return reservationList;
	}

	@Override
	public Reservation retrieveByReservationId(String reservationId) throws Exception {
		Reservation reservation = null;
		try{
			reservation = reservationDAO.retrieveByReservationId(reservationId);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return reservation;
	}

	@Override
	public List<Reservation> retrieveListByIds(List<String> reservationIdList) throws Exception {
		List<Reservation> reservationList = new ArrayList<Reservation>();
		try{
			reservationList = reservationDAO.retrieveListByIds(reservationIdList);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return reservationList;
	}

}
