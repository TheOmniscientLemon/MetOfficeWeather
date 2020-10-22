package training.metofficeweather.forecast;

import com.google.gson.annotations.SerializedName;

public class Period {

    public Rep[] getRep() {
        return rep;
    }

    public void setRep(Rep[] rep) {
        this.rep = rep;
    }

    @SerializedName("Rep")
    private Rep[] rep;


}
