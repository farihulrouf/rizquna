package com.silver.con2;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.silver.dao.DaoCetakUlang;
import com.silver.implemen.ImplemenCetakUlang;
import java.sql.Connection;
import java.sql.SQLException;

public class MappingCetak {
  private static Connection connection;
  
  private static DaoCetakUlang dao;
  
  public static Connection getConnection() throws SQLException {
    if (connection == null) {
      MysqlDataSource dataSource = new MysqlDataSource();

      //dataSource.setUrl("jdbc:mysql://localhost:3306/rizqy");
      dataSource.setUrl("jdbc:mysql://192.168.1.40:3306/rizky");
      dataSource.setUser("root");
      dataSource.setPassword("");
      connection = dataSource.getConnection();
    } 
    return connection;
  }
  
  public static DaoCetakUlang getDaoCetakUlang() throws SQLException {
    if (dao == null)
      dao = (DaoCetakUlang)new ImplemenCetakUlang(getConnection()); 
    return dao;
  }
}
