package training.metofficeweather.forecast;

import com.google.gson.annotations.SerializedName;

public class SiteRep {
    public DV getDV() {
        return dv;
    }

    public void setLocation(Location location) {
        this.dv = dv;
    }

    @SerializedName("DV")
    private DV dv;


}
