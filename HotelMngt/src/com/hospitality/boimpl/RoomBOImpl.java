package com.hospitality.boimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.bo.RoomBO;
import com.hospitality.core.Hotel;
import com.hospitality.core.Room;
import com.hospitality.dao.RoomDAO;
import com.hospitality.dao.RoomTypeDAO;
import com.hospitality.dto.DataTableDTO;

@Service("RoomBO")
@Scope(value="prototype")
public class RoomBOImpl implements RoomBO{

	@Autowired
	private RoomDAO roomDAO;
	
	@Override
	public void create(Room room) {
		try{
			if(StringUtils.isNotBlank(room.getRoomId())){
				roomDAO.update(room);
			}else{
				roomDAO.create(room);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<Room> retrieveRoomList(Hotel hotel)throws Exception {
		List<Room> roomList = new ArrayList<Room>();
		try{
			roomList = roomDAO.retrieveRoomList(hotel);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return roomList;
	}

	@Override
	public Map<String, Object> retrieveRoomsServersideDatatable(DataTableDTO dataTable, Hotel hotel) throws Exception {
		Map<String, Object> roomMap = new HashMap<>();
		try{
			String condition = "o.hotel h";
			
			roomMap = roomDAO.retrieveServerSideDataTable(dataTable, null, null, null);
		}catch(Exception e){
			e.printStackTrace();
		}
		return roomMap;
	}

	@Override
	public Room retrieveById(String roomId) throws Exception {
		Room room = null;
		try{
			room = roomDAO.retrieveById(roomId);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return room;
	}

	@Override
	public Room retrieveByRoomId(String roomId) throws Exception {
		Room room = null;
		try{
			room = roomDAO.retrieveByRoomId(roomId);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return room;
	}

	@Override
	public List<Room> retrieveListByIds(List<String> roomIdList) throws Exception {
		List<Room> roomList = new ArrayList<Room>();
		try{
			roomList = roomDAO.retrieveListByIds(roomIdList);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return roomList;
	}

}
