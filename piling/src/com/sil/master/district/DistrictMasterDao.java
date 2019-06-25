/**
 * 
 */
package com.sil.master.district;

import java.util.List;

/**
 * @author sumanta roy
 *
 */
public interface DistrictMasterDao {

	List<DistrictMasterBean> getDistrictDetails(String stateCode);

	void deleteDistrict(DistrictMasterBean bean);

	void modifyDistrict(DistrictMasterBean bean);

	void saveDistrict(DistrictMasterBean bean);

}
