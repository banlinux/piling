package com.sil.pile;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sil.databasemodel.ContractMaster;
import com.sil.databasemodel.PileDetail;
import com.sil.databasemodel.RigDetail;
import com.sil.rig.RigMasterBean;
@Transactional
@Repository
public class PileMasterDaoImpl implements PileMasterDao {

	private SessionFactory sessionFactory;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public Set<String> getContractDetails(String senderType, String query) {
		Set <String>ll=new HashSet<String>();
		Set <String>ll1=new HashSet<String>();
		Set <String>ll2=new HashSet<String>();
		query = query.trim().replaceAll("\\s+", "%");

	//	if(senderType.equalsIgnoreCase("CONTRACT")){

			Query res=sessionFactory.getCurrentSession().createQuery("from ContractMaster where upper(contract_no) like '%"+query.toUpperCase()+"%'");

			for (Iterator<ContractMaster> it = res.iterate(); it.hasNext();) {
				ContractMaster data=it.next();
				String temp=data.getContract_no().trim()+":"+data.getContract_desc().trim();
				ll.add(temp);
			}

			Query res1=sessionFactory.getCurrentSession().createQuery("from ContractMaster where upper(contract_desc) like '%"+query.toUpperCase()+"%'");

			for (Iterator<ContractMaster> it = res1.iterate(); it.hasNext();) {
				ContractMaster data=it.next();
				String temp=data.getContract_no().trim()+":"+data.getContract_desc().trim();
				ll1.add(temp);
			}
			ll.addAll(ll1);
	//	}
	//	else{
	//		return ll;
	//	}
	
		return ll;

	}


	@Override
	public List<String> getSiteDetails(String contractNo) {

		System.out.println("??????????????????????????????????????");
		Query query =sessionFactory.getCurrentSession().createSQLQuery("SELECT SITE_NO from TB_SS_CONTRACT_MST where CONTRACT_NO='"+contractNo+"' ");
		List ls=query.list();
		
			return ls;
	}

	@Override
	public boolean savePileMaster(PileMasterBean bean) {
		PileDetail table=new PileDetail();
		table.setContract_no(bean.getContract_no());
		table.setSite_no(bean.getSite_no());
		table.setBoring_length(bean.getBoring_length());
		table.setCage_detail(bean.getCage_detail());
		table.setCage_length(bean.getCage_length());
		table.setConcrete_volume(bean.getConcrete_volume());
		table.setPile_dia(bean.getPile_dia());
		table.setDrawing_no(bean.getDrawing_no());
		table.setPile_no(bean.getPile_no());
		sessionFactory.getCurrentSession().save(table);
		return true;
	}

}
