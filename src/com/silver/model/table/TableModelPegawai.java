package com.silver.model.table;

import com.silver.data.Pegawai;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelPegawai extends AbstractTableModel {
  private List<Pegawai> list = new ArrayList<>();
  
  private static final long serialVersionUID = 3321339460003575583L;
  
  public void setList(List<Pegawai> list) {
    this.list = list;
  }
  
  public int getColumnCount() {
    return 2;
  }
  
  public String getColumnName(int column) {
    switch (column) {
      case 0:
        return "user";
      case 1:
        return "nama Lengkap";
    } 
    return null;
  }
  
  public int getRowCount() {
    return this.list.size();
  }
  
  public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
      case 0:
        return ((Pegawai)this.list.get(rowIndex)).getUser_name();
      case 1:
        return ((Pegawai)this.list.get(rowIndex)).getNama_pegawai();
    } 
    return null;
  }
  
  public boolean add(Pegawai e) {
    try {
      return this.list.add(e);
    } finally {
      fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    } 
  }
  
  public Pegawai get(int index) {
    return this.list.get(index);
  }
  
  public Pegawai set(int index, Pegawai element) {
    try {
      return this.list.set(index, element);
    } finally {
      fireTableRowsUpdated(index, index);
    } 
  }
  
  public Pegawai remove(int index) {
    try {
      return this.list.remove(index);
    } finally {
      fireTableRowsDeleted(index, index);
    } 
  }
}
