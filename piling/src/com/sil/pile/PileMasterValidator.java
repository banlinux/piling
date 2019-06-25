package com.sil.pile;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



@Repository
public class PileMasterValidator implements Validator{
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return arg0.isAssignableFrom(PileMasterBean.class);
	}
	
	@Override
	public void validate(Object obj, Errors err) {
		PileMasterBean bean=(PileMasterBean)obj;
	//	if(bean.getCountryName().isEmpty())
	//		err.rejectValue("countryName", "CountryMasterValidator.countryName", "Enter Country Name");
		
	}
}
