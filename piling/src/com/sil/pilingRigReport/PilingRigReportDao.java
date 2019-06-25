package com.sil.pilingRigReport;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public interface PilingRigReportDao {
    public Connection getConnectionDB() throws SQLException;

	    public void callProcedureDataIntoTemp(String var1, Date var2, Date var3, String var4);
}
