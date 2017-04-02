package backend.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import backend.connect.GetWeatherNow;
import backend.data.TwoDays;
import backend.data.TwoDaysItem;
import backend.data.WeatherNow;
import backend.data.Week;
import backend.data.WeekItem;;

@Path("weather/")
public class WeatherService {
	
	private GetWeatherNow weatherNow = GetWeatherNow.getInstance();
	
	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "hello";
	}
	
	@GET
	@Path("now")
	@Produces(MediaType.APPLICATION_JSON)
	public List<WeatherNow> nowWeather() {
		List<WeatherNow> nows = new ArrayList<WeatherNow>();
		nows = weatherNow.getNowWeather();
		return nows;
	}
	
	@GET
	@Path("test")
	@Produces(MediaType.APPLICATION_JSON)
	public WeatherNow testWeather() {
		WeatherNow weather = new WeatherNow();
		
		weather.setH_24r(0.0);
		weather.setHumd(30.0);
		weather.setLocationName("西屯區");
		weather.setTemp(17.0);
		weather.setTime("2017-04-03T00:00:00+08:00");
		weather.setWdir(30.0);
		weather.setWdsd(15.0);
		
		return weather;	
	}
	
	@GET
	@Path("testTwoDays")
	@Produces(MediaType.APPLICATION_JSON)
	public TwoDays testTwoDaysWeather() {
		TwoDays twoDays = new TwoDays();
		List<TwoDaysItem> items = new ArrayList<TwoDaysItem>();
		
		twoDays.setLocationName("西屯區");
		for (int i=1; i<=24; i++){
			TwoDaysItem item = new TwoDaysItem();
			item.setName("session" + i);
			item.setTime("2017-04-03T00:00:00+08:00");
			item.setTemp(18.0);
			item.setWx("多雲時晴");
			item.setPop(10.0);
			
			items.add(item);
		}
		twoDays.setItems(items);
		
		return twoDays;
	}
	
	@GET
	@Path("testWeek")
	@Produces(MediaType.APPLICATION_JSON)
	public Week testWeekWeather() {
		Week week = new Week();
		List<WeekItem> items = new ArrayList<WeekItem>();
		
		week.setLocationName("西屯區");
		
		for(int i=1; i<=7; i++){
			WeekItem item = new WeekItem();
			item.setName("Day" + i);
			item.setTempMax(28.0);
			item.setTempMin(23.0);
			item.setWxDay("晴時多雲");
			item.setWxNight("多雲");
			
			items.add(item);
		}
		week.setItems(items);
		
		return week;
	}
}
