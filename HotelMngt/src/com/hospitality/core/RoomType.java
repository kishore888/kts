package com.hospitality.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;


/**
 * The persistent class for the room_type database table.
 * 
 */
@Entity
@Table(name="room_type")
//@NamedQuery(name="RoomType.findAll", query="SELECT r FROM RoomType r")
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class RoomType extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="room_type_id")
	private String roomTypeId;

	@Column(name="room_type")
	private String roomType;
	
	@Column(name="room_type_status")
	private String roomTypeStatus;

	@Column(name="room_type_tariff")
	private String roomTypeTariff;

	public RoomType() {
	}

	public String getRoomTypeId() {
		return this.roomTypeId;
	}

	public void setRoomTypeId(String roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomTypeStatus() {
		return this.roomTypeStatus;
	}

	public void setRoomTypeStatus(String roomTypeStatus) {
		this.roomTypeStatus = roomTypeStatus;
	}

	public String getRoomTypeTariff() {
		return this.roomTypeTariff;
	}

	public void setRoomTypeTariff(String roomTypeTariff) {
		this.roomTypeTariff = roomTypeTariff;
	}

}