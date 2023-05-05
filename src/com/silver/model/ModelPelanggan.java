package com.silver.model;

import com.silver.con2.MappingDbPelanggan;
import com.silver.dao.DaoPelanggan;
import com.silver.dao.ErrorInfo;
import com.silver.data.Pelanggan;
import java.sql.SQLException;

public class ModelPelanggan {
  private String nama_pelanggan;
  
  private String no_hp;
  
  private Double poin;
  
  private String id_pelanggan;
  
  public String getNama_pelanggan() {
    return this.nama_pelanggan;
  }
  
  public void setNama_pelanggan(String nama_pelanggan) {
    this.nama_pelanggan = nama_pelanggan;
  }
  
  public String getNo_hp() {
    return this.no_hp;
  }
  
  public void setNo_hp(String no_hp) {
    this.no_hp = no_hp;
  }
  
  public Double getPoin() {
    return this.poin;
  }
  
  public void setPoin(Double poin) {
    this.poin = poin;
  }
  
  public String getId_pelanggan() {
    return this.id_pelanggan;
  }
  
  public void setId_pelanggan(String id_pelanggan) {
    this.id_pelanggan = id_pelanggan;
  }
  
  public void insertPelanggan() throws SQLException, ErrorInfo {
    DaoPelanggan dao = MappingDbPelanggan.getDaoPelanggan();
    Pelanggan pelanggan = new Pelanggan();
    pelanggan.setNama_pelanggan(this.nama_pelanggan);
    pelanggan.setNo_hp(this.no_hp);
    pelanggan.setPoin(this.poin);
    pelanggan.setId_pelanggan(this.id_pelanggan);
    dao.insertPelanggan(pelanggan);
  }
  
  public void updatePelanggan() throws SQLException, ErrorInfo {
    DaoPelanggan dao = MappingDbPelanggan.getDaoPelanggan();
    Pelanggan pelanggan = new Pelanggan();
    pelanggan.setNama_pelanggan(this.nama_pelanggan);
    pelanggan.setNo_hp(this.no_hp);
    pelanggan.setPoin(this.poin);
    pelanggan.setId_pelanggan(this.id_pelanggan);
    dao.updatePelanggan(pelanggan);
  }
  
  public void deletePelanggan() throws SQLException, ErrorInfo {
    DaoPelanggan dao = MappingDbPelanggan.getDaoPelanggan();
    dao.deletePelanggan(this.id_pelanggan);
  }
}
