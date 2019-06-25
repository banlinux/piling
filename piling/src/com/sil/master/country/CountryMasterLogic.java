/**
 * 
 */
package com.sil.master.country;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author sumanta roy
 *
 */
@Repository
@Service
public class CountryMasterLogic {
 private CountryMasterDao countryMasterDao;
	public void saveCountry(CountryMasterBean bean) {
		countryMasterDao.saveCountry(bean);
		
	}
	/**
	 * @param countryMasterDao the countryMasterDao to set
	 */
	@Autowired
	public void setCountryMasterDao(CountryMasterDao countryMasterDao) {
		this.countryMasterDao = countryMasterDao;
	}
	public void modifyCountry(CountryMasterBean bean) {
		countryMasterDao.modifyCountry(bean);
		
	}
	public void deleteCountry(CountryMasterBean bean) {
		countryMasterDao.deleteCountry(bean);
		
	}
	public List<CountryMasterBean> getCountryDetails() {
		// TODO Auto-generated method stub
		return countryMasterDao.getCountryDetails();
	}

}
