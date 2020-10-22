package training.metofficeweather.forecast;

import com.google.gson.Gson;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class Forecast {
    public void forecast(String locationId) {
        Client metClient = (Client) ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        String link = ("http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/"+locationId+"?res=3hourly&key=74919905-673a-4436-8f8c-4c0f7f8bf9c3");
        String locationForecast = metClient.target(link).request(MediaType.TEXT_PLAIN).get(String.class);
        Gson gson = new Gson();
        training.metofficeweather.forecast.Root root1 = gson.fromJson(locationForecast, training.metofficeweather.forecast.Root.class);
        SiteRep siteRep = root1.getSiteRep();
        DV dv = siteRep.getDV();
        training.metofficeweather.forecast.Location location = dv.getLocation();
        Period[] period = location.getPeriod();
        //Rep[] rep = period[0].getRep();
        //System.out.println(rep[0].getFeelsLike());
        System.out.println("Location name: " + location.getName());
        Rep[] rep = period[0].getRep();
        for (int j = 0; j < rep.length ; j++){
            String hour = (Integer.toString((rep[j].getTime())/60) + ":00");
            System.out.println("Time " +hour);
            System.out.println("Temperature: "+rep[j].getTemperature()+ "°C, Feels like: "+rep[j].getFeelsLike()+"°C");
            System.out.println("Weather type: "+rep[j].getWeatherType());
            System.out.println("Precipitation Probability: "+rep[j].getPrecipitationProbability());
            System.out.println("Wind Speed: "+rep[j].getWindSpeed()+ "  (Gust: "+rep[j].getWindGust()+", direction: "+rep[j].getWindDirection()+ ")");
            System.out.println("Visibility: "+rep[j].getVisibility());
            System.out.println("Relative humidity: "+rep[j].getRelativeHumidity());
            System.out.println("Max UV: "+rep[j].getMaxUV());
        }

    }
}
