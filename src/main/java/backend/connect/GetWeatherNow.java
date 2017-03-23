package backend.connect;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import org.w3c.dom.*;

import backend.data.WeatherNow;
import backend.data.CwbData;

import java.io.*;

//import org.w3c.dom.NodeList;
//import org.w3c.dom.Node;

public class GetWeatherNow {
	
	private static GetWeatherNow connect = new GetWeatherNow();

	public static GetWeatherNow getInstance() {
	   return connect;
	}
	
	private GetWeatherNow(){
		
	}
	
	private static CwbData data = new CwbData();
	
	private static String dataid = data.getAutoNow(); //自動氣象站-氣象觀測資料
	
	private static String authorizationkey = data.getTokenKey();
	
	public JSONObject getJson() {
		
		JSONObject soapDatainJsonObject = new JSONObject();

		try {
			String pre_apiURL = "http://opendata.cwb.gov.tw/opendataapi?dataid=" + dataid + "&authorizationkey=" + authorizationkey;
			System.out.println("url " + pre_apiURL);
			System.out.println("----------------------------");
			URL url = new URL(pre_apiURL);

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(url.openStream());
			
			DOMSource domSource = new DOMSource(doc);
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.transform(domSource, result);
			
			String soapmessageString = writer.toString();
			soapDatainJsonObject = XML.toJSONObject(soapmessageString);
//			System.out.println(soapDatainJsonObject);

		} catch (Exception error) {
			System.out.println(error);
		}
		return soapDatainJsonObject;
	}
	
	public List<WeatherNow> getNowWeather(){
		JSONObject obj = getJson();
		
		List<WeatherNow> nows = new ArrayList<WeatherNow>();
		
		JSONArray arr = obj.getJSONObject("cwbopendata").getJSONArray("location");
		for(int i=0; i<arr.length(); i++){
			WeatherNow now = new WeatherNow();
			String locationName = arr.getJSONObject(i).getString("locationName");
			System.out.println(locationName);
			now.setLocationName(locationName);
			
			String time = arr.getJSONObject(i).getJSONObject("time").getString("obsTime");
			System.out.println("發布時間: " + time);
			now.setTime(time);
			
			JSONArray weatherElement = arr.getJSONObject(i).getJSONArray("weatherElement");
			for (int j=0; j<weatherElement.length(); j++){
				String elementName = weatherElement.getJSONObject(j).getString("elementName");
				Double elementValue = weatherElement.getJSONObject(j).getJSONObject("elementValue").getDouble("value");
				System.out.println(elementName + " : " + elementValue);
				
				switch(elementName){
				case"WDIR":
					now.setWdir(elementValue);
					break;
				case"WDSD":
					now.setWdsd(elementValue);
					break;
				case"TEMP":
					now.setTemp(elementValue);
					break;
				case"HUMD":
					now.setHumd(elementValue);
					break;
				case"H_24R":
					now.setH_24r(elementValue);
					break;
				default:
					break;
				}
			}
			nows.add(now);
			System.out.println("--------------------------------------------------------");
		}
		return nows;
	}
}