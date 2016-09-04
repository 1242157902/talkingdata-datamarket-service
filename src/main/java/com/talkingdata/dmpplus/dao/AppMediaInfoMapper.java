package com.talkingdata.dmpplus.dao;

import java.util.List;

import com.talkingdata.dmpplus.dao.entity.AppMediaInfo;

public interface AppMediaInfoMapper {
  List<AppMediaInfo> selectByAppId(String appId);
}
