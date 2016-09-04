package com.talkingdata.dmpplus.controller.response;

import com.talkingdata.dmpplus.constant.DmpPlusConstant;

public class BaseResp<T> {
  private int result;
  private String message;
  private T data;

  public BaseResp() {
    super();
  }

  public BaseResp(int result, String message) {
    super();
    this.result = result;
    this.message = message;
  }

  public BaseResp(T data) {
    super();
    this.result = DmpPlusConstant.RESP_SUCC;
    this.message = DmpPlusConstant.RESP_SUCC_MSG;
    this.data = data;
  }

  public BaseResp(int result, String message, T data) {
    super();
    this.result = result;
    this.message = message;
    this.data = data;
  }

  public int getResult() {
    return result;
  }

  public void setResult(int result) {
    this.result = result;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

}
