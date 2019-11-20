/** ReservationBOImpl.java  Nov 12,19
*/

package com.hospitality.boimpl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.bo.ReservationBO;
import com.hospitality.core.Reservation;
import com.hospitality.dao.ReservationDAO;

/**
* @author  #Kishore
*/

@Service("ReservationBO")
@Scope(value="prototype")
public class ReservationBOImpl implements ReservationBO{

	@Autowired
	private ReservationDAO reservationDAO;
	
	@Override
	public void create(Reservation reservation) throws Exception{
		try{
			String base64String = reservation.getCustomerImage();
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
		        
	            reservation.setPath(path);
	        }
            
			if(StringUtils.isNotBlank(reservation.getReservationId())){
				reservationDAO.update(reservation);
			}else{
				reservationDAO.create(reservation);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
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

}
