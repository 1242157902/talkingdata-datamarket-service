package com.talkingdata.dmpplus.controller.response;

import java.util.List;

public class AppResp {

  private List<AppBaseInfoResp> apps;

  public AppResp() {
    super();
  }

  public AppResp(List<AppBaseInfoResp> apps) {
    super();
    this.apps = apps;
  }

  public List<AppBaseInfoResp> getApps() {
    return apps;
  }

  public void setApps(List<AppBaseInfoResp> apps) {
    this.apps = apps;
  }

}
