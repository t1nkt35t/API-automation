package main.java.com.grfc.expert;

import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {
	
	static JSONParser jsonParser = new JSONParser();
	
	public static String parseResponse (String payload, String apiMeth) throws ParseException {
		
	    String parsed = null;
	    
	    switch (apiMeth) {
	    case "auth":
	    JSONObject jsonResult = (JSONObject) jsonParser.parse(payload);
	    parsed = jsonResult.get("token").toString();
	    break;	    
	    }
	    
	    switch (apiMeth) {
	    case "expert-degrees":
		JSONArray jsonResult = (JSONArray) jsonParser.parse(payload);	
		Iterator<?> i = jsonResult.iterator();
		StringBuilder sb = new StringBuilder();
        
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            sb.append(innerObj.get("pk") 
            + "   " + innerObj.get("name") 
            + "   " + innerObj.get("code"));
            sb.append(System.getProperty("line.separator"));
            }
        parsed = sb.toString();
	    break;	    
	    }
	    
	    switch (apiMeth) {
	    case "violation-types":
		JSONArray jsonResult = (JSONArray) jsonParser.parse(payload);	
		Iterator<?> i = jsonResult.iterator();
		StringBuilder sb = new StringBuilder();
        
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            sb.append(innerObj.get("pk") 
            + "   " + innerObj.get("name") 
            + "   " + innerObj.get("name_for_print") 
            + "   " + innerObj.get("is_active"));
            sb.append(System.getProperty("line.separator"));
            }
        parsed = sb.toString();
	    break;	    
	    }
	    
	    switch (apiMeth) {
	    case "expert-specialties":
		JSONArray jsonResult = (JSONArray) jsonParser.parse(payload);	
		Iterator<?> i = jsonResult.iterator();
		StringBuilder sb = new StringBuilder();
        
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            sb.append(innerObj.get("pk")
            + "   " + innerObj.get("name") 
            + "   " + innerObj.get("code"));
            sb.append(System.getProperty("line.separator"));
            }
        parsed = sb.toString();
	    break;	    
	    }
	    
	    switch (apiMeth) {
	    case "region":
		JSONArray jsonResult = (JSONArray) jsonParser.parse(payload);	
		Iterator<?> i = jsonResult.iterator();
		StringBuilder sb = new StringBuilder();
        
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            sb.append(innerObj.get("entity_code") 
            + "   " + innerObj.get("name") 
            + "   " + innerObj.get("capital_city") 
            + "   " + innerObj.get("timezone_diff"));
            JSONObject jsonSub = (JSONObject) jsonParser.parse(innerObj.get("federal_district").toString());
            sb.append("   " + jsonSub.get("id") 
            		+ "   " + jsonSub.get("name"));
            sb.append(System.getProperty("line.separator"));
            }
        parsed = sb.toString();
	    break;	    
	    }
	    
	    switch (apiMeth) {
	    case "external-experts":
		JSONArray jsonResult = (JSONArray) jsonParser.parse(payload);	
		Iterator<?> i = jsonResult.iterator();
		StringBuilder sb = new StringBuilder();
        
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            sb.append(innerObj.get("pk") 
            + "   " + innerObj.get("first_name") 
            + "   " + innerObj.get("last_name") 
            + "   " + innerObj.get("middle_name") 
            + "   " + innerObj.get("region")
            + "   " + innerObj.get("experience_duration") 
            + "   " + innerObj.get("is_active")
            + "   " + innerObj.get("external_expert_url")
            + Tools.removeQuotes(innerObj.get("degrees").toString())
            + Tools.removeQuotes(innerObj.get("specialties").toString()));

            sb.append(System.getProperty("line.separator"));
            }
        parsed = sb.toString();
	    break;	    
	    }
	    
	    switch (apiMeth) {
	    case "sources":
	    	JSONArray jsonResult = (JSONArray) jsonParser.parse(payload);	
			Iterator<?> i = jsonResult.iterator();
			StringBuilder sb = new StringBuilder();
	        
	        while (i.hasNext()) {
	            JSONObject innerObj = (JSONObject) i.next();
	            sb.append(innerObj.get("pk") 
	            + "   " + innerObj.get("name") 
	            + "   " + innerObj.get("source_url"));
	            sb.append(System.getProperty("line.separator"));
	            }
	        parsed = sb.toString();
	    break;	    
	    }
	    
	    switch (apiMeth) {
	    case "users":
	    	JSONArray jsonResult = (JSONArray) jsonParser.parse(payload);	
			Iterator<?> i = jsonResult.iterator();
			StringBuilder sb = new StringBuilder();
	        
	        while (i.hasNext()) {
	            JSONObject innerObj = (JSONObject) i.next();
	            sb.append(Tools.nullMaker(innerObj.get("pk").toString()) 
	            + "   " + Tools.nullMaker(innerObj.get("username").toString()) 
	            + "   " + Tools.nullMaker(innerObj.get("first_name").toString())
	            + "   " + Tools.nullMaker(innerObj.get("last_name").toString()) 
	            + "   " + Tools.nullMaker(innerObj.get("middle_name").toString())
	            + "   " + Tools.nullMaker(innerObj.get("is_active").toString()) 
	            + "   " + Tools.nullMaker(innerObj.get("position").toString())
	            + "   " + Tools.nullMaker(innerObj.get("phone_number").toString()) 
	            + "   " + Tools.nullMaker(innerObj.get("email").toString())
	            + "   " + Tools.nullMaker(innerObj.get("full_name").toString()) 
	            + "   " + Tools.nullMaker(innerObj.get("role").toString()));
	            sb.append(System.getProperty("line.separator"));
	            }
	        parsed = sb.toString();
	    break;	    
	    }
	    
	    switch (apiMeth) {
	    case "source-types":
		JSONArray jsonResult = (JSONArray) jsonParser.parse(payload);	
		Iterator<?> i = jsonResult.iterator();
		StringBuilder sb = new StringBuilder();
        
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            sb.append(innerObj.get("pk") 
            + "   " + innerObj.get("value"));
            sb.append(System.getProperty("line.separator"));
            }
        parsed = sb.toString();
	    break;	    
	    }
	    
	    switch (apiMeth) {
	    case "information-types":
		JSONArray jsonResult = (JSONArray) jsonParser.parse(payload);	
		Iterator<?> i = jsonResult.iterator();
		StringBuilder sb = new StringBuilder();
        
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            sb.append(innerObj.get("pk") 
            + "   " + innerObj.get("value"));
            sb.append(System.getProperty("line.separator"));
            }
        parsed = sb.toString();
	    break;	    
	    }
	    
	    switch (apiMeth) {
	    case "review-types":
		JSONArray jsonResult = (JSONArray) jsonParser.parse(payload);	
		Iterator<?> i = jsonResult.iterator();
		StringBuilder sb = new StringBuilder();
        
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            sb.append(innerObj.get("pk") 
            + "   " + innerObj.get("value"));
            sb.append(System.getProperty("line.separator"));
            }
        parsed = sb.toString();
	    break;	    
	    }
	    
	    switch (apiMeth) {
	    case "review-decisions":
		JSONArray jsonResult = (JSONArray) jsonParser.parse(payload);	
		Iterator<?> i = jsonResult.iterator();
		StringBuilder sb = new StringBuilder();
        
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            sb.append(innerObj.get("pk") 
            + "   " + innerObj.get("value"));
            sb.append(System.getProperty("line.separator"));
            }
        parsed = sb.toString();
	    break;	    
	    }
	    
	    switch (apiMeth) {
	    case "review-inquiries":
		JSONArray jsonResult = (JSONArray) jsonParser.parse(payload);	
		Iterator<?> i = jsonResult.iterator();
		StringBuilder sb = new StringBuilder();
        
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            sb.append(innerObj.get("pk"));
            sb.append(System.getProperty("line.separator"));
            }
        parsed = sb.toString();
	    break;
	    }
	    
	    System.out.println(parsed);
	    return parsed;
	    
	}
	
	public static String assign (String payload, String key) throws ParseException {
		JSONObject jsonResult = (JSONObject) jsonParser.parse(payload);
		JSONObject sub1 = (JSONObject) jsonResult.get(key);
		JSONObject sub2 = (JSONObject) sub1.get("report");
		Long value = (Long) sub2.get("expert_review_pk");
		System.out.println(value.toString());
		return value.toString();
	}
//-------------------------------------------------------------------------------------	
	public static String findExprevPk (String givenPayload, String keyword) throws ParseException {
		
		JSONParser jsonParser = new JSONParser();

	    String parsed = null;
		JSONArray jsonResult = (JSONArray) jsonParser.parse(givenPayload);	
		Iterator<?> i = jsonResult.iterator();
		StringBuilder sb = new StringBuilder();
	        while (i.hasNext()) {
	            JSONObject innerObj = (JSONObject) i.next();
	            JSONObject media = (JSONObject) innerObj.get("media");
	            try {
	            	if (media.get("material_title").equals(keyword)) {
	            		sb.append(media.get("pk"));
	            	}
	            }
	            catch (NullPointerException npe) {System.out.println("совпадений не найдено");
	            }
	        }
        parsed = sb.toString();
        System.out.println(parsed);
		return parsed;
	}
}