package main.java.com.grfc.expert;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlRequest {
	
	static String baseUrl = Settings.ip;
	
	public static String getSql (String methForSql) throws SQLException {

		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://" + baseUrl + ":5432/expert", "expert",
					"expert123");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		
		Statement st = connection.createStatement();
		StringBuilder sb = new StringBuilder();
		StringBuilder sbSub = new StringBuilder();
		
		ResultSet rs = null;
		
		switch (methForSql) {
		case "expert-degrees":
			rs = st.executeQuery("SELECT * FROM reviewsapp_degree");
			while (rs.next())
			{
				sb.append(rs.getString("id") 
				+"   "+ rs.getString("name") 
				+"   "+ rs.getString("code"));
				sb.append(System.getProperty("line.separator"));

			}
		break;	
		}
		
		switch (methForSql) {
		case "violation-types":
			rs = st.executeQuery("SELECT id, name, name_for_print, is_active FROM reviewsapp_violationtype");
			while (rs.next())
			{			
				sb.append(rs.getString("id") 
				+ "   " + rs.getString("name") 
				+ "   " + rs.getString("name_for_print") 
				+ "   " + Tools.tfTrueFalse(rs.getString("is_active")));
				sb.append(System.getProperty("line.separator"));
			}
		break;	
		}
		
		switch (methForSql) {
		case "expert-specialties":
			rs = st.executeQuery("SELECT * FROM reviewsapp_specialty");
			while (rs.next())
			{
				sb.append(rs.getString("id") 
				+ "   " + rs.getString("name") 
				+ "   " + rs.getString("code"));
				sb.append(System.getProperty("line.separator"));

			}
		break;	
		}
		
		switch (methForSql) {
		case "region":
			rs = st.executeQuery("select r.entity_code, r.name, r.capital_city, r.region_timezone, r.federal_district_id, f.name AS FNAME from regionsapp_constituententity r\r\n" + 
					"join regionsapp_federaldistrict f \r\n" + 
					"on r.federal_district_id = f.id");
			while (rs.next())
			{
				sb.append(rs.getString("entity_code") +
						"   " + rs.getString("name") +
						"   " + rs.getString("capital_city") +
						"   " + Settings.timeZone(rs.getString("region_timezone")) +
						"   " + rs.getString("federal_district_id") +
						"   " + rs.getString("FNAME"));
				sb.append(System.getProperty("line.separator"));

			}
		break;	
		}
		
		switch (methForSql) {
		case "external-experts":
			rs = st.executeQuery("select q.id, q.first_name, q.middle_name, q.last_name, r.name AS RNAME, q.experience_duration, q.is_active, q.contract_expiry_date, q.contract_signing_date from reviewsapp_externalexpert q\r\n" + 
					"left join regionsapp_constituententity r ON q.region_id = r.entity_code");
			while (rs.next())
			{
				sb.append(rs.getString("id") +
						"   "+ rs.getString("first_name") +
						"   "+ rs.getString("last_name") +
						"   "+ rs.getString("middle_name") +
						"   "+ rs.getString("RNAME") +
						"   "+ rs.getString("experience_duration"));
//------------------------------------------------for checking crazy crutch instead of base write-----
				String expi = rs.getString("contract_expiry_date");
				String signi = rs.getString("contract_signing_date");
				if (expi == null || signi == null) { 
					sb.append("   "+ Tools.tfTrueFalse(rs.getString("is_active")));
				}
				else {
					long exp = new Long(expi.substring(0, 10).replace("-", "")).longValue();
//					long sign = new Long(signi.substring(0, 10).replace("-", "")).longValue();
					long now = Long.valueOf(Tools.timeStamp("yyyyMMdd"));
					if (exp <= now) {
						sb.append("   false");
					}
					else {
						sb.append("   "+ Tools.tfTrueFalse(rs.getString("is_active")));
					}
				}
//---------------------------------------------------------------------------------------------------
				sb.append("   /api/v1/external-experts/" + rs.getString("id"));
				Statement stSub = connection.createStatement();
				ResultSet rsSub = stSub.executeQuery("select d.name AS DNAME from reviewsapp_degree d join reviewsapp_externalexpert_degrees w ON w.degree_id = d.id where externalexpert_id="+rs.getString("id"));
				
				if (rsSub.next() == false) { 
					sb.append("null");  
					} 
				else { 
					do { 
						sbSub.append("   "+ rsSub.getString("DNAME")); 
						} 
					while (rsSub.next()); 
					}
				sb.append(Tools.stringOrder(sbSub.toString()));
				sbSub.setLength(0);
				stSub.close();
				rsSub.close();
				Statement stSub2 = connection.createStatement();
				ResultSet rsSub2 = stSub2.executeQuery("select s.name AS SNAME from reviewsapp_specialty s join reviewsapp_externalexpert_specialties e ON e.specialty_id = s.id where externalexpert_id="+rs.getString("id"));

				if (rsSub2.next() == false) { 
					sb.append("null");  
					} 
				else { 
					do {
						sbSub.append("   "+ rsSub2.getString("SNAME")); 
						} 
					while (rsSub2.next()); 
					}
				sb.append(Tools.stringOrder(sbSub.toString()));
				sbSub.setLength(0);
				
				sb.append(System.getProperty("line.separator"));
				stSub2.close();
				rsSub2.close();
			}
		break;	
		}
		
		switch (methForSql) {
		case "sources":
			rs = st.executeQuery("select id, name, url from sourcesapp_source");
			while (rs.next())
			{
				sb.append(rs.getString("id") +
						"   "+ rs.getString("name") +
						"   "+ Settings.IP_API + Settings.VER_API + "sources/" + rs.getString("id"));
				sb.append(System.getProperty("line.separator"));

			}
		break;	
		}
		
		switch (methForSql) {
		case "users":
			rs = st.executeQuery("select r.id, r.username, r.first_name, "
					+ "r.last_name, r.middle_name, r.is_active, r.position, r.phone_number, "
					+ "r.email, a.name AS ANAME from users_user r\n" + 
					"join users_user_groups u ON r.id = u.user_id\n" + 
					"join auth_group a ON a.id = u.group_id");
			while (rs.next())
			{
				sb.append(Tools.nullMaker(rs.getString("id")) 
				+ "   " + Tools.nullMaker(rs.getString("username")) 
				+ "   " + Tools.nullMaker(rs.getString("first_name"))
				+ "   " + Tools.nullMaker(rs.getString("last_name")) 
				+ "   " + Tools.nullMaker(rs.getString("middle_name")) 
				+ "   " + Tools.nullMaker(Tools.tfTrueFalse(rs.getString("is_active")))
				+ "   " + Tools.nullMaker(rs.getString("position")) 
				+ "   " + Tools.nullMaker(rs.getString("phone_number")) 
				+ "   " + Tools.nullMaker(rs.getString("email"))
				+ "   " + Tools.nullMakerSum(rs.getString("first_name"),rs.getString("last_name")) 
				+ "   " + Tools.nullMaker(rs.getString("ANAME")));
				sb.append(System.getProperty("line.separator"));

			}
		break;
		}
		
		rs.close();
		st.close();
		connection.close();
		String sqlResult = sb.toString();
		System.out.println(sqlResult);
		return sqlResult;
		
	}
	
//--------------------------------------------creates test inquiries------------------------------------------	
	
	public static void insertReview (String locatorName) throws SQLException {
		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://" + baseUrl + ":5432/expert", "expert",
					"expert123");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		
		Statement st = connection.createStatement();
		st.executeUpdate(
                "INSERT INTO reviewsapp_reviewinquiry VALUES (DEFAULT,10465,'2018-01-11 00:01:00+03','2017-01-10 23:23:23.543445+03','Антон Любимов','','тост перетост весьма','','','" + locatorName + "','','lool','2018-01-08','23:23:30','',null,null,'','',1,1,130,'','','','',FALSE);");
		connection.close();
		st.close();
	}
	
}