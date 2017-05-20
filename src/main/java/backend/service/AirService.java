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

import backend.connect.GetAirNow;
import backend.data.AQI;
import backend.data.AqiValues;
import backend.data.Result;
import backend.data.ThreeDaysAqi;
import backend.data.UVI;
import backend.db.AirDBManager;

@Path("air/")
public class AirService {
	
	private GetAirNow aqi = GetAirNow.getInstance();
	
	private static AirDBManager airDb = AirDBManager.getInstance(); 
	
	@GET
	@Path("updateAqi")
	@Produces(MediaType.APPLICATION_JSON)
	public Result nowAQI() {
		List<AQI> aqis = new ArrayList<AQI>();
		aqis = aqi.getAQI();
		Result result = new Result();
		result.setAqis(aqis);
		return result;
	}
	
	@POST
	@Path("aqi")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Result getAQI(@FormParam("lat") Double lat, @FormParam("lng") Double lng){
		AQI aqi = new AQI();
		aqi = airDb.getAqi();
		
		Result result = new Result();
		result.setLat(lat);
		result.setLng(lng);
		result.setAqi(aqi);
		return result;
		
	}
	
	@GET
	@Path("listAqis")
	@Produces(MediaType.APPLICATION_JSON)
	public Result listAqis() {
		List<AQI> aqis = new ArrayList<AQI>();
		aqis = airDb.listAqi();
		Result result = new Result();
		result.setAqis(aqis);
		return result;
	}
	
	@GET
	@Path("threeDaysAqis")
	@Produces(MediaType.APPLICATION_JSON)
	public Result getThreeDaysAqi() {
		List<ThreeDaysAqi> lsThreeDaysAqis = new ArrayList<ThreeDaysAqi>();
		lsThreeDaysAqis = aqi.getThreeDaysAqi();
		
		Result result = new Result();
		result.setThreeDaysAqis(lsThreeDaysAqis);
		return result;
	}
	
	@GET
	@Path("updateUvi")
	@Produces(MediaType.APPLICATION_JSON)
	public Result nowUVI() {
		List<UVI> uvis = new ArrayList<UVI>();
		uvis = aqi.getUVI();
		
		Result result = new Result();
		result.setUvis(uvis);
		return result;
	}
	
	@POST
	@Path("uvi")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Result getUVI(@FormParam("lat") Double lat, @FormParam("lng") Double lng){
		UVI uvi = new UVI();
		uvi = airDb.getUvi();
		
		Result result = new Result();
		result.setLat(lat);
		result.setLng(lng);
		result.setUvi(uvi);
		return result;
	}
	
	@GET
	@Path("listUvis")
	@Produces(MediaType.APPLICATION_JSON)
	public Result listUvis() {
		List<UVI> uvis = new ArrayList<UVI>();
		uvis = airDb.listUvi();
		
		Result result = new Result();
		result.setUvis(uvis);
		return result;
	}
}
