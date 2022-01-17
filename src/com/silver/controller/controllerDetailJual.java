package com.silver.controller;

import com.silver.model.ModelDetailJual;
import view.AdminKasir;
import java.awt.Component;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class controllerDetailJual {
  private int no_transaksi;
  
  private ModelDetailJual model;
  
  public int getNo_transaksi() {
    return this.no_transaksi;
  }
  
  public void setNo_transaksi(int no_transaksi) {
    this.no_transaksi = no_transaksi;
  }
  
  DecimalFormat df = new DecimalFormat("###.#");
  
  public void setModel(ModelDetailJual model) {
    this.model = model;
  }
  
  public void insertDetailJuals(AdminKasir view) {
    int no_jual = getNo_transaksi();
    int id_jual = view.getNo_jual();
    String id_jual_nama = "yuli";
    for (int i = 0; i < view.getTable().getRowCount(); i++) {
      this.model.setId_jual(no_jual);
      this.model.setKode_barang((String)view.getTable().getValueAt(i, 0));
      this.model.setJumlah(Integer.parseInt(
            view.getTable().getValueAt(i, 3)
            .toString().trim()));
      this.model.setHarga_jual(
          Double.parseDouble((
            (String)view.getTable()
            .getValueAt(i, 2)).replace(",", "")));
      System.out.println(Double.parseDouble((
            (String)view.getTable()
            .getValueAt(i, 2)).replace(",", "")));
      try {
        this.model.insertDetailJual();
      } catch (Throwable throwable) {
        JOptionPane.showMessageDialog((Component)view, new Object[] { "Terjadi error di database dengan pesan", 
              throwable.getMessage() });
      } 
    } 
  }
}
