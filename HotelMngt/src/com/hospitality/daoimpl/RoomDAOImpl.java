package com.hospitality.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.Room;
import com.hospitality.core.RoomType;
import com.hospitality.dao.RoomDAO;

@Repository
@Transactional
public class RoomDAOImpl extends GenericDAOImpl<Room> implements RoomDAO{

	@Override
	public List<Room> retrieveRoomList() {
		List<Room> roomList = new ArrayList<>();
		try{
			String queryString = "Select r from Room r join fetch r.roomType join fetch r.hotelPlanMaster";
			Query query = entityManager.createQuery(queryString);
			roomList = query.getResultList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return roomList;
	}

}
