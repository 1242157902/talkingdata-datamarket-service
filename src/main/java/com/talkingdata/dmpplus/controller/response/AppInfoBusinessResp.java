package com.talkingdata.dmpplus.controller.response;

import com.talkingdata.dmpplus.dao.entity.BusinessInfo;

public class AppInfoBusinessResp extends BusinessInfo {

  public AppInfoBusinessResp() {
    super();
  }

  public AppInfoBusinessResp(String id, String name) {
    super(id, name);
  }

}
