package com.hospitality.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.Hotel;
import com.hospitality.core.Room;
import com.hospitality.core.RoomType;
import com.hospitality.dao.RoomDAO;

@Repository
@Transactional
public class RoomDAOImpl extends GenericDAOImpl<Room> implements RoomDAO{

	@Override
	public List<Room> retrieveRoomList(Hotel hotel) throws Exception{
		List<Room> roomList = new ArrayList<>();
		try{
			String queryString = "Select r from Room r join fetch r.roomType join fetch r.hotelPlanMaster join fetch r.hotel h where h.hotelId=:hotelId";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("hotelId", hotel.getHotelId());
			roomList = query.getResultList();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return roomList;
	}

	@Override
	public Room retrieveByRoomId(String roomId) throws Exception {
		Room room = null;
		try{
			String queryString = "Select r from Room r join fetch r.roomType join fetch r.hotelPlanMaster join fetch r.paymentAccount join fetch r.hotel h where r.roomId=:roomId";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("roomId", roomId);
			if(query.getResultList().size() > 0) {
				room = (Room) query.getSingleResult();
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return room;
	}

}
