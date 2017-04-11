package backend.data;

public class WeatherNow {
	
	private String locationName;
	
	private String time;
	
	private String wdir; //風向，單位:度
	
	private Double wdsd; //風速，m/s
	
	private Double temp; //溫度，C
	
	private int humd; //濕度，%
	
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

	public String getWdir() {
		return wdir;
	}

	public void setWdir(String wdir) {
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

	public int getHumd() {
		return humd;
	}

	public void setHumd(int humd) {
		this.humd = humd;
	}

	public Double getH_24r() {
		return h_24r;
	}

	public void setH_24r(Double h_24r) {
		this.h_24r = h_24r;
	}
	
	public String wdirToString(Double value){
		String wind = "";
		if(((value>=0) && (value<=11.25)) || ((value>348.75) && value<=360)){ //0
			wind = "北";
		}
		else if((value>0) && (value>11.25) && (value<=33.75)){ //22.5
			wind = "北北東";
		}
		else if((value>0) && (value>33.75) && (value<=56.25)){ //45
			wind = "東北";
		}
		else if((value>0) && (value>56.25) && (value<=78.75)){ //67.5
			wind = "東北東";
		}
		else if((value>0) && (value>78.75) && (value<=101.25)){ //90
			wind = "東";
		}
		else if((value>0) && (value>101.25) && (value<=123.75)){ //112.5
			wind = "東南東";
		}
		else if((value>0) && (value>123.75) && (value<=146.25)){ //135
			wind = "東南";
		}
		else if((value>0) && (value>146.25) && (value<=168.75)){ //157.5
			wind = "南南東";
		}
		else if((value>0) && (value>168.75) && (value<=191.25)){ //180
			wind = "南";
		}
		else if((value>0) && (value>191.25) && (value<=213.75)){ //205.5
			wind = "南南西";
		}
		else if((value>0) && (value>213.75) && (value<=236.25)){ //225
			wind = "西南";
		}
		else if((value>0) && (value>236.25) && (value<=258.75)){ //247.5
			wind = "西南西";
		}
		else if((value>0) && (value>258.75) && (value<=281.25)){ //270
			wind = "西";
		}
		else if((value>0) && (value>281.25) && (value<=303.75)){ //292.5
			wind = "西北西";
		}
		else if((value>0) && (value>303.75) && (value<=326.25)){ //315
			wind = "西北";
		}
		else if((value>0) && (value>326.25) && (value<=348.75)){ //337.5
			wind = "北北西";
		}
		else{
			wind="錯誤";
		}
		
		return wind;
	}
}
