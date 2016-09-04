package com.talkingdata.dmpplus.service;

import java.util.List;

import com.talkingdata.dmpplus.dao.entity.AppInfo;
import com.talkingdata.dmpplus.dao.entity.AppIntroduction;
import com.talkingdata.dmpplus.dao.entity.AppMediaInfo;
import com.talkingdata.dmpplus.dao.entity.BusinessInfo;


public interface AppInfoService {

  String createEmptyAppInfo();

  AppInfo getAppInfoById(String id);

  Integer getAppCount();

  Integer getNewAppCount();

  Integer getRecommendAppCount();

  List<AppInfo> getAllApps();

  List<AppMediaInfo> getAppMediaByAppId(String appId);

  List<AppIntroduction> getIntroductionByAppId(String appId);

  List<AppInfo> getAppsBySupplier(String supplier);

  List<BusinessInfo> getAppBusinessInfoById(String appId);

}
