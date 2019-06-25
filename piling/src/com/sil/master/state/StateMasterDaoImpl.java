/**
 * 
 */
package com.sil.master.state;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sil.databasemodel.RegionMaster;
import com.sil.databasemodel.StateMaster;
import com.sil.master.region.RegionMasterBean;

/**
 * @author sumanta roy
 *
 */
@Transactional
@Repository
public class StateMasterDaoImpl implements StateMasterDao {
	private SessionFactory sessionFactory;

	@Override
	public void saveState(StateMasterBean bean) {
		Query query = sessionFactory.getCurrentSession().createQuery("select max(state_code) from StateMaster");
		List list = query.list();
		int code=(Integer)list.get(0);
		  System.out.println("Max State Code: " + code);
		StateMaster table = new StateMaster();
		table.setCountry_code(bean.getCountryCode());
		table.setState_code(code+1);
		table.setState_name(bean.getStateName());
		table.setRegion_code(bean.getRegionCode());
		table.setDel_flag("N");
		sessionFactory.getCurrentSession().save(table);
		
	}

	@Override
	public void modifyState(StateMasterBean bean) {
		StateMaster table = new StateMaster();
		table.setCountry_code(bean.getCountryCode());
		table.setRegion_code(bean.getRegionCode());
		table.setState_code(bean.getStateCode());
		table.setState_name(bean.getStateName());
		table.setDel_flag("N");
		sessionFactory.getCurrentSession().update(table);
		
	}

	@Override
	public void deleteState(StateMasterBean bean) {
		StateMaster table = new StateMaster();
		table.setCountry_code(bean.getCountryCode());
		table.setRegion_code(bean.getRegionCode());
		table.setState_code(bean.getStateCode());
		table.setState_name(bean.getStateName());
		table.setDel_flag("Y");
		sessionFactory.getCurrentSession().update(table);
		
	}

	@Override
	public List<StateMasterBean> getStateDetails(String regionCode) {
		System.out.println("regionCode=="+regionCode);
		List<StateMasterBean>  lis=new ArrayList<StateMasterBean>();
		List <StateMaster> query=sessionFactory.getCurrentSession().createQuery("from StateMaster where  region_code="+regionCode+" and del_flag='N'").list();
		 for(StateMaster res : query){
			 StateMasterBean bean=new StateMasterBean();
			 bean.setCountryCode(res.getCountry_code());
			 bean.setRegionCode(res.getRegion_code());
			 bean.setStateCode(res.getState_code());
			 bean.setStateName(res.getState_name());
			 lis.add(bean);
		 }
			return lis;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
