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
        Rep[] rep = period[0].getRep();
        System.out.println(rep[0].getFeelsLike());
    }
}
