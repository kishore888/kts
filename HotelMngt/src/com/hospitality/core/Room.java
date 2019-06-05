package com.hospitality.core;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import java.util.Date;


/**
 * The persistent class for the room database table.
 * 
 */
@Entity
@Table(name="room")
//@NamedQuery(name="Room.findAll", query="SELECT r FROM Room r")
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class Room extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="room_id")
	private String roomId;

	@Column(name="room_number")
	private int roomNumber;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="room_type_id")
	private RoomType roomType;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hotel_plan_master_id")
	private HotelPlanMaster hotelPlanMaster;

	@Column(name="room_charges")
	private double roomCharges;
	
	@Column(name="max_no_of_adults")
	private int maxNoOfAdults;

	@Column(name="max_no_of_kids")
	private int maxNoOfKids;

	@Column(name="status")
	private String status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="created_by")
	private String createdBy;

	@Column(name="updated_by")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;

	public Room() {
	}

	public String getRoomId() {
		return this.roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public int getMaxNoOfAdults() {
		return this.maxNoOfAdults;
	}

	public void setMaxNoOfAdults(int maxNoOfAdults) {
		this.maxNoOfAdults = maxNoOfAdults;
	}

	public int getMaxNoOfKids() {
		return this.maxNoOfKids;
	}

	public void setMaxNoOfKids(int maxNoOfKids) {
		this.maxNoOfKids = maxNoOfKids;
	}

	public double getRoomCharges() {
		return this.roomCharges;
	}

	public void setRoomCharges(double roomCharges) {
		this.roomCharges = roomCharges;
	}

	public int getRoomNumber() {
		return this.roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public HotelPlanMaster getHotelPlanMaster() {
		return hotelPlanMaster;
	}

	public void setHotelPlanMaster(HotelPlanMaster hotelPlanMaster) {
		this.hotelPlanMaster = hotelPlanMaster;
	}

}