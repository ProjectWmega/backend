package backend.data;

public class WeatherNow {
	
	private String locationName;
	
	private String time;
	
	private Double wdir; //風向，單位:度
	
	private Double wdsd; //風速，m/s
	
	private Double temp; //溫度，C
	
	private Double humd; //濕度，%
	
	private Double h_24r; //日累積雨量，毫米

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Double getWdir() {
		return wdir;
	}

	public void setWdir(Double wdir) {
		this.wdir = wdir;
	}

	public Double getWdsd() {
		return wdsd;
	}

	public void setWdsd(Double wdsd) {
		this.wdsd = wdsd;
	}

	public Double getTemp() {
		return temp;
	}

	public void setTemp(Double temp) {
		this.temp = temp;
	}

	public Double getHumd() {
		return humd;
	}

	public void setHumd(Double humd) {
		this.humd = humd;
	}

	public Double getH_24r() {
		return h_24r;
	}

	public void setH_24r(Double h_24r) {
		this.h_24r = h_24r;
	}
}
