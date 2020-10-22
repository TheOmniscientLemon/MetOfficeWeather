package training.metofficeweather.forecast;

import com.google.gson.annotations.SerializedName;

public class DV {
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @SerializedName("Location")
    private Location location;
}
