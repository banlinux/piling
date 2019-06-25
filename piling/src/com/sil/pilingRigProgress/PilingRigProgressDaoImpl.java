package com.sil.pilingRigProgress;

import java.util.ArrayList;
import java.text.SimpleDateFormat; 
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sil.databasemodel.ContractMaster;

import com.sil.databasemodel.DepartmentMasterDetail;
import com.sil.databasemodel.EmployeeMasterDetail;
import com.sil.databasemodel.PileDetail;
import com.sil.databasemodel.PilingRigBreakdownTime;
import com.sil.databasemodel.PilingRigIdleTime;
import com.sil.databasemodel.PilingRigMovementTime;
import com.sil.databasemodel.RigDetail;

import com.sil.pile.PileMasterBean;

import com.sil.rig.RigMasterBean;

@Transactional
@Repository
public class PilingRigProgressDaoImpl implements PilingRigProgressDao {
	private SessionFactory sessionFactory;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public Set<String> getContractDetails(String senderType, String query) {
		Set <String>ll=new HashSet<String>();
		Set <String>ll1=new HashSet<String>();
		Set <String>ll2=new HashSet<String>();
		query = query.trim().replaceAll("\\s+", "%");
System.out.println("DAO IMPL"+senderType+":"+query);
	//	if(senderType.equalsIgnoreCase("CONTRACT")){

			Query res=sessionFactory.getCurrentSession().createQuery("from ContractMaster where upper(contract_no) like '%"+query.toUpperCase()+"%'");

			for (Iterator<ContractMaster> it = res.iterate(); it.hasNext();) {
				ContractMaster data=it.next();
				String temp=data.getContract_no().trim()+":"+data.getContract_desc().trim();
				ll.add(temp);
			}

			Query res1=sessionFactory.getCurrentSession().createQuery("from ContractMaster where upper(contract_desc) like '%"+query.toUpperCase()+"%'");

			for (Iterator<ContractMaster> it = res1.iterate(); it.hasNext();) {
				ContractMaster data=it.next();
				String temp=data.getContract_no().trim()+":"+data.getContract_desc().trim();
				ll1.add(temp);
			}
			ll.addAll(ll1);
	//	}
	//	else{
	//		return ll;
	//	}
	
		return ll;

	}
	@Override
	public List<String> getSiteDetails(String contractNo) {

		System.out.println("??????????????????????????????????????");
		Query query =sessionFactory.getCurrentSession().createSQLQuery("SELECT SITE_NO from TB_SS_CONTRACT_MST where CONTRACT_NO='"+contractNo+"' ");
		List ls=query.list();
		
			return ls;
	}
	@Override
	public Set<String> getRigList(String senderType,String query) {
		Set <String>ll=new HashSet<String>();

		query = query.trim().replaceAll("\\s+", "%");

			Query res=sessionFactory.getCurrentSession().createQuery("from RigDetail where upper(rig_sl_no) like '%"+query.toUpperCase()+"%'");

			for (Iterator<RigDetail> it = res.iterate(); it.hasNext();) {
				RigDetail data=it.next();
				String temp=data.getRig_sl_no().trim()+":"+data.getRig_name().trim();
				ll.add(temp);
			}

		return ll;
	}
	
	@Override
	public Set<String> getPileDetails(String senderType,String query) {
		Set <String>ll=new HashSet<String>();
		Set <String>ll1=new HashSet<String>();

		query = query.trim().replaceAll("\\s+", "%");




			Query res=sessionFactory.getCurrentSession().createQuery("from PileDetail where upper(pile_no) like '%"+query.toUpperCase()+"%'");

			for (Iterator<PileDetail> it = res.iterate(); it.hasNext();) {
				PileDetail data=it.next();
				String temp=data.getPile_no().trim();
				ll.add(temp);
			}


	

	
		return ll;
	}
	
	@Override
	public List<PileMasterBean> getPileDetails(String pileNo) {
		List<PileMasterBean>  lis=new ArrayList<PileMasterBean>();
		List <PileDetail> query=sessionFactory.getCurrentSession().createQuery("from PileDetail where  pile_no='"+pileNo+"'").list();
		 for(PileDetail res : query){
			 PileMasterBean bean=new PileMasterBean();
			 bean.setSite_no(res.getSite_no());
			 bean.setPile_no(res.getPile_no());
			 bean.setPile_dia(res.getPile_dia());
			 bean.setDrawing_no(res.getDrawing_no());
			 bean.setCage_length(res.getCage_length());
			 bean.setConcrete_volume(res.getConcrete_volume());
			 bean.setContract_no(res.getContract_no());
			 bean.setBoring_length(res.getBoring_length());
			 bean.setCage_detail(res.getCage_detail());
			 
			 lis.add(bean);
		 }
			return lis;
	}
	@Override
	public void saveDetail(PilingRigProgressForm pilingRigProgressForm) {
		Session session = sessionFactory.getCurrentSession();
	//	Transaction trn=session.beginTransaction();
		List<IdleTime> it0 = pilingRigProgressForm.getIdleTimes();


			PilingRigIdleTime table0=new PilingRigIdleTime();
			try{
			table0.setIdle_date( pilingRigProgressForm.getDataDate());
			}
			catch(Exception e){}
			table0.setRig_no(pilingRigProgressForm.getRig_no());
			String  hourStart0=pilingRigProgressForm.getIdleHour();
			String minuteStart0 = pilingRigProgressForm.getIdleMinute();
			table0.setPiling_rig_idle_time_start(hourStart0+":"+minuteStart0);
			String  hourEnd0=pilingRigProgressForm.getIdleHourEnd();
			String minuteEnd0 = pilingRigProgressForm.getIdleMinuteEnd();
			table0.setPiling_rig_idle_time_end(hourEnd0+":"+minuteEnd0);
			table0.setReason(pilingRigProgressForm.getIdleReason());
			table0.setSl_no( pilingRigProgressForm.getDataDate().toString()+pilingRigProgressForm.getRig_no()+hourStart0+":"+minuteStart0+hourEnd0+":"+minuteEnd0+0);
			session.save(table0);

		
	//	
		List<IdleTime> it = pilingRigProgressForm.getIdleTimes();
		int k=1;
		for (IdleTime idleTime : it) {

			PilingRigIdleTime table=new PilingRigIdleTime();
			try{
			table.setIdle_date( pilingRigProgressForm.getDataDate());
			}
			catch(Exception e){}
			table.setRig_no(pilingRigProgressForm.getRig_no());
			String  hourStart=idleTime.getIdleHourStart();
			String minuteStart = idleTime.getIdleMinuteStart();
			table.setPiling_rig_idle_time_start(hourStart+":"+minuteStart);
			String  hourEnd=idleTime.getIdleHourEnd();
			String minuteEnd = idleTime.getIdleMinuteEnd();
			table.setPiling_rig_idle_time_end(hourEnd+":"+minuteEnd);
			table.setReason(pilingRigProgressForm.getIdleReason());
			table.setSl_no( pilingRigProgressForm.getDataDate().toString()+pilingRigProgressForm.getRig_no()+hourStart+":"+minuteStart+hourEnd+":"+minuteEnd+k);
			session.save(table);
			k++;
		}
		//
		PilingRigBreakdownTime table1=new PilingRigBreakdownTime();
		try{
		table1.setBreakdown_date( pilingRigProgressForm.getDataDate());
		}
		catch(Exception e){}
		table1.setRig_no(pilingRigProgressForm.getRig_no());
		String  hourStart1=pilingRigProgressForm.getBreakdownHour();
		String minuteStart1 = pilingRigProgressForm.getBreakdownMinute();
		table1.setPiling_rig_breakdown_time_start(hourStart1+":"+minuteStart1);
		String  hourEnd1=pilingRigProgressForm.getBreakdownHourEnd();
		String minuteEnd1 = pilingRigProgressForm.getBreakdownMinuteEnd();
		table1.setPiling_rig_breakdown_time_end(hourEnd1+":"+minuteEnd1);
		table1.setDetails(pilingRigProgressForm.getBreakdownDetails());
		table1.setSl_no( pilingRigProgressForm.getDataDate().toString()+pilingRigProgressForm.getRig_no()+hourStart1+":"+minuteStart1+hourEnd1+":"+minuteEnd1+0);
		session.save(table1);
		//
		List<BreakdownTime> bt = pilingRigProgressForm.getBreakdownTimes();
		int j=1;
		for (BreakdownTime breakdownTime : bt) {

			PilingRigBreakdownTime table=new PilingRigBreakdownTime();
			try{
			table.setBreakdown_date(pilingRigProgressForm.getDataDate());
			}
			catch(Exception e){}
			table.setRig_no(pilingRigProgressForm.getRig_no());
			String  hourStart=breakdownTime.getBreakdownHourStart();
			String minuteStart = breakdownTime.getBreakdownMinuteStart();
			table.setPiling_rig_breakdown_time_start(hourStart+":"+minuteStart);
			String  hourEnd=breakdownTime.getBreakdownHourEnd();
			String minuteEnd = breakdownTime.getBreakdownMinuteEnd();
			table.setPiling_rig_breakdown_time_end(hourEnd+":"+minuteEnd);
			table.setDetails(pilingRigProgressForm.getBreakdownDetails());
			table.setSl_no( pilingRigProgressForm.getDataDate().toString()+pilingRigProgressForm.getRig_no()+hourStart+":"+minuteStart+hourEnd+":"+minuteEnd+j);
			session.save(table);
			j++;
		}
		
		//
		PilingRigMovementTime table2=new PilingRigMovementTime();
		try{
		table2.setMovement_date( pilingRigProgressForm.getDataDate());
		}
		catch(Exception e){}
		table2.setRig_no(pilingRigProgressForm.getRig_no());
		String  hourStart2=pilingRigProgressForm.getMovementHour();
		String minuteStart2 = pilingRigProgressForm.getMovementMinute();
		table2.setPiling_rig_movement_time_start(hourStart2+":"+minuteStart1);
		String  hourEnd2=pilingRigProgressForm.getBreakdownHourEnd();
		String minuteEnd2 = pilingRigProgressForm.getBreakdownMinuteEnd();
		table2.setPiling_rig_movement_time_end(hourEnd2+":"+minuteEnd2);
		table2.setFrom_pile(pilingRigProgressForm.getFrom_pile());
		table2.setTo_pile(pilingRigProgressForm.getTo_pile());
		table2.setSl_no( pilingRigProgressForm.getDataDate().toString()+pilingRigProgressForm.getRig_no()+hourStart2+":"+minuteStart2+hourEnd2+":"+minuteEnd2+0);
		session.save(table2);
		//
		List<MovementTime> mt = pilingRigProgressForm.getMovementTimes();
		int i=1;
		for (MovementTime movementTime : mt) {

			PilingRigMovementTime table=new PilingRigMovementTime();
			try{
			table.setMovement_date(pilingRigProgressForm.getDataDate());
			}
			catch(Exception e){}
			table.setRig_no(pilingRigProgressForm.getRig_no());
			String  hourStart=movementTime.getMovementHourStart();
			String minuteStart = movementTime.getMovementMinuteStart();
			table.setPiling_rig_movement_time_start(hourStart+":"+minuteStart);
			String  hourEnd=movementTime.getMovementHourEnd();
			String minuteEnd = movementTime.getMovementMinuteEnd();
			table.setPiling_rig_movement_time_end(hourEnd+":"+minuteEnd);
			table.setFrom_pile(movementTime.getFrom_pile());
			table.setTo_pile(movementTime.getTo_pile());
			table.setSl_no( pilingRigProgressForm.getDataDate().toString()+pilingRigProgressForm.getRig_no()+hourStart+":"+minuteStart+hourEnd+":"+minuteEnd+i);
			session.save(table);
			i++;
		}
	}
}
