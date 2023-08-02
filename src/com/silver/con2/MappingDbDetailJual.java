package com.silver.con2;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.silver.dao.DaoDetailJual;
import com.silver.implemen.implemenDetailJual;
import java.sql.Connection;
import java.sql.SQLException;

public class MappingDbDetailJual {
  private static Connection connection;
  
  private static DaoDetailJual dao;
  
  public static Connection getConnection() throws SQLException {
    if (connection == null) {
        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/toko");
       // String url = "jdbc:mysql://192.168.1.18:3306/rizky";
        dataSource.setUser("root");
        dataSource.setPassword("");
        connection = dataSource.getConnection();
    } 
    return connection;
  }
  
  public static DaoDetailJual getDaoDetailJual() throws SQLException {
    if (dao == null)
      dao = (DaoDetailJual)new implemenDetailJual(getConnection()); 
    return dao;
  }
}
