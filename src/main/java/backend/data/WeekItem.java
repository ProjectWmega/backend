package backend.data;

public class WeekItem {
	
	private String name;  //天數名稱
	
	private Double tempMax; //當天高溫
	
	private Double tempMin; //當天低溫
	
	private String wxDay;   //早上天氣概況
	
	private String wxNight; //晚上天氣概況
	
//	private Double uvi; //紫外線指數

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getTempMax() {
		return tempMax;
	}

	public void setTempMax(Double tempMax) {
		this.tempMax = tempMax;
	}

	public Double getTempMin() {
		return tempMin;
	}

	public void setTempMin(Double tempMin) {
		this.tempMin = tempMin;
	}

	public String getWxDay() {
		return wxDay;
	}

	public void setWxDay(String wxDay) {
		this.wxDay = wxDay;
	}

	public String getWxNight() {
		return wxNight;
	}

	public void setWxNight(String wxNight) {
		this.wxNight = wxNight;
	}

//	public Double getUvi() {
//		return uvi;
//	}
//
//	public void setUvi(Double uvi) {
//		this.uvi = uvi;
//	}

}
