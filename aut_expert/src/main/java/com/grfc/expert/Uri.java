package main.java.com.grfc.expert;

public class Uri {
	
	public static String url (int user) {
		String apiUrl = null;
		if (user == 0) {
			apiUrl = Settings.IP_API + Settings.VER_API;
		}
		else if (user == 1) {
			apiUrl = Settings.IP_API + Settings.VER_API + "users/";
		}
		else if (user == 2) {
			apiUrl = Settings.IP_API + Settings.VER_API + "users/man/";
		}
		else if (user == 22) {
			apiUrl = Settings.IP_API + Settings.VER_API + "users/man1/";
		}
		else if (user == 3) {
			apiUrl = Settings.IP_API + Settings.VER_API + "users/groupman/";
		}
		else if (user == 4) {
			apiUrl = Settings.IP_API + Settings.VER_API + "users/topman/";
		}
		return apiUrl;
	}
}
