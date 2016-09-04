package com.talkingdata.dmpplus.dao;

import java.util.List;

import com.talkingdata.dmpplus.dao.entity.AppBussinessMappingKey;

public interface AppBussinessMappingMapper {
  List<AppBussinessMappingKey> selectByAppId(String appId);
}
