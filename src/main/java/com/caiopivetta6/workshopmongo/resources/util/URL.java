package com.caiopivetta6.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;



public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			return " ";
		}
	}
	
	public static Instant convertDate(String textDate, Instant defaultValue) {
		try {
			return Instant.parse(textDate);
		}catch (Exception e) {
			return defaultValue;
		}
		
	}
	
	
	
}
