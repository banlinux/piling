package com.sil.pilingRigReport;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository
public class PilingRigReportImpl implements PilingRigReportDao {

    private DataSource dataSource;
    private SessionFactory sessionFactory;

    public Connection getConnectionDB() throws SQLException {
        return this.dataSource.getConnection();
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public void callProcedureDataIntoTemp(String var1, Date var2, Date var3, String var4) {
		// TODO Auto-generated method stub
		
	}

}
