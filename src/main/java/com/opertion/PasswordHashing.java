package com.opertion;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHashing {

 public static void main(String[] args) {
  System.out.println(doHashing("12345678"));
 }

 public static String doHashing (String password) {
  try {
   MessageDigest messageDigest = MessageDigest.getInstance("MD5");
   
   messageDigest.update(password.getBytes());
   
   byte[] resultByteArray = messageDigest.digest();
   
   StringBuilder sb = new StringBuilder();
   
   for (byte b : resultByteArray) {
    sb.append(String.format("%02x", b));
   }
   
   return sb.toString();
   
  } catch (NoSuchAlgorithmException e) {
   e.printStackTrace();
  }
  
  return "";
 }
 
}