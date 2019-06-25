/**
 * 
 */
package com.sil.master.country;

import java.util.List;

/**
 * @author sumanta roy
 *
 */
public interface CountryMasterDao {

	void saveCountry(CountryMasterBean bean);

	void modifyCountry(CountryMasterBean bean);

	void deleteCountry(CountryMasterBean bean);

	List<CountryMasterBean> getCountryDetails();

}
