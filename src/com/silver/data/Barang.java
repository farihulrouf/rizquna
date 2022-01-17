package com.silver.data;

public class Barang {
  private String id_barang;
  
  private String nama_barang;
  
  private double harga_beli;
  
  private String satuan;
  
  private double harga_diskon;
  
  private double harga_jual;
  
  private double harga_lain;
  
  private int id_kategori;
  
  private int persediaan;
  
  private int balance;
  
  private int mindiskon;
  
  private int mindiskon2;
  
  private int poin;
  
  public int getPoin() {
    return this.poin;
  }
  
  public void setPoin(int poin) {
    this.poin = poin;
  }
  
  public int hashCode() {
    int prime = 31;
    int result = 1;
    result = 31 * result + this.balance;
    long temp = Double.doubleToLongBits(this.harga_beli);
    result = 31 * result + (int)(temp ^ temp >>> 32L);
    temp = Double.doubleToLongBits(this.harga_diskon);
    result = 31 * result + (int)(temp ^ temp >>> 32L);
    temp = Double.doubleToLongBits(this.harga_jual);
    result = 31 * result + (int)(temp ^ temp >>> 32L);
    temp = Double.doubleToLongBits(this.harga_lain);
    result = 31 * result + (int)(temp ^ temp >>> 32L);
    result = 31 * result + ((this.id_barang == null) ? 0 : this.id_barang.hashCode());
    result = 31 * result + this.id_kategori;
    result = 31 * result + this.mindiskon;
    result = 31 * result + this.mindiskon2;
    result = 31 * result + ((this.nama_barang == null) ? 0 : this.nama_barang.hashCode());
    result = 31 * result + this.persediaan;
    result = 31 * result + this.poin;
    result = 31 * result + ((this.satuan == null) ? 0 : this.satuan.hashCode());
    return result;
  }
  
  public boolean equals(Object obj) {
    if (this == obj)
      return true; 
    if (obj == null)
      return false; 
    if (getClass() != obj.getClass())
      return false; 
    Barang other = (Barang)obj;
    if (this.balance != other.balance)
      return false; 
    if (Double.doubleToLongBits(this.harga_beli) != Double.doubleToLongBits(other.harga_beli))
      return false; 
    if (Double.doubleToLongBits(this.harga_diskon) != Double.doubleToLongBits(other.harga_diskon))
      return false; 
    if (Double.doubleToLongBits(this.harga_jual) != Double.doubleToLongBits(other.harga_jual))
      return false; 
    if (Double.doubleToLongBits(this.harga_lain) != Double.doubleToLongBits(other.harga_lain))
      return false; 
    if (this.id_barang == null) {
      if (other.id_barang != null)
        return false; 
    } else if (!this.id_barang.equals(other.id_barang)) {
      return false;
    } 
    if (this.id_kategori != other.id_kategori)
      return false; 
    if (this.mindiskon != other.mindiskon)
      return false; 
    if (this.mindiskon2 != other.mindiskon2)
      return false; 
    if (this.nama_barang == null) {
      if (other.nama_barang != null)
        return false; 
    } else if (!this.nama_barang.equals(other.nama_barang)) {
      return false;
    } 
    if (this.persediaan != other.persediaan)
      return false; 
    if (this.poin != other.poin)
      return false; 
    if (this.satuan == null) {
      if (other.satuan != null)
        return false; 
    } else if (!this.satuan.equals(other.satuan)) {
      return false;
    } 
    return true;
  }
  
  public String getId_barang() {
    return this.id_barang;
  }
  
  public void setId_barang(String id_barang) {
    this.id_barang = id_barang;
  }
  
  public String getNama_barang() {
    return this.nama_barang;
  }
  
  public void setNama_barang(String nama_barang) {
    this.nama_barang = nama_barang;
  }
  
  public double getHarga_beli() {
    return this.harga_beli;
  }
  
  public void setHarga_beli(double harga_beli) {
    this.harga_beli = harga_beli;
  }
  
  public String getSatuan() {
    return this.satuan;
  }
  
  public void setSatuan(String satuan) {
    this.satuan = satuan;
  }
  
  public double getHarga_diskon() {
    return this.harga_diskon;
  }
  
  public void setHarga_diskon(double harga_diskon) {
    this.harga_diskon = harga_diskon;
  }
  
  public double getHarga_jual() {
    return this.harga_jual;
  }
  
  public void setHarga_jual(double harga_jual) {
    this.harga_jual = harga_jual;
  }
  
  public double getHarga_lain() {
    return this.harga_lain;
  }
  
  public void setHarga_lain(double harga_lain) {
    this.harga_lain = harga_lain;
  }
  
  public int getId_kategori() {
    return this.id_kategori;
  }
  
  public void setId_kategori(int id_kategori) {
    this.id_kategori = id_kategori;
  }
  
  public int getPersediaan() {
    return this.persediaan;
  }
  
  public void setPersediaan(int persediaan) {
    this.persediaan = persediaan;
  }
  
  public int getBalance() {
    return this.balance;
  }
  
  public void setBalance(int balance) {
    this.balance = balance;
  }
  
  public int getMindiskon() {
    return this.mindiskon;
  }
  
  public void setMindiskon(int mindiskon) {
    this.mindiskon = mindiskon;
  }
  
  public int getMindiskon2() {
    return this.mindiskon2;
  }
  
  public void setMindiskon2(int mindiskon2) {
    this.mindiskon2 = mindiskon2;
  }
}
