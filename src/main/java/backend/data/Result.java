package backend.data;

import java.util.List;

public class Result {
	
	private Double lat;
	
	private Double lng;
	
	private WeatherNow now;
	
	private TwoDays twoDay;
	
	private Week week;
	
	private AQI aqi;
	
	private UVI uvi;

	private List<WeatherNow> weatherNows;
	
	private List<TwoDays> twoDays;
	
	private List<Week> weeks;
	
	private List<AQI> aqis;
	
	private List<ThreeDaysAqi> threeDaysAqis;
	
	private List<UVI> uvis;

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public WeatherNow getNow() {
		return now;
	}

	public void setNow(WeatherNow now) {
		this.now = now;
	}

	public TwoDays getTwoDay() {
		return twoDay;
	}

	public void setTwoDay(TwoDays twoDay) {
		this.twoDay = twoDay;
	}

	public Week getWeek() {
		return week;
	}

	public void setWeek(Week week) {
		this.week = week;
	}

	public AQI getAqi() {
		return aqi;
	}

	public void setAqi(AQI aqi) {
		this.aqi = aqi;
	}

	public UVI getUvi() {
		return uvi;
	}

	public void setUvi(UVI uvi) {
		this.uvi = uvi;
	}

	public List<WeatherNow> getWeatherNows() {
		return weatherNows;
	}

	public void setWeatherNows(List<WeatherNow> weatherNows) {
		this.weatherNows = weatherNows;
	}

	public List<TwoDays> getTwoDays() {
		return twoDays;
	}

	public void setTwoDays(List<TwoDays> twoDays) {
		this.twoDays = twoDays;
	}

	public List<Week> getWeeks() {
		return weeks;
	}

	public void setWeeks(List<Week> weeks) {
		this.weeks = weeks;
	}

	public List<AQI> getAqis() {
		return aqis;
	}

	public void setAqis(List<AQI> aqis) {
		this.aqis = aqis;
	}

	public List<ThreeDaysAqi> getThreeDaysAqis() {
		return threeDaysAqis;
	}

	public void setThreeDaysAqis(List<ThreeDaysAqi> threeDaysAqis) {
		this.threeDaysAqis = threeDaysAqis;
	}

	public List<UVI> getUvis() {
		return uvis;
	}

	public void setUvis(List<UVI> uvis) {
		this.uvis = uvis;
	}
}
