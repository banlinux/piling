package com.sil.rig;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sil.master.country.CountryMasterBean;
@Repository
public class RigMasterValidator implements Validator{
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return arg0.isAssignableFrom(RigMasterBean.class);
	}
	
	@Override
	public void validate(Object obj, Errors err) {
		RigMasterBean bean=(RigMasterBean)obj;
	//	if(bean.getCountryName().isEmpty())
	//		err.rejectValue("countryName", "CountryMasterValidator.countryName", "Enter Country Name");
		
	}
}
