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
import backend.data.Result;
import backend.data.TwoDays;
import backend.data.TwoDaysItem;
import backend.data.WeatherNow;
import backend.data.Week;
import backend.data.WeekItem;
import backend.db.WeatherDBManager;

@Path("weather/")
public class WeatherService {
	
	private GetWeatherNow weatherNow = GetWeatherNow.getInstance();
	private GetTwoDaysWeather twoDaysWeather = GetTwoDaysWeather.getInstance();
	private GetWeekWeather weeksWeather = GetWeekWeather.getInstance();
	private WeatherDBManager wDB = WeatherDBManager.getInstance();
	
	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "hello";
	}
	
	@GET
	@Path("updateNow")
	@Produces(MediaType.APPLICATION_JSON)
	public Result nowWeather() {
		List<WeatherNow> nows = new ArrayList<WeatherNow>();
		nows = weatherNow.getNowWeather();
		Result result = new Result();
		result.setWeatherNows(nows);
		return result;
	}
	
	@POST
	@Path("now")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Result getNowWeather(@FormParam("lat") Double lat, @FormParam("lng") Double lng) {
		WeatherNow weather = new WeatherNow();
		
		weather = wDB.getNowWeather();
		
		Result result = new Result();
		result.setLat(lat);
		result.setLng(lng);
		result.setNow(weather);
		return result;	
	}
	
	@GET
	@Path("listNow")
	@Produces(MediaType.APPLICATION_JSON)
	public Result listNow() {
		List<WeatherNow> nows = new ArrayList<WeatherNow>();
		nows = wDB.listAllNowWeather();
		Result result = new Result();
		result.setWeatherNows(nows);
		return result;
	}
	
	@GET
	@Path("updateTwoDays")
	@Produces(MediaType.APPLICATION_JSON)
	public Result twoDaysWeather(){
		List<TwoDays> twoDays = new ArrayList<TwoDays>();
		twoDays = twoDaysWeather.getTwoDaysWeather();
		
		Result result = new Result();
		result.setTwoDays(twoDays);
		return result;
	}
	
	@POST
	@Path("twoDays")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Result getTwoDaysWeather(@FormParam("lat") Double lat, @FormParam("lng") Double lng) {
		TwoDays twoDay = new TwoDays();
		twoDay = wDB.getTwoDaysWeather();
		
		Result result = new Result();
		result.setLat(lat);
		result.setLng(lng);
		result.setTwoDay(twoDay);
		return result;
	}
	

	@GET
	@Path("listTwoDays")
	@Produces(MediaType.APPLICATION_JSON)
	public Result listTwoDays() {
		List<TwoDays> twoDays = new ArrayList<TwoDays>();
		twoDays = wDB.listAllTwoDaysWeather();
		
		Result result = new Result();
		result.setTwoDays(twoDays);
		return result;
	}
	
	@GET
	@Path("updateWeek")
	@Produces(MediaType.APPLICATION_JSON)
	public Result weekWeather(){
		List<Week> weeks= new ArrayList<Week>();
		weeks = weeksWeather.getWeekWeather();
		
		Result result = new Result();
		result.setWeeks(weeks);
		return result;
	}
	
	@POST
	@Path("week")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Result getWeekWeather(@FormParam("lat") Double lat, @FormParam("lng") Double lng) {
		Week week = new Week();
		week = wDB.getWeekWeather();
		
		Result result = new Result();
		result.setLat(lat);
		result.setLng(lng);
		result.setWeek(week);
		
		return result;
	}
	
	@POST
	@Path("listWeeks")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Result listWeeks(@FormParam("lat") Double lat, @FormParam("lng") Double lng) {
		List<Week> weeks = new ArrayList<Week>();
		weeks = wDB.listWeekWeather();
		
		Result result = new Result();
		result.setLat(lat);
		result.setLng(lng);
		result.setWeeks(weeks);
		
		return result;
	}
}
