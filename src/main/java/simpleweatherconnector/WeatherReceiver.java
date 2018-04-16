package simpleweatherconnector;

import org.json.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class WeatherReceiver {
    private String weatherurl;

    public void WeatherReceiver() {
    		weatherurl= "http://api.openweathermap.org/data/2.5/weather?q=Noida,in&appid=d65196a1f5545b774786d4a1455b9ae8";
    }
    public void setWeatherUrl(String str) {
    		weatherurl = str;
    }
    public String getWeatherUrl() {
    		return weatherurl;
    }
    
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
          sb.append((char) cp);
        }
        return sb.toString();
      }
    
    public static JSONObject readJsonFromUrl(String url) {
	        InputStream is = null;
	        BufferedReader rd;
	        String jsonText = "";
	        JSONObject json = null;

			try {
				is = new URL(url).openStream();
				rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		        jsonText = readAll(rd);
		        json = new JSONObject(jsonText);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
	        	  		is.close();
	          	} catch (IOException e) {
	          		// TODO Auto-generated catch block
	          		e.printStackTrace();
	          	}
			}
        		return json;
        }
    public String GetData() throws IOException {
    		String retValue = "";
    		try {
    			retValue = readJsonFromUrl(weatherurl).toString();
    		}
    		catch (JSONException e) {
    			
    		}
		return retValue;
   }
}