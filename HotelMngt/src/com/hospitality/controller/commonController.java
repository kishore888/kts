package com.hospitality.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;

@Controller
public class commonController {
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.setAutoGrowCollectionLimit(20000);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		
//		webDataBinder.registerCustomEditor(Date.class, new LenientDateParser());
	}

}
