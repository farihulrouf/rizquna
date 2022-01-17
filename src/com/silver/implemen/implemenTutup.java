package com.silver.implemen;

import com.silver.dao.DaoTutupToko;
import com.silver.dao.ErrorInfo;
import com.silver.data.tutup_toko;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class implemenTutup implements DaoTutupToko {
  private Connection con;
  
  private final String insert = "INSERT INTO tutup_toko(no,tanggal,jam,hasil,jumlah)VALUES (?,?,?,?,?)";
  
  private final String selectAll = "select *From total_hasil where id_kasir='wati' AND tanggal=curdate()";
  
  private final String selectAlls = "select *From total_hasil where id_kasir='reni' AND tanggal=curdate()";
  
  public implemenTutup(Connection con) {
    this.con = con;
  }
  
  public List<tutup_toko> selectAllbarang() throws ErrorInfo {
    Statement statement = null;
    List<tutup_toko> list = new ArrayList<>();
    try {
      this.con.setAutoCommit(false);
      statement = this.con.createStatement();
      ResultSet result = statement.executeQuery("select *From total_hasil where id_kasir='wati' AND tanggal=curdate()");
      while (result.next()) {
        tutup_toko toko = new tutup_toko();
        toko.setTanggal(result.getDate("tanggal"));
        toko.setJam(result.getString("jam"));
        toko.setTotal(Double.valueOf(result.getDouble("total")));
        list.add(toko);
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
  
  public void insertBarang(tutup_toko toko) throws ErrorInfo {
    PreparedStatement statement = null;
    try {
      this.con.setAutoCommit(false);
      statement = this.con.prepareStatement("INSERT INTO tutup_toko(no,tanggal,jam,hasil,jumlah)VALUES (?,?,?,?,?)");
      statement.setInt(1, toko.getNo_tutup());
      statement.setDate(2, new Date(toko.getTanggal().getTime()));
      statement.setString(3, toko.getJam());
      statement.setInt(5, toko.getTransaksi());
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
  
  public List<tutup_toko> selectTutup(String no) throws ErrorInfo {
    Statement statement = null;
    String selecte = "select *from total_hasil where tanggal = curdate() - " + no + ";";
    List<tutup_toko> list = new ArrayList<>();
    try {
      this.con.setAutoCommit(false);
      statement = this.con.createStatement();
      ResultSet result = statement.executeQuery(selecte);
      while (result.next()) {
        tutup_toko toko = new tutup_toko();
        toko.setTanggal(result.getDate("tanggal"));
        toko.setJam(result.getString("jam"));
        toko.setTotal(Double.valueOf(result.getDouble("total")));
        list.add(toko);
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
  
  public List<tutup_toko> selectDari(String tanggal1, String tanggal2) throws ErrorInfo {
    Statement statement = null;
    String id_kasir = "id_kasir";
    String selecte = "select tanggal, id_kasir, sum(total) as total from jual where jam <= \"12:00:00\" AND tanggal = '" + 
      tanggal2 + "'" + "group by id_kasir;";
    List<tutup_toko> list = new ArrayList<>();
    try {
      this.con.setAutoCommit(false);
      statement = this.con.createStatement();
      ResultSet result = statement.executeQuery(selecte);
      while (result.next()) {
        tutup_toko toko = new tutup_toko();
        toko.setTanggal(result.getDate("tanggal"));
        toko.setId_kasir(result.getString("id_kasir"));
        toko.setTotal(Double.valueOf(result.getDouble("total")));
        list.add(toko);
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
  
  public List<tutup_toko> select() throws ErrorInfo {
    Statement statement = null;
    List<tutup_toko> list = new ArrayList<>();
    try {
      this.con.setAutoCommit(false);
      statement = this.con.createStatement();
      ResultSet result = statement.executeQuery("select *From jual where id_kasir='eka' AND tanggal=curdate()");
      while (result.next()) {
        tutup_toko toko = new tutup_toko();
        toko.setTanggal(result.getDate("tanggal"));
        toko.setJam(result.getString("jam"));
        toko.setTotal(Double.valueOf(result.getDouble("total")));
        list.add(toko);
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
  
  public List<tutup_toko> selectDari2(String tanggal1, String tanggal2) throws ErrorInfo {
    Statement statement = null;
    String id_kasir = "id_kasir";
    String selecte = "select tanggal, id_kasir, sum(total) as total from jual where jam >= \"12:00:00\" AND tanggal = '" + 
      tanggal2 + "'" + "group by id_kasir;";
    List<tutup_toko> list = new ArrayList<>();
    try {
      this.con.setAutoCommit(false);
      statement = this.con.createStatement();
      ResultSet result = statement.executeQuery(selecte);
      while (result.next()) {
        tutup_toko toko = new tutup_toko();
        toko.setTanggal(result.getDate("tanggal"));
        toko.setId_kasir(result.getString("id_kasir"));
        toko.setTotal(Double.valueOf(result.getDouble("total")));
        list.add(toko);
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
