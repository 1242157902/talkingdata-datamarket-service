package com.talkingdata.dmpplus.dao;

import java.util.List;

import com.talkingdata.dmpplus.dao.entity.UserAppMapping;

public interface UserAppMappingMapper {
  UserAppMapping selectByPrimaryKey(String id);

  List<UserAppMapping> selectByUserId(String userId);

  List<UserAppMapping> selectByAppId(String appId);
}
