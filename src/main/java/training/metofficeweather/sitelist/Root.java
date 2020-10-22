package training.metofficeweather.sitelist;

import com.google.gson.annotations.SerializedName;
import training.metofficeweather.sitelist.Locations;

public class Root {
    public Locations getLocations() {
        return locations;
    }

    public void setLocations(Locations locations) {
        this.locations = locations;
    }

    @SerializedName("Locations")
    private Locations locations;


}
