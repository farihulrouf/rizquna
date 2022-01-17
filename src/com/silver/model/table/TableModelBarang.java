package com.silver.model.table;

import com.silver.data.Barang;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;

public class TableModelBarang extends AbstractTableModel {
  private List<Barang> list = new ArrayList<>();
  
  String pattern = "###,###.###";
  
  Locale locale = new Locale("en", "UK");
  
  DecimalFormat df = (DecimalFormat)NumberFormat.getNumberInstance(this.locale);
  
  private static final long serialVersionUID = 3321339460003575583L;
  
  public void setList(List<Barang> list) {
    this.list = list;
  }
  
  public TableModelBarang() {
    this.df.applyPattern(this.pattern);
  }
  
  public int getColumnCount() {
    return 4;
  }
  
  public String getColumnName(int column) {
    switch (column) {
      case 0:
        return "Barang";
      case 1:
        return "Persediaan";
      case 2:
        return "Harga Beli";
      case 3:
        return "harga jual";
    } 
    return null;
  }
  
  public int getRowCount() {
    return this.list.size();
  }
  
  public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
      case 0:
        return ((Barang)this.list.get(rowIndex)).getNama_barang();
      case 1:
        return this.df.format(((Barang)this.list.get(rowIndex)).getPersediaan());
      case 2:
        return this.df.format(((Barang)this.list.get(rowIndex)).getHarga_beli());
      case 3:
        return this.df.format(((Barang)this.list.get(rowIndex)).getHarga_jual());
    } 
    return null;
  }
  
  public boolean add(Barang e) {
    try {
      return this.list.add(e);
    } finally {
      fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    } 
  }
  
  public Barang get(int index) {
    return this.list.get(index);
  }
  
  public Barang set(int index, Barang element) {
    try {
      return this.list.set(index, element);
    } finally {
      fireTableRowsUpdated(index, index);
    } 
  }
  
  public Barang remove(int index) {
    try {
      return this.list.remove(index);
    } finally {
      fireTableRowsDeleted(index, index);
    } 
  }
}
