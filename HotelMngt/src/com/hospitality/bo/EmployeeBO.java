/** EmployeeBO.java  Oct 31,17
*/

package com.hospitality.bo;

import java.util.List;

import com.hospitality.core.Employee;

/**
* @author  Kishore
*/

public interface EmployeeBO {

	public void create(Employee Employee);
	public List<Employee> retrieveList();

}
