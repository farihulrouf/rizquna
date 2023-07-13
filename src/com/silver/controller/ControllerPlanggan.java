package com.silver.controller;
 
import com.silver.model.ModelPelanggan;

import view.dialog.viewDataPelanggan;

import java.awt.Component;
import javax.swing.JOptionPane;

public class ControllerPlanggan {
  private ModelPelanggan model;
  
  public void setModel(ModelPelanggan model) {
    this.model = model;
  }
  
  public void deletePelanggan(viewDataPelanggan view) {
    if (view.getTable().getSelectedRowCount() == 0) {
      JOptionPane.showMessageDialog((Component)view, "piih dahulu data yang di hapus");
    } else if (JOptionPane.showConfirmDialog((Component)view, "Anda yakin ingin menghapus data") == 0) {
      this.model.setId_pelanggan(view.getTextFieldUser().getText());
      try {
        this.model.deletePelanggan();
        JOptionPane.showMessageDialog((Component)view, "data berhasil di hapus");
      } catch (Exception exception) {}
    } 
  }
  
  public void insertPelanggan(viewDataPelanggan view) {
    if (view.getTextFieldUser().getText().trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Id tidak boleh kosong");
    } else if (view.getPasswordField().getText().trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Hp belum di isi");
    } else if (view.getTextField_1().getText().trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Nama belum di isi");
    } else if (view.getTextPoin().getText().trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Poin belum di isi");
    } else {
      Double poin = Double.parseDouble(view.getTextPoin().getText());
      this.model.setId_pelanggan(view.getTextFieldUser().getText());
      this.model.setNama_pelanggan(view.getTextField_1().getText());
      this.model.setNo_hp(view.getPasswordField().getText());
      this.model.setPoin(poin);
      
      try {
        this.model.insertPelanggan();
        JOptionPane.showMessageDialog((Component)view, "data berhasil di simpan");
      } catch (Throwable throwable) {
        JOptionPane.showMessageDialog((Component)view, new Object[] { "Terjadi error di databse dengan pesan", 
              throwable.getMessage() });
      } 
    } 
  }
  
  public void updatePelanggan(viewDataPelanggan view) {
    if (view.getTextFieldUser().getText().trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Id tidak boleh kosong");
    } else if (view.getPasswordField().getText().trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Hp belum di isi");
    } else if (view.getTextField_1().getText().trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Nama belum di isi");
    } else if (view.getTextPoin().getText().trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Poin belum di isi");
    } else {
      Double poin = Double.parseDouble(view.getTextPoin().getText());
      this.model.setId_pelanggan(view.getTextFieldUser().getText());
      this.model.setNama_pelanggan(view.getTextField_1().getText());
      this.model.setNo_hp(view.getPasswordField().getText());
      this.model.setPoin(poin);
      try {
        this.model.updatePelanggan();
        JOptionPane.showMessageDialog((Component)view, "data berhasil di update");
      } catch (Throwable throwable) {
        JOptionPane.showMessageDialog((Component)view, new Object[] { "Terhadi error di databse dengan pesan", 
              throwable.getMessage() });
      } 
    } 
  }
}
