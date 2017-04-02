package backend.data;

public class TwoDaysItem {
	
	private String name;  //時間區間名稱

	private String time;  //時間
	
	private Double temp;  //溫度
	
	private String wx;    //天氣狀況
	
	private Double pop;   //降雨機率

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Double getTemp() {
		return temp;
	}

	public void setTemp(Double temp) {
		this.temp = temp;
	}

	public String getWx() {
		return wx;
	}

	public void setWx(String wx) {
		this.wx = wx;
	}

	public Double getPop() {
		return pop;
	}

	public void setPop(Double pop) {
		this.pop = pop;
	}
}
