package com.silver.model;

import com.silver.con2.MappingDbDetailJual;
import com.silver.dao.DaoDetailJual;
import com.silver.dao.ErrorInfo;
import com.silver.data.detail_jual;
import java.sql.SQLException;

public class ModelDetailJual {
  private int id_jual;
  
  private Double harga_jual;
  
  private int jumlah;
  
  private String kode_barang;
  
  public int getId_jual() {
    return this.id_jual;
  }
  
  public void setId_jual(int id_jual) {
    this.id_jual = id_jual;
  }
  
  public Double getHarga_jual() {
    return this.harga_jual;
  }
  
  public void setHarga_jual(double harga_jual) {
    this.harga_jual = Double.valueOf(harga_jual);
  }
  
  public int getJumlah() {
    return this.jumlah;
  }
  
  public void setJumlah(int jumlah) {
    this.jumlah = jumlah;
  }
  
  public String getKode_barang() {
    return this.kode_barang;
  }
  
  public void setKode_barang(String kode_barang) {
    this.kode_barang = kode_barang;
  }
  
  public void insertDetailJual() throws SQLException, ErrorInfo {
    DaoDetailJual dao = MappingDbDetailJual.getDaoDetailJual();
    detail_jual detal = new detail_jual();
    detal.setId_jual(this.id_jual);
    detal.setJumlah(this.jumlah);
    detal.setKode_barang(this.kode_barang);
    detal.setHarga_jual(this.harga_jual.doubleValue());
    dao.insertDetailJual(detal);
  }
  
  public void deleteDetailJual(int id_juals, String kod_barang) throws SQLException, ErrorInfo {
    DaoDetailJual dao = MappingDbDetailJual.getDaoDetailJual();
    dao.deleteDetail_jual(id_juals, kod_barang);
  }
}
