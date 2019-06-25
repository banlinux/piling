/**
 * 
 */
package com.sil.login;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sil.databasemodel.UserLoginMaster;
import com.sil.login.LoginDao;
import com.sil.login.LoginBean;


@Transactional
@Repository
public class LoginDaoImpl implements LoginDao {

	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sil.login.dao.LoginDao#getUserList(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<LoginBean> getUserList(String userId, String password) {
		List<LoginBean> list = new ArrayList<LoginBean>();
		try{
			System.out.println("SQL");
		Query result = sessionFactory.getCurrentSession().createQuery(
				"from UserLoginMaster where user_id='" + userId+ "'");
		for (Iterator<UserLoginMaster> it = result.iterate(); it.hasNext();) {
			LoginBean bean = new LoginBean();
			UserLoginMaster res = it.next();			
			bean.setUserName(res.getUser_name());
			bean.setUserId(res.getUser_id());
			bean.setContractCode(res.getContract_code());
			bean.setLocationCode(res.getLocation_code());
			if (res.getPassword() != null) {
				
				if (res.getPassword().compareTo(password) == 0 && res.getStatus().compareTo("y")==0){
					
					list.add(bean);
				}
			}
		}
		System.out.println("Returning List");
		return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
