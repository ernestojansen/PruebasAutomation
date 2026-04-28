package POMpractice.utils;

import java.util.UUID;

public class DataGenerator {

	public static String generateName() {
		return "User" + System.currentTimeMillis();
	}
	
	public static String generateEmail() {
		return "user" + UUID.randomUUID().toString().substring(0, 5)+ "@test.com";
	}	
	
	public static String generatePassword() {
		return "Pass@" + System.currentTimeMillis();
	}

}