package com.silver.dao;

import com.silver.data.CetakUlang;
import java.util.List;

public interface DaoCetakUlang {
  List<CetakUlang> CetakUlangData(String paramString) throws ErrorInfo;
}
