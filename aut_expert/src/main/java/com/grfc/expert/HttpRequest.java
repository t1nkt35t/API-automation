package main.java.com.grfc.expert;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

public class HttpRequest {

	public static String sendRequest (String reqUrl, String urlParameters, String reqType, String token, String contType) throws IOException, InterruptedException {
	String response = null;	

		URL url = new URL(reqUrl);
		System.out.println("url = " + url);
		System.out.println("urlParams = " + urlParameters);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		con.setRequestMethod(reqType);
		con.setRequestProperty("Content-Type", contType);
		con.setRequestProperty("Accept", "application/json, text/plain, */*");
		con.setRequestProperty("charset", "utf-8");
		con.setRequestProperty("authorization", "JWT " + token + "");
		// conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength
		// ));

		switch (reqType) {
		
		case "POST":
			con.setDoOutput(true);
			con.setInstanceFollowRedirects(false);
			con.setUseCaches(false);
//			postData = urlParameters.getBytes(StandardCharsets.UTF_8);
//			try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
//				wr.write(postData);
//			}
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
			break;
		}
		int responseCode = con.getResponseCode();
	    InputStream in = null;
	      if (responseCode == 200) {
	          in = con.getInputStream();
	       } else {
	          in = con.getErrorStream();
	       }
//		InputStream in = new BufferedInputStream(con.getInputStream());
		response = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
		con.disconnect();
		System.out.println(responseCode);
		System.out.println("response = " + response);
//		Thread.sleep(2000);
    return response;
	}
	
	public static String sendPutRequest (String reqUrl, String token, String body) throws IOException, InterruptedException {
		URL url = new URL(reqUrl);
		System.out.println("url = " + url);
		System.out.println("body = " + body);
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.setRequestMethod("PUT");
		httpCon.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		httpCon.setRequestProperty("Accept", "application/json, text/plain, */*");
//		httpCon.setRequestProperty("charset", "utf-8");
//		httpCon.setRequestProperty("Cache-Control", "no-cache");
		httpCon.setRequestProperty("authorization", "JWT " + token);
//		httpCon.setRequestProperty("User-Agent", "Mozilla/5.0");
		httpCon.setDoOutput(true);
		OutputStreamWriter out = new OutputStreamWriter(
		httpCon.getOutputStream());
		out.write(body);
		out.flush();
		out.close();
		int responseCode = httpCon.getResponseCode();
		String response = null;
	    InputStream is = null;
	      if (responseCode == 200) {
	          is = httpCon.getInputStream();
	       } else {
	          is = httpCon.getErrorStream();
	       }
	      
	      response = org.apache.commons.io.IOUtils.toString(is, "UTF-8");
	    httpCon.disconnect();  
	    System.out.println(responseCode);
		System.out.println("response = " + response);
//		Thread.sleep(2000);
	    return response;
	}
	
	public static String sendPutRequestFormData (String reqUrl, String token, String param, String value, String file, String updateFieldName) throws IOException, InterruptedException {
		String charset = "UTF-8";
		System.out.println("url = " + reqUrl);
		File binaryFile = new File(file);
		String boundary = Long.toHexString(System.currentTimeMillis()); // Just generate some unique random value.
		String CRLF = "\r\n"; // Line separator required by multipart/form-data.

		URLConnection connection = new URL(reqUrl).openConnection();
		((HttpURLConnection) connection).setRequestMethod("PUT");
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
		connection.setRequestProperty("Accept", "application/json, text/plain, */*");
		connection.setRequestProperty("authorization", "JWT " + token);

		try (
		    OutputStream output = connection.getOutputStream();
		    PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, charset), true);
		) {
		    // Send normal param.
		    writer.append("--" + boundary).append(CRLF);
//		    writer.append("Content-Disposition: form-data; name=\"param\"").append(CRLF);
		    writer.append("Content-Disposition: form-data; name=" + param).append(CRLF);
		    writer.append("Content-Type: text/plain; charset=" + charset).append(CRLF);
		    writer.append(CRLF).append(value).append(CRLF).flush();

		    // Send binary file.
		    writer.append("--" + boundary).append(CRLF);
		    writer.append("Content-Disposition: form-data; name=" + updateFieldName + "; filename=\"" + binaryFile.getName() + "\"").append(CRLF);
		    writer.append("Content-Type: " + URLConnection.guessContentTypeFromName(binaryFile.getName())).append(CRLF);
		    writer.append("Content-Transfer-Encoding: binary").append(CRLF);
		    writer.append(CRLF).flush();
		    Files.copy(binaryFile.toPath(), output);
		    output.flush(); // Important before continuing with writer!
		    writer.append(CRLF).flush(); // CRLF is important! It indicates end of boundary.

		    // End of multipart/form-data.
		    writer.append("--" + boundary + "--").append(CRLF).flush();
		}

		// Request is lazily fired whenever you need to obtain information about response.
		int responseCode = ((HttpURLConnection) connection).getResponseCode();
		System.out.println(responseCode); // Should be 200
		String response = null;
	    InputStream is = null;
	      if (responseCode == 200) {
	          is = connection.getInputStream();
	       } else {
	          is = ((HttpURLConnection) connection).getErrorStream();
	       }
	      
	      response = org.apache.commons.io.IOUtils.toString(is, "UTF-8");
	    System.out.println(responseCode);
		System.out.println("response = " + response);
//		Thread.sleep(2000);
	    return response;
	}
	
	public static String sendPostRequest (String reqUrl, String urlParameters, String auth, String contType, String body) throws IOException, InterruptedException {
	String response = null;	

		URL url = new URL(reqUrl);
		System.out.println("url = " + url);
		System.out.println("urlParams = " + urlParameters);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		con.setRequestMethod("POST");
		con.setDoOutput(true);
		con.setRequestProperty("Content-Type", contType);
		con.setRequestProperty("Accept", "application/json, text/plain, */*");
		con.setRequestProperty("charset", "utf-8");
		con.setRequestProperty("authorization", auth);
		con.setInstanceFollowRedirects(false);
		con.setUseCaches(false);
		OutputStreamWriter wr = new OutputStreamWriter(
		con.getOutputStream());
		wr.write(body);
		wr.flush();
		wr.close();
		int responseCode = con.getResponseCode();
	    InputStream in = null;
	      if (responseCode == 200) {
	          in = con.getInputStream();
	       } else {
	          in = con.getErrorStream();
	       }
		response = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
		con.disconnect();
		System.out.println(responseCode);
		System.out.println("response = " + response);
    return response;
	}
	
}
