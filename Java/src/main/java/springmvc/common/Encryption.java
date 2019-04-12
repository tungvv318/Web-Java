package springmvc.common;

import org.mindrot.jbcrypt.BCrypt;

public class Encryption {
	public static String hashPassword(String password) {
		String passWordAfterHash = BCrypt.hashpw(password, BCrypt.gensalt(8));
		return passWordAfterHash;
	}
	public static boolean checkPassAtferHash(String password, String passWordAfterHash) {
		boolean valuate = BCrypt.checkpw(password, passWordAfterHash);
		return valuate;
	}
}
