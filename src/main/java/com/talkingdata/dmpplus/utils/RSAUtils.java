package com.talkingdata.dmpplus.utils;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public class RSAUtils {
  public static final String KEY_ALGORITHM = "RSA";
  private static final String PUBLIC_KEY = "RSAPublicKey";
  private static final String PRIVATE_KEY = "RSAPrivateKey";

  private static final String RSA_PRIVATE_KEY =
      "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAItslEgIskWph5Tndzn43nE19Z99OHnZvtyjlvZCgmVDTcYlSdHdGq2HqU2d6AYZl500YPgGUBiHMH0VkUGEqZE+kOaoFrEgAnuQCLvsCalfzZzzjaU1p+zmjSWjiExKDaPALSLk3orUT4prXWxjuRxoKSXhhGrgQ9CoSIkPB4pnAgMBAAECgYEAidMG7gJywDxrA76gdJVYx08RBN1TQ9kFPLUWWU+7+QBEVLittaC9a4cszMZpBAaugr+xj90ltmmFfFEiq0LKH42EtBRQFFtykbfeiNIrc5bPghlC2JAH/cX0ThP3vJ9iYV1+4i7NrK5wPUeRgEfQVxC59Yia+/cedvtisrdFp2ECQQDE3adHWYgr7qchH0rzl1xob7dMUXxClU1MaDvU4sTDfBrzWZlG9Lp2mNTEcD0UmIG2MbJP9/KiEQFvNJKnZu33AkEAtU3YTloPkRN5OOW7ZhWpcWTG7VPWlpS8fvYXay3rC2Uw90fVGan9pnIn0w3bTmHMELtuO1QED0Kur8eBAUDrEQJBAKi/2zEE5P3Lj4WL3mKZn0OCZ5vKyXoFowHY41ijnch3rF5mskWpZ+BbNx6/mwv5gk6boN59ioUzkIgzh3Zpe5cCQCDZ+R7BXN65u5ZesiUeObStQQpRzak9TCZpKvclu9g1vrif0HI1Bhv5xVONyDYcrGA/xgqD/7RQLdz19l8mxzECQFAAJFTIlpKRViKyx/kxKofmcSEqZG71/NDWDY81iZZW11CVrnHckC/+7Uco7K58WEnhcICk0aIjNm/2sKCXMtw=";

  /**
   * 功能描述: 用私钥解密 作 者:xiaowei.wang@tendcloud.com 创建日期:Mar 27, 2014
   *
   * @param data
   * @param key
   * @return
   * @throws Exception
   */
  public static byte[] decryptByPrivateKey(byte[] data, String key) throws Exception {
    // 对密钥解密
    byte[] keyBytes = decryptBASE64(key);

    // 取得私钥
    PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
    Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

    // 对数据解密
    Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
    cipher.init(Cipher.DECRYPT_MODE, privateKey);

    return cipher.doFinal(data);
  }

  /**
   * 功能描述: 用公钥加密 作 者:xiaowei.wang@tendcloud.com 创建日期:Mar 27, 2014
   *
   * @param data
   * @param key
   * @return
   * @throws Exception
   */
  public static byte[] encryptByPublicKey(byte[] data, String key) throws Exception {
    // 对公钥解密
    byte[] keyBytes = decryptBASE64(key);

    // 取得公钥
    X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
    Key publicKey = keyFactory.generatePublic(x509KeySpec);

    // 对数据加密
    Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
    cipher.init(Cipher.ENCRYPT_MODE, publicKey);

    return cipher.doFinal(data);
  }

  /**
   * 取得私钥
   *
   * @param keyMap
   * @return
   * @throws Exception
   */
  public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
    Key key = (Key) keyMap.get(PRIVATE_KEY);

    return encryptBASE64(key.getEncoded());
  }

  /**
   * 取得公钥
   *
   * @param keyMap
   * @return
   * @throws Exception
   */
  public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
    Key key = (Key) keyMap.get(PUBLIC_KEY);

    return encryptBASE64(key.getEncoded());
  }

  /**
   * 初始化密钥
   *
   * @return
   * @throws Exception
   */
  public static Map<String, Object> initKey() throws Exception {
    KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
    keyPairGen.initialize(1024);

    KeyPair keyPair = keyPairGen.generateKeyPair();

    // 公钥
    RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

    // 私钥
    RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

    Map<String, Object> keyMap = new HashMap<String, Object>(2);

    keyMap.put(PUBLIC_KEY, publicKey);
    keyMap.put(PRIVATE_KEY, privateKey);
    return keyMap;
  }

  /**
   * 功能描述: base64解码
   *
   * @param key
   * @return
   * @throws Exception
   */
  public static byte[] decryptBASE64(String key) throws Exception {
    return Base64.decodeBase64(key);
  }

  /**
   * 功能描述: base64编码
   *
   * @param key
   * @return
   * @throws Exception
   */
  public static String encryptBASE64(byte[] key) throws Exception {
    return new String(Base64.encodeBase64(key));
  }

  public static String decryptByPrivateKey(String encryptValue) throws Exception {
    byte[] decodedData = RSAUtils.decryptByPrivateKey(RSAUtils.decryptBASE64(encryptValue), RSA_PRIVATE_KEY);
    return new String(decodedData);
  }
}
