package com.talkingdata.dmpplus.dao;

import java.util.List;

import com.talkingdata.dmpplus.dao.entity.AppIntroduction;

public interface AppIntroductionMapper {

  List<AppIntroduction> selectByAppId(String appId);
}
