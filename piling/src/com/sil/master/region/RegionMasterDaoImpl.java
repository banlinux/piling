/**
 * 
 */
package com.sil.master.region;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sil.databasemodel.CountryMaster;
import com.sil.databasemodel.RegionMaster;
import com.sil.master.country.CountryMasterBean;


@Transactional
@Repository
public class RegionMasterDaoImpl implements RegionMasterDao {
	private SessionFactory sessionFactory;
	@Override
	public void saveRegion(RegionMasterBean bean) {
		Query query = sessionFactory.getCurrentSession().createQuery("select max(region_code) from RegionMaster");
		List list = query.list();
		int code=(Integer)list.get(0);
		  System.out.println("Max country Code: " + code);
		RegionMaster table = new RegionMaster();
		table.setCountry_code(bean.getCountryCode());
		table.setRegion_code(code+1);
		table.setRegion_name(bean.getRegionName());
		table.setDel_flag("N");
		sessionFactory.getCurrentSession().save(table);
	}

	@Override
	public void modifyRegion(RegionMasterBean bean) {
		RegionMaster table = new RegionMaster();
		table.setCountry_code(bean.getCountryCode());
		table.setRegion_code(bean.getRegionCode());
		table.setRegion_name(bean.getRegionName());
		table.setDel_flag("N");
		sessionFactory.getCurrentSession().update(table);
		
	}

	@Override
	public void deleteRegion(RegionMasterBean bean) {
		RegionMaster table = new RegionMaster();
		table.setCountry_code(bean.getCountryCode());
		table.setRegion_code(bean.getRegionCode());
		table.setRegion_name(bean.getRegionName());
		table.setDel_flag("Y");
		sessionFactory.getCurrentSession().update(table);
		
	}

	@Override
	public List<RegionMasterBean> getRegionDetails(String countryCode) {
		List<RegionMasterBean>  lis=new ArrayList<RegionMasterBean>();
		List <RegionMaster> query=sessionFactory.getCurrentSession().createQuery("from RegionMaster where  country_code='"+countryCode+"'and del_flag='N'").list();
		 for(RegionMaster res : query){
			 RegionMasterBean bean=new RegionMasterBean();
			 bean.setCountryCode(res.getCountry_code());
			 bean.setRegionName(res.getRegion_name());
			 bean.setRegionCode(res.getRegion_code());
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
