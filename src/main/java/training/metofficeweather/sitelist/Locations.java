package training.metofficeweather.sitelist;

import com.google.gson.annotations.SerializedName;
import training.metofficeweather.sitelist.Location;

public class Locations {
    public Location[] getLocations() {
        return locations;
    }

    public void setLocations(Location[] locations) {
        this.locations = locations;
    }

    @SerializedName("Location")
    private Location[] locations;
}
