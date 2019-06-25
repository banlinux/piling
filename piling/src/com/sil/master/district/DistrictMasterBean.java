/**
 * 
 */
package com.sil.master.district;

import java.util.Map;

/**
 * @author sumanta roy
 *
 */
public class DistrictMasterBean {
	private Integer regionCode;
	private Integer countryCode;
	private Integer stateCode;
	private Integer districtCode;
	private String districtName;
	private Map stateMap;
	private Map countryMap;
	private Map regionMap;
	/**
	 * @return the regionCode
	 */
	public Integer getRegionCode() {
		return regionCode;
	}
	/**
	 * @param regionCode the regionCode to set
	 */
	public void setRegionCode(Integer regionCode) {
		this.regionCode = regionCode;
	}
	/**
	 * @return the countryCode
	 */
	public Integer getCountryCode() {
		return countryCode;
	}
	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * @return the stateCode
	 */
	public Integer getStateCode() {
		return stateCode;
	}
	/**
	 * @param stateCode the stateCode to set
	 */
	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}
	/**
	 * @return the districtCode
	 */
	public Integer getDistrictCode() {
		return districtCode;
	}
	/**
	 * @param districtCode the districtCode to set
	 */
	public void setDistrictCode(Integer districtCode) {
		this.districtCode = districtCode;
	}
	/**
	 * @return the districtName
	 */
	public String getDistrictName() {
		return districtName;
	}
	/**
	 * @param districtName the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	/**
	 * @return the stateMap
	 */
	public Map getStateMap() {
		return stateMap;
	}
	/**
	 * @param stateMap the stateMap to set
	 */
	public void setStateMap(Map stateMap) {
		this.stateMap = stateMap;
	}
	/**
	 * @return the countryMap
	 */
	public Map getCountryMap() {
		return countryMap;
	}
	/**
	 * @param countryMap the countryMap to set
	 */
	public void setCountryMap(Map countryMap) {
		this.countryMap = countryMap;
	}
	/**
	 * @return the regionMap
	 */
	public Map getRegionMap() {
		return regionMap;
	}
	/**
	 * @param regionMap the regionMap to set
	 */
	public void setRegionMap(Map regionMap) {
		this.regionMap = regionMap;
	}

}
