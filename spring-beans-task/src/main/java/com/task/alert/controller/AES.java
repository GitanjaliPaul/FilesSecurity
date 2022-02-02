package com.task.alert.controller;
import java.io.File;

import javax.crypto.Cipher;
import java.security.*;
import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.core.codec.ByteArrayEncoder;
import org.springframework.web.bind.annotation.RestController;
import com.security.utils.*;
@RestController
public class AES {

	
		
		private static final String ALGO="AES";
		private byte[] keyvalue;
		
		public AES(String key) {
			keyvalue=key.getBytes();
			
		}
		
		public String encrypt(String data) throws Exception {
			Key key=generateKey();
			Cipher c=Cipher.getInstance(ALGO);
			c.init(Cipher.ENCRYPT_MODE,key);
			byte[] encVal=c.doFinal(data.getBytes());
			String encryptedvalue=new BASE64Encoder().encode(encVal);
			return encryptedvalue;
		}
		public Sring decrypt(String encrypteddata) throws Exception{
			Key key=generateKey();
			Cipher c=Cipher.getInstance(ALGO);
			c.init(Cipher.DECRYPT_MODE,key);
			
                byte[] decordedvalue =new BASE64Decoder().decodeBuffer(encrypteddata);
                byte[] decValue=c.doFinal(decordedvalue);
                String decryptedvalue=new String(decValue);
                return decryptedvalue;}
		private Key generateKey() throws Exception{
			Key key=new SecretKeySpec(keyvalue,ALGO);
			return key;
		}
		
		public static void main(String[] args) {
			try {
				AES aes=new AES("Iv39eptlvuhaqqsr");
				String encdata=aes.encrypt("TaskOnhand");
				System.out.println("Encrypted data:"+encdata);
				String decrypt=aes.decrypt(encdata);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
//		
		 
		}
