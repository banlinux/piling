/**
 * 
 */
package com.sil.master.region;

import java.util.Map;

/**
 * @author sumanta roy
 *
 */
public class RegionMasterBean {
	private String regionName;
	private Integer regionCode;
	private Map countryMap;
	private Integer countryCode;
	private String CountryName;
	/**
	 * @return the regionName
	 */
	public String getRegionName() {
		return regionName;
	}
	/**
	 * @param regionName the regionName to set
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
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
	 * @return the countryName
	 */
	public String getCountryName() {
		return CountryName;
	}
	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		CountryName = countryName;
	}

}
