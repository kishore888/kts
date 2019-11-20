/** ReservationDAOImpl.java  Nov 12,19
*/

package com.hospitality.daoimpl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.Reservation;
import com.hospitality.dao.ReservationDAO;


/**
* @author  #Kishore
*/

@Repository
@Transactional
public class ReservationDAOImpl extends GenericDAOImpl<Reservation> implements ReservationDAO{

	@Override
	public Reservation retrieveByReservationId(String reservationId) throws Exception {
		Reservation reservation = null;
		try{
			String queryString = "Select r from Reservation r join fetch r.customer join fetch r.room where r.reservationId=:reservationId";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("reservationId", reservationId);
			if(query.getResultList().size() > 0) {
				reservation = (Reservation) query.getSingleResult();
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return reservation;
	}

}
