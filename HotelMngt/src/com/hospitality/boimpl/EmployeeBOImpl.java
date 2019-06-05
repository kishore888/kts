/** EmployeeBOImpl.java  Oct 31,17
*/

package com.hospitality.boimpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.bo.EmployeeBO;
import com.hospitality.core.Employee;
import com.hospitality.dao.EmployeeDAO;

/**
* @author  Kishore
*/

@Service("EmployeeBO")
@Scope(value="prototype")
public class EmployeeBOImpl implements EmployeeBO{

	@Autowired
	private EmployeeDAO EmployeeDAO;
	
	@Override
	public void create(Employee Employee) {
		try{
			if(StringUtils.isNotBlank(Employee.getEmployeeId())){
				EmployeeDAO.update(Employee);
			}else{
				EmployeeDAO.create(Employee);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<Employee> retrieveList() {
		List<Employee> EmployeeList = null;
		try{
			EmployeeList = EmployeeDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return EmployeeList;
	}

}
