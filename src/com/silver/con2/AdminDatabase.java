package com.silver.con2;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.silver.dao.DaoPengguna;
import com.silver.implemen.impelemenPengguna;
import java.sql.Connection;
import java.sql.SQLException;

public class AdminDatabase {
  private static Connection connection;
  
  private static DaoPengguna adminDao;
  
  public static Connection getConnection() throws SQLException {
    if (connection == null) {
      MysqlDataSource dataSource = new MysqlDataSource();

      //dataSource.setUrl("jdbc:mysql://192.168.1.10:3306/rizqy");
      dataSource.setUrl("jdbc:mysql://localhost:3306/rizky");
      dataSource.setUser("root");
      dataSource.setPassword("");
      connection = dataSource.getConnection();
    } 
    return connection;
  }
  
  public static DaoPengguna getDaoPengguna() throws SQLException {
    if (adminDao == null)
      adminDao = (DaoPengguna)new impelemenPengguna(getConnection()); 
    return adminDao;
  }
}
