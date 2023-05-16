package com.silver.controller;

import com.silver.model.ModelBarang; 
import view.dialog.viewBarang;
import java.awt.Component;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControllerBarang {
  private ModelBarang model;
  
  public void setModel(ModelBarang model) {
    this.model = model;
  }
  
  public void deleteBarang(viewBarang view) {
    if (view.getTable().getSelectedRowCount() == 0) {
      JOptionPane.showMessageDialog((Component)view, "piih dahulu data yang di hapus");
    } else if (JOptionPane.showConfirmDialog((Component)view, "Anda yakin ingin menghapus data") == 0) {
      this.model.setId_barang(view.getTextField().getText());
      try {
        this.model.deleteBarang();
        JOptionPane.showMessageDialog((Component)view, "data berhasil di hapus");
      } catch (Exception exception) {}
    } 
  }
  
  public void insertBarang(viewBarang view) {
    String harga_jual = view.getTextField_6().getText();
    String id_barang = view.getTextField().getText();
    String nama_barang = view.getTextField_1().getText();
    String jumlah = view.getTextField_9().getText();
    String harga_diskon = view.getTextField_7().getText();
    String harga_lain = view.getTextField_8().getText();
    String harga_beli = view.getTextField_5().getText();
    String persediaan = view.getTextField_9().getText();
    String poin = view.getTextPointField().getText();
    String balance = view.getINputKategori().getText();
    String mdiskon1 = view.getTextField_15().getText();
    String mdiskon2 = view.getTextField_16().getText();
    if (nama_barang.trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Nama tidak boleh kosong");
    } else if (harga_beli.trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Harga Beli masih kosong");
    } else if (harga_jual.trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Harga Jual masih kosong");
    } else if (harga_diskon.trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Harga Kulaan masih kosong");
    } else if (harga_lain.trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Harga Karton masih kosong");
    } else if (persediaan.trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Harga Karton masih kosong");
    } else if (view.getINputKategori().getText().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Status Belum di masukan");
    }  else if (mdiskon2.trim().equals("")) {
        JOptionPane.showMessageDialog((Component)view, "M diskon masih kosong");
    }
    
    else {
      this.model.setId_barang(id_barang);
      this.model.setNama_barang(nama_barang);
      this.model.setId_kategori(Integer.parseInt(view.getINputKategori().getText()));
      this.model.setHarga_beli(Double.parseDouble(harga_beli.replace(",", "")));
      this.model.setHarga_diskon(Double.parseDouble(harga_diskon.replace(",", "")));
      this.model.setHarga_lain(Double.parseDouble(harga_lain.replace(",", "")));
      this.model.setHarga_jual(Double.parseDouble(harga_jual.replace(",", "")));
      this.model.setPersediaan(Integer.parseInt(persediaan));
      this.model.setPoin(Integer.parseInt(poin));
      this.model.setBalance(Integer.parseInt(balance));
      this.model.setMindiskon(Integer.parseInt(mdiskon1));
      this.model.setMindiskon2(Integer.parseInt(mdiskon2));

      try {
        this.model.insertBrang();
        JOptionPane.showMessageDialog((Component)view, "Sukses Di tambah");
      } catch (Exception exception) {}
    } 
  }
  
  public void updateBarang(viewBarang view) {
    String harga_jual = view.getTextField_6().getText();
    String id_barang = view.getTextField().getText();
    String nama_barang = view.getTextField_1().getText();
    String jumlah = view.getTextField_9().getText();
    String harga_diskon = view.getTextField_7().getText();
    String harga_lain = view.getTextField_8().getText();
    String harga_beli = view.getTextField_5().getText();
    String persediaan = view.getTextField_9().getText();
    String point = view.getTextPointField().getText();
    String balance = view.getINputKategori().getText();

    String mdiskon1 = view.getTextField_15().getText();
    String mdiskon2 = view.getTextField_16().getText();
    System.out.println("harga diskon");
    System.out.print(mdiskon2);
    if (nama_barang.trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Nama tidak boleh kosong");
    } else if (harga_beli.trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Harga Beli masih kosong");
    } else if (harga_jual.trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Harga Jual masih kosong");
    } else if (harga_diskon.trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Harga Kulaan masih kosong");
    } else if (harga_lain.trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Harga Karton masih kosong");
    } else if (persediaan.trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Persediaan Masih Kosong");
    } else if (point.trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Point masih kosong");
    }
    else if (mdiskon2.trim().equals("")) {
        JOptionPane.showMessageDialog((Component)view, "M diskon masih kosong");
    }
    else if (mdiskon1.trim().equals("")) {
        JOptionPane.showMessageDialog((Component)view, "M diskon masih kosong");
    }
    else {
      this.model.setId_barang(id_barang);
      this.model.setNama_barang(nama_barang);
      this.model.setId_kategori(1);
      this.model.setHarga_beli(Double.parseDouble(harga_beli.replace(",", "")));
      this.model.setHarga_diskon(Double.parseDouble(harga_diskon.replace(",", "")));
      this.model.setHarga_lain(Double.parseDouble(harga_lain.replace(",", "")));
      this.model.setHarga_jual(Double.parseDouble(harga_jual.replace(",", "")));
      this.model.setPersediaan(Integer.parseInt(persediaan));
      this.model.setPoin(Integer.parseInt(point));
      this.model.setBalance(Integer.parseInt(balance));

      this.model.setMindiskon(Integer.parseInt(mdiskon1));
      this.model.setMindiskon2(Integer.parseInt(mdiskon2));
      try {
        this.model.updateBrang();
      } catch (SQLException|com.silver.dao.ErrorInfo e) {
        e.printStackTrace();
      } 
    } 
  }
}
