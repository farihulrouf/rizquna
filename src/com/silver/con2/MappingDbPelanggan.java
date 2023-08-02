package com.silver.con2;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.silver.dao.DaoPelanggan;
import com.silver.implemen.implemenPelanggan;
import java.sql.Connection;
import java.sql.SQLException;

public class MappingDbPelanggan {
  private static Connection connection;
  
  private static DaoPelanggan dao;
  
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
  
  public static DaoPelanggan getDaoPelanggan() throws SQLException {
    if (dao == null)
      dao = (DaoPelanggan)new implemenPelanggan(getConnection()); 
    return dao;
  }
}
