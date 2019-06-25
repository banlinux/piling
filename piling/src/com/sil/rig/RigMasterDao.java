package com.sil.rig;

import java.util.List;
import java.util.Set;



public interface RigMasterDao {
	Set<String> getContractDetails(String senderType,String query);
	List<String> getSiteDetails(String contractNo);
	boolean saveRigMaster(RigMasterBean bean);
}
