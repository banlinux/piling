/**
 * 
 */
package com.sil.util;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.DbTimestampType;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
import com.sil.databasemodel.ContractMaster;
import com.sil.databasemodel.CountryMaster;

import com.sil.databasemodel.DepartmentMasterDetail;

import com.sil.databasemodel.DistrictMaster;
import com.sil.databasemodel.EmployeeMasterDetail;
import com.sil.databasemodel.RegionMaster;
import com.sil.databasemodel.SiteMaster;
import com.sil.databasemodel.StateMaster;
import com.sil.master.district.DistrictMasterBean;
import com.sil.master.region.RegionMasterBean;
import com.sil.master.state.StateMasterBean;
import com.sil.pilingRigProgress.PilingRigProgressForm;
import com.sil.databasemodel.ZoneMaster;
import com.sil.pilingRigReport.PilingRigReportBean;

@Transactional
@Repository
public class CommonFunctionImpl implements CommonFunctionDao{
	
	SessionFactory sessionFactory;

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Date getCurrentDate(){
		Date date = new Date();
		try{

			org.hibernate.type.DbTimestampType type = new DbTimestampType();
			System.out.println("Ajax Handler3");
		//	date = (Date) type.seed((SessionImplementor)sessionFactory.getCurrentSession());	
		}catch(Exception ex){
			ex.printStackTrace();
		}
			return getDate(date);
	}
	
	/*
	 * get date with  dd-MM-yyy format
	 */
	@Override
	public  Date getDate(Date date){

		try{
			if(date==null)
				return null;
			else{
				DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
				return df.parse(df.format(date));
			}
		}catch(ParseException dfe){
			dfe.printStackTrace();
		}
		return null;		
	}
	
	/*
	 * get the date as a string with dd-MM-yyy format
	 */
	@Override
	public  String getDateString(Date date){
		try{
			if(date==null)
				return null;
			else{
				DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
				return df.format(date);
			}
		}catch(Exception dfe){
			dfe.printStackTrace();
		}
		return null;		
	}
	
	@Override
	public Date getDateFromString(String date) throws Exception{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
		return df.parse(date);
	}
	


	@Override
	public Map getDepartmentDetails() {
		Map <String, String>map=new LinkedHashMap<String, String>();	
		List<DepartmentMasterDetail> res=	sessionFactory.getCurrentSession().createQuery(" from DepartmentMasterDetail").list();
		for(DepartmentMasterDetail data : res){
			map.put(data.getDeptcd(),"("+data.getDeptcd()+"):"+ data.getDepartmentName());
		}
		return map;
	}
	@Override
	public Map getEmployeeDetails(String code) {
		Map <String, String>map=new LinkedHashMap<String, String>();	
		List<EmployeeMasterDetail> res=	sessionFactory.getCurrentSession().createQuery(" from EmployeeMasterDetail where DEPTCD ='"+code+"'").list();
		for(EmployeeMasterDetail data : res){
			map.put(data.getEmpcd(), data.getEmpname());
		}
		return map;
	}

/*	@Override
	public Map contractDetails() {
		Map <String, String>map=new LinkedHashMap<String, String>();
		List<ContractMaster>  res=	sessionFactory.getCurrentSession().createQuery(" from ContractMaster").list();
		for(ContractMaster data:res){
			map.put(data.getContcd(), data.getContcd()+"--"+data.getContname());
		}
		return map;
	}
*/	



	@Override
	public Map<Integer, String> getCountryMap() {
		Map <Integer, String>map=new LinkedHashMap<Integer, String>();
		List <CountryMaster>list=sessionFactory.getCurrentSession().createQuery("from CountryMaster where del_flag='N'").list();
		for(CountryMaster res:list){
			map.put(res.getCountry_code(), res.getCountry_name());
		}
		return map;
	}
	
	@Override
	public List <RegionMasterBean> getRegionMap(String countryCode) {
		
		List <RegionMasterBean> data=new ArrayList<RegionMasterBean>();
		List <RegionMaster>list=sessionFactory.getCurrentSession().createQuery("from RegionMaster where country_code="+countryCode+" and del_flag='N'").list();
		for(RegionMaster res:list){
			RegionMasterBean bean=new RegionMasterBean();
			bean.setRegionCode(res.getRegion_code());
			bean.setRegionName(res.getRegion_name());
			data.add(bean);
		}
		return data;
	}

	@Override
	public List<StateMasterBean> getStateDetails(String regionCode) {
		List <StateMasterBean> data=new ArrayList<StateMasterBean>();
		List <StateMaster>list=sessionFactory.getCurrentSession().createQuery("from StateMaster where region_code="+regionCode+" and del_flag='N'").list();
		for(StateMaster res:list){
			StateMasterBean bean=new StateMasterBean();
			bean.setStateCode(res.getState_code());
			bean.setStateName(res.getState_name());
			data.add(bean);
		}
		return data;
	}

	@Override
	public List<DistrictMasterBean> getDistrictDetails(String stateCode) {
		List <DistrictMasterBean> data=new ArrayList<DistrictMasterBean>();
		List <DistrictMaster>list=sessionFactory.getCurrentSession().createQuery("from DistrictMaster where state_code="+stateCode+" and del_flag='N'").list();
		for(DistrictMaster res:list){
			DistrictMasterBean bean=new DistrictMasterBean();
			bean.setDistrictCode(res.getDistrict_code());
			bean.setDistrictName(res.getDistrict_name());
			data.add(bean);
		}
		return data;
	}
	
	@Override
	public Map<String, String> getDepartmentMap() {
		Map <String, String>map=new LinkedHashMap<String, String>();
		List <DepartmentMasterDetail>list=sessionFactory.getCurrentSession().createQuery("from DepartmentMasterDetail where activeind='Y'").list();
		for(DepartmentMasterDetail res:list){
			map.put(res.getDeptcd(), res.getDepartmentName());
		}
		return map;
	}
	
	
	public Long getBillNext() {
	    Query query = 
	    	sessionFactory.getCurrentSession().createSQLQuery("select BILL_DOC_NUMBER.nextval as num from dual")
	            .addScalar("num", StandardBasicTypes.BIG_INTEGER);

	    return ((BigInteger) query.uniqueResult()).longValue();
	}

	@Override
	public void headerCellStyle(PdfPCell cell){
		 
	    // alignment
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	 
	    // padding
	    cell.setPaddingTop(0f);
	    cell.setPaddingBottom(7f);
	 
	    // background color
	    cell.setBackgroundColor(new BaseColor(0,121,182));
	 
	    // border
	    cell.setBorder(0);
	    cell.setBorderWidthBottom(2f);
	 
	}
	@Override
	public  void labelCellStyle(PdfPCell cell){
	    // alignment
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	    // padding
	    cell.setPadding (2.0f);
	    //cell.setPaddingLeft(3f);
	    //cell.setPaddingTop(0f);
	 
	    // background color
	    //cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	    cell.setBackgroundColor (new BaseColor (255, 200, 0));
	}
	@Override 
	public void valueCellStyle(PdfPCell cell){
	    // alignment
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	    // padding
	    cell.setPadding (2.0f);
	}
	 /******************pilingMilan *********************/
	
	 @Override
	 public Map<String, String> getZoneMap(){
		 
			Map <String, String>map=new LinkedHashMap<String, String>();
			List <ZoneMaster>list=sessionFactory.getCurrentSession().createQuery("from ZoneMaster where status='Y'").list();
			for(ZoneMaster res:list){
				map.put(res.getZone_no(), res.getZone_desc());
			}
			return map;
		}
	 
		@Override
		public List<PilingRigProgressForm> getSiteMap(String zoneCode) {
			List <PilingRigProgressForm> data=new ArrayList<PilingRigProgressForm>();
			List <SiteMaster>list=sessionFactory.getCurrentSession().createQuery("from SiteMaster where zone_no="+zoneCode+" and site_active='Y'").list();
			for(SiteMaster res:list){
				PilingRigProgressForm bean=new PilingRigProgressForm();
				bean.setSiteCode(res.getSite_no());
				bean.setSiteName(res.getSite_desc());
				data.add(bean);
			}
			return data;
		}
		@Override
		public List<PilingRigProgressForm> 	getContractDetails(String siteCode) {
			List <PilingRigProgressForm> data=new ArrayList<PilingRigProgressForm>();
			System.out.println("Impl");
			List <ContractMaster>list=sessionFactory.getCurrentSession().createQuery("from ContractMaster where site_no='"+siteCode+"'").list();
			for(ContractMaster res:list){
				PilingRigProgressForm bean=new PilingRigProgressForm();
				bean.setContractCode(res.getContract_no());
				bean.setContractName(res.getContract_desc());
				System.out.println(res.getContract_no()+res.getContract_desc());
				data.add(bean);
			}
			return data;
		}
		@Override
		public List<PilingRigReportBean> 	getContractDetails() {
			List <PilingRigReportBean> data=new ArrayList<PilingRigReportBean>();
			System.out.println("Impl");
			List <ContractMaster>list=sessionFactory.getCurrentSession().createQuery("from ContractMaster ").list();
			for(ContractMaster res:list){
				PilingRigReportBean bean=new PilingRigReportBean();
				bean.setContract_no(res.getContract_no());
				System.out.println(res.getContract_no()+res.getContract_desc());
				data.add(bean);
			}
			return data;
		}
}
