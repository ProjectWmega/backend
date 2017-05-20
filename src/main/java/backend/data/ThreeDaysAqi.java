package backend.data;

import java.util.List;

public class ThreeDaysAqi {
	
	private String publishTime;

	private String area;
	
	private List<ThreeDaysAqiValue> values;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public List<ThreeDaysAqiValue> getValues() {
		return values;
	}

	public void setValues(List<ThreeDaysAqiValue> values) {
		this.values = values;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
}
