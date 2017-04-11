package backend.data;

public class TwoDaysItem {
	
	private int name;  //時間區間名稱

	private String time;  //時間
	
	private int temp;  //溫度
	
	private String wx;    //天氣狀況
	
	private int pop;   //降雨機率

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public String getWx() {
		return wx;
	}

	public void setWx(String wx) {
		this.wx = wx;
	}

	public int getPop() {
		return pop;
	}

	public void setPop(int pop) {
		this.pop = pop;
	}
}
