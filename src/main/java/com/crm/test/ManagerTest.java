package com.crm.test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.crm.util.PasswordEncrypt;


public class ManagerTest {
	
	
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String encodeByMd5 = PasswordEncrypt.encodeByMd5("ysd123");
		System.out.println(encodeByMd5);
	}
}
