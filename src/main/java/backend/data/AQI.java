package backend.data;

public class AQI {
	private String siteName;
	
	private String county;
	
	private AqiValues values;
	

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public AqiValues getValues() {
		return values;
	}

	public void setValues(AqiValues values) {
		this.values = values;
	}
}
