/**
 * 
 */
package com.sil.login;


import java.util.List;

import com.sil.login.LoginBean;


public interface LoginDao {
	
	public List<LoginBean> getUserList(String userId,String password);

}
