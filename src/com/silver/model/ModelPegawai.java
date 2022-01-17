package com.silver.model;

import com.silver.con2.AdminDatabase;
import com.silver.dao.DaoPengguna;
import com.silver.dao.ErrorInfo;
import com.silver.data.Pegawai;
import java.sql.SQLException;

public class ModelPegawai {
  private String nama_pegawai;
  
  private String user_name;
  
  private String password;
  
  private String role;
  
  private Double jumlah;
  
  public Double getJumlah() {
    return this.jumlah;
  }
  
  public void setJumlah(Double jumlah) {
    this.jumlah = jumlah;
  }
  
  public String getNama_pegawai() {
    return this.nama_pegawai;
  }
  
  public void setNama_pegawai(String nama_pegawai) {
    this.nama_pegawai = nama_pegawai;
  }
  
  public String getUser_name() {
    return this.user_name;
  }
  
  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }
  
  public String getPassword() {
    return this.password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public String getRole() {
    return this.role;
  }
  
  public void setRole(String role) {
    this.role = role;
  }
  
  public void insertPegawai() throws SQLException, ErrorInfo {
    DaoPengguna dao = AdminDatabase.getDaoPengguna();
    Pegawai pegawai = new Pegawai();
    pegawai.setNama_pegawai(this.nama_pegawai);
    pegawai.setPassword(this.password);
    pegawai.setRole(this.role);
    pegawai.setUser_name(this.user_name);
    pegawai.setJumlah(Double.valueOf(0.0D));
    dao.insertPengguna(pegawai);
  }
  
  public void updatePegawai() throws SQLException, ErrorInfo {
    DaoPengguna dao = AdminDatabase.getDaoPengguna();
    Pegawai pegawai = new Pegawai();
    pegawai.setNama_pegawai(this.nama_pegawai);
    pegawai.setPassword(this.password);
    pegawai.setRole(this.role);
    pegawai.setUser_name(this.user_name);
    pegawai.setJumlah(Double.valueOf(0.0D));
    dao.updatePengguna(pegawai);
  }
  
  public void deletePegawai() throws SQLException, ErrorInfo {
    DaoPengguna dao = AdminDatabase.getDaoPengguna();
    dao.deletePengguna(this.user_name);
  }
}
