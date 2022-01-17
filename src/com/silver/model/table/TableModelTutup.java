package com.silver.model.table;

import com.silver.data.tutup_toko;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;

public class TableModelTutup extends AbstractTableModel {
  private List<tutup_toko> list = new ArrayList<>();
  
  Locale locale = new Locale("en", "UK");
  
  DecimalFormat df = (DecimalFormat)NumberFormat.getNumberInstance(this.locale);
  
  private static final long serialVersionUID = 3321339460003575583L;
  
  public void setList(List<tutup_toko> list) {
    this.list = list;
  }
  
  public int getColumnCount() {
    return 3;
  }
  
  public String getColumnName(int column) {
    switch (column) {
      case 0:
        return "tanggal";
      case 1:
        return "kasir";
      case 2:
        return "Total";
    } 
    return null;
  }
  
  public int getRowCount() {
    return this.list.size();
  }
  
  public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
      case 0:
        return ((tutup_toko)this.list.get(rowIndex)).getTanggal();
      case 1:
        return ((tutup_toko)this.list.get(rowIndex)).getId_kasir();
      case 2:
        return this.df.format(((tutup_toko)this.list.get(rowIndex)).getTotal());
    } 
    return null;
  }
  
  public boolean add(tutup_toko e) {
    try {
      return this.list.add(e);
    } finally {
      fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    } 
  }
  
  public tutup_toko get(int index) {
    return this.list.get(index);
  }
  
  public tutup_toko set(int index, tutup_toko element) {
    try {
      return this.list.set(index, element);
    } finally {
      fireTableRowsUpdated(index, index);
    } 
  }
  
  public tutup_toko remove(int index) {
    try {
      return this.list.remove(index);
    } finally {
      fireTableRowsDeleted(index, index);
    } 
  }
}
