package backend.data;

public class WeekItem {
	
	private String name;  //�ѼƦW��
	
	private Double tempMax; //��Ѱ���
	
	private Double tempMin; //��ѧC��
	
	private String wxDay;   //���W�Ѯ𷧪p
	
	private String wxNight; //�ߤW�Ѯ𷧪p
	
//	private Double uvi; //���~�u����

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
