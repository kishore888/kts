package com.hospitality.bo;

import java.util.List;
import java.util.Map;

import com.hospitality.core.Hotel;
import com.hospitality.core.Room;
import com.hospitality.dto.DataTableDTO;

public interface RoomBO {

	public void create(Room room);
	public List<Room> retrieveRoomList();
	public Map<String, Object> retrieveRoomsServersideDatatable(DataTableDTO dataTable, Hotel hotel) throws Exception;

}
