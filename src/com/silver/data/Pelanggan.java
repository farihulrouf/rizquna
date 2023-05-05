package com.silver.data;

public class Pelanggan {
  private String id_pelanggan;
  
  private String nama_pelanggan;
  
  private String no_hp;
  
  private Double poin;
  
  public String getId_pelanggan() {
    return this.id_pelanggan;
  }
  
  public void setId_pelanggan(String id_pelanggan) {
    this.id_pelanggan = id_pelanggan;
  }
  
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
  
  
  public boolean equals(Object obj) {
    if (this == obj)
      return true; 
    if (obj == null)
      return false; 
    if (getClass() != obj.getClass())
      return false; 
    Pelanggan other = (Pelanggan)obj;
    if (this.id_pelanggan == null) {
      if (other.id_pelanggan != null)
        return false; 
    } else if (!this.id_pelanggan.equals(other.id_pelanggan)) {
      return false;
    } 
    if (this.nama_pelanggan == null) {
      if (other.nama_pelanggan != null)
        return false; 
    } else if (!this.nama_pelanggan.equals(other.nama_pelanggan)) {
      return false;
    } 
    if (this.no_hp == null) {
      if (other.no_hp != null)
        return false; 
    } else if (!this.no_hp.equals(other.no_hp)) {
      return false;
    } 
    if (this.poin != other.poin)
      return false; 
    return true;
  }
}
