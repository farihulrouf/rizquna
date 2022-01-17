package com.silver.model.table;

import com.silver.data.Pemasok;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelPemasok extends AbstractTableModel {
  private static final long serialVersionUID = 1L;
  
  private List<Pemasok> list = new ArrayList<>();
  
  public void setList(List<Pemasok> list) {
    this.list = list;
  }
  
  public int getColumnCount() {
    return 2;
  }
  
  public String getColumnName(int column) {
    switch (column) {
      case 0:
        return "Pemasok";
      case 1:
        return "Kota";
    } 
    return null;
  }
  
  public int getRowCount() {
    return this.list.size();
  }
  
  public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
      case 0:
        return ((Pemasok)this.list.get(rowIndex)).getNama_pemasok();
      case 1:
        return ((Pemasok)this.list.get(rowIndex)).getKota();
    } 
    return null;
  }
  
  public boolean add(Pemasok e) {
    try {
      return this.list.add(e);
    } finally {
      fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    } 
  }
  
  public Pemasok get(int index) {
    return this.list.get(index);
  }
  
  public Pemasok set(int index, Pemasok element) {
    try {
      return this.list.set(index, element);
    } finally {
      fireTableRowsUpdated(index, index);
    } 
  }
  
  public Pemasok remove(int index) {
    try {
      return this.list.remove(index);
    } finally {
      fireTableRowsDeleted(index, index);
    } 
  }
}
