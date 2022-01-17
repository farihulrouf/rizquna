package com.silver.implemen;

import com.silver.dao.DaoDetailJual;
import com.silver.dao.ErrorInfo;
import com.silver.data.detail_jual;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class implemenDetailJual implements DaoDetailJual {
  private Connection con;
  
  private final String insert = "INSERT INTO detail_jual(id_jual,kd_barang,harga_jual,jumlah)VALUES (?,?,?,?)";
  
  public implemenDetailJual(Connection con) {
    this.con = con;
  }
  
  public void insertDetailJual(detail_jual detail) throws ErrorInfo {
    PreparedStatement statement = null;
    try {
      this.con.setAutoCommit(false);
      statement = this.con.prepareStatement("INSERT INTO detail_jual(id_jual,kd_barang,harga_jual,jumlah)VALUES (?,?,?,?)");
      statement.setInt(1, detail.getId_jual());
      statement.setString(2, detail.getKode_barang());
      statement.setDouble(3, detail.getHarga_jual().doubleValue());
      statement.setInt(4, detail.getJumlah());
      statement.executeUpdate();
      this.con.commit();
    } catch (SQLException exception) {
      try {
        this.con.rollback();
      } catch (Exception exception1) {}
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
  
  public void deleteDetail_jual(int id_jual, String kd_barang) throws ErrorInfo {
    String deletBarang = "DELETE FROM detail_jual WHERE kd_barang=? AND id_jual=?";
    PreparedStatement statement = null;
    try {
      this.con.setAutoCommit(false);
      statement = this.con.prepareStatement(deletBarang);
      statement.setInt(1, id_jual);
      statement.setString(2, kd_barang);
      statement.executeUpdate();
      this.con.commit();
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
