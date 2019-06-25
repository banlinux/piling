/**
 * 
 */
package com.sil.master.region;

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
@Repository
@Service
public class RegionMasterLogic {
	private CommonFunctionDao commonFunctionDao;
	private RegionMasterDao regionMasterDao;
	
	public void saveRegion(RegionMasterBean bean) {
		regionMasterDao.saveRegion(bean);
		
	}

	public void modifyRegion(RegionMasterBean bean) {
		regionMasterDao.modifyRegion(bean);
		
	}

	public void deleteRegion(RegionMasterBean bean) {
		regionMasterDao.deleteRegion(bean);
		
	}

	public List<RegionMasterBean> getRegionDetails(String countryCode) {
		
		return regionMasterDao.getRegionDetails(countryCode);
	}
	
	public Map getCountryMap(){
		return commonFunctionDao.getCountryMap();
	}

	/**
	 * @param commonFunctionDao the commonFunctionDao to set
	 */
	@Autowired
	public void setCommonFunctionDao(CommonFunctionDao commonFunctionDao) {
		this.commonFunctionDao = commonFunctionDao;
	}

	/**
	 * @param regionMasterDao the regionMasterDao to set
	 */
	@Autowired
	public void setRegionMasterDao(RegionMasterDao regionMasterDao) {
		this.regionMasterDao = regionMasterDao;
	}

}
