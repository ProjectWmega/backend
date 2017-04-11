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
//		Day cloneDay = new Day();
//		cloneDay.setMaxT(day.getMaxT());
//		cloneDay.setMinT(day.getMinT());
//		cloneDay.setPop(day.getPop());
//		cloneDay.setWx(day.getWx());
//		this.day = cloneDay;
		this.day = day;
	}

	public Night getNight() {
		return night;
	}

	public void setNight(Night night) {
//		Night cloneNight = new Night();
//		cloneNight.setMaxT(night.getMaxT());
//		cloneNight.setMinT(night.getMinT());
//		cloneNight.setPop(night.getPop());
//		cloneNight.setWx(night.getWx());
//		this.night = cloneNight;
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
