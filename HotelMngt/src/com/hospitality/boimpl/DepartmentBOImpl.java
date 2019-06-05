/** DepartmentBOImpl.java  Oct 31,17
*/

package com.hospitality.boimpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.bo.DepartmentBO;
import com.hospitality.core.Department;
import com.hospitality.dao.DepartmentDAO;

/**
* @author  Kishore
*/

@Service("DepartmentBO")
@Scope(value="prototype")
public class DepartmentBOImpl implements DepartmentBO{

	@Autowired
	private DepartmentDAO DepartmentDAO;
	
	@Override
	public void create(Department Department) {
		try{
			if(StringUtils.isNotBlank(Department.getDepartmentId())){
				DepartmentDAO.update(Department);
			}else{
				DepartmentDAO.create(Department);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<Department> retrieveList() {
		List<Department> DepartmentList = null;
		try{
			DepartmentList = DepartmentDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return DepartmentList;
	}

}
