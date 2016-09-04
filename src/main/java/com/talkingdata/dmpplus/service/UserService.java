package com.talkingdata.dmpplus.service;


public interface UserService {
  boolean checkUser(String username, String password);

  boolean checkUserToken(String accessToken, String ip);

  String generateAccessToken(String username, String ip);

  boolean saveAccessToken(String username, String accessToken);
}
