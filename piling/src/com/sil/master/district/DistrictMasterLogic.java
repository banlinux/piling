/**
 * 
 */
package com.sil.master.district;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sil.master.state.StateMasterBean;
import com.sil.util.CommonFunctionDao;

/**
 * @author sumanta roy
 *
 */
@Repository
@Service
public class DistrictMasterLogic {
	 private CommonFunctionDao commonFunctionDao;
	 private DistrictMasterDao districtMasterDao;
	 
	public Map getCountryMap() {
		// TODO Auto-generated method stub
		return commonFunctionDao.getCountryMap();
	}

	/**
	 * @param commonFunctionDao the commonFunctionDao to set
	 */
	@Autowired
	public void setCommonFunctionDao(CommonFunctionDao commonFunctionDao) {
		this.commonFunctionDao = commonFunctionDao;
	}

	public List<DistrictMasterBean> getDistrictDetails(String stateCode) {
		// TODO Auto-generated method stub
		return districtMasterDao.getDistrictDetails(stateCode);
	}

	public void deleteDistrict(DistrictMasterBean bean) {
		districtMasterDao.deleteDistrict(bean);
		
	}

	public void modifyDistrict(DistrictMasterBean bean) {
		districtMasterDao.modifyDistrict(bean);
		
	}

	public void saveDistrict(DistrictMasterBean bean) {
		districtMasterDao.saveDistrict(bean);
		
	}

	/**
	 * @param districtMasterDao the districtMasterDao to set
	 */
	@Autowired
	public void setDistrictMasterDao(DistrictMasterDao districtMasterDao) {
		this.districtMasterDao = districtMasterDao;
	}

	public List<StateMasterBean> getStateDetails(String regionCode) {
		return commonFunctionDao.getStateDetails(regionCode);
	}

}
