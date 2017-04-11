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
import org.json.JSONException;
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
	
	private static String dataAuto = data.getAutoNow(); //自動氣象站-氣象觀測資料
	
	private static String dataBureau = data.getBureauNow(); //局屬
	
	private static String authorizationkey = data.getTokenKey();
	
	public JSONObject getJson(String dataId) {
		
		JSONObject soapDatainJsonObject = new JSONObject();

		try {
			String pre_apiURL = "http://opendata.cwb.gov.tw/opendataapi?dataid=" + dataId + "&authorizationkey=" + authorizationkey;
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
			error.printStackTrace();
		}
		return soapDatainJsonObject;
	}
	
	public List<WeatherNow> getNowWeather(){
		JSONObject autoObj = getJson(dataAuto);
		JSONObject bureauObj = getJson(dataBureau);
		
		List<WeatherNow> nows = new ArrayList<WeatherNow>();
		
		//getAutoWeatherData
		JSONArray autoArr = autoObj.getJSONObject("cwbopendata").getJSONArray("location");
		for(int i=0; i<autoArr.length(); i++){
			WeatherNow now = new WeatherNow();
			
			//get locationName
			String locationName = autoArr.getJSONObject(i).getString("locationName");
			System.out.println(locationName);
			now.setLocationName(locationName);
			
			//get time
			String time = autoArr.getJSONObject(i).getJSONObject("time").getString("obsTime");
			System.out.println("發布時間: " + time);
			now.setTime(time);
			
			//get weather element
			JSONArray weatherElement = autoArr.getJSONObject(i).getJSONArray("weatherElement");
			for (int j=0; j<weatherElement.length(); j++){
				String elementName = weatherElement.getJSONObject(j).getString("elementName");
				Double elementValue = weatherElement.getJSONObject(j).getJSONObject("elementValue").getDouble("value");
				System.out.println(elementName + " : " + elementValue);
				
				switch(elementName){
				case"WDIR":{
					String wind = now.wdirToString(elementValue);
					now.setWdir(wind);
				}
					break;
				case"WDSD":
					now.setWdsd(elementValue);
					break;
				case"TEMP":
					now.setTemp(elementValue);
					break;
				case"HUMD":{
					int value = 0;
					elementValue = elementValue*100;
					value = elementValue.intValue();
					now.setHumd(value);
					System.out.println("get: " + now.getHumd());
					break;
				}
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
		
		//getBureauWeatherData
		JSONArray bureauArr = bureauObj.getJSONObject("cwbopendata").getJSONArray("location");
		for(int i=0; i<bureauArr.length(); i++){
			WeatherNow now = new WeatherNow();
			String locationName = bureauArr.getJSONObject(i).getString("locationName");
			System.out.println(locationName);
			now.setLocationName(locationName);
			
			String time = bureauArr.getJSONObject(i).getJSONObject("time").getString("obsTime");
			System.out.println("發布時間: " + time);
			now.setTime(time);
			
			JSONArray weatherElement = bureauArr.getJSONObject(i).getJSONArray("weatherElement");
			for (int j=0; j<weatherElement.length(); j++){
				String elementName = weatherElement.getJSONObject(j).getString("elementName");
				Double elementValue = 0.0;
				try{
					elementValue = weatherElement.getJSONObject(j).getJSONObject("elementValue").getDouble("value");
				}catch(JSONException e){
					e.getStackTrace();
					System.out.println(elementName + " :------error------");
				}
				System.out.println(elementName + " : " + elementValue);
				
				switch(elementName){
				case"WDIR":{
					String wind = now.wdirToString(elementValue);
					now.setWdir(wind);
				}
					break;
				case"WDSD":
					now.setWdsd(elementValue);
					break;
				case"TEMP":
					now.setTemp(elementValue);
					break;
				case"HUMD":{
					int value = 0;
					elementValue = elementValue*100;
					value = elementValue.intValue();
					now.setHumd(value);
					System.out.println("get: " + now.getHumd());
					break;
				}
				case"24R":
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