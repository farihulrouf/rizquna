package com.silver.con2;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.silver.dao.DaoHasilPerjam;
import com.silver.implemen.implemenLaporanPerjam;
import java.sql.Connection;
import java.sql.SQLException;

public class MappingLaporanJam {
  private static Connection connection;
  
  private static DaoHasilPerjam dao;
  
  public static Connection getConnection() throws SQLException {
    if (connection == null) {
      MysqlDataSource dataSource = new MysqlDataSource();

      //dataSource.setUrl("jdbc:mysql://192.168.1.10:3306/rizqy");
      dataSource.setUrl("jdbc:mysql://localhost:3306/rizqy");
      dataSource.setUser("root");
      dataSource.setPassword("");
      connection = dataSource.getConnection();
    } 
    return connection;
  }
  
  public static DaoHasilPerjam getDaoHasilPerjam() throws SQLException {
    if (dao == null)
      dao = (DaoHasilPerjam)new implemenLaporanPerjam(getConnection()); 
    return dao;
  }
}
