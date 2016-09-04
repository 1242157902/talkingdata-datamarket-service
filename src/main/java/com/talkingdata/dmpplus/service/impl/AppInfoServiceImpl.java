package com.talkingdata.dmpplus.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talkingdata.dmpplus.constant.DmpPlusConstant;
import com.talkingdata.dmpplus.dao.AppBussinessMappingMapper;
import com.talkingdata.dmpplus.dao.AppInfoMapper;
import com.talkingdata.dmpplus.dao.AppIntroductionMapper;
import com.talkingdata.dmpplus.dao.AppMediaInfoMapper;
import com.talkingdata.dmpplus.dao.BusinessInfoMapper;
import com.talkingdata.dmpplus.dao.UserAppMappingMapper;
import com.talkingdata.dmpplus.dao.UserInfoMapper;
import com.talkingdata.dmpplus.dao.entity.AppBussinessMappingKey;
import com.talkingdata.dmpplus.dao.entity.AppInfo;
import com.talkingdata.dmpplus.dao.entity.AppIntroduction;
import com.talkingdata.dmpplus.dao.entity.AppMediaInfo;
import com.talkingdata.dmpplus.dao.entity.BusinessInfo;
import com.talkingdata.dmpplus.service.AppInfoService;
import com.talkingdata.dmpplus.utils.DmpPlusUtils;

@Service
public class AppInfoServiceImpl implements AppInfoService {

  @Autowired
  private UserInfoMapper userInfoMapper;

  @Autowired
  private UserAppMappingMapper userAppMappingMapper;

  @Autowired
  private AppInfoMapper appInfoMapper;

  @Autowired
  private AppMediaInfoMapper appMediaInfoMapper;

  @Autowired
  private AppIntroductionMapper appIntroductionMapper;

  @Autowired
  private AppBussinessMappingMapper appBussinessMappingMapper;

  @Autowired
  private BusinessInfoMapper businessInfoMapper;

  @Override
  public String createEmptyAppInfo() {
    String appId = DmpPlusUtils.getUuid();
    AppInfo appInfo = new AppInfo();
    appInfo.setId(appId);
    if (appInfoMapper.insert(appInfo) == 1) {
      return appId;
    }
    return "";
  }

  @Override
  public AppInfo getAppInfoById(String id) {
    return appInfoMapper.selectByPrimaryKey(id);
  }

  @Override
  public Integer getAppCount() {
    return appInfoMapper.getAppCount();
  }

  @Override
  public Integer getNewAppCount() {
    return appInfoMapper.getAppCountByTag(DmpPlusConstant.APP_TAG_NEW);
  }

  @Override
  public Integer getRecommendAppCount() {
    return appInfoMapper.getAppCountByTag(DmpPlusConstant.APP_TAG_RECOMMEND);
  }

  @Override
  public List<AppInfo> getAllApps() {
    return appInfoMapper.listAll();
  }

  @Override
  public List<AppMediaInfo> getAppMediaByAppId(String appId) {
    return appMediaInfoMapper.selectByAppId(appId);
  }

  @Override
  public List<AppIntroduction> getIntroductionByAppId(String appId) {
    return appIntroductionMapper.selectByAppId(appId);
  }

  @Override
  public List<AppInfo> getAppsBySupplier(String supplier) {
    return appInfoMapper.selectBySupplier(supplier);
  }

  @Override
  public List<BusinessInfo> getAppBusinessInfoById(String appId) {
    List<BusinessInfo> result = new ArrayList<BusinessInfo>();
    List<AppBussinessMappingKey> mapping = appBussinessMappingMapper.selectByAppId(appId);
    for (AppBussinessMappingKey m : mapping) {
      result.add(businessInfoMapper.selectByPrimaryKey(m.getBusinessId()));
    }
    return result;
  }

}
