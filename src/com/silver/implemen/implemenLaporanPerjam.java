package com.silver.implemen;

import com.silver.dao.DaoHasilPerjam;
import com.silver.dao.ErrorInfo;
import com.silver.data.JamLaporan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class implemenLaporanPerjam implements DaoHasilPerjam {
  private final String selectAll = " select id_kasir, sum(total) as total, hour(jam) as jam from cetak_ulang where tanggal = curdate()  GROUP by hour(jam),id_kasir";
  
  private final String selectAlls = "select id_kasir,sum(total) as total, hour(jam) as jam from cetak_ulang  where tanggal = curdate() && id_kasir='wati' GROUP by hour(jam)";
  
  private final String selectAlls2 = "select id_kasir,sum(total) as total, hour(jam) as jam from cetak_ulang  where tanggal = curdate() && id_kasir='reni' GROUP by hour(jam)";
  
  private Connection con;
  
  public implemenLaporanPerjam(Connection con) {
    this.con = con;
  }
  
  public List<JamLaporan> selectAll() throws ErrorInfo {
    Statement statement = null;
    List<JamLaporan> list = new ArrayList<>();
    try {
      this.con.setAutoCommit(false);
      statement = this.con.createStatement();
      ResultSet result = statement.executeQuery("select id_kasir,sum(total) as total, hour(jam) as jam from cetak_ulang  where tanggal = curdate() && id_kasir='wati' GROUP by hour(jam)");
      while (result.next()) {
        JamLaporan jam = new JamLaporan();
        jam.setJam(result.getString("jam"));
        jam.setNama_komputer(result.getString("id_kasir"));
        jam.setTotal(Double.valueOf(result.getDouble("total")));
        list.add(jam);
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
  
  public List<JamLaporan> selectAlldua() throws ErrorInfo {
    Statement statement = null;
    List<JamLaporan> list = new ArrayList<>();
    try {
      this.con.setAutoCommit(false);
      statement = this.con.createStatement();
      ResultSet result = statement.executeQuery("select id_kasir,sum(total) as total, hour(jam) as jam from cetak_ulang  where tanggal = curdate() && id_kasir='reni' GROUP by hour(jam)");
      while (result.next()) {
        JamLaporan jam = new JamLaporan();
        jam.setJam(result.getString("jam"));
        jam.setNama_komputer(result.getString("id_kasir"));
        jam.setTotal(Double.valueOf(result.getDouble("total")));
        list.add(jam);
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
  
  public List<JamLaporan> pilihTanggal(String dari, String ke) throws ErrorInfo {
    String querysatu = "SELECT id_kasir,total,jam, tanggal FROM `jual` WHERE tanggal=CURRENT_DATE";
    Statement statement = null;
    List<JamLaporan> list = new ArrayList<>();
    try {
      this.con.setAutoCommit(false);
      statement = this.con.createStatement();
      ResultSet result = statement.executeQuery(querysatu);
      while (result.next()) {
        JamLaporan jam = new JamLaporan();
        jam.setJam(result.getString("jam"));
        jam.setNama_komputer(result.getString("id_kasir"));
        jam.setTotal(Double.valueOf(result.getDouble("total")));
        list.add(jam);
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
  
  public List<JamLaporan> pilihTanggal2(String dari, String ke) throws ErrorInfo {
    String querysatu = "SELECT id_kasir,total,jam, tanggal FROM `jual` WHERE tanggal=CURRENT_DATE";
    Statement statement = null;
    List<JamLaporan> list = new ArrayList<>();
    try {
      this.con.setAutoCommit(false);
      statement = this.con.createStatement();
      ResultSet result = statement.executeQuery(querysatu);
      while (result.next()) {
        JamLaporan jam = new JamLaporan();
        jam.setJam(result.getString("jam"));
        jam.setNama_komputer(result.getString("id_kasir"));
        jam.setTotal(Double.valueOf(result.getDouble("total")));
        list.add(jam);
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
