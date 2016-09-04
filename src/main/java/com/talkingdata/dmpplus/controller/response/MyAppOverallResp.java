package com.talkingdata.dmpplus.controller.response;

public class MyAppOverallResp {
  private Integer allApp;
  private Integer newApp;
  private Integer recommendApp;

  public MyAppOverallResp() {
    super();
  }

  public MyAppOverallResp(Integer allApp, Integer newApp, Integer recommendApp) {
    super();
    this.allApp = allApp;
    this.newApp = newApp;
    this.recommendApp = recommendApp;
  }

  public Integer getAllApp() {
    return allApp;
  }

  public void setAllApp(Integer allApp) {
    this.allApp = allApp;
  }

  public Integer getNewApp() {
    return newApp;
  }

  public void setNewApp(Integer newApp) {
    this.newApp = newApp;
  }

  public Integer getRecommendApp() {
    return recommendApp;
  }

  public void setRecommendApp(Integer recommendApp) {
    this.recommendApp = recommendApp;
  }

}
