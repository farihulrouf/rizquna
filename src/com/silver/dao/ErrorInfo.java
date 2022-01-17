package com.silver.dao;

public class ErrorInfo extends Exception {
  private static final long serialVersionUID = -3680463424712690964L;
  
  public ErrorInfo() {}
  
  public ErrorInfo(String msg) {
    super(msg);
  }
}
