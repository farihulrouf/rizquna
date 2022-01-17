package com.silver.data;

public class detail_jual {
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
  
  public Double getHarga_jual() {
    return this.harga_jual;
  }
  
  public void setHarga_jual(double harga_jual) {
    this.harga_jual = Double.valueOf(harga_jual);
  }
  
  public String toString() {
    return "detail_jual [id_jual=" + this.id_jual + ", harga_jual=" + this.harga_jual + 
      ", jumlah=" + this.jumlah + ", kode_barang=" + this.kode_barang + "]";
  }
}
