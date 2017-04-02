package backend.data;

import java.util.List;

public class TwoDays {

	private String locationName;
	
	private List<TwoDaysItem> items;

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public List<TwoDaysItem> getItems() {
		return items;
	}

	public void setItems(List<TwoDaysItem> items) {
		this.items = items;
	}
}
