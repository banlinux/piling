package com.sil.pile;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sil.pile.PileMasterDao;
import com.sil.rig.RigMasterBean;

@Service
@Repository
public class PileMasterLogic {
	private PileMasterDao pileMasterDao;
	

	/**
	 * @param outEntryDao the outEntryDao to set
	 */
	@Autowired	
	@Resource(name="pileMasterDaoImpl")
	public void setPileMasterDao(PileMasterDao pileMasterDao) {
		this.pileMasterDao = pileMasterDao;
	}
	public Set getContractDetails(String senderType,String query){
		System.out.println(senderType+":"+query);
		return pileMasterDao.getContractDetails(senderType,query);
	}
	public List<String> getSiteDetails(String contractNo) {
		
		return pileMasterDao.getSiteDetails(contractNo);
	}
	public boolean savePileMaster(PileMasterBean bean, HttpSession httpSession) {
		
		return pileMasterDao.savePileMaster(bean);
	}
}
