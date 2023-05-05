package com.silver.model.table;

import com.silver.data.Jual;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelJual extends AbstractTableModel {
  private List<Jual> list = new ArrayList<>();
  
  private static final long serialVersionUID = 3321339460003575583L;
  
  public void setList(List<Jual> list) {
    this.list = list;
  }
  
  public int getColumnCount() {
    return 5;
  }
  
  public String getColumnName(int column) {
    switch (column) {
      case 0:
        return "No";
      case 1:
        return "Kasir";
      case 2:
        return "jam";
      case 3:
        return "poin";
      case 4:
        return "pelanggan";
    } 
    return null;
  }
  
  public int getRowCount() {
    return this.list.size();
  }
  
  public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
      case 0:
        return Integer.valueOf(((Jual)this.list.get(rowIndex)).getNo());
      case 1:
        return ((Jual)this.list.get(rowIndex)).getId_user();
      case 2:
        return ((Jual)this.list.get(rowIndex)).getJam();
      case 3:
        return Double.valueOf(((Jual)this.list.get(rowIndex)).getPoin());
      case 4:
        return ((Jual)this.list.get(rowIndex)).getNama();
    } 
    return null;
  }
  
  public boolean add(Jual e) {
    try {
      return this.list.add(e);
    } finally {
      fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    } 
  }
  
  public Jual get(int index) {
    return this.list.get(index);
  }
  
  public Jual set(int index, Jual element) {
    try {
      return this.list.set(index, element);
    } finally {
      fireTableRowsUpdated(index, index);
    } 
  }
  
  public Jual remove(int index) {
    try {
      return this.list.remove(index);
    } finally {
      fireTableRowsDeleted(index, index);
    } 
  }
}
