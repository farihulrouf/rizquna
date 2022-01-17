package com.silver.model;

import com.silver.con2.MappingDbBarang;
import com.silver.dao.DaoBarang;
import com.silver.dao.ErrorInfo;
import com.silver.dao.listenerBarang;
import com.silver.data.Barang;
import java.sql.SQLException;

public class ModelBarang {
  private listenerBarang listener;
  
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
  
  public listenerBarang getListener() {
    return this.listener;
  }
  
  public void setListener(listenerBarang listener) {
    this.listener = listener;
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
  
  public void insertBrang() throws SQLException, ErrorInfo {
    DaoBarang dao = MappingDbBarang.getDaoBarang();
    Barang barang = new Barang();
    barang.setId_barang(this.id_barang);
    barang.setNama_barang(this.nama_barang);
    barang.setHarga_beli(this.harga_beli);
    barang.setHarga_jual(this.harga_jual);
    barang.setHarga_diskon(this.harga_diskon);
    barang.setHarga_lain(this.harga_lain);
    barang.setId_kategori(this.id_kategori);
    barang.setSatuan("PCS");
    barang.setPersediaan(this.persediaan);
    barang.setBalance(this.balance);
    barang.setMindiskon(0);
    barang.setMindiskon2(0);
    barang.setPoin(this.poin);
    dao.insertBarang(barang);
    fireOnInsert(barang);
  }
  
  public int getPoin() {
    return this.poin;
  }
  
  public void setPoin(int poin) {
    this.poin = poin;
  }
  
  public void updateBrang() throws SQLException, ErrorInfo {
    DaoBarang dao = MappingDbBarang.getDaoBarang();
    Barang barang = new Barang();
    barang.setId_barang(this.id_barang);
    barang.setNama_barang(this.nama_barang);
    barang.setHarga_beli(this.harga_beli);
    barang.setHarga_jual(this.harga_jual);
    barang.setHarga_diskon(this.harga_diskon);
    barang.setHarga_lain(this.harga_lain);
    barang.setId_kategori(this.id_kategori);
    barang.setSatuan("PCS");
    barang.setPersediaan(this.persediaan);
    barang.setBalance(this.balance);
    barang.setMindiskon(0);
    barang.setMindiskon2(0);
    barang.setPoin(this.poin);
    dao.updateBarang(barang);
    fireOnUpdate(barang);
  }
  
  public void deleteBarang() throws SQLException, ErrorInfo {
    DaoBarang dao = MappingDbBarang.getDaoBarang();
    dao.deleteBarang(this.id_barang);
    fireOndelete();
  }
  
  public void fireOnchange() {
    if (this.listener != null)
      this.listener.onChange(this); 
  }
  
  public void fireOndelete() {
    if (this.listener != null)
      this.listener.onDelete(); 
  }
  
  public void fireOnInsert(Barang barang) {
    if (this.listener != null)
      this.listener.onInser(barang); 
  }
  
  public void fireOnUpdate(Barang barang) {
    if (this.listener != null)
      this.listener.onUpdate(barang); 
  }
}
