package com.m2m.technicalservices.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.m2m.technicalservices.log.ILogger;
import com.m2m.technicalservices.log.impl.SL4JLogger;

/**
 * classe uttilitaire
 * 
 * @author Younes SOUTEH
 * 
 */
public class Utils {

	private static final ILogger LOGGER = SL4JLogger.getInstance(Utils.class);

	private Utils() {
	}

	/**
	 * convert to SHA1
	 * 
	 * @param input
	 * @return
	 */
	public static String toSHA1(String input) {
		byte[] convertme = input.getBytes();
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {

			LOGGER.error("NoSuchAlgorithmException : error converting to SHA1",
					e);
		}
		return byteArrayToHexString(md.digest(convertme));
	}

	private static String byteArrayToHexString(byte[] b) {
		String result = "";
		for (int i = 0; i < b.length; i++) {
			result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
		}
		return result;
	}

}
