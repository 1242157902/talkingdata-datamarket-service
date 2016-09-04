package com.talkingdata.dmpplus.controller.response;

import java.util.List;

public class MyAppResp {
  private MyAppOverallResp overall;
  private List<UserAppInfoResp> apps;

  public MyAppResp() {
    super();
  }

  public MyAppResp(MyAppOverallResp overall, List<UserAppInfoResp> apps) {
    super();
    this.overall = overall;
    this.apps = apps;
  }

  public MyAppOverallResp getOverall() {
    return overall;
  }

  public void setOverall(MyAppOverallResp overall) {
    this.overall = overall;
  }

  public List<UserAppInfoResp> getApps() {
    return apps;
  }

  public void setApps(List<UserAppInfoResp> apps) {
    this.apps = apps;
  }

}
