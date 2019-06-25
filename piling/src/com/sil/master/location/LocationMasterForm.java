/**
 * 
 */
package com.sil.master.location;

import java.util.Map;

/**
 * @author sumanta roy
 *
 */
public class LocationMasterForm {
	private String contractCode;
	private String locationName;
	private String locationAddress;
	private String locationCode;
	private String active;
	private Map contractDetails;
	/**
	 * @return the contractCode
	 */
	public String getContractCode() {
		return contractCode;
	}
	/**
	 * @param contractCode the contractCode to set
	 */
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	/**
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}
	/**
	 * @param locationName the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	/**
	 * @return the locationAddress
	 */
	public String getLocationAddress() {
		return locationAddress;
	}
	/**
	 * @param locationAddress the locationAddress to set
	 */
	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}
	/**
	 * @return the contractDetails
	 */
	public Map getContractDetails() {
		return contractDetails;
	}
	/**
	 * @param contractDetails the contractDetails to set
	 */
	public void setContractDetails(Map contractDetails) {
		this.contractDetails = contractDetails;
	}
	/**
	 * @return the locationCode
	 */
	public String getLocationCode() {
		return locationCode;
	}
	/**
	 * @param locationCode the locationCode to set
	 */
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}
	

}
