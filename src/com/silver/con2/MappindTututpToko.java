package com.silver.con2;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.silver.dao.DaoTutupToko;
import com.silver.implemen.implemenTutup;
import java.sql.Connection;
import java.sql.SQLException;

public class MappindTututpToko {
  private static Connection connection;
  
  private static DaoTutupToko dao;
  
  public static Connection getConnection() throws SQLException {
    if (connection == null) {
      MysqlDataSource dataSource = new MysqlDataSource();

      //dataSource.setUrl("jdbc:mysql://192.168.1.10:3306/rizqy");
      dataSource.setUrl("jdbc:mysql://192.168.1.40:3306/rizky");
      dataSource.setUser("root");
      dataSource.setPassword("");
      connection = dataSource.getConnection();
    } 
    return connection;
  }
  
  public static DaoTutupToko getDaoTutupToko() throws SQLException {
    if (dao == null)
      dao = (DaoTutupToko)new implemenTutup(getConnection()); 
    return dao;
  }
}
