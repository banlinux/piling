/**
 * 
 */
package com.sil.master.region;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sil.master.district.DistrictMasterBean;

/**
 * @author sumanta roy
 *
 */
@Repository
public class RegionMasterValidator implements Validator {

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> arg0) {
		return arg0.isAssignableFrom(RegionMasterBean.class);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object obj, Errors err) {
		RegionMasterBean bean=(RegionMasterBean)obj;
		if(bean.getCountryCode().compareTo(0)==0)
			err.rejectValue("countryCode", "RegionMasterValidator.countryCode", "Select Country");
		

	}

}
