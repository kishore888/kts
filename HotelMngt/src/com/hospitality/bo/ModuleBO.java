/** ModuleBO.java  Dec 3,17
*/

package com.hospitality.bo;

import java.util.List;

import com.hospitality.core.Module;

/**
* @author  Kishore
*/

public interface ModuleBO {

	public void create(Module Module);
	public List<Module> retrieveList();

}
