package com.silver.data;

import java.util.Date;

public class Jual {
  private int id_jual;
  
  private String id_user;
  
  private Date tanggal;
  
  private int no;
  
  private Double tunai;
  
  private Double total;
  
  private String jam;
  
  private Double poin;
  
  private String nama;
  
  public Double getPoin() {
    return this.poin;
  }
  
  public void setPoin(double poin) {
    this.poin = poin;
  }
  
  public String getNama() {
    return this.nama;
  }
  
  public void setNama(String nama) {
    this.nama = nama;
  }
  
  public String getJam() {
    return this.jam;
  }
  
  public void setJam(String jam) {
    this.jam = jam;
  }
  
  public Double getTotal() {
    return this.total;
  }
  
  public void setTotal(Double total) {
    this.total = total;
  }
  
  public Double getTunai() {
    return this.tunai;
  }
  
  public void setTunai(Double tunai) {
    this.tunai = tunai;
  }
  
  public int getNo() {
    return this.no;
  }
  
  public void setNo(int no) {
    this.no = no;
  }
  
  public int getId_jual() {
    return this.id_jual;
  }
  
  public void setId_jual(int id_jual) {
    this.id_jual = id_jual;
  }
  
  public String getId_user() {
    return this.id_user;
  }
  
  public void setId_user(String id_user) {
    this.id_user = id_user;
  }
  
  public Date getTanggal() {
    return this.tanggal;
  }
  
  public void setTanggal(Date tanggal) {
    this.tanggal = tanggal;
  }
  

  public boolean equals(Object obj) {
    if (this == obj)
      return true; 
    if (obj == null)
      return false; 
    if (getClass() != obj.getClass())
      return false; 
    Jual other = (Jual)obj;
    if (this.nama == null) {
      if (other.nama != null)
        return false; 
    } else if (!this.nama.equals(other.nama)) {
      return false;
    } 
    if (this.poin != other.poin)
      return false; 
    return true;
  }
}
