package backend.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import backend.connect.GetTwoDaysWeather;
import backend.connect.GetWeatherNow;
import backend.connect.GetWeekWeather;
import backend.data.Day;
import backend.data.Night;
import backend.data.TwoDays;
import backend.data.TwoDaysItem;
import backend.data.WeatherNow;
import backend.data.Week;
import backend.data.WeekItem;

@Path("weather/")
public class WeatherService {
	
	private GetWeatherNow weatherNow = GetWeatherNow.getInstance();
	private GetTwoDaysWeather twoDaysWeather = GetTwoDaysWeather.getInstance();
	private GetWeekWeather weeksWeather = GetWeekWeather.getInstance();
	
	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "hello";
	}
	
	@POST
	@Path("testPost")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String test(@FormParam("lat") Double lat, @FormParam("lng") Double lng) {
		String result = "your site: " + lat + ", " + lng;
		return result;
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
	@Path("twoDays")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TwoDays> twoDaysWeather(){
		List<TwoDays> twoDays = new ArrayList<TwoDays>();
		twoDays = twoDaysWeather.getTwoDaysWeather();
		
		return twoDays;
	}
	
	@GET
	@Path("week")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Week> weekWeather(){
		List<Week> weeks= new ArrayList<Week>();
		weeks = weeksWeather.getWeekWeather();
		return weeks;
	}
	
	@GET
	@Path("test")
	@Produces(MediaType.APPLICATION_JSON)
	public WeatherNow testWeather() {
		WeatherNow weather = new WeatherNow();
		
		weather.setH_24r(0.0);
		weather.setHumd(30);
		weather.setLocationName("西屯區");
		weather.setTemp(17.0);
		weather.setTime("2017-04-03T00:00:00+08:00");
		weather.setWdir("北北西");
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
			item.setName(i);
			item.setTime("2017-04-03T00:00:00+08:00");
			item.setTemp(18);
			item.setWx("多雲時晴");
			item.setPop(10);
			
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
		
		int i=0;
		
		for(i=0; i<7; i++){
			WeekItem item = new WeekItem();
			item.setName(i+1);
			items.add(item);
		}
		
		i=0;
		
		for (WeekItem item : items) {
			Day day = new Day();
			day.setMaxT(30);
			day.setMinT(28);
			day.setWx("晴天");
			day.setPop(0);
			item.setDay(day);
			i++;

			Night night = new Night();
			night.setMaxT(28);
			night.setMinT(25);
			night.setWx("多雲");
			night.setPop(0);
			item.setNight(night);
			i++;
		}
		week.setItems(items);
		
		return week;
	}
}
