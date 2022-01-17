package com.silver.model.table;

import com.silver.data.JamLaporan;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;

public class TableModelJam2 extends AbstractTableModel {
  private List<JamLaporan> list = new ArrayList<>();
  
  public void setList(List<JamLaporan> list) {
    this.list = list;
  }
  
  Locale locale = new Locale("en", "UK");
  
  DecimalFormat df = (DecimalFormat)NumberFormat.getNumberInstance(this.locale);
  
  private static final long serialVersionUID = 3321339460003575583L;
  
  public int getColumnCount() {
    return 3;
  }
  
  public String getColumnName(int column) {
    switch (column) {
      case 0:
        return "Kasir";
      case 1:
        return "Jam";
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
        return ((JamLaporan)this.list.get(rowIndex)).getNama_komputer();
      case 1:
        return String.valueOf(String.valueOf(((JamLaporan)this.list.get(rowIndex)).getJam())) + ".0.0";
      case 2:
        return this.df.format(((JamLaporan)this.list.get(rowIndex)).getTotal());
    } 
    return null;
  }
  
  public boolean add(JamLaporan e) {
    try {
      return this.list.add(e);
    } finally {
      fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    } 
  }
  
  public JamLaporan get(int index) {
    return this.list.get(index);
  }
  
  public JamLaporan set(int index, JamLaporan element) {
    try {
      return this.list.set(index, element);
    } finally {
      fireTableRowsUpdated(index, index);
    } 
  }
  
  public JamLaporan remove(int index) {
    try {
      return this.list.remove(index);
    } finally {
      fireTableRowsDeleted(index, index);
    } 
  }
}
