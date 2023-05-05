package com.silver.controller;

import com.silver.model.ModelJual;
import view.AdminKasir;
import view.Koneksi;
import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControllerJual {
  private ModelJual model;
  
  private int no_trans;
  
  public void setModel(ModelJual model) {
    this.model = model;
  }
  
  public int getNo_trans() {
    return this.no_trans;
  }
  
  public void setNo_trans(int no_trans) {
    this.no_trans = no_trans;
  }
  
  public int autoNumber3() {
    int noPegawai = 0;
    try {
      Connection konek = Koneksi.getKoneksi();
      Statement state = konek.createStatement();
      String query = "SELECT MAX(id_jual) AS nomer FROM jual";
      ResultSet rs = state.executeQuery(query);
      while (rs.next()) {
        if (!rs.first()) {
          noPegawai = 1;
          continue;
        } 
        rs.last();
        noPegawai = rs.getInt(1) + 1;
        String no = String.valueOf(noPegawai);
        System.out.println(no);
      } 
      rs.close();
      state.close();
    } catch (Exception exception) {}
    return noPegawai;
  }
  
  public void insertJuals(AdminKasir view) {
    JTable table = view.getTable();
    int id_juals = view.getNo_jual();
    DateFormat jam = new SimpleDateFormat("HH:mm:ss");
    Date hasil = new Date();
    String jam_skr = jam.format(hasil).toString();
    int xy = autoNumber3();
    setNo_trans(xy);
    if (table.getRowCount() == 0) {
      JOptionPane.showMessageDialog((Component)view, "Maaf Anda Belum Memilih Barang ");
    } else {
      if (view.getNama_pelanggan() == null || view.getNama_pelanggan() == "") {
        this.model.setId_jual(xy);
        this.model.setId_user(view.getUser_name());
        this.model.setTanggal(new Date());
        this.model.setNo(id_juals);
        this.model.setTunai(view.getTunai());
        this.model.setJam(jam_skr);
        this.model.setTotal(Double.valueOf(Math.round(view.getTotal_bayar().doubleValue())));
        this.model.setPoin(0);
        this.model.setNama(" ");
        System.out.println("ok ok sip");
      } else {
        this.model.setId_jual(xy);
        this.model.setId_user(view.getUser_name());
        this.model.setTanggal(new Date());
        this.model.setNo(id_juals);
        this.model.setTunai(view.getTunai());
        this.model.setJam(jam_skr);
        this.model.setTotal(Double.valueOf(Math.round(view.getTotal_bayar().doubleValue())));
        this.model.setPoin(view.getPoin_total_jual());
        this.model.setNama(view.getNama_pelanggan());
      } 
      try {
        this.model.insertJual();
      } catch (Throwable throwable) {
        JOptionPane.showMessageDialog((Component)view, new Object[] { "Terjadi error di databse dengan pesan", 
              throwable.getMessage() });
      } 
    } 
  }
}
