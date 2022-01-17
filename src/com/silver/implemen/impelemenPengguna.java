package com.silver.implemen;

import com.silver.dao.DaoPengguna;
import com.silver.dao.ErrorInfo;
import com.silver.data.Pegawai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class impelemenPengguna implements DaoPengguna {
  private Connection con;
  
  private final String insert = "INSERT INTO pengguna(id_pengguna,password,nama_pegawai,role,jumlah)VALUES (?,?,?,?,?)";
  
  private final String update = "UPDATE pengguna  SET password=?, nama_pegawai=?, role=? WHERE  id_pengguna=?";
  
  private final String delete = "DELETE FROM pengguna WHERE id_pengguna=?";
  
  private final String selectAll = "select *from pengguna ";
  
  private final String getById = "SELECT * FROM pengguna WHERE id_pengguna=?";
  
  private final String selectAlldua = "select *from pengguna Where role = '2' ";
  
  private final String selectCount = "SELECT COUNT(*)+role FROM pengguna WHERE id_pengguna=? AND password=?";
  
  public impelemenPengguna(Connection con) {
    this.con = con;
  }
  
  public void insertPengguna(Pegawai pegawai) throws ErrorInfo {
    PreparedStatement statement = null;
    try {
      this.con.setAutoCommit(false);
      statement = this.con.prepareStatement("INSERT INTO pengguna(id_pengguna,password,nama_pegawai,role,jumlah)VALUES (?,?,?,?,?)");
      statement.setString(1, pegawai.getUser_name());
      statement.setString(2, pegawai.getPassword());
      statement.setString(3, pegawai.getNama_pegawai());
      statement.setString(4, pegawai.getRole());
      statement.setDouble(5, pegawai.getJumlah().doubleValue());
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
  
  public void updatePengguna(Pegawai pegawai) throws ErrorInfo {
    PreparedStatement statement = null;
    try {
      this.con.setAutoCommit(false);
      statement = this.con.prepareStatement("UPDATE pengguna  SET password=?, nama_pegawai=?, role=? WHERE  id_pengguna=?");
      statement.setString(1, pegawai.getPassword());
      statement.setString(2, pegawai.getNama_pegawai());
      statement.setString(3, pegawai.getRole());
      statement.setString(4, pegawai.getUser_name());
      statement.setDouble(5, pegawai.getJumlah().doubleValue());
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
  
  public void deletePengguna(String id_pengguna) throws ErrorInfo {
    PreparedStatement statement = null;
    try {
      this.con.setAutoCommit(false);
      statement = this.con.prepareStatement("DELETE FROM pengguna WHERE id_pengguna=?");
      statement.setString(1, id_pengguna);
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
  
  public List<Pegawai> selectAll() throws ErrorInfo {
    Statement statement = null;
    List<Pegawai> list = new ArrayList<>();
    try {
      this.con.setAutoCommit(false);
      statement = this.con.createStatement();
      ResultSet result = statement.executeQuery("select *from pengguna ");
      while (result.next()) {
        Pegawai pegawai = new Pegawai();
        pegawai.setUser_name(result.getString("user_name"));
        pegawai.setPassword(result.getString("password"));
        pegawai.setNama_pegawai(result.getString("nama_pengguna"));
        list.add(pegawai);
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
  
  public List<Pegawai> selectAll(String nama_pengguna) throws ErrorInfo {
    Statement statement = null;
    List<Pegawai> list = new ArrayList<>();
    try {
      this.con.setAutoCommit(false);
      statement = this.con.createStatement();
      ResultSet result = 
        statement.executeQuery("SELECT *FROM pengguna where nama_pegawai like'%" + 
          
          nama_pengguna + "%" + "'" + ";");
      while (result.next()) {
        Pegawai pegawai = new Pegawai();
        pegawai.setUser_name(result.getString("id_pengguna"));
        pegawai.setPassword(result.getString("password"));
        pegawai.setNama_pegawai(result.getString("nama_pegawai"));
        pegawai.setRole(result.getString("role"));
        pegawai.setJumlah(Double.valueOf(result.getDouble("jumlah")));
        list.add(pegawai);
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
  
  public Pegawai getAdmin(int id_admin) throws ErrorInfo {
    PreparedStatement statement = null;
    try {
      this.con.setAutoCommit(false);
      statement = this.con.prepareStatement("SELECT * FROM pengguna WHERE id_pengguna=?");
      statement.setInt(1, id_admin);
      ResultSet result = statement.executeQuery();
      Pegawai admin = null;
      if (result.next()) {
        admin = new Pegawai();
        admin.setUser_name(result.getString("username"));
        admin.setPassword(result.getString("password"));
        admin.setNama_pegawai(result.getString("nama_pegawai"));
        admin.setRole(result.getString("role"));
      } else {
        throw new ErrorInfo("Data user dengan id " + id_admin + " tidak ditemukan");
      } 
      this.con.commit();
      return admin;
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
  
  public int selectCount(Pegawai pegawai) throws ErrorInfo {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    int rowCount = 0;
    try {
      this.con.setAutoCommit(false);
      statement = this.con.prepareStatement("SELECT COUNT(*)+role FROM pengguna WHERE id_pengguna=? AND password=?");
      statement.setString(1, pegawai.getUser_name());
      statement.setString(2, pegawai.getPassword());
      resultSet = statement.executeQuery();
      this.con.commit();
      while (resultSet.next())
        rowCount = resultSet.getInt(1); 
    } catch (SQLException exception) {
      try {
        this.con.rollback();
      } catch (SQLException sQLException) {}
      throw new ErrorInfo(exception.getMessage());
    } finally {
      try {
        this.con.setAutoCommit(true);
        if (resultSet != null)
          resultSet.close(); 
      } catch (SQLException sQLException) {}
      if (statement != null)
        try {
          statement.close();
        } catch (SQLException sQLException) {} 
    } 
    return rowCount;
  }
  
  public List<Pegawai> selectAllDua() throws ErrorInfo {
    Statement statement = null;
    List<Pegawai> list = new ArrayList<>();
    try {
      this.con.setAutoCommit(false);
      statement = this.con.createStatement();
      ResultSet result = statement.executeQuery("select *from pengguna Where role = '2' ");
      while (result.next()) {
        Pegawai pegawai = new Pegawai();
        pegawai.setUser_name(result.getString("id_pengguna"));
        pegawai.setPassword(result.getString("password"));
        pegawai.setNama_pegawai(result.getString("nama_pegawai"));
        pegawai.setRole(result.getString("role"));
        pegawai.setJumlah(Double.valueOf(result.getDouble("jumlah")));
        list.add(pegawai);
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
