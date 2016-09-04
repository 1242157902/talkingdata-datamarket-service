package com.talkingdata.dmpplus.controller.response;

public class LoginResp {
  private String token;

  public LoginResp() {
    super();
  }

  public LoginResp(String token) {
    super();
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

}
