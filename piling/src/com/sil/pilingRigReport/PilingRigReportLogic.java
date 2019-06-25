package com.sil.pilingRigReport;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sil.pilingRigReport.PilingRigReportDao;
import com.sil.util.CommonFunctionDao;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

@Repository
@Service
public class PilingRigReportLogic {
	private CommonFunctionDao commonFunctionDao;
    private PilingRigReportDao pilingRigReportDao;

    public Connection getConnectionDB() throws SQLException {
        return this.pilingRigReportDao.getConnectionDB();
    }
    public Map getContractDetails() {
        return this.commonFunctionDao.getDepartmentDetails();
    }
    public synchronized String generateReport(PilingRigReportBean bean, HttpServletRequest request) {
 
        String startDate = bean.getStartDate();

        String endDate = bean.getEndDate();
        
        String contract = bean.getContract_no();
        
        String site = bean.getSite_no();
        
        String rig  = bean.getRig_no();
        
        String pile = bean.getPileNo();
        
   
        try {
         //   this.PilingRigReportDao.callProcedureDataIntoTemp(zone, this.getStringToDate(startDate), this.getStringToDate(endDate), status);
            String inFileLocation = request.getSession().getServletContext().getRealPath("in");
            String outFileLocation = request.getSession().getServletContext().getRealPath("out");
            FileInputStream input = new FileInputStream(new File(String.valueOf(inFileLocation) + "/PILING_RIG_PROGERSS.jasper"));

            HashMap<String, Object> mp = new HashMap<String, Object>();
            mp.put("CONTRACT_NO", contract);
            mp.put("SITE_NO", site);
            mp.put("P_FROM_DATE", startDate);
            mp.put("P_TO_DATE", endDate);
            mp.put("PILE_NO", pile);
            mp.put("RIG_NO", rig);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            
    
            long outFile = new Date().getTime();
            String outPutFile = "piling_rig_report_" + outFile + ".xls";
            
            ByteArrayOutputStream outputByteArray = new ByteArrayOutputStream();
            FileOutputStream outputfile = new FileOutputStream(new File(String.valueOf(outFileLocation) + "/" + outPutFile));
            JasperReport report = (JasperReport)JRLoader.loadObject((InputStream)input);
            JasperPrint jasperPrint = JasperFillManager.fillReport((JasperReport)report, mp, (Connection)this.getConnectionDB());
            JRXlsExporter exporterXLS = new JRXlsExporter();
            exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, (Object)jasperPrint);
            exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, (Object)outputByteArray);
            exporterXLS.setParameter((JRExporterParameter)JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, (Object)Boolean.FALSE);
            exporterXLS.setParameter(JRXlsExporterParameter.MAXIMUM_ROWS_PER_SHEET, (Object)Integer.decode("65000"));
            exporterXLS.setParameter((JRExporterParameter)JRXlsExporterParameter.IS_DETECT_CELL_TYPE, (Object)Boolean.TRUE);
            exporterXLS.setParameter((JRExporterParameter)JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, (Object)Boolean.FALSE);
            exporterXLS.setParameter((JRExporterParameter)JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, (Object)Boolean.TRUE);
            exporterXLS.exportReport();
            outputfile.write(outputByteArray.toByteArray());
            System.out.println("Report created");
            exporterXLS = null;
            jasperPrint = null;
            outputByteArray = null;
            
            return outPutFile;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
