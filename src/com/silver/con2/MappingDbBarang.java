package com.silver.con2;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.silver.dao.DaoBarang;
import com.silver.implemen.implemenBarang;
import java.sql.Connection;
import java.sql.SQLException;

public class MappingDbBarang {
  private static Connection connection;
  
  private static DaoBarang dao;
  
  public static Connection getConnection() throws SQLException {
    if (connection == null) {
      MysqlDataSource dataSource = new MysqlDataSource();

      //dataSource.setUrl("jdbc:mysql://192.168.1.10:3306/rizqy");
      dataSource.setUrl("jdbc:mysql://localhost:3306/rizky");

      //dataSource.setUrl("jdbc:mysql://localhost:3306/rizqy");
      dataSource.setUser("root");
      dataSource.setPassword("");
      connection = dataSource.getConnection();
    } 
    return connection;
  }
  
  public static DaoBarang getDaoBarang() throws SQLException {
    if (dao == null)
      dao = (DaoBarang)new implemenBarang(getConnection()); 
    return dao;
  }
}
