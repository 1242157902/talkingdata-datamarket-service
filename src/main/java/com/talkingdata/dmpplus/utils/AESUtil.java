package com.talkingdata.dmpplus.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AESUtil {
  private final static Logger logger = LoggerFactory.getLogger(AESUtil.class);

  private static final String key = "talkingdata12345";

  public static String encrypt(String data) {
    try {

      Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
      int blockSize = cipher.getBlockSize();

      byte[] dataBytes = data.getBytes();
      int plaintextLength = dataBytes.length;
      if (plaintextLength % blockSize != 0) {
        plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
      }

      byte[] plaintext = new byte[plaintextLength];
      System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);

      SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
      IvParameterSpec ivspec = new IvParameterSpec(key.getBytes());

      cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
      byte[] encrypted = cipher.doFinal(plaintext);

      return new String(Base64.encodeBase64(encrypted));

    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      return null;
    }
  }

  public static String desEncrypt(String data) {
    try {
      byte[] encrypted1 = Base64.decodeBase64(data);

      Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
      SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
      IvParameterSpec ivspec = new IvParameterSpec(key.getBytes());

      cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

      byte[] original = cipher.doFinal(encrypted1);
      String originalString = new String(original);
      return originalString;
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      return null;
    }
  }

  public static void main(String[] args) throws Exception {
    System.out.println(encrypt("xiaochun.zeng@tendcloud.com#127.0.0.1#1361111111"));
    System.out.println(desEncrypt("NZ2EJDTnYQqGXmeuc85F8Q=="));
  }
}
