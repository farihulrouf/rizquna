package com.silver.model.table;

import com.silver.data.CetakUlang;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;

public class TableModelDetailJual extends AbstractTableModel {
  private List<CetakUlang> list = new ArrayList<>();
  
  Locale locale = new Locale("en", "UK");
  
  DecimalFormat df = (DecimalFormat)NumberFormat.getNumberInstance(this.locale);
  
  private static final long serialVersionUID = 3321339460003575583L;
  
  public void setList(List<CetakUlang> list) {
    this.list = list;
  }
  
  public int getColumnCount() {
    return 5;
  }
  
  public String getColumnName(int column) {
    switch (column) {
      case 0:
        return "Barcode";
      case 1:
        return "Barang";
      case 2:
        return "Harga Jual";
      case 3:
        return "Qty";
      case 4:
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
        return ((CetakUlang)this.list.get(rowIndex)).getKode_barang();
      case 1:
        return ((CetakUlang)this.list.get(rowIndex)).getNama_barang();
      case 2:
        return this.df.format(((CetakUlang)this.list.get(rowIndex)).getHarga_jual());
      case 3:
        return Integer.valueOf(((CetakUlang)this.list.get(rowIndex)).getQty());
      case 4:
        return this.df.format(((CetakUlang)this.list.get(rowIndex)).getTotal());
    } 
    return null;
  }
  
  public boolean add(CetakUlang e) {
    try {
      return this.list.add(e);
    } finally {
      fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    } 
  }
  
  public CetakUlang get(int index) {
    return this.list.get(index);
  }
  
  public CetakUlang set(int index, CetakUlang element) {
    try {
      return this.list.set(index, element);
    } finally {
      fireTableRowsUpdated(index, index);
    } 
  }
  
  public CetakUlang remove(int index) {
    try {
      return this.list.remove(index);
    } finally {
      fireTableRowsDeleted(index, index);
    } 
  }
}
