package backend.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import backend.connect.GetAirNow;
import backend.data.AQI;
import backend.data.UVI;

@Path("air/")
public class AirService {
	
	private GetAirNow aqi = GetAirNow.getInstance();
	
	@GET
	@Path("now")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AQI> nowAQI() {
		List<AQI> aqis = new ArrayList<AQI>();
		aqis = aqi.getAQI();
		return aqis;
	}
	
	@GET
	@Path("uviNow")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UVI> nowUVI() {
		List<UVI> uvis = new ArrayList<UVI>();
		uvis = aqi.getUVI();
		return uvis;
	}

}
