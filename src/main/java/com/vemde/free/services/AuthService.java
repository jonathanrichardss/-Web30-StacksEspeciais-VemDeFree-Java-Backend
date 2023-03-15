package com.vemde.free.services;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
	
	public static String makeASecret(String key) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		var secret = key;
		
		MessageDigest secretsBox = MessageDigest.getInstance("SHA-256");
		byte secretKeyArray[] = secretsBox.digest(secret.getBytes("UTF-8"));
		
		StringBuilder hexStringSecretKey = new StringBuilder();
		
		for (byte b : secretKeyArray) {
			hexStringSecretKey.append(String.format("%02X", 0xFF & b));
		}
		
		String hexKeyUser = hexStringSecretKey.toString();
		
		return hexKeyUser;
		
	}
}
