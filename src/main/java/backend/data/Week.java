package backend.data;

import java.util.List;

public class Week {

	private String locationName;
	
	private List<WeekItem> items;

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public List<WeekItem> getItems() {
		return items;
	}

	public void setItems(List<WeekItem> items) {
		this.items = items;
	}
}
