/** FinancialYearBOImpl.java  Dec 8,19
*/

package com.hospitality.boimpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.bo.FinancialYearBO;
import com.hospitality.core.FinancialYear;
import com.hospitality.dao.FinancialYearDAO;

/**
* @author  #Kishore
*/

@Service("FinancialYearBO")
@Scope(value="prototype")
public class FinancialYearBOImpl implements FinancialYearBO{

	@Autowired
	private FinancialYearDAO financialYearDAO;
	
	@Override
	public void create(FinancialYear financialYear) throws Exception{
		String yearName = "";
		try{
			SimpleDateFormat sdfStart = new SimpleDateFormat("yyyy");
			SimpleDateFormat sdfEnd = new SimpleDateFormat("yy");
			yearName = sdfStart.format(financialYear.getStartDate())+"-"+sdfEnd.format(financialYear.getEndDate());
			financialYear.setYearName(yearName);
			if(StringUtils.isNotBlank(financialYear.getFinancialYearId())){
				financialYearDAO.update(financialYear);
			}else{
				financialYearDAO.create(financialYear);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<FinancialYear> retrieveList() throws Exception{
		List<FinancialYear> financialYearList = new ArrayList<>();
		try{
			financialYearList = financialYearDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return financialYearList;
	}

	@Override
	public FinancialYear retrieveById(String financialYearId) throws Exception {
		FinancialYear financialYear = null;
		try {
			financialYear = financialYearDAO.findById(financialYearId);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return financialYear;
	}

	@Override
	public void delete(String financialYearId) throws Exception {
		FinancialYear financialYear = null;
		try {
			financialYear = financialYearDAO.findById(financialYearId);
			financialYearDAO.delete(financialYear);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
