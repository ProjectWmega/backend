package backend.data;

public class Night {
	
	private int maxT; // ����
	
	private int minT; // �C��
	
	private String wx; // �Ѯ𪬪p
	
	private int pop; // ���B���v

	public int getMaxT() {
		return maxT;
	}

	public void setMaxT(int maxT) {
		this.maxT = maxT;
	}

	public int getMinT() {
		return minT;
	}

	public void setMinT(int minT) {
		this.minT = minT;
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
