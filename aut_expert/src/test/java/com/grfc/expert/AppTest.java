package test.java.com.grfc.expert;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import main.java.com.grfc.expert.Comparer;
import main.java.com.grfc.expert.HttpRequest;
import main.java.com.grfc.expert.JsonParser;
import main.java.com.grfc.expert.KeyFinder;
import main.java.com.grfc.expert.Uri;
import main.java.com.grfc.expert.Settings;
import main.java.com.grfc.expert.SqlRequest;
import main.java.com.grfc.expert.TestData;
import main.java.com.grfc.expert.Tools;
import main.java.com.grfc.expert.JsonBuilder;
import ru.yandex.qatools.allure.annotations.*;

public class AppTest {

    @Test
    @Description("get token, request method /expert-degrees, parse json, sql select with join on tables, compare")
    @Step("/expert-degrees")
    public void structExpertDegrees() throws ParseException, IOException, SQLException, InterruptedException {
    	String token = JsonParser.parseResponse(HttpRequest.sendRequest(Uri.url(1) + "auth/login", Settings.getExpParameters(), "POST", null, Settings.httpContType("FORM")), 
				"auth");
		String json = JsonParser.parseResponse(HttpRequest.sendRequest(Uri.url(0) + "expert-degrees/", null, "GET", token, Settings.httpContType("FORM")),
				"expert-degrees");
		String sqlToTest = SqlRequest.getSql("expert-degrees");
		assertTrue("Result is not equal", Comparer.equals(Comparer.stringToSet(sqlToTest), Comparer.stringToSet(json)) == true);
    }
    
    @Test
    @Description("get token, request method /violation-types, parse json, sql select with join on tables, compare")
    @Step("/violation-types")
    public void structViolationType() throws ParseException, IOException, SQLException, InterruptedException {
    	String token = JsonParser.parseResponse(HttpRequest.sendRequest(Uri.url(1) + "auth/login", Settings.getExpParameters(), "POST", null, Settings.httpContType("FORM")), 
				"auth");
    	String json = JsonParser.parseResponse(HttpRequest.sendRequest(Uri.url(0) + "violation-types/", null, "GET", token, Settings.httpContType("FORM")),
				"violation-types");
    	String sqlToTest = SqlRequest.getSql("violation-types");
    	assertTrue("Result is not equal", Comparer.equals(Comparer.stringToSet(sqlToTest), Comparer.stringToSet(json)) == true);
    }
    
    @Test
    @Description("get token, request method /expert-specialties, parse json, sql select with join on tables, compare")
    @Step("/expert-specialties")
    public void structExpertSpecs() throws ParseException, IOException, SQLException, InterruptedException {
    	String token = JsonParser.parseResponse(HttpRequest.sendRequest(Uri.url(1) + "auth/login", Settings.getExpParameters(), "POST", null, Settings.httpContType("FORM")), 
				"auth");
    	String json = JsonParser.parseResponse(HttpRequest.sendRequest(Uri.url(0) + "expert-specialties/", null, "GET", token, Settings.httpContType("FORM")),
				"expert-specialties");
    	String sqlToTest = SqlRequest.getSql("expert-specialties");
    	assertTrue("Result is not equal", Comparer.equals(Comparer.stringToSet(sqlToTest), Comparer.stringToSet(json)) == true);
    }
    
    @Test
    @Description("get token, request method /region, parse json, sql select with join on tables, compare")
    @Step("/region")
    public void structRegion() throws ParseException, IOException, SQLException, InterruptedException {
    	String token = JsonParser.parseResponse(HttpRequest.sendRequest(Uri.url(1) + "auth/login", Settings.getExpParameters(), "POST", null, Settings.httpContType("FORM")), 
				"auth");
    	String json = JsonParser.parseResponse(HttpRequest.sendRequest(Uri.url(0) + "region/", null, "GET", token, Settings.httpContType("FORM")),
				"region");
    	String sqlToTest = SqlRequest.getSql("region");
    	assertTrue("Result is not equal", Comparer.equals(Comparer.stringToSet(sqlToTest), Comparer.stringToSet(json)) == true);
    }
    
	@Test
	@Description("get token, request method /external_experts , parse json, sql select, compare")
	@Step("/sources")
    public void structExEx() throws ParseException, IOException, SQLException, InterruptedException {
    	String token = JsonParser.parseResponse(HttpRequest.sendRequest(Uri.url(1) + "auth/login", Settings.getExpParameters(), "POST", null, Settings.httpContType("FORM")), 
				"auth");
    	String json = JsonParser.parseResponse(HttpRequest.sendRequest(Uri.url(0) + "external-experts/", null, "GET", token, Settings.httpContType("FORM")),
				"external-experts");
    	String sqlToTest = SqlRequest.getSql("external-experts");
    	assertTrue("Result is not equal", Comparer.equals(Comparer.stringToSet(sqlToTest), Comparer.stringToSet(json)) == true);
    }
    
    @Test
    @Description("get token, request method /sources , parse json, sql select, compare")
    @Step("/sources")
    public void structSourceList() throws ParseException, IOException, SQLException, InterruptedException {
    	String token = JsonParser.parseResponse(HttpRequest.sendRequest(Uri.url(1) + "auth/login", Settings.getExpParameters(), "POST", null, Settings.httpContType("FORM")), 
				"auth");
    	String json = JsonParser.parseResponse(HttpRequest.sendRequest(Uri.url(0) + "sources/", null, "GET", token, Settings.httpContType("FORM")),
				"sources");
    	String sqlToTest = SqlRequest.getSql("sources");
    	assertTrue("Result is not equal", Comparer.equals(Comparer.stringToSet(sqlToTest), Comparer.stringToSet(json)) == true);
    }
    
    @Test
    @Description("get token, request method /sources , parse json, sql select, compare")
    @Step("/users")
    public void structUsers() throws ParseException, IOException, SQLException, InterruptedException {
    	String token = JsonParser.parseResponse(HttpRequest.sendRequest(Uri.url(1) + "auth/login", Settings.getExpParameters(), "POST", null, Settings.httpContType("FORM")), 
				"auth");
    	String json = JsonParser.parseResponse(HttpRequest.sendRequest(Uri.url(0) + "users/", null, "GET", token, Settings.httpContType("FORM")),
				"users");
    	String sqlToTest = SqlRequest.getSql("users");
    	assertTrue("Result is not equal", Comparer.equals(Comparer.stringToSet(sqlToTest), Comparer.stringToSet(json)) == true);
    }
    
    @Test
    @Description("get token, request method /source-types , parse json, compare to static")
    @Step("/source-types")
    public void structSourceTypes() throws ParseException, IOException, SQLException, InterruptedException {
    	String token = JsonParser.parseResponse(HttpRequest.sendRequest(Uri.url(1) + "auth/login", Settings.getExpParameters(), "POST", null, Settings.httpContType("FORM")), 
				"auth");
    	String json = JsonParser.parseResponse(HttpRequest.sendRequest(Uri.url(0) + "source-types/", null, "GET", token, Settings.httpContType("FORM")),
				"source-types");
    	assertTrue("Result is not equal", Comparer.equals(Comparer.stringToSet(Settings.SOURCE_TYPES), Comparer.stringToSet(json)) == true);
    }

    @Test
    @Description("get token, request method /information-types , parse json, compare to static")
    @Step("/information-types")    
    public void structInformTypes() throws ParseException, IOException, SQLException, InterruptedException {
    	String token = JsonParser.parseResponse(HttpRequest.sendRequest(Uri.url(1) + "auth/login", Settings.getExpParameters(), "POST", null, Settings.httpContType("FORM")), 
				"auth");
    	String json = JsonParser.parseResponse(HttpRequest.sendRequest(Uri.url(0) + "information-types/", null, "GET", token, Settings.httpContType("FORM")),
				"information-types");
    	assertTrue("Result is not equal", Comparer.equals(Comparer.stringToSet(Settings.INFORMARTION_TYPES), Comparer.stringToSet(json)) == true);
    }
    
    @Test
    @Description("get token, request method /review-types , parse json, compare to static")
    @Step("/review-types")    
    public void structReviewTypes() throws ParseException, IOException, SQLException, InterruptedException {
    	String token = JsonParser.parseResponse(HttpRequest.sendRequest(Uri.url(1) + "auth/login", Settings.getExpParameters(), "POST", null, Settings.httpContType("FORM")), 
				"auth");
    	String json = JsonParser.parseResponse(HttpRequest.sendRequest(Uri.url(0) + "review-types/", null, "GET", token, Settings.httpContType("FORM")),
				"review-types");
    	assertTrue("Result is not equal", Comparer.equals(Comparer.stringToSet(Settings.REVIEW_TYPES), Comparer.stringToSet(json)) == true);
    }
    
    @Test
    @Description("get token, request method /information-decisions , parse json, compare to static")
    @Step("/review-decisions")    
    public void structReviewDecisions() throws ParseException, IOException, SQLException, InterruptedException {
    	String token = JsonParser.parseResponse(HttpRequest.sendRequest(Uri.url(1) + "auth/login", Settings.getExpParameters(), "POST", null, Settings.httpContType("FORM")), 
				"auth");
    	String json = JsonParser.parseResponse(HttpRequest.sendRequest(Uri.url(0) + "review-decisions/", null, "GET", token, Settings.httpContType("FORM")),
				"review-decisions");
    	assertTrue("Result is not equal", Comparer.equals(Comparer.stringToSet(Settings.REVIEW_DECISIONS), Comparer.stringToSet(json)) == true);
    }
	
//////--------------------------------------------------endToEnd-------------------------------------------------- 
		
	@Test
    @Description("endToEnd")
    @Step("endToEnd")    
    public void endToEnd() throws ParseException, IOException, SQLException, InterruptedException {
		
//    	String keyword = TestData.createCard();
//    	Thread.sleep(3000);
//    	String keyword = "TEST20180425165132";
//    	System.out.println(keyword);
//    	--------------SQL illegal request creation
//    	String keyword = "test"+Tools.timeStamp("yyyyMMddHHmmss");
//    	SqlRequest.insertReview (keyword);
//    	--------------SQL illegal request creation
    	String authMan = HttpRequest.sendRequest(Uri.url(1) + "auth/login", Settings.getExpParameters(), "POST", null, Settings.httpContType("FORM"));	
    	String authManOne = HttpRequest.sendRequest(Uri.url(1) + "auth/login", Settings.getExpParameters(), "POST", null, Settings.httpContType("FORM"));
    	String authGroupMan = HttpRequest.sendRequest(Uri.url(1) + "auth/login", Settings.getGroupmanCreds(), "POST", null, Settings.httpContType("FORM"));
    	String authTopMan = HttpRequest.sendRequest(Uri.url(1) + "auth/login", Settings.getManagCreds(), "POST", null, Settings.httpContType("FORM"));
    	
    	String token = JsonParser.parseResponse(authMan, "auth");
    	String token1 = JsonParser.parseResponse(authManOne, "auth");
    	String token2 = JsonParser.parseResponse(authGroupMan, "auth");
    	String token3 = JsonParser.parseResponse(authTopMan, "auth");
//		String inqPk = JsonParser.findExprevPk(HttpRequest.sendRequest(Uri.url(0) + "review-inquiries/", null, "GET", token, Settings.httpContType("FORM")),keyword);
    	String inqPk = "1448";
//    	System.out.println(inqPk);
    	String assignPayload = HttpRequest.sendRequest(Uri.url(2) + "review-inquiries/assign", "{\"inquiry_ids\":[\"" + inqPk + "\"],\"coauthors_ids\":[" + KeyFinder.getValueAnd(authMan, "pk") + "],\"group_manager_id\":"+ KeyFinder.getValueAnd(authGroupMan, "pk") +"}", "POST", token, Settings.httpContType("JSON"));
    	String expPk = JsonParser.assign(assignPayload, inqPk);
//    	String expPk = "665";
    	HttpRequest.sendPutRequest(Uri.url(2) + "expert-reviews/" + expPk, token, JsonBuilder.editBlockerBody("start"));
    	String upload = HttpRequest.sendPutRequestFormData(Uri.url(2) + "expert-reviews/" + expPk, token, "edit_blocker", "update", "C:\\Users\\psi\\Documents\\_work\\E000-307_18_v3.docx", "conclusions");
    	String docxUrl = KeyFinder.getValueAnd(upload, "document");
    	System.out.println(docxUrl);
    	List<String> items = Arrays.asList(docxUrl.split("/"));
    	System.out.println(items);
    	String docxFilename = items.get(items.size() -1);
    	System.out.println(docxFilename);
    	HttpRequest.sendPutRequest(Uri.url(2) + "expert-reviews/" + expPk, token, JsonBuilder.opinion());
    	HttpRequest.sendPutRequest(Uri.url(2) + "expert-reviews/" + expPk, token, JsonBuilder.editBlockerBody("finish"));
    	Tools.saveFile(docxFilename + ".sig", docxUrl);
    	
    	HttpRequest.sendPutRequest(Uri.url(3) + "expert-reviews/" + expPk, token2, JsonBuilder.editBlockerBody("start"));
    	HttpRequest.sendPutRequest(Uri.url(3) + "expert-reviews/" + expPk, token2, JsonBuilder.update());
    	HttpRequest.sendPutRequest(Uri.url(3) + "expert-reviews/" + expPk + "/change_status/", token2, JsonBuilder.rework());
    	HttpRequest.sendPutRequest(Uri.url(3) + "expert-reviews/" + expPk, token2, JsonBuilder.editBlockerBody("finish"));
//    	
    	HttpRequest.sendPutRequest(Uri.url(2) + "expert-reviews/" + expPk, token, JsonBuilder.editBlockerBody("start"));
    	HttpRequest.sendPutRequest(Uri.url(2) + "expert-reviews/" + expPk, token, JsonBuilder.opinion());
    	HttpRequest.sendPutRequest(Uri.url(2) + "expert-reviews/" + expPk, token, JsonBuilder.editBlockerBody("finish"));
//    	
    	HttpRequest.sendPutRequest(Uri.url(3) + "expert-reviews/" + expPk, token2, JsonBuilder.editBlockerBody("start"));
    	HttpRequest.sendPutRequest(Uri.url(3) + "expert-reviews/" + expPk, token2, JsonBuilder.update());
    	HttpRequest.sendPutRequest(Uri.url(3) + "expert-reviews/" + expPk + "/change_status/", token2, JsonBuilder.all());
    	HttpRequest.sendPutRequest(Uri.url(3) + "expert-reviews/" + expPk, token2, JsonBuilder.editBlockerBody("finish"));
//    	
    	
    	HttpRequest.sendPutRequest(Uri.url(4) + "expert-reviews/" + expPk, token3, JsonBuilder.editBlockerBody("start"));
    	HttpRequest.sendPutRequest(Uri.url(4) + "expert-reviews/" + expPk, token3, JsonBuilder.update());
    	HttpRequest.sendPutRequest(Uri.url(4) + "expert-reviews/" + expPk, token3, JsonBuilder.editBlockerBody("finish"));
    	HttpRequest.sendPutRequest(Uri.url(4) + "expert-reviews/" + expPk + "/change_status/", token3, JsonBuilder.rework()); //finish before change_status is necessary!
    	
    	
    	HttpRequest.sendPutRequest(Uri.url(3) + "expert-reviews/" + expPk, token2, JsonBuilder.editBlockerBody("start"));
    	HttpRequest.sendPutRequest(Uri.url(3) + "expert-reviews/" + expPk, token2, JsonBuilder.update());
    	HttpRequest.sendPutRequest(Uri.url(3) + "expert-reviews/" + expPk + "/change_status/", token2, JsonBuilder.all());
    	HttpRequest.sendPutRequest(Uri.url(3) + "expert-reviews/" + expPk, token2, JsonBuilder.editBlockerBody("finish"));

    	HttpRequest.sendPutRequest(Uri.url(4) + "expert-reviews/" + expPk, token3, JsonBuilder.editBlockerBody("start"));
    	HttpRequest.sendPutRequest(Uri.url(4) + "expert-reviews/" + expPk, token3, JsonBuilder.update());
    	HttpRequest.sendPutRequest(Uri.url(4) + "expert-reviews/" + expPk + "/change_status/", token3, JsonBuilder.approve());
    	HttpRequest.sendPutRequest(Uri.url(4) + "expert-reviews/" + expPk, token3, JsonBuilder.editBlockerBody("finish"));
    	HttpRequest.sendPutRequest(Uri.url(4) + "expert-reviews/" + expPk, token3, JsonBuilder.editBlockerBody("start"));
    	HttpRequest.sendPutRequestFormData(Uri.url(4) + "expert-reviews/" + expPk, token3, "edit_blocker", "update", Settings.FILEPATH + docxFilename + ".sig", "sign");
    	HttpRequest.sendPutRequest(Uri.url(4) + "expert-reviews/" + expPk, token3, JsonBuilder.editBlockerBody("finish"));
	}
//------------------------------------------email ext exp------------------   
//    @Test
//    @Description("endToEnd")
//    @Step("endToEnd")    
//    public void externalExpScene() throws ParseException, IOException, SQLException, InterruptedException {
//    	String token2 = JsonParser.parseResponse(HttpRequest.sendRequest(Uri.url(1) + "auth/login", 		Settings.getGroupmanCreds(), "POST", null, Settings.httpContType("FORM")), 
//				"auth");
////    	String inqPk = JsonParser.findExprevPk(HttpRequest.sendRequest(Uri.url(0) + "review-inquiries/", null, "GET", token, Settings.httpContType("FORM")),keyword);
//    	String inqPk = "1309";
//    	String assignPayload = HttpRequest.sendRequest(Uri.url(3) + "review-inquiries/assign_forming_on_email", "{\"inquiry_ids\":[\"1309\"],\"external_expert\":332,\"group_manager_id\":110}", "POST", token2, Settings.httpContType("JSON"));
//    	String expPk = JsonParser.assign(assignPayload, inqPk);
//-------------------------------------------------------------------------
}
