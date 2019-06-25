/**
 * 
 */
package com.sil.menu;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sil.databasemodel.UserPermission;

/**
 * @author Milan Dutta
 *
 */
@Transactional
@Repository
public class MenuDaoImpl implements MenuDao {
	private SessionFactory sessionFactory;

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public MenuBean getUserPermission(String userId) {
		List <UserPermission>res1=new ArrayList<UserPermission>();
		try{
			res1=sessionFactory.getCurrentSession().createQuery("from UserPermission where user_id='"+userId+"'").list();
		}catch (Exception nre){
			nre.printStackTrace();
			System.out.println("***********");
			//Ignore this because as per your logic this is ok!
		}
		for(UserPermission res:res1){
			MenuBean bean=new MenuBean();
			bean.setUserId(res.getUser_id());
	//		bean.setM_zone(res.getM_zone());
			bean.setM_site(res.getM_site());
			bean.setM_contract(res.getM_contract());
			bean.setM_permission(res.getM_permission());
			bean.setF_rig_progress(res.getF_rig_progress());
			bean.setR_rig_progress(res.getR_rig_progress());
			bean.setM_pile(res.getM_pile());
			bean.setM_rig(res.getM_rig());
			return bean;
		}
		return null;
	}
	
	

}
