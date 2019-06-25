/**
 * 
 */
package com.sil.master.location;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sil.databasemodel.LocationMaster;


@Transactional
@Repository
public class LocationMasterDaoImpl implements LocationMasterDao {
 private SessionFactory sessionFactory;
	@Override
	public void saveLocation(LocationMasterForm bean) {
		LocationMaster table=new LocationMaster();
		table.setContract_code(bean.getContractCode());
		table.setLocation_code(getLastLocationCode(bean.getContractCode()));
		table.setLocation_address(bean.getLocationAddress());
		table.setLocation_name(bean.getLocationName());
		table.setActive("Y");
		sessionFactory.getCurrentSession().save(table);
	}
	
	
	public String getLastLocationCode(String conCode){
		String str="";
		List <LocationMaster> res=sessionFactory.getCurrentSession().createQuery("from LocationMaster where contract_code='"+conCode+"' order by location_code desc").list();
		if(res.size()>0){
			LocationMaster lm=res.get(0);
			String locationCode=lm.getLocation_code();
			NumberFormat Nf = new DecimalFormat("000");
			String ss=locationCode.substring(3);
			int ii=Integer.parseInt(ss);
			String mControlNo = Nf.format(Double.valueOf(ii+1));
			str="LOC"+mControlNo;
		}
		else{
			str="LOC001";
		}
		return str;
	}
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public List<LocationMasterForm> getLocationDetails(String conCode) {
		List<LocationMasterForm> result=new ArrayList<LocationMasterForm>();
		List <LocationMaster> res=sessionFactory.getCurrentSession().createQuery("from LocationMaster where contract_code='"+conCode+"' order by location_code desc").list();
		for(LocationMaster data:res){
			LocationMasterForm bean=new LocationMasterForm();
			bean.setContractCode(data.getContract_code());
			bean.setLocationCode(data.getLocation_code());
			bean.setLocationAddress(data.getLocation_address());
			bean.setLocationName(data.getLocation_name());
			bean.setActive(data.getActive());
			result.add(bean);
		}
		return result;
	}

}
