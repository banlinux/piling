/**
 * 
 */
package com.sil.master.state;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sil.master.region.RegionMasterBean;
import com.sil.util.CommonFunctionDao;

/**
 * @author sumanta roy
 *
 */
@Repository
@Service
public class StateMasterLogic {
    private CommonFunctionDao commonFunctionDao;
    private StateMasterDao stateMasterDao;
	public Map getCountryMap() {
		return commonFunctionDao.getCountryMap();
	}
	/**
	 * @param commonFunctionDao the commonFunctionDao to set
	 */
	@Autowired
	public void setCommonFunctionDao(CommonFunctionDao commonFunctionDao) {
		this.commonFunctionDao = commonFunctionDao;
	}
	public void saveState(StateMasterBean bean) {
		stateMasterDao.saveState(bean);
		
	}
	public void modifyState(StateMasterBean bean) {
		stateMasterDao.modifyState(bean);
		
	}
	public void deleteState(StateMasterBean bean) {
		stateMasterDao.deleteState(bean);
		
	}
	public List<StateMasterBean> getStateDetails(String regionCode) {
		
		return stateMasterDao.getStateDetails(regionCode);
	}
	/**
	 * @param stateMasterDao the stateMasterDao to set
	 */
	@Autowired
	public void setStateMasterDao(StateMasterDao stateMasterDao) {
		this.stateMasterDao = stateMasterDao;
	}
	public List<RegionMasterBean> getRegionDetails(String countryCode) {		
		return commonFunctionDao.getRegionMap(countryCode);
	}

}
