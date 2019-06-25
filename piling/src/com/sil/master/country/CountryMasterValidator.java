/**
 * 
 */
package com.sil.master.country;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author sumanta roy
 *
 */
@Repository
public class CountryMasterValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return arg0.isAssignableFrom(CountryMasterBean.class);
	}

	@Override
	public void validate(Object obj, Errors err) {
		CountryMasterBean bean=(CountryMasterBean)obj;
		if(bean.getCountryName().isEmpty())
			err.rejectValue("countryName", "CountryMasterValidator.countryName", "Enter Country Name");
		
	}

}
