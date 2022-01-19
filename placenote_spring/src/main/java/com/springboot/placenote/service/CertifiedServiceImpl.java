package com.springboot.placenote.service;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Service
public class CertifiedServiceImpl implements CertifiedService {

	@Override
	public void certifiedPhoneNumber(String phoneNumber, String cerNum) {
		String api_key = "NCSPTKRF0KTVR9NT";
		String api_secret = "TTS4KZTRWJ9R9O7IIDB98ZWD6KRKJ1UJ";
		Message coolsms = new Message(api_key, api_secret);
		
		HashMap<String, String> params = new HashMap<>();
		params.put("to", phoneNumber);
		params.put("from", "010-7653-1685");
		params.put("type", "SMS");
		params.put("text", "휴대폰 인증 메세지 : 인증번호는 [" + cerNum + "] 입니다.");
		params.put("app_version", "test app 1.2");

		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
	}
	
}
