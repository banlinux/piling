package com.sil.rig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sil.databasemodel.ContractMaster;

import com.sil.databasemodel.RigDetail;

@Transactional
@Repository
public class RigMasterDaoImpl implements RigMasterDao {
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
/*	@Override
	public String  getVatDetails(String code,String supplier_code) {
		Map<String,String> courierAddressMap = new HashMap<String, String>();
		System.out.println("??????????????????????????????????????");
		Query query =sessionFactory.getCurrentSession().createSQLQuery(" Select vat_no FROM Courier_Address where courier_code='"+supplier_code+"' AND state='"+code+"'");
		List ls=query.list();
		if (ls.isEmpty())
			return " ";
		else 
			return ls.get(0).toString();
	}*/
	@Override
	public boolean saveRigMaster(RigMasterBean bean) {
		RigDetail table=new RigDetail();
		table.setContract_no(bean.getContract_no());
		table.setMachine_code(bean.getMachine_code());
		table.setRemark(bean.getRemark());
		table.setRfid_code(bean.getRfif_code());
		table.setRig_capacity(bean.getRig_capacity());
		table.setRig_installation_date(bean.getRig_installation_date());
		table.setRig_make(bean.getRig_make());
		table.setRig_model(bean.getRig_model());
		table.setRig_name(bean.getRig_name());
		table.setSite_no(bean.getSite_no());
		table.setRig_release_date(bean.getRig_release_date());
		table.setRig_sl_no(bean.getRig_sl_no());
		table.setRig_yom(bean.getRig_yom());
		sessionFactory.getCurrentSession().save(table);
		return true;
	}

}
