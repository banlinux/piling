/**
 * 
 */
package com.sil.master.userpermission;

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


//import com.sil.databasemodel.ContractMaster;
//import com.sil.databasemodel.DepartmentMasterDetail;
//import com.sil.databasemodel.EmployeeMasterDetail;
import com.sil.databasemodel.UserPermission;

import com.sil.databasemodel.UserLoginMaster;
import com.sil.master.userpermission.PermissionBean;


@Transactional
@Repository
public class PermissionDaoImpl implements PermissionDao {
		private SessionFactory sessionFactory;
		@Autowired
		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		/*Rinku commented from controller
		public Map<String, String> getEmployeeNames(String userContcd){
			Map<String,String> emplMap = new HashMap<String,String>();
			Query result = sessionFactory.getCurrentSession().createQuery("FROM UserLoginMaster WHERE contract_code='"+userContcd+ "' ORDER BY user_id ASC");
			for (Iterator<UserLoginMaster> it = result.iterate(); it.hasNext();){
				UserLoginMaster userLoginMaster = it.next();
				emplMap.put(userLoginMaster.getUser_id(), userLoginMaster.getUser_id());
			}
			return emplMap;
		}
		*/
		// _target1. Get user permission records in grid for individual employee code.
		@Override
		public List<String>	getPermissionDetails(String empcd){
			List<String> list = new ArrayList<String>();
			System.out.println(empcd);
			//JavaRptUserPermission res = (JavaRptUserPermission)sessionFactory.getCurrentSession().get(JavaRptUserPermission.class, empcd);Rinku
			//Query query=sessionFactory.getCurrentSession().createQuery("SELECT A.ltds,A.csbso,A.es,A.inc,A.faa,A.scbsf,A.up from JavaRptUserPermission AS A ,UserLoginMaster  AS B where upper(B.emp_code) like '%"+empcd.toUpperCase()+"%' and A.user_id = B.login");
			
			Iterator itr = sessionFactory.getCurrentSession().createSQLQuery("SELECT A.user_id,A.m_site,A.m_contract,A.m_permission,A.f_rig_progress,A.r_rig_progress,A.m_rig,A.m_pile from PILING_USER_PERMISSION  A ,USER_LOGIN   B where upper(B.user_id) like '%"+empcd.toUpperCase()+"%' and A.user_id = B.user_id").list().iterator();
			
//			List ls=query.list();
//	 
//				list.add(ls.get(0).toString());
//				list.add(ls.get(1).toString());
//				list.add(ls.get(2).toString());
//				list.add(ls.get(3).toString());
//				list.add(ls.get(4).toString());
//				list.add(ls.get(5).toString());
				
				while(itr.hasNext()){
					Object[] tuple = (Object[]) itr.next();
					System.out.println("LENGTH "+tuple.length);
					list.add(tuple[0].toString());
					list.add(tuple[1].toString());
					list.add(tuple[2].toString());
					list.add(tuple[3].toString());
					list.add(tuple[4].toString());
					list.add(tuple[5].toString());
					list.add(tuple[6].toString());
					list.add(tuple[7].toString());
				//	list.add(tuple[8].toString());
				//	list.add(tuple[9].toString());

				   
				}
			
			/*
			if (res!=null){
				list.add(res.getLtds());
				list.add(res.getCsbso());
				list.add(res.getEs());
				list.add(res.getInc());
				list.add(res.getFaa());
				list.add(res.getScbsf());
				list.add(res.getCourierMenu());
				list.add(res.getContMstViewMenu());
				list.add(res.getCourierRateMenu());
				list.add(res.getOutEntryMenu());
				list.add(res.getOutEntryDispMenu());
				list.add(res.getReturnEntryModMenu());
				list.add(res.getReturnMenu());
				list.add(res.getConsignModMenu());
				System.out.println(res.getConsignModMenu());
				list.add(res.getInEntryMenu());
				list.add(res.getCourierReturnMenu());
				list.add(res.getIndAckMenu());
				System.out.println(res.getEntryAckMenu());
				list.add(res.getEntryAckMenu());
				list.add(res.getIncommingRptMenu());
				list.add(res.getOutSumRptMenu());
				list.add(res.getReturnRptMenu());
				list.add(res.getOutDtlRptMenu());
				// new menu.
				list.add(res.getCountryMstMenu());
				list.add(res.getRegionMstMenu());
				list.add(res.getStateMstMenu());
				list.add(res.getDistrictMstMenu());
				list.add(res.getCityMstMenu());
				list.add(res.getContDeptAssociation());*/
			
			return list;
		}
		
		// target2.
		@Override
		public List<String> getEmpDetails(String empCode) {
			List<String>list=new ArrayList<String>();

			Iterator itr = sessionFactory.getCurrentSession().createSQLQuery("SELECT USER_ID,USER_NAME,STATUS from USER_LOGIN    where upper(USER_ID) like '%"+empCode.toUpperCase()+"%' ").list().iterator();
			while(itr.hasNext()){
				Object[] tuple = (Object[]) itr.next();
				System.out.println("LENGTH "+tuple.length);
				list.add(tuple[0].toString());
				list.add(tuple[1].toString());
				list.add(tuple[0].toString());
				list.add(tuple[2].toString());
			   
			}
			return list;
		}
		
		// target3.
		@Override
		public List<String> getPassword(String empCode){
			List<String>list = new ArrayList<String>();
			UserLoginMaster userLoginMaster=(UserLoginMaster)sessionFactory.getCurrentSession().get(UserLoginMaster.class, empCode);
			if (userLoginMaster != null){
				list.add(userLoginMaster.getPassword());
				list.add(userLoginMaster.getStatus());
			}
			return list;
		}
		
		@Override
		public boolean insertPermissionEntry(PermissionBean pbean){
	//		UserLoginMaster logintab = saveLogin(pbean);  Rinku Commented
	//		sessionFactory.getCurrentSession().save(logintab);	Rinku Commented
			
			UserPermission table = putData(pbean);
			sessionFactory.getCurrentSession().save(table);
			
			return false;
		}
	
		@Override
		public boolean modifyPermissionEntry(PermissionBean bean) {
			// TODO Auto-generated method stub
		//	UserLoginMaster logintab = putLogin(bean);
		//	sessionFactory.getCurrentSession().update(logintab);
			
			UserPermission table = putData(bean);
			sessionFactory.getCurrentSession().update(table);
			
			return false;
		}
	
		/*Rinku Commented
		private UserLoginMaster saveLogin(PermissionBean pbean) {
			// TODO Auto-generated method stub
			UserLoginMaster table = new UserLoginMaster();
			
			table.setUser_id(pbean.getUserId());
			table.setPassword(pbean.getPassword());
			if (pbean.getStatus()!=null)
				table.setStatus(pbean.getStatus().toLowerCase());
			else
				table.setStatus("n");
			
			table.setUser_name(pbean.getUserName());
			table.setContract_code(pbean.getContCode());
			table.setLocation_code(pbean.getContCode());
			return table;
		}
		
		private UserLoginMaster putLogin(PermissionBean pbean) {
			// TODO Auto-generated method stub
			//UserLoginMaster table = new UserLoginMaster();
			
			UserLoginMaster table =(UserLoginMaster)sessionFactory.getCurrentSession().get(UserLoginMaster.class, pbean.getUserId());
			table.setUser_id(pbean.getUserId());
			table.setPassword(pbean.getPassword());
			if (pbean.getStatus()!=null)
				table.setStatus(pbean.getStatus().toLowerCase());
			else
				table.setStatus("n");
			
			table.setUser_name(pbean.getUserName());
			table.setContract_code(pbean.getContCode());
			return table;
		}
		*/
		
		private UserPermission putData(PermissionBean pbean) {
			// TODO Auto-generated method stub
			UserPermission table = new UserPermission();
			System.out.println("IMPL"+pbean.getUserId());
			table.setUser_id(pbean.getUserId());
			if (pbean.getF_rig_progress()!= null && pbean.getF_rig_progress().equalsIgnoreCase("Y"))
				table.setF_rig_progress("Y");
			else
				table.setF_rig_progress("N");
			
			if (pbean.getM_contract()!= null && pbean.getM_contract().equalsIgnoreCase("Y"))
				table.setM_contract("Y");
			else
				table.setM_contract("N");
			
			if (pbean.getM_permission()!= null && pbean.getM_permission().equalsIgnoreCase("Y"))
				table.setM_permission("Y");
			else
				table.setM_permission("N");
			
			if (pbean.getM_pile()!= null && pbean.getM_pile().equalsIgnoreCase("Y"))
				table.setM_pile("Y");
			else
				table.setM_pile("N");
			
			if (pbean.getM_rig()!= null && pbean.getM_rig().equalsIgnoreCase("Y"))
				table.setM_rig("Y");
			else
				table.setM_rig("N");
			
			if (pbean.getM_site()!= null && pbean.getM_site().equalsIgnoreCase("Y"))
				table.setM_site("Y");
			else
				table.setM_site("N");
			
			if (pbean.getR_rig_progress() != null && pbean.getR_rig_progress().equalsIgnoreCase("Y"))
				table.setR_rig_progress("Y");
			else
				table.setR_rig_progress("N");;
			
	
			
			return table;
		}
		
		/*Rinku Added */
		 
		@Override
		public Set<String> getEmployeeDetails(String senderType,String query) {
			Set <String>ll=new HashSet<String>();
			Set <String>ll1=new HashSet<String>();
			Set <String>ll2=new HashSet<String>();
			query = query.trim().replaceAll("\\s+", "%");
			if(senderType.equalsIgnoreCase("EMPLOYEE")){
				Query res=sessionFactory.getCurrentSession().createQuery("from UserLoginMaster where upper(user_id) like '%"+query.toUpperCase()+"%'");

				for (Iterator<UserLoginMaster> it = res.iterate(); it.hasNext();) {
					UserLoginMaster data=it.next();
					String temp=data.getUser_id().trim()+":"+data.getUser_name().trim();
					ll.add(temp);
				}
				Query res1=sessionFactory.getCurrentSession().createQuery("from UserLoginMaster where upper(user_name) like '%"+query.toUpperCase()+"%'");

				for (Iterator<UserLoginMaster> it1 = res1.iterate(); it1.hasNext();) {
					UserLoginMaster data=it1.next();
					String temp=data.getUser_id().trim()+":"+data.getUser_name().trim();
					ll1.add(temp);
				}
		//		ll.add("------------SELECT---------------");
				ll.addAll(ll1);

		/*		Query res2=sessionFactory.getCurrentSession().createQuery("from EmployeeMasterDetail where empcd like '"+new_query+"%'");
				for (Iterator<EmployeeMasterDetail> it = res2.iterate(); it.hasNext();) {
					EmployeeMasterDetail data=it.next();
					String temp=data.getEmpcd().trim()+":"+data.getEmpname().trim();
					ll2.add(temp);
				}*/
				ll.addAll(ll2);
			}


			else{
				return ll;
			}
		
			return ll;
		}

		/*Rinku Added End*/
}

