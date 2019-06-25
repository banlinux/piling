/**
 * 
 */
package com.sil.master.country;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sil.databasemodel.CountryMaster;

/**
 * @author sumanta roy
 *
 */
@Transactional
@Repository
public class CountryMasterDaoImpl implements CountryMasterDao {
	
	static Logger log = Logger.getLogger(CountryMasterDaoImpl.class.getName());
	private SessionFactory sessionFactory;
	@Override
	public void  saveCountry(CountryMasterBean bean) {
		Query query = sessionFactory.getCurrentSession().createQuery("select max(country_code) from CountryMaster");
		List list = query.list();
		int code=(Integer)list.get(0);
		  System.out.println("Max country Code: " + code);
		CountryMaster table = new CountryMaster();
		table.setCountry_name(bean.getCountryName());
		table.setCountry_code(code+1);
		table.setDel_flag("N");
		sessionFactory.getCurrentSession().save(table);
		
	}
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void modifyCountry(CountryMasterBean bean) {
		CountryMaster table = new CountryMaster();
		table.setCountry_name(bean.getCountryName());
		table.setCountry_code(bean.getCountryCode());
		table.setDel_flag("N");
		sessionFactory.getCurrentSession().update(table);
		
	}
	@Override
	public void deleteCountry(CountryMasterBean bean) {
		CountryMaster table = new CountryMaster();
		table.setCountry_name(bean.getCountryName());
		table.setCountry_code(bean.getCountryCode());
		table.setDel_flag("Y");
		sessionFactory.getCurrentSession().update(table);
		
	}
	@Override
	public List<CountryMasterBean> getCountryDetails() {
		List<CountryMasterBean>  lis=new ArrayList<CountryMasterBean>();
	 List <CountryMaster> query=sessionFactory.getCurrentSession().createQuery("from CountryMaster where del_flag='N'").list();
	 for(CountryMaster res : query){
		 CountryMasterBean bean=new CountryMasterBean();
		 bean.setCountryCode(res.getCountry_code());
		 bean.setCountryName(res.getCountry_name());
		 lis.add(bean);
	 }
		return lis;
	}

}
