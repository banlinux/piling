/**
 * 
 */
package com.sil.master.state;

import java.util.Map;

/**
 * @author sumanta roy
 *
 */
public class StateMasterBean {
	private Integer regionCode;
	private Integer countryCode;
	private Integer stateCode;
	private String stateName;

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
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}
	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
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
