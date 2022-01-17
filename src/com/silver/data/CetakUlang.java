package com.silver.data;

public class CetakUlang {
  private int id_jual;
  
  private String nama_barang;
  
  private Double total;
  
  private Double harga_jual;
  
  private int qty;
  
  private String kode_barang;
  
  private String jam;
  
  public String getJam() {
    return this.jam;
  }
  
  public void setJam(String jam) {
    this.jam = jam;
  }
  
  public int getId_jual() {
    return this.id_jual;
  }
  
  public void setId_jual(int id_jual) {
    this.id_jual = id_jual;
  }
  
  public String getNama_barang() {
    return this.nama_barang;
  }
  
  public void setNama_barang(String nama_barang) {
    this.nama_barang = nama_barang;
  }
  
  public Double getTotal() {
    return this.total;
  }
  
  public void setTotal(Double total) {
    this.total = total;
  }
  
  public Double getHarga_jual() {
    return this.harga_jual;
  }
  
  public void setHarga_jual(Double harga_jual) {
    this.harga_jual = harga_jual;
  }
  
  public int getQty() {
    return this.qty;
  }
  
  public void setQty(int qty) {
    this.qty = qty;
  }
  
  public String getKode_barang() {
    return this.kode_barang;
  }
  
  public void setKode_barang(String kode_barang) {
    this.kode_barang = kode_barang;
  }
}
