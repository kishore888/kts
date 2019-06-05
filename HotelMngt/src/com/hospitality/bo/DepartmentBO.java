/** DepartmentBO.java  Oct 31,17
*/

package com.hospitality.bo;

import java.util.List;

import com.hospitality.core.Department;

/**
* @author  Kishore
*/

public interface DepartmentBO {

	public void create(Department department);
	public List<Department> retrieveList();

}
