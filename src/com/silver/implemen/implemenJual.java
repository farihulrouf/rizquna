package com.silver.implemen;

import com.silver.dao.DaoJual;
import com.silver.dao.ErrorInfo;
import com.silver.data.Jual;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class implemenJual implements DaoJual {
  private Connection con;
  
  public implemenJual(Connection con) {
    this.con = con;
  }
  
  public void insertJual(Jual jual) throws ErrorInfo {
    PreparedStatement statement = null;
    try {
      this.con.setAutoCommit(false);
      statement = this.con.prepareStatement("INSERT INTO jual(id_jual,tanggal,id_kasir,no_transaksi,tunai,total,jam, poin, nama)VALUES (?,?,?,?,?,?,?,?,?)");
      statement.setInt(1, jual.getId_jual());
      statement.setDate(2, new Date(jual.getTanggal().getTime()));
      statement.setString(3, jual.getId_user());
      statement.setInt(4, jual.getNo());
      statement.setDouble(5, jual.getTunai().doubleValue());
      statement.setDouble(6, jual.getTotal().doubleValue());
      statement.setString(7, jual.getJam());
      statement.setInt(8, jual.getPoin());
      statement.setString(9, jual.getNama());
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
  
  public List<Jual> CariNotmerTransaksi(String nomer) throws ErrorInfo {
    Statement statement = null;
    List<Jual> list = new ArrayList<>();
    try {
      this.con.setAutoCommit(false);
      statement = this.con.createStatement();
      ResultSet result = 
        statement.executeQuery("SELECT *FROM jual where tanggal=curdate() AND no_transaksi like'" + 
          nomer + "%" + "'" + ";");
      while (result.next()) {
        Jual jual = new Jual();
        jual.setId_jual(result.getInt("id_jual"));
        jual.setTanggal(result.getDate("tanggal"));
        jual.setId_user(result.getString("id_kasir"));
        jual.setNo(result.getInt("no_transaksi"));
        jual.setTunai(Double.valueOf(result.getDouble("tunai")));
        jual.setTotal(Double.valueOf(result.getDouble("total")));
        jual.setJam(result.getString("jam"));
        jual.setPoin(result.getInt("poin"));
        jual.setNama(result.getString("nama"));
        list.add(jual);
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
  
  public List<Jual> TampilkanReport() throws ErrorInfo {
    return null;
  }
  
  public List<Jual> TampilkanPerjam() throws ErrorInfo {
    return null;
  }
  
  public List<Jual> TampilkanTanggal(String tanggal) throws ErrorInfo {
    Statement statement = null;
    List<Jual> list = new ArrayList<>();
    try {
      this.con.setAutoCommit(false);
      statement = this.con.createStatement();
      ResultSet result = 
        statement.executeQuery("SELECT *FROM jual where tanggal='" + 
          tanggal + "'" + ";");
      while (result.next()) {
        Jual jual = new Jual();
        jual.setId_jual(result.getInt("id_jual"));
        jual.setTanggal(result.getDate("tanggal"));
        jual.setId_user(result.getString("id_kasir"));
        jual.setNo(result.getInt("no_transaksi"));
        jual.setTunai(Double.valueOf(result.getDouble("tunai")));
        jual.setTotal(Double.valueOf(result.getDouble("total")));
        jual.setJam(result.getString("jam"));
        jual.setPoin(result.getInt("poin"));
        jual.setNama(result.getString("nama"));
        list.add(jual);
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
  
  public List<Jual> TampilkanPerPc() throws ErrorInfo {
    Statement statement = null;
    List<Jual> list = new ArrayList<>();
    try {
      this.con.setAutoCommit(false);
      statement = this.con.createStatement();
      ResultSet result = 
        statement.executeQuery("SELECT *select id_kasir,sum(total) as total from jual where tanggal=curdate() GROUP by id_kasir ;");
      while (result.next()) {
        Jual jual = new Jual();
        jual.setId_jual(result.getInt("id_jual"));
        jual.setTanggal(result.getDate("tanggal"));
        jual.setId_user(result.getString("id_kasir"));
        jual.setNo(result.getInt("no_transaksi"));
        jual.setTunai(Double.valueOf(result.getDouble("tunai")));
        jual.setTotal(Double.valueOf(result.getDouble("total")));
        jual.setJam(result.getString("jam"));
        jual.setPoin(result.getInt("poin"));
        jual.setNama(result.getString("nama"));
        list.add(jual);
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
