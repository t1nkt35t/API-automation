package main.java.com.grfc.expert;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.sql.Timestamp;
import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.json.simple.JSONObject;

public class Tools {
	
	public static boolean saveFile(String fileName, String url) {
	    try 
	    {   
	    	URL download = new URL(url);
//	        String saveTo = System.getProperty("user.dir") + "\\Test\\";
	        ReadableByteChannel rbc = Channels.newChannel(download.openStream());
	        FileOutputStream fos = new FileOutputStream(Settings.FILEPATH + fileName);
	        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
	        fos.close();
	        return true;
	    }
	    catch (FileNotFoundException e)
	    {
	        e.printStackTrace();
	    }
	    catch (MalformedURLException e)
	    {
	        e.printStackTrace();
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	public static String stringOrder (String arr) {
				
				StringBuilder sb = new StringBuilder();
				Collator collator = Collator.getInstance(Locale.US);
		        SortedSet<String> set = new TreeSet<String>(collator);
		        String[] sArray = arr.split("   ");
		        for (String item:sArray) {
		        set.add(item);
		        }
		        for(String s : set) {
//		            System.out.println(s);
		            sb.append(s);
		        }
		    		
		return sb.toString();
		
	}
	
	public static Set<?> stringToSet (String one) {
		
		Set<String> set = new HashSet<>();
		Scanner scanner = new Scanner(one);
		while (scanner.hasNextLine()) {
		  String line = scanner.nextLine();
		  set.add(line);
		}
		scanner.close();
		System.out.println(set);
		return set;		
	}
	
	public static String nullMaker (String input) {
		
		if (input.length() < 1) {
    		input = "null";
    	}
		return input;
	}
	
	public static String nullMakerSum (String input1, String input2) {
		
		String result = null;
		
		if ((input1.length() < 1)&&(input2.length() < 1)) {
			result = null;
		}
		else if (!(input1.length() < 1)&&(input2.length() < 1)) {
			result = input1;
		}
		else if ((input1.length() < 1)&&!(input2.length() < 1)) {
			result = input2;
		}
		else {
			result = input1 + " " + input2; 
		}
		return result;
	}
	
	public static String killFirstLast (String value) {
    	
    	String killFirstLast = value.toString().substring(1, value.toString().length()-1);
    	if (killFirstLast.length() < 1) {
    		killFirstLast = "null";
    	}
		return killFirstLast;
	}
	
	public static String removeQuotes (String arr) {
		
		StringBuilder sb = new StringBuilder();
		List<String> items = Arrays.asList(Tools.killFirstLast(arr).split("\\s*,\\s*"));
		for (String item : items) {
			sb.append(item.replace("\"", ""));
		}
		String result = sb.toString();
		return result;	
	}
	
	public static String tfTrueFalse (String in) {
		String out = null;
		switch (in) {
		case "t":
			out = "true";
		break;
		
		case "f":
			out = "false";
		break;
		}
		return out;
	}
	
	public static String timeStamp (String dateFormat) {                 //"yyyy.MM.dd.HH.mm.ss"
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Timestamp time = new Timestamp(System.currentTimeMillis());
		return sdf.format(time);
		
	}

}

