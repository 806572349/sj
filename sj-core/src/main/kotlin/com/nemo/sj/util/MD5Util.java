package com.nemo.sj.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class MD5Util {

	public static String md5(byte[] bytes){
		return DigestUtils.md5Hex(bytes);
	}
	
	/** 
     * MD5数字签名 
     * @param src 
     * @return 
     * @throws Exception 
     */  
    public static String md5Digest(String src)  {
       // 定义数字签名方法, 可用：MD5, SHA-1  
        MessageDigest md = null;
        byte[] b=new byte[]{};
        try {
            md = MessageDigest.getInstance("MD5");
             b = md.digest(src.getBytes("utf-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return byte2HexStr(b);
    }  
    /** 
     * 字节数组转化为大写16进制字符串 
     * @param b 
     * @return 
     */  
    private static String byte2HexStr(byte[] b) {  
        StringBuilder sb = new StringBuilder();  
        for (int i = 0; i < b.length; i++) {  
            String s = Integer.toHexString(b[i] & 0xFF);  
            if (s.length() == 1) {  
                sb.append("0");  
            }  
            sb.append(s.toUpperCase());  
        }  
        return sb.toString();  
    }

    /**
     * 返回随机唯一码
     * @return
     */
    public static String RondomMD5Str(){
        return md5(UUID.randomUUID().toString().getBytes());
    }





}
