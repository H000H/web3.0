package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class Encryption {
	public static String EncoderByMD5(String str){
		try {
			MessageDigest md5=MessageDigest.getInstance("MD5");
			BASE64Encoder base64en=new BASE64Encoder();
			String newStr;
			newStr = base64en.encode(md5.digest(str.getBytes("utf-8")));
			return newStr;
		} catch (NoSuchAlgorithmException|UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) {
		String a="holle word";
		String newa=EncoderByMD5(a);
		System.out.print(newa);
	}
}
