package com.silver.dao;

import com.silver.data.detail_jual;

public interface DaoDetailJual {
  void insertDetailJual(detail_jual paramdetail_jual) throws ErrorInfo;
  
  void deleteDetail_jual(int paramInt, String paramString) throws ErrorInfo;
}
