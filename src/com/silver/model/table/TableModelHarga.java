package com.silver.model.table;

import com.silver.data.Harga;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelHarga extends AbstractTableModel {
  private static final long serialVersionUID = 1L;
  
  public void setList(List<Harga> list) {
    this.list = list;
  }
  
  private List<Harga> list = new ArrayList<>();
  
  public int getColumnCount() {
    return 2;
  }
  
  public int getRowCount() {
    return this.list.size();
  }
  
  public String getColumnName(int column) {
    switch (column) {
      case 0:
        return "jenis Harga";
      case 1:
        return "Nominal";
    } 
    return null;
  }
  
  public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
      case 0:
        return ((Harga)this.list.get(rowIndex)).getNama_harga();
      case 1:
        this.list.get(rowIndex);
        return Harga.getHarga_jual();
    } 
    return null;
  }
  
  public boolean add(Harga e) {
    try {
      return this.list.add(e);
    } finally {
      fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    } 
  }
  
  public Harga get(int index) {
    return this.list.get(index);
  }
  
  public Harga set(int index, Harga element) {
    try {
      return this.list.set(index, element);
    } finally {
      fireTableRowsUpdated(index, index);
    } 
  }
  
  public Harga remove(int index) {
    try {
      return this.list.remove(index);
    } finally {
      fireTableRowsDeleted(index, index);
    } 
  }
}
