package com.silver.implemen;

import com.silver.dao.DaoBarang;
import com.silver.dao.ErrorInfo;
import com.silver.data.Barang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class implemenBarang implements DaoBarang {
  private Connection con;
  
  private final String getById = "SELECT * FROM Barang WHERE kd_barang=?";
  
  private final String insert1 = "INSERT INTO Barang(kd_barang,nama_barang,harga_beli,harga_jual,harga_diskon,harga_lain,id_kategori,satuan,persediaan,balance,mindiskon,mindiskon2, poins)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
  
  private final String updateBarang = "UPDATE Barang SET nama_barang=?, harga_beli=?,harga_jual=?, harga_diskon=?, harga_lain=?,id_kategori = ?, satuan = ?,persediaan=?,balance=?, mindiskon=?, mindiskon2=?, poins=? WHERE kd_barang=?";
  
  private final String selectAll = "select *from Barang order by nama_barang";
  
  private final String deletBarang = "DELETE FROM Barang WHERE kd_barang=?";
  
  public implemenBarang(Connection con) {
    this.con = con;
  }
  
  public void insertBarang(Barang barang) throws ErrorInfo {
    PreparedStatement statement = null;
    try {
      this.con.setAutoCommit(false);
      statement = this.con.prepareStatement("INSERT INTO Barang(kd_barang,nama_barang,harga_beli,harga_jual,harga_diskon,harga_lain,id_kategori,satuan,persediaan,balance,mindiskon,mindiskon2, poins)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
      statement.setString(1, barang.getId_barang());
      statement.setString(2, barang.getNama_barang());
      statement.setDouble(3, barang.getHarga_beli());
      statement.setDouble(4, barang.getHarga_jual());
      statement.setDouble(5, barang.getHarga_diskon());
      statement.setDouble(6, barang.getHarga_lain());
      statement.setInt(7, barang.getId_kategori());
      statement.setString(8, barang.getSatuan());
      statement.setInt(9, barang.getPersediaan());
      statement.setInt(10, barang.getBalance());
      statement.setInt(11, barang.getMindiskon());
      statement.setInt(12, barang.getMindiskon2());
      statement.setInt(13, barang.getPoin());
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
  
  public void updateBarang(Barang barang) throws ErrorInfo {
    PreparedStatement statement = null;
    try {
      this.con.setAutoCommit(false);
      statement = this.con.prepareStatement("UPDATE Barang SET nama_barang=?, harga_beli=?,harga_jual=?, harga_diskon=?, harga_lain=?,id_kategori = ?, satuan = ?,persediaan=?,balance=?, mindiskon=?, mindiskon2=?, poins=? WHERE kd_barang=?");
      statement.setString(1, barang.getNama_barang());
      statement.setDouble(2, barang.getHarga_beli());
      statement.setDouble(3, barang.getHarga_jual());
      statement.setDouble(4, barang.getHarga_diskon());
      statement.setDouble(5, barang.getHarga_lain());
      statement.setInt(6, barang.getId_kategori());
      statement.setString(7, barang.getSatuan());
      statement.setInt(8, barang.getPersediaan());
      statement.setInt(9, barang.getBalance());
      statement.setInt(10, barang.getMindiskon());
      statement.setInt(11, barang.getMindiskon2());
      statement.setString(12, barang.getId_barang());
      statement.setInt(13, barang.getPoin());
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
  
  public List<Barang> selectAllbarang() throws ErrorInfo {
    Statement statement = null;
    List<Barang> list = new ArrayList<>();
    try {
      this.con.setAutoCommit(false);
      statement = this.con.createStatement();
      ResultSet result = statement.executeQuery("select *from Barang order by nama_barang");
      while (result.next()) {
        Barang barang = new Barang();
        barang.setId_barang(result.getString("kd_barang"));
        barang.setNama_barang(result.getString("nama_barang"));
        barang.setHarga_beli(result.getDouble("harga_beli"));
        barang.setHarga_jual(result.getDouble("harga_jual"));
        barang.setHarga_diskon(result.getDouble("harga_diskon"));
        barang.setHarga_lain(result.getDouble("harga_lain"));
        barang.setId_kategori(result.getInt("id_kategori"));
        barang.setSatuan(result.getString("satuan"));
        barang.setPersediaan(result.getInt("persediaan"));
        barang.setBalance(result.getInt("balance"));
        barang.setMindiskon(result.getInt("mindiskon"));
        barang.setMindiskon2(result.getInt("mindiskon2"));
        barang.setPoin(result.getInt("poins"));
        list.add(barang);
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
  
  public List<Barang> cariBarang(String kd_barang) throws ErrorInfo {
    Statement statement = null;
    List<Barang> list = new ArrayList<>();
    try {
      this.con.setAutoCommit(false);
      statement = this.con.createStatement();
      ResultSet result = 
        statement.executeQuery("SELECT *FROM Barang where nama_barang like'" + 
          kd_barang + "%" + "'" + ";");
      while (result.next()) {
        Barang barang = new Barang();
        barang.setId_barang(result.getString("kd_barang"));
        barang.setNama_barang(result.getString("nama_barang"));
        barang.setHarga_beli(result.getDouble("harga_beli"));
        barang.setHarga_jual(result.getDouble("harga_jual"));
        barang.setHarga_diskon(result.getDouble("harga_diskon"));
        barang.setHarga_lain(result.getDouble("harga_lain"));
        barang.setId_kategori(result.getInt("id_kategori"));
        barang.setSatuan(result.getString("satuan"));
        barang.setPersediaan(result.getInt("persediaan"));
        barang.setBalance(result.getInt("balance"));
        barang.setMindiskon(result.getInt("mindiskon"));
        barang.setMindiskon2(result.getInt("mindiskon2"));
        barang.setPoin(result.getInt("poins"));
        list.add(barang);
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
  
  public void deleteBarang(String kode_barang) throws ErrorInfo {
    PreparedStatement statement = null;
    try {
      this.con.setAutoCommit(false);
      statement = this.con.prepareStatement("DELETE FROM Barang WHERE kd_barang=?");
      statement.setString(1, kode_barang);
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
  
  public List<Barang> cariBarangKode(String kode_barang) throws ErrorInfo {
    Statement statement = null;
    List<Barang> list = new ArrayList<>();
    try {
      this.con.setAutoCommit(false);
      statement = this.con.createStatement();
      ResultSet result = 
        statement.executeQuery("SELECT *FROM Barang where kd_barang like'%" + 
          
          kode_barang + "%" + "'" + ";");
      while (result.next()) {
        Barang barang = new Barang();
        barang.setId_barang(result.getString("kd_barang"));
        barang.setNama_barang(result.getString("nama_barang"));
        barang.setHarga_beli(result.getDouble("harga_beli"));
        barang.setHarga_jual(result.getDouble("harga_jual"));
        barang.setHarga_diskon(result.getDouble("harga_diskon"));
        barang.setHarga_lain(result.getDouble("harga_lain"));
        barang.setId_kategori(result.getInt("id_kategori"));
        barang.setSatuan(result.getString("satuan"));
        barang.setPersediaan(result.getInt("persediaan"));
        barang.setBalance(result.getInt("balance"));
        barang.setMindiskon(result.getInt("mindiskon"));
        barang.setMindiskon2(result.getInt("mindiskon2"));
        barang.setPoin(result.getInt("poins"));
        list.add(barang);
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
  
  public Barang getBarang(String kode_barang) throws ErrorInfo {
    PreparedStatement statement = null;
    try {
      this.con.setAutoCommit(false);
      statement = this.con.prepareStatement("SELECT * FROM Barang WHERE kd_barang=?");
      statement.setString(1, kode_barang);
      ResultSet result = statement.executeQuery();
      Barang barang = null;
      if (result.next()) {
        barang = new Barang();
        barang.setNama_barang(result.getString("nama_barang"));
        barang.setHarga_beli(result.getDouble("harga_beli"));
        barang.setHarga_jual(result.getDouble("harga_jual"));
        barang.setHarga_diskon(result.getDouble("harga_diskon"));
        barang.setHarga_lain(result.getDouble("harga_lain"));
        barang.setId_kategori(result.getInt("id_kategori"));
        barang.setSatuan(result.getString("satuan"));
        barang.setPersediaan(result.getInt("persediaan"));
        barang.setBalance(result.getInt("balance"));
        barang.setMindiskon(result.getInt("mindiskon"));
        barang.setMindiskon2(result.getInt("mindiskon2"));
        barang.setPoin(result.getInt("poins"));
        System.out.println("Barang di temukan");
      } else {
        throw new ErrorInfo("Barang dengan id " + kode_barang + " tidak ditemukan");
      } 
      this.con.commit();
      return barang;
    } catch (SQLException exception) {
      try {
        this.con.setAutoCommit(true);
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
