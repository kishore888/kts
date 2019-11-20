package com.hospitality.dao;

import java.util.List;

import com.hospitality.core.Hotel;
import com.hospitality.core.Room;

public interface RoomDAO extends GenericDAO<Room>{

	public List<Room> retrieveRoomList(Hotel hotel) throws Exception;

}
