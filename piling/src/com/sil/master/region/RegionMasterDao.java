/**
 * 
 */
package com.sil.master.region;

import java.util.List;

/**
 * @author sumanta roy
 *
 */
public interface RegionMasterDao {

	void saveRegion(RegionMasterBean bean);

	void modifyRegion(RegionMasterBean bean);

	void deleteRegion(RegionMasterBean bean);

	List<RegionMasterBean> getRegionDetails(String countryCode);

}
