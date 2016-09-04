package com.talkingdata.dmpplus.dao;

import com.talkingdata.dmpplus.dao.entity.AppAccessInfo;

public interface AppAccessInfoMapper {
  AppAccessInfo selectByPrimaryKey(String appId);
}
