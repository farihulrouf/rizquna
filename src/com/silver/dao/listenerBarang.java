package com.silver.dao;

import com.silver.data.Barang;
import com.silver.model.ModelBarang;

public interface listenerBarang {
  void onInser(Barang paramBarang);
  
  void onUpdate(Barang paramBarang);
  
  void onDelete();
  
  void onChange(ModelBarang paramModelBarang);
}
