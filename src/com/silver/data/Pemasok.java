package com.silver.data;

public class Pemasok {
  private int id_pemasok;
  
  private String nama_pemasok;
  
  private String kota;
  
  private String phone;
  
  public int hashCode() {
    int prime = 31;
    int result = 1;
    result = 31 * result + this.id_pemasok;
    result = 31 * result + ((this.kota == null) ? 0 : this.kota.hashCode());
    result = 31 * result + (
      (this.nama_pemasok == null) ? 0 : this.nama_pemasok.hashCode());
    result = 31 * result + ((this.phone == null) ? 0 : this.phone.hashCode());
    return result;
  }
  
  public boolean equals(Object obj) {
    if (this == obj)
      return true; 
    if (obj == null)
      return false; 
    if (getClass() != obj.getClass())
      return false; 
    Pemasok other = (Pemasok)obj;
    if (this.id_pemasok != other.id_pemasok)
      return false; 
    if (this.kota == null) {
      if (other.kota != null)
        return false; 
    } else if (!this.kota.equals(other.kota)) {
      return false;
    } 
    if (this.nama_pemasok == null) {
      if (other.nama_pemasok != null)
        return false; 
    } else if (!this.nama_pemasok.equals(other.nama_pemasok)) {
      return false;
    } 
    if (this.phone == null) {
      if (other.phone != null)
        return false; 
    } else if (!this.phone.equals(other.phone)) {
      return false;
    } 
    return true;
  }
  
  public int getId_pemasok() {
    return this.id_pemasok;
  }
  
  public void setId_pemasok(int id_pemasok) {
    this.id_pemasok = id_pemasok;
  }
  
  public String getNama_pemasok() {
    return this.nama_pemasok;
  }
  
  public void setNama_pemasok(String nama_pemasok) {
    this.nama_pemasok = nama_pemasok;
  }
  
  public String getKota() {
    return this.kota;
  }
  
  public void setKota(String kota) {
    this.kota = kota;
  }
  
  public String getPhone() {
    return this.phone;
  }
  
  public void setPhone(String phone) {
    this.phone = phone;
  }
}
