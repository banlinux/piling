package com.sil.pile;

import java.util.List;
import java.util.Set;



public interface PileMasterDao {
	Set<String> getContractDetails(String senderType,String query);
	List<String> getSiteDetails(String contractNo);
	boolean savePileMaster(PileMasterBean bean);
}
