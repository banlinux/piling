/**
 * 
 */
package com.sil.master.district;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author sumanta roy
 *
 */
@Repository
public class DistrictMasterValidator implements Validator {

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> arg0) {
		return arg0.isAssignableFrom(DistrictMasterBean.class);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object obj, Errors err) {
		DistrictMasterBean bean=(DistrictMasterBean)obj;
		if(bean.getCountryCode().compareTo(0)==0)
			err.rejectValue("countryCode", "DistrictMasterValidator.countryCode", "Select Country");
		if(bean.getRegionCode().compareTo(0)==0)
			err.rejectValue("regionCode", "DistrictMasterValidator.regionCode", "Select Region");
		if(bean.getStateCode().compareTo(0)==0)
			err.rejectValue("stateCode", "DistrictMasterValidator.stateCode", "Select State");

	}

}
