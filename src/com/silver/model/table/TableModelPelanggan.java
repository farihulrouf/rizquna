package com.silver.model.table;

import com.silver.data.Barang;
import com.silver.data.Pelanggan;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.table.AbstractTableModel;

public class TableModelPelanggan extends AbstractTableModel {
  private List<Pelanggan> list = new ArrayList<>();
  
  private static final long serialVersionUID = 3321339460003575583L;
  
  String pattern = "###,###.###";
  
  Locale locale = new Locale("en", "UK");
  
  DecimalFormat df = (DecimalFormat)NumberFormat.getNumberInstance(this.locale);
  public void setList(List<Pelanggan> list) {
    this.list = list;
  }
  
  public int getColumnCount() {
    return 4;
  }
  
  public String getColumnName(int column) {
    switch (column) {
      case 0:
        return "Nam";
      case 1:
        return "No Hp";
      case 2:
        return "Total Belanja Uang";
      case 3:
        return "poin";
      
    } 
    return null;
  }
  
  public int getRowCount() {
    return this.list.size();
  }
  
  public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
      case 0:
    	  return ((Pelanggan)this.list.get(rowIndex)).getNama_pelanggan();
       
      case 1:
    	  return ((Pelanggan)this.list.get(rowIndex)).getNo_hp();
      case 2:
    	 // return Double.valueOf(((Pelanggan)this.list.get(rowIndex)).getUang());
    	   return this.df.format(((Pelanggan)this.list.get(rowIndex)).getUang());
      case 3:
        return Double.valueOf(((Pelanggan)this.list.get(rowIndex)).getPoin());
     
    	  
    } 
    return null;
  }
  
  public boolean add(Pelanggan e) {
    try {
      return this.list.add(e);
    } finally {
      fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    } 
  }
  
  public Pelanggan get(int index) {
    return this.list.get(index);
  }
  
  public Pelanggan set(int index, Pelanggan element) {
    try {
      return this.list.set(index, element);
    } finally {
      fireTableRowsUpdated(index, index);
    } 
  }
  
  public Pelanggan remove(int index) {
    try {
      return this.list.remove(index);
    } finally {
      fireTableRowsDeleted(index, index);
    } 
  }
}
