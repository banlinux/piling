package com.sil.pilingRigProgress;

import java.util.List;
import java.util.Set;


import com.sil.pile.PileMasterBean;

import com.sil.rig.RigMasterBean;

public interface PilingRigProgressDao {
	Set<String> getContractDetails(String senderType,String query);
	List<String> getSiteDetails(String contractNo);
	Set<String> getRigList(String senderType,String query);
	Set<String> getPileDetails(String senderType,String query);
	List<PileMasterBean> getPileDetails(String pileNo);
	public void saveDetail(PilingRigProgressForm pilingRigProgressForm);
}
