/**
 * 
 */
package com.sil.master.location;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sil.util.CommonFunctionDao;

/**
 * @author sumanta roy
 *
 */
@Service
@Repository
public class LocationMasterLogic {
	private LocationMasterDao locationMasterDao;
	private CommonFunctionDao commonFunctionDao;

	/**
	 * @param commonFunctionDao the commonFunctionDao to set
	 */
	@Autowired
	public void setCommonFunctionDao(CommonFunctionDao commonFunctionDao) {
		this.commonFunctionDao = commonFunctionDao;
	}
	/*
	public Map<String,String>contractDetails(){
		return commonFunctionDao.contractDetails();
	}
*/
	public void saveLocation(LocationMasterForm bean) {
		locationMasterDao.saveLocation(bean);
		
	}

	/**
	 * @param locationMasterDao the locationMasterDao to set
	 */
	@Autowired
	public void setLocationMasterDao(LocationMasterDao locationMasterDao) {
		this.locationMasterDao = locationMasterDao;
	}

	public List<LocationMasterForm> getLocationDetails(String conCode) {
		// TODO Auto-generated method stub
		return locationMasterDao.getLocationDetails(conCode);
	}

}
