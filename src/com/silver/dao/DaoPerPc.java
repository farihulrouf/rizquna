package com.silver.dao;

import com.silver.data.TampilkanPerPc;
import java.util.List;

public interface DaoPerPc {
  List<TampilkanPerPc> selectAll() throws ErrorInfo;
}
