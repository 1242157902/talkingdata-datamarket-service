package com.talkingdata.dmpplus.dao;

import java.util.List;

import com.talkingdata.dmpplus.dao.entity.AppInfo;

public interface AppInfoMapper {
  int insert(AppInfo record);

  AppInfo selectByPrimaryKey(String id);

  Integer getAppCountByTag(String tag);

  Integer getAppCount();

  List<AppInfo> listAll();

  List<AppInfo> selectBySupplier(String supplier);
}
