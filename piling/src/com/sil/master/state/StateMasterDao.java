/**
 * 
 */
package com.sil.master.state;

import java.util.List;

/**
 * @author sumanta roy
 *
 */
public interface StateMasterDao {

	void saveState(StateMasterBean bean);

	void modifyState(StateMasterBean bean);

	void deleteState(StateMasterBean bean);

	List<StateMasterBean> getStateDetails(String regionCode);

}
