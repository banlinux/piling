/**
 * 
 */
package com.sil.master.state;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author sumanta roy
 *
 */
@Repository
public class StateMasterValidator implements Validator {

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> arg0) {
		return arg0.isAssignableFrom(StateMasterBean.class);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object obj, Errors err) {
		StateMasterBean bean=(StateMasterBean)obj;
		if(bean.getCountryCode().compareTo(0)==0)
			err.rejectValue("countryCode", "StateMasterValidator.countryCode", "Select Country");
		if(bean.getRegionCode().compareTo(0)==0)
			err.rejectValue("regionCode", "StateMasterValidator.regionCode", "Select Region");

	}

}
