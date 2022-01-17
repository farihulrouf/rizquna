package com.silver.controller;

import com.silver.model.ModelPegawai;
import view.dialog.viewPegawai;
import java.awt.Component;
import javax.swing.JOptionPane;

public class ControllerPengguna {
  private ModelPegawai model;
  
  public void setModel(ModelPegawai model) {
    this.model = model;
  }
  
  public void deletePengguna(viewPegawai view) {
    if (view.getTable().getSelectedRowCount() == 0) {
      JOptionPane.showMessageDialog((Component)view, "piih dahulu data yang di hapus");
    } else if (JOptionPane.showConfirmDialog((Component)view, "Anda yakin ingin menghapus data") == 0) {
      this.model.setUser_name(view.getTextFieldUser().getText());
      try {
        this.model.deletePegawai();
        JOptionPane.showMessageDialog((Component)view, "data berhasil di hapus");
      } catch (Exception exception) {}
    } 
  }
  
  public void insertPengguna(viewPegawai view) {
    if (view.getTextFieldUser().getText().trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "user tidak boleh kosong");
    } else if (view.getPasswordField().getText().trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "password belum di isi");
    } else if (view.getTextField_1().getText().trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Nama belum di isi");
    } else {
      this.model.setUser_name(view.getTextFieldUser().getText());
      this.model.setNama_pegawai(view.getTextField_1().getText());
      this.model.setPassword(view.getPasswordField().getText());
      this.model.setRole("2");
      try {
        this.model.insertPegawai();
        JOptionPane.showMessageDialog((Component)view, "data berhasil di simpan");
      } catch (Throwable throwable) {
        JOptionPane.showMessageDialog((Component)view, new Object[] { "Terhadi error di databse dengan pesan", 
              throwable.getMessage() });
      } 
    } 
  }
  
  public void updatePegawai(viewPegawai view) {
    if (view.getTable().getSelectedRowCount() == 0) {
      JOptionPane.showMessageDialog((Component)view, "pilih dulu data yang ingin di hapus");
    } else if (view.getTextFieldUser().getText().trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "user tidak boleh kosong");
    } else if (view.getPasswordField().getText().trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "password belum di isi");
    } else if (view.getTextField_1().getText().trim().equals("")) {
      JOptionPane.showMessageDialog((Component)view, "Nama belum di isi");
    } else {
      this.model.setUser_name(view.getTextFieldUser().getText());
      this.model.setNama_pegawai(view.getTextField_1().getText());
      this.model.setPassword(view.getPasswordField().getText());
      this.model.setRole("2");
      try {
        this.model.updatePegawai();
        JOptionPane.showMessageDialog((Component)view, "data berhasil di update");
      } catch (Throwable throwable) {
        JOptionPane.showMessageDialog((Component)view, new Object[] { "Terhadi error di databse dengan pesan", 
              throwable.getMessage() });
      } 
    } 
  }
}
