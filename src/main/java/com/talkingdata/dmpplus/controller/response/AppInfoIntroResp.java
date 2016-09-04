package com.talkingdata.dmpplus.controller.response;

public class AppInfoIntroResp {
  private String title;
  private String details;

  public AppInfoIntroResp() {
    super();
  }

  public AppInfoIntroResp(String title, String details) {
    super();
    this.title = title;
    this.details = details;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

}
