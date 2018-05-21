package main.java.com.grfc.expert;

public class Settings {
	public static String ip = "192.168.71.63";
//	public static String ip = "192.168.69.118:8000";
	public static String IP_API        = "http://" + ip + "/";
	public static String VER_API        = "api/v1/";
	
	public static String FILEPATH = System.getProperty("user.dir") + "\\Test\\";

	private static String AUTH_CREDENTIALS  = "username=man&password=pswd";
	private static String AUTH_CREDENTIALS1  = "username=man1&password=pswd";
	private static String AUTH_CREDENTIALS_GROUPMAN  = "username=groupman&password=pswd";
	private static String AUTH_CREDENTIALS_MANAGER  = "username=topman&password=pswd";
	
	public static String SOURCE_TYPES = "1   Электронное периодическое издание\r\n"
									  + "2   Информационное агентство\r\n"
									  + "3   Сетевое издание\r\n"
									  + "4   Интернет-сайт, не зарегистрированный в качестве СМИ (Hearst Shkulev Digital)\r\n"
									  + "5   Интернет-сайт, не зарегистрированный в качестве СМИ (иное)\r\n"
									  + "6   Печатное СМИ (газета)\r\n"
									  + "7   Печатное СМИ (журнал)\r\n"
									  + "8   Телеканал\r\n"
									  + "9   Радиоканал\r\n";
	
	public static String INFORMARTION_TYPES = "0   Аудиоматериал\r\n"
											+ "1   Видеоматериал\r\n"
											+ "2   Изображение\r\n"
											+ "3   Текст\r\n";
	
	public static String REVIEW_TYPES = "0   СМИ\r\n"
									  + "1   Экспресс\r\n"
									  + "2   Суицид\r\n"
	                                  + "3   ДП\r\n";
	
	public static String REVIEW_DECISIONS = "true   Да\r\n"
										  + "false   Нет\r\n";
	
	public static String getExpParameters() {
		return AUTH_CREDENTIALS;
	}
	public static String getExpTwoParameters() {
		return AUTH_CREDENTIALS;
	}
	public static String getGroupmanCreds() {
		return AUTH_CREDENTIALS_GROUPMAN;
	}
	public static String getManagCreds() {
		return AUTH_CREDENTIALS_MANAGER;
	}
	
	public static void setUrlParameters(String urlParameters) {
		Settings.AUTH_CREDENTIALS = urlParameters;
	}
	
	public static String timeZone(String regionDep) {
		
		String zone = null;
		
		switch (regionDep) {
		case "Europe/Kaliningrad":
			zone = "23";
		break;
		}
		
		switch (regionDep) {
		case "Asia/Irkutsk":
			zone = "5";
		break;
		}
		
		switch (regionDep) {
		case "Asia/Yakutsk":
			zone = "6";
		break;
		}
		
		switch (regionDep) {
		case "Asia/Yekaterinburg":
			zone = "2";
		break;
		}
		
		switch (regionDep) {
		case "Europe/Samara":
			zone = "1";
		break;
		}
		
		switch (regionDep) {
		case "Asia/Novosibirsk":
			zone = "4";
		break;
		}
		
		switch (regionDep) {
		case "Asia/Krasnoyarsk":
			zone = "4";
		break;
		}
		
		switch (regionDep) {
		case "Europe/Moscow":
			zone = "0";
		break;
		}
		
		switch (regionDep) {
		case "Asia/Magadan":
			zone = "8";
		break;
		}
		
		switch (regionDep) {
		case "Asia/Kamchatka":
			zone = "9";
		break;
		}
		
		switch (regionDep) {
		case "Asia/Vladivostok":
			zone = "7";
		break;
		}
		
		return zone;
		
	}
	
	public static String httpContType (String contType) {
		
		switch (contType) {
		case "JSON":
			contType = "application/json";
		break;
		}
		
		switch (contType) {
		case "FORM":
			contType = "application/x-www-form-urlencoded";
		break;
		}
		
		return contType;
	}
}
