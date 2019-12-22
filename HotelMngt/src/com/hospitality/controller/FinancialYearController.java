/** FinancialYearController.java  Dec 8,19
*/


package com.hospitality.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.FinancialYearBO;
import com.hospitality.core.FinancialYear;

/**
* @author  #Kishore
*/

@Controller
@RequestMapping("/financialYear/")
public class FinancialYearController extends commonController{
	
	@Autowired
	private FinancialYearBO financialYearBO;
	
	@RequestMapping(value="create",method = RequestMethod.GET)
	public ModelAndView showCreateFinancialYear(String financialYearId){
		FinancialYear financialYear = null;
		List<FinancialYear> financialYearList = new ArrayList<>();
		try{
			if(StringUtils.isNotBlank(financialYearId)) {
				financialYear = financialYearBO.retrieveById(financialYearId);
			}
			financialYearList = financialYearBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateFinancialYear", "financialYear", financialYear).addObject("financialYearList", financialYearList);
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(FinancialYear financialYear){
		try{
			financialYearBO.create(financialYear);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("redirect:create?financialYearId="+financialYear.getFinancialYearId());
	}
	
	@RequestMapping(value="retrieveFinancialYearList",method = RequestMethod.GET)
	public ModelAndView retrieveList(FinancialYear financialYear){
		List<FinancialYear> financialYearList = new ArrayList<>();
		try{
			financialYearList = financialYearBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("financialYearList").addObject("financialYearList", financialYearList);
	}
	
	@RequestMapping(value="delete",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> delete(String financialYearId){
		Map<String, Object> response = new HashMap<String, Object>();
		try{
			financialYearBO.delete(financialYearId);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
}
