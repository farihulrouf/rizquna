package com.silver.model.table;

import com.silver.data.TampilkanPerPc;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;

public class tableModelPerPc extends AbstractTableModel {
  private List<TampilkanPerPc> list = new ArrayList<>();
  
  Locale locale = new Locale("en", "UK");
  
  DecimalFormat df = (DecimalFormat)NumberFormat.getNumberInstance(this.locale);
  
  private static final long serialVersionUID = 3321339460003575583L;
  
  public void setList(List<TampilkanPerPc> list) {
    this.list = list;
  }
  
  public int getColumnCount() {
    return 2;
  }
  
  public String getColumnName(int column) {
    switch (column) {
      case 0:
        return "nama pc";
      case 1:
        return "total";
    } 
    return null;
  }
  
  public int getRowCount() {
    return this.list.size();
  }
  
  public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
      case 0:
        return ((TampilkanPerPc)this.list.get(rowIndex)).getKasir();
      case 1:
        return this.df.format(((TampilkanPerPc)this.list.get(rowIndex)).getTotal());
    } 
    return null;
  }
  
  public boolean add(TampilkanPerPc e) {
    try {
      return this.list.add(e);
    } finally {
      fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    } 
  }
  
  public TampilkanPerPc get(int index) {
    return this.list.get(index);
  }
  
  public TampilkanPerPc set(int index, TampilkanPerPc element) {
    try {
      return this.list.set(index, element);
    } finally {
      fireTableRowsUpdated(index, index);
    } 
  }
  
  public TampilkanPerPc remove(int index) {
    try {
      return this.list.remove(index);
    } finally {
      fireTableRowsDeleted(index, index);
    } 
  }
}
