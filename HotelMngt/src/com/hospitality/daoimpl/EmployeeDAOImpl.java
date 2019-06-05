/** EmployeeDAOImpl.java  Oct 31,17
*/

package com.hospitality.daoimpl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.Employee;
import com.hospitality.dao.EmployeeDAO;


/**
* @author  Kishore
*/

@Repository
@Transactional
public class EmployeeDAOImpl extends GenericDAOImpl<Employee> implements EmployeeDAO{

}
