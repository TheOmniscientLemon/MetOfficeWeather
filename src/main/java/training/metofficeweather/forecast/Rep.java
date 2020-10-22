package training.metofficeweather.forecast;

import com.google.gson.annotations.SerializedName;

public class Rep {
    @SerializedName("F")
    private String feelsLike;
    @SerializedName("G")
    private String windGust;
    @SerializedName("H")
    private String relativeHumidity;
    @SerializedName("T")
    private String temperature;
    @SerializedName("V")
    private String visibility;
    @SerializedName("D")
    private String windDirection;
    @SerializedName("S")
    private String windSpeed;
    @SerializedName("U")
    private String maxUV;
    @SerializedName("W")
    private String weatherType;
    @SerializedName("Pp")
    private String precipitationProbability;
    @SerializedName("$")
    private int time;

    public int getTime(){
        return time;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public String getWindGust() {
        return windGust;
    }

    public String getRelativeHumidity() {
        return relativeHumidity;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getMaxUV() {
        return maxUV;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public String getPrecipitationProbability() {
        return precipitationProbability;
    }
}
