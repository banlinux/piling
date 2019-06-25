/**
 * 
 */
package com.sil.util;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.pdf.PdfPCell;

import com.sil.master.district.DistrictMasterBean;
import com.sil.master.region.RegionMasterBean;
import com.sil.master.state.StateMasterBean;
import com.sil.pilingRigProgress.PilingRigProgressForm;
import com.sil.pilingRigReport.PilingRigReportBean;


public interface CommonFunctionDao {
	 public Date getCurrentDate();
	 public  Date getDate(Date date);
	 public  String getDateString(Date date);
	 public Date getDateFromString(String date) throws Exception;
	
	 public Map getDepartmentDetails();
	 public Map getEmployeeDetails(String code);
	// public Map contractDetails();
	
	 public Map<Integer,String> getCountryMap();
	 public List <RegionMasterBean> getRegionMap(String countryCode);
	 public List<StateMasterBean> getStateDetails(String regionCode);
	 public List<DistrictMasterBean> getDistrictDetails(String stateCode);
	 public Map<String, String> getDepartmentMap();
	 public Long getBillNext();
	 public void headerCellStyle(PdfPCell cell);
	 public  void labelCellStyle(PdfPCell cell);
	 public void valueCellStyle(PdfPCell cell);
	 
	 
	 /******************pilingMilan *********************/
	 public Map<String, String> getZoneMap();
	 public List<PilingRigProgressForm> getSiteMap(String zoneCode);
	 public List<PilingRigProgressForm> getContractDetails(String siteCode);
	 public List<PilingRigReportBean> getContractDetails();
}
