package com.silver.implemen;

import com.silver.dao.DaoPelanggan;
import com.silver.dao.ErrorInfo;
import com.silver.data.Pelanggan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class implemenPelanggan implements DaoPelanggan {
  private Connection con;
  
  private final String getById = "SELECT * FROM pelanggan WHERE id=?";
  
  private final String insert1 = "INSERT INTO pelanggan(id,nama,hp,poin)VALUES (?,?,?,?)";
  
  private final String updatePelanggan = "UPDATE pelanggan SET nama=?,hp=?, poin=? WHERE id=?";
  
  private final String selectAll = "select *from pelanggan order by nama";
  
  private final String deletPelanggan = "DELETE FROM pelanggan WHERE id=?";
  
  public implemenPelanggan(Connection con) {
    this.con = con;
  }
  
  public void insertPelanggan(Pelanggan paramPelanggan) throws ErrorInfo {
    PreparedStatement statement = null;
    try {
      this.con.setAutoCommit(false);
      statement = this.con.prepareStatement("INSERT INTO pelanggan(id,nama,hp,poin)VALUES (?,?,?,?)");
      statement.setString(1, paramPelanggan.getId_pelanggan());
      statement.setString(2, paramPelanggan.getNama_pelanggan());
      statement.setString(3, paramPelanggan.getNo_hp());
      statement.setDouble(4, paramPelanggan.getPoin());
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
  
  public void updatePelanggan(Pelanggan paramPelanggan) throws ErrorInfo {
    PreparedStatement statement = null;
    try {
      this.con.setAutoCommit(false);
      statement = this.con.prepareStatement("UPDATE pelanggan SET nama=?,hp=?,poin=? WHERE id=?");
      statement.setString(1, paramPelanggan.getNama_pelanggan());
      statement.setString(2, paramPelanggan.getNo_hp());
      statement.setDouble(3, paramPelanggan.getPoin());
      statement.setString(4, paramPelanggan.getId_pelanggan());
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
  
  public List<Pelanggan> selectAllpelanggan() throws ErrorInfo {
    Statement statement = null;
    List<Pelanggan> list = new ArrayList<>();
    try {
      this.con.setAutoCommit(false);
      statement = this.con.createStatement();
      ResultSet result = 
        statement.executeQuery("SELECT *FROM pelanggan order by poin desc");
      while (result.next()) {
        Pelanggan pelanggan = new Pelanggan();
        pelanggan.setId_pelanggan(result.getNString("id"));
        pelanggan.setNama_pelanggan(result.getString("nama"));
        pelanggan.setNo_hp(result.getString("hp"));
        pelanggan.setPoin(result.getDouble("poin"));
        list.add(pelanggan);
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
  
  public List<Pelanggan> cariPelanggan(String paramString) throws ErrorInfo {
    Statement statement = null;
    List<Pelanggan> list = new ArrayList<>();
    try {
      this.con.setAutoCommit(false);
      statement = this.con.createStatement();
      ResultSet result = 
        statement.executeQuery("SELECT *FROM pelanggan where nama like'" + 
          paramString + "%" + "'" + ";");
      while (result.next()) {
        Pelanggan pelanggan = new Pelanggan();
        pelanggan.setId_pelanggan(result.getNString("id"));
        pelanggan.setNama_pelanggan(result.getString("nama"));
        pelanggan.setNo_hp(result.getString("hp"));
        pelanggan.setPoin(result.getDouble("poin"));
        pelanggan.setUang(result.getDouble("uang"));
        list.add(pelanggan);
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
  
  public List<Pelanggan> cariPelangganKode(String paramString) throws ErrorInfo {
    return null;
  }
  
  public void deletePelanggan(String paramString) throws ErrorInfo {
    PreparedStatement statement = null;
    try {
      this.con.setAutoCommit(false);
      statement = this.con.prepareStatement("DELETE FROM pelangan WHERE id=?");
      statement.setString(1, paramString);
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
  
  public Pelanggan getPelanggan(String paramString) throws ErrorInfo {
    return null;
  }
}
