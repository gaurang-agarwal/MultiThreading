package pack;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
public class webService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			String uid=webService.getWeather("");
			System.out.println("\n\n\n>>>>>>>>>>>>>>>>.. uid is "+uid);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("\n\n\n\n<>>>>>>>>>>>>>>>  eror is "+e.getMessage());
		}
	}
	public static String getWeather(String city) throws MalformedURLException,
	IOException {
	 
	//Code to make a webservice HTTP request
	String responseString = "";
	String outputString = "";
	String wsURL = "http://www.zeeintranet.com/EsselConnectWS/EsselConnectWS.asmx";
	URL url = new URL(wsURL);
	URLConnection connection = url.openConnection();
	HttpURLConnection httpConn = (HttpURLConnection)connection;
	ByteArrayOutputStream bout = new ByteArrayOutputStream();
	String xmlInput =
	" <soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://www.zeeintranet.com/EsselConnectWS\">\n" +
	" <soapenv:Header/>\n" +
	" <soapenv:Body>\n" +
	" <web:GetEmployeeDetails>\n" +
	" <!--Optional:-->\n" +
	" <web:GUID>47d130e0-da20-45fa-8478-41c24dbbb1a8</web:GUID>\n" +
	" </web:GetEmployeeDetails>\n" +
	" </soapenv:Body>\n" +
	" </soapenv:Envelope>";
		
	StringBuilder str=new StringBuilder("");
	str.append("<?xml version=\"1.0\"?>");
	str.append("<soap:Envelopexmlns:soap=\"http://www.w3.org/2001/12/soap-envelope\" soap:encodingStyle=\"http://www.w3.org/2001/12/soap-encoding\">");
	str.append("<soap:Body xmlns:m=\"http://www.zeeintranet.com/EsselConnectWS\">");
	str.append("<m:GetEmployeeDetails>");
	str.append("<m:GUID>34.5</m:GUID>");
	str.append("</m:GetEmployeeDetails>");
	str.append("</soap:Body>");
	str.append("</soap:Envelope>");
	
	//xmlInput=str.toString();
	
	System.out.println("\n\n\n >>>>>>>>>>>>>>>>>xmlInput  >>>>>>>>> "+xmlInput);
	 
	byte[] buffer = new byte[xmlInput.length()];
	buffer = xmlInput.getBytes();
	bout.write(buffer);
	byte[] b = bout.toByteArray();
	String SOAPAction =
	"http://www.zeeintranet.com/EsselConnectWS/GetEmployeeDetails";
	// Set the appropriate HTTP parameters.
	httpConn.setRequestProperty("Content-Length",
	String.valueOf(b.length));
	httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
	httpConn.setRequestProperty("SOAPAction", SOAPAction);
	httpConn.setRequestMethod("POST");
	httpConn.setDoOutput(true);
	httpConn.setDoInput(true);
	OutputStream out = httpConn.getOutputStream();
	System.out.println("\n\n\n>>>>>>>>>>>>>>> outpt is >>>>>>>>>>> "+out.toString());
	//Write the content of the request to the outputstream of the HTTP Connection.
	out.write(b);
	out.close();
	//Ready with sending the request.
	 
	//Read the response.
	InputStreamReader isr =
	new InputStreamReader(httpConn.getInputStream());
	BufferedReader in = new BufferedReader(isr);
	 
	//Write the SOAP message response to a String.
	while ((responseString = in.readLine()) != null) {
	outputString = outputString + responseString;
	}
	System.out.println("\n\n\n >>>>>>>>>>>>>>>>>outputString  >>>>>>>>>outputString");
	return outputString;
	}

}
