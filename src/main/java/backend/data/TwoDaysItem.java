package backend.data;

public class TwoDaysItem {
	
	private int name;  //�ɶ��϶��W��

	private String time;  //�ɶ�
	
	private int temp;  //�ū�
	
	private String wx;    //�Ѯ𪬪p
	
	private int pop;   //���B���v

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
