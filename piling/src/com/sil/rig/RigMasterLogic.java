package com.sil.rig;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import com.sil.util.CommonFunctionDao;
@Service
@Repository
public class RigMasterLogic {
	
	private RigMasterDao rigMasterDao;
	

	/**
	 * @param outEntryDao the outEntryDao to set
	 */
	@Autowired	
	@Resource(name="rigMasterDaoImpl")
	public void setRigMasterDao(RigMasterDao rigMasterDao) {
		this.rigMasterDao = rigMasterDao;
	}
	public Set getContractDetails(String senderType,String query){
		System.out.println(senderType+":"+query);
		return rigMasterDao.getContractDetails(senderType,query);
	}
	public List<String> getSiteDetails(String contractNo) {
		
		return rigMasterDao.getSiteDetails(contractNo);
	}
	
	public boolean saveRigMaster(RigMasterBean bean, HttpSession httpSession) {
	
		return rigMasterDao.saveRigMaster(bean);
	}
}
