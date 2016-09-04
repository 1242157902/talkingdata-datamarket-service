package com.talkingdata.dmpplus.controller.request;

public class LoginReq {
  private String username;
  private String password;

  public LoginReq() {
    super();
  }

  public LoginReq(String username, String password) {
    super();
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
