/** FinancialYearBO.java  Dec 8,19
*/

package com.hospitality.bo;

import java.util.List;

import com.hospitality.core.FinancialYear;

/**
* @author  #Kishore
*/

public interface FinancialYearBO {

	public void create(FinancialYear financialYear) throws Exception;
	public List<FinancialYear> retrieveList() throws Exception;
	public FinancialYear retrieveById(String financialYearId) throws Exception;
	public void delete(String financialYearId) throws Exception;

}
