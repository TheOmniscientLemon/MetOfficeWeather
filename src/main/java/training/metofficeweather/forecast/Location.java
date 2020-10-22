package training.metofficeweather.forecast;

import com.google.gson.annotations.SerializedName;

public class Location {
    public Period[] getPeriod() {
        return period;
    }

    public void setPeriod(Period[] period) {
        this.period = period;
    }

    @SerializedName("Period")
    private Period[] period;


}
