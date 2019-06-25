package com.sil.login;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.sil.login.LoginDao;
import com.sil.login.LoginBean;


@Repository
@Service
public class Login {
	
	private LoginDao loginDao;
	
	
	public List<LoginBean> getUserList(String userName, String password){
		System.out.println("Returning list Login");
		return loginDao.getUserList(userName,password);
	}
	@Autowired
	public void setLoginDao(LoginDao loginDao){
		this.loginDao=loginDao;
	}
	
	 public List<LoginBean> canLogin (String userName, String password)
	    {
	        List<LoginBean> uDetails=getUserList(userName,password);   

	        return uDetails;
	    }

}
