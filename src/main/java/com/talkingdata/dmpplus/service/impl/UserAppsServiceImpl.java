package com.talkingdata.dmpplus.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.talkingdata.dmpplus.controller.response.AppInfoBusinessResp;
import com.talkingdata.dmpplus.controller.response.UserAppInfoResp;
import com.talkingdata.dmpplus.dao.AppAccessInfoMapper;
import com.talkingdata.dmpplus.dao.AppInfoMapper;
import com.talkingdata.dmpplus.dao.UserAppMappingMapper;
import com.talkingdata.dmpplus.dao.UserInfoMapper;
import com.talkingdata.dmpplus.dao.entity.AppAccessInfo;
import com.talkingdata.dmpplus.dao.entity.AppInfo;
import com.talkingdata.dmpplus.dao.entity.BusinessInfo;
import com.talkingdata.dmpplus.dao.entity.UserAppMapping;
import com.talkingdata.dmpplus.dao.entity.UserInfo;
import com.talkingdata.dmpplus.service.AppInfoService;
import com.talkingdata.dmpplus.service.UserAppsService;

@Service
public class UserAppsServiceImpl implements UserAppsService {

  @Autowired
  private UserInfoMapper userInfoMapper;

  @Autowired
  private UserAppMappingMapper userAppMappingMapper;

  @Autowired
  private AppInfoMapper appInfoMapper;

  @Autowired
  private AppInfoService appInfoService;

  @Autowired
  private AppAccessInfoMapper appAccessInfoMapper;

  @Override
  public List<UserAppInfoResp> getUserApps(String username) {
    List<UserAppInfoResp> apps = new ArrayList<UserAppInfoResp>();
    String userId = userInfoMapper.selectIdByUserName(username);
    if (userId != null) {
      List<UserAppMapping> appIds = userAppMappingMapper.selectByUserId(userId);
      if (!CollectionUtils.isEmpty(appIds)) {
        for (UserAppMapping mapping : appIds) {
          AppInfo appInfo = appInfoMapper.selectByPrimaryKey(mapping.getAppId());
          if (appInfo != null) {
            UserAppInfoResp userAppInfoResp = new UserAppInfoResp(appInfo);
            userAppInfoResp.setPurchaseDate(mapping.getPurchaseDate());
            userAppInfoResp.setExpireDate(mapping.getExpireDate());

            List<BusinessInfo> bussiness = appInfoService.getAppBusinessInfoById(appInfo.getId());
            if (!CollectionUtils.isEmpty(bussiness)) {
              for (BusinessInfo bus : bussiness) {
                userAppInfoResp.getBusinessType().add(new AppInfoBusinessResp(bus.getId(), bus.getName()));
              }
            }

            apps.add(userAppInfoResp);
          }
        }
      }
    }
    return apps;
  }

  @Override
  public List<UserInfo> getPurchasedUser(String appId) {
    List<UserInfo> users = new ArrayList<UserInfo>();
    List<UserAppMapping> userApps = userAppMappingMapper.selectByAppId(appId);
    if (!CollectionUtils.isEmpty(userApps)) {
      for (UserAppMapping userApp : userApps) {
        users.add(userInfoMapper.selectByPrimaryKey(userApp.getUserId()));
      }
    }
    return users;
  }

  @Override
  public AppAccessInfo getAppAccessByAppId(String appId) {
    return appAccessInfoMapper.selectByPrimaryKey(appId);
  }

}
