package backend.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import backend.connect.GetWeatherNow;
import backend.data.WeatherNow;

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
}
