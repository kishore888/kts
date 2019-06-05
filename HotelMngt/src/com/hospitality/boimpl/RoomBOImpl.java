package com.hospitality.boimpl;

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
	public List<Room> retrieveRoomList() {
		List<Room> roomList = null;
		try{
			roomList = roomDAO.retrieveRoomList();
		}catch(Exception e){
			e.printStackTrace();
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

}
