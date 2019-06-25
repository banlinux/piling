/**
 * 
 */
package com.sil.master.district;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sil.databasemodel.DistrictMaster;

/**
 * @author sumanta roy
 *
 */
@Transactional
@Repository
public class DistrictMasterDaoImpl implements DistrictMasterDao {
	
	private SessionFactory sessionFactory;

	@Override
	public List<DistrictMasterBean> getDistrictDetails( String stateCode) {
		List<DistrictMasterBean>  lis=new ArrayList<DistrictMasterBean>();
		List <DistrictMaster> query=sessionFactory.getCurrentSession().createQuery("from DistrictMaster where  state_code='"+stateCode+"'and del_flag='N'").list();
		 for(DistrictMaster res : query){
			 DistrictMasterBean bean=new DistrictMasterBean();
			 bean.setStateCode(res.getState_code());
			 bean.setDistrictName(res.getDistrict_name());
			 bean.setDistrictCode(res.getDistrict_code());
			 lis.add(bean);
		 }
			return lis;
	}

	@Override
	public void deleteDistrict(DistrictMasterBean bean) {
		DistrictMaster table = new DistrictMaster();
		table.setState_code(bean.getStateCode());
		table.setDistrict_code(bean.getDistrictCode());
		table.setDistrict_name(bean.getDistrictName());
		table.setDel_flag("Y");
		sessionFactory.getCurrentSession().update(table);
		
	}

	@Override
	public void modifyDistrict(DistrictMasterBean bean) {
		DistrictMaster table = new DistrictMaster();
		table.setState_code(bean.getStateCode());
		table.setDistrict_code(bean.getDistrictCode());
		table.setDistrict_name(bean.getDistrictName());
		table.setDel_flag("N");
		sessionFactory.getCurrentSession().update(table);
		
	}

	@Override
	public void saveDistrict(DistrictMasterBean bean) {
		Query query = sessionFactory.getCurrentSession().createQuery("select max(district_code) from DistrictMaster");
		List list = query.list();
		int code=(Integer)list.get(0);
		  System.out.println("Max country Code: " + code);
		DistrictMaster table = new DistrictMaster();
		table.setState_code(bean.getStateCode());
		table.setDistrict_code(code+1);
		table.setDistrict_name(bean.getDistrictName());
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

}
