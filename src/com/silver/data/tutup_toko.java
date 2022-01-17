package com.silver.data;

import java.util.Date;

public class tutup_toko {
  private int no_tutup;
  
  private Double total;
  
  private int transaksi;
  
  private Date tanggal;
  
  private String jam;
  
  private String id_kasir;
  
  public String getId_kasir() {
    return this.id_kasir;
  }
  
  public void setId_kasir(String id_kasir) {
    this.id_kasir = id_kasir;
  }
  
  public Double getTotal() {
    return this.total;
  }
  
  public void setTotal(Double total) {
    this.total = total;
  }
  
  public int getNo_tutup() {
    return this.no_tutup;
  }
  
  public void setNo_tutup(int no_tutup) {
    this.no_tutup = no_tutup;
  }
  
  public int getTransaksi() {
    return this.transaksi;
  }
  
  public void setTransaksi(int transaksi) {
    this.transaksi = transaksi;
  }
  
  public Date getTanggal() {
    return this.tanggal;
  }
  
  public void setTanggal(Date tanggal) {
    this.tanggal = tanggal;
  }
  
  public String getJam() {
    return this.jam;
  }
  
  public void setJam(String jam) {
    this.jam = jam;
  }
}
