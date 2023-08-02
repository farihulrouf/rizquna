package com.silver.con2;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.silver.dao.DaoJual;
import com.silver.implemen.implemenJual;
import java.sql.Connection;
import java.sql.SQLException;

public class MappingJual {
  private static Connection connection;
  
  private static DaoJual dao;
  
  public static Connection getConnection() throws SQLException {
    if (connection == null) {
      MysqlDataSource dataSource = new MysqlDataSource();

      //dataSource.setUrl("jdbc:mysql://192.168.1.10:3306/rizqy");
      dataSource.setUrl("jdbc:mysql://localhost:3306/toko");
      dataSource.setUser("root");
      dataSource.setPassword("");
      connection = dataSource.getConnection();
    } 
    return connection;
  }
  
  public static DaoJual getDaoJual() throws SQLException {
    if (dao == null)
      dao = (DaoJual)new implemenJual(getConnection()); 
    return dao;
  }
}
