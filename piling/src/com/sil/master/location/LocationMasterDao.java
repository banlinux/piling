/**
 * 
 */
package com.sil.master.location;

import java.util.List;

/**
 * @author sumanta roy
 *
 */
public interface LocationMasterDao {

	public void saveLocation(LocationMasterForm bean);

	public List<LocationMasterForm> getLocationDetails(String conCode);

}
