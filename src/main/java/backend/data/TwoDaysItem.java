package backend.data;

public class TwoDaysItem {
	
	private String name;  //�ɶ��϶��W��

	private String time;  //�ɶ�
	
	private Double temp;  //�ū�
	
	private String wx;    //�Ѯ𪬪p
	
	private Double pop;   //���B���v

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
