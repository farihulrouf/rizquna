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
    //int no_jual = getNo_transaksi();
    //int id_jual = view.getNo_jual();
	  System.out.println("cetak this one"+view.nomer_transaksi);
    String id_jual_nama = "yuli";
    for (int i = 0; i < view.table.getRowCount(); i++) {
      this.model.setId_jual(view.nomer_transaksi);
      this.model.setKode_barang((String)view.tableModel.getValueAt(i, 0));
      this.model.setJumlah(Integer.parseInt(
            view.tableModel.getValueAt(i, 3)
            .toString().trim()));
      this.model.setHarga_jual(
          Double.parseDouble((
            (String)view.tableModel.getValueAt(i, 4)).replace(",", "")));
      /*
      this.model.setPoin(
              Double.parseDouble((
                (String)view.getTable()
                .getValueAt(i, 3)).replace(",", "")));
     /* System.out.println(Double.parseDouble((
            (String)view.getTable()
            .getValueAt(i, 2)).replace(",", "")));
      */
      /*
      System.out.println("test detail jual");

      System.out.println(no_jual);
      System.out.println((String)view.getTable().getValueAt(i, 0));
      System.out.println(Integer.parseInt( view.getTable().getValueAt(i, 4) .toString().trim()));
      System.out.println(Double.parseDouble(((String)view.getTable().getValueAt(i, 3)).replace(",", "")));
      */
      
      try {
        this.model.insertDetailJual();
      } catch (Throwable throwable) {
        JOptionPane.showMessageDialog((Component)view, new Object[] { "Terjadi error di database dengan pesan", 
              throwable.getMessage() });
      } 
    } 
  }
}
