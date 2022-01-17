package com.silver.data;

public class Harga {
  private String nama_harga;
  
  private static Double harga_jual;
  
  public String getNama_harga() {
    return this.nama_harga;
  }
  
  public void setNama_harga(String nama_harga) {
    this.nama_harga = nama_harga;
  }
  
  public static Double getHarga_jual() {
    return harga_jual;
  }
  
  public static void setHarga_jual(Double harga_jual) {
    harga_jual = Harga.harga_jual;
  }
}
