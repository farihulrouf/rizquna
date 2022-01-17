package com.silver.data;

public class Pegawai {
  private String user_name;
  
  private String password;
  
  private String role;
  
  private Double jumlah;
  
  private String nama_pegawai;
  
  public Double getJumlah() {
    return this.jumlah;
  }
  
  public void setJumlah(Double jumlah) {
    this.jumlah = jumlah;
  }
  
  public String getRole() {
    return this.role;
  }
  
  public void setRole(String role) {
    this.role = role;
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
  
  public String getNama_pegawai() {
    return this.nama_pegawai;
  }
  
  public void setNama_pegawai(String nama_pegawai) {
    this.nama_pegawai = nama_pegawai;
  }
  
  public int hashCode() {
    int prime = 31;
    int result = 1;
    result = 31 * result + ((this.jumlah == null) ? 0 : this.jumlah.hashCode());
    result = 31 * result + (
      (this.nama_pegawai == null) ? 0 : this.nama_pegawai.hashCode());
    result = 31 * result + (
      (this.password == null) ? 0 : this.password.hashCode());
    result = 31 * result + ((this.role == null) ? 0 : this.role.hashCode());
    result = 31 * result + (
      (this.user_name == null) ? 0 : this.user_name.hashCode());
    return result;
  }
  
  public boolean equals(Object obj) {
    if (this == obj)
      return true; 
    if (obj == null)
      return false; 
    if (getClass() != obj.getClass())
      return false; 
    Pegawai other = (Pegawai)obj;
    if (this.jumlah == null) {
      if (other.jumlah != null)
        return false; 
    } else if (!this.jumlah.equals(other.jumlah)) {
      return false;
    } 
    if (this.nama_pegawai == null) {
      if (other.nama_pegawai != null)
        return false; 
    } else if (!this.nama_pegawai.equals(other.nama_pegawai)) {
      return false;
    } 
    if (this.password == null) {
      if (other.password != null)
        return false; 
    } else if (!this.password.equals(other.password)) {
      return false;
    } 
    if (this.role == null) {
      if (other.role != null)
        return false; 
    } else if (!this.role.equals(other.role)) {
      return false;
    } 
    if (this.user_name == null) {
      if (other.user_name != null)
        return false; 
    } else if (!this.user_name.equals(other.user_name)) {
      return false;
    } 
    return true;
  }
}
