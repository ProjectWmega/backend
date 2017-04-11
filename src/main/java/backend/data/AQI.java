package backend.data;

public class AQI {
	private String siteName;
	
	private String county;
	
	private Double aqi;
	
	private String pollutant;
	
	private String status;
	
	private Double so2;
	
	private Double co;
	
	private Double o3;
	
	private Double pm10;
	
	private Double pm25;
	
	private Double no2;
	
	private Double nox;
	
	private Double no;
	
	private Double windSpeed;
	
	private String windDirec;
	
	private String time;
	
	private Double pm25_AVG;
	
	private Double pm10_AVG;

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public Double getAqi() {
		return aqi;
	}

	public void setAqi(Double aqi) {
		this.aqi = aqi;
	}

	public String getPollutant() {
		return pollutant;
	}

	public void setPollutant(String pollutant) {
		this.pollutant = pollutant;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getSo2() {
		return so2;
	}

	public void setSo2(Double so2) {
		this.so2 = so2;
	}

	public Double getCo() {
		return co;
	}

	public void setCo(Double co) {
		this.co = co;
	}

	public Double getO3() {
		return o3;
	}

	public void setO3(Double o3) {
		this.o3 = o3;
	}

	public Double getPm10() {
		return pm10;
	}

	public void setPm10(Double pm10) {
		this.pm10 = pm10;
	}

	public Double getPm25() {
		return pm25;
	}

	public void setPm25(Double pm25) {
		this.pm25 = pm25;
	}

	public Double getNo2() {
		return no2;
	}

	public void setNo2(Double no2) {
		this.no2 = no2;
	}

	public Double getNox() {
		return nox;
	}

	public void setNox(Double nox) {
		this.nox = nox;
	}

	public Double getNo() {
		return no;
	}

	public void setNo(Double no) {
		this.no = no;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
