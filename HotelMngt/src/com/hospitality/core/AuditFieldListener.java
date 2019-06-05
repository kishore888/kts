package com.hospitality.core;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AuditFieldListener {
	@PrePersist
	public void persistAuditFields(AuditFields<Object> auditFields) {
		String userName = getUserName();
		auditFields.setCreatedBy(userName);
		auditFields.setCreatedOn(new Date());
		auditFields.setUpdatedBy(userName);
		auditFields.setUpdatedOn(new Date());
	}
	
	@PreUpdate
	public void updateAuditFields(AuditFields<Object> auditFields) {
		String userName = getUserName();
		auditFields.setUpdatedBy(userName);
		auditFields.setUpdatedOn(new Date());
	}
	
	private String getUserName() {
		String userName = "unknown";
		try {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			userName = userDetails.getUsername();
		}catch(Exception e) {
			return userName;
		}
		return userName;
	}

}
