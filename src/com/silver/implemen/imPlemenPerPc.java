package com.silver.implemen;

import com.silver.dao.DaoPerPc;
import com.silver.dao.ErrorInfo;
import com.silver.data.TampilkanPerPc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class imPlemenPerPc implements DaoPerPc {
  private Connection con;
  
  private final String selectAll = "select *from perpc";
  
  public imPlemenPerPc(Connection con) {
    this.con = con;
  }
  
  public List<TampilkanPerPc> selectAll() throws ErrorInfo {
    Statement statement = null;
    List<TampilkanPerPc> list = new ArrayList<>();
    try {
      this.con.setAutoCommit(false);
      statement = this.con.createStatement();
      ResultSet result = statement.executeQuery("select *from perpc");
      while (result.next()) {
        TampilkanPerPc tampil = new TampilkanPerPc();
        tampil.setKasir(result.getString("id_kasir"));
        tampil.setTotal(Double.valueOf(result.getDouble("total")));
        list.add(tampil);
      } 
      this.con.commit();
      return list;
    } catch (SQLException exception) {
      try {
        this.con.rollback();
      } catch (SQLException sQLException) {}
      throw new ErrorInfo(exception.getMessage());
    } finally {
      try {
        this.con.setAutoCommit(true);
      } catch (SQLException sQLException) {}
      if (statement != null)
        try {
          statement.close();
        } catch (SQLException sQLException) {} 
    } 
  }
}
