package com.talkingdata.dmpplus.service;

import java.util.List;

import com.talkingdata.dmpplus.controller.response.UserAppInfoResp;
import com.talkingdata.dmpplus.dao.entity.AppAccessInfo;
import com.talkingdata.dmpplus.dao.entity.UserInfo;

public interface UserAppsService {
  List<UserAppInfoResp> getUserApps(String username);

  List<UserInfo> getPurchasedUser(String appId);

  AppAccessInfo getAppAccessByAppId(String appId);
}
