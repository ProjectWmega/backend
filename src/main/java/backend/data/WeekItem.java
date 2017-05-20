package backend.data;

public class WeekItem {
	
	private int name;  //天數名稱
	
	private Day day;
	
	private Night night;
	
	
//	private Double uvi; //紫外線指數

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public Night getNight() {
		return night;
	}

	public void setNight(Night night) {
		this.night = night;
	}

//	public Double getUvi() {
//		return uvi;
//	}
//
//	public void setUvi(Double uvi) {
//		this.uvi = uvi;
//	}

}
