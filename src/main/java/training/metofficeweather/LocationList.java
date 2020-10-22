package training.metofficeweather;

import com.google.gson.Gson;
import org.glassfish.jersey.jackson.JacksonFeature;
import training.metofficeweather.sitelist.Location;
import training.metofficeweather.sitelist.Locations;
import training.metofficeweather.sitelist.Root;
//import training.metofficeweather.forecast.Location;
import training.metofficeweather.forecast.SiteRep;
import training.metofficeweather.forecast.Period;
import training.metofficeweather.forecast.Rep;
//import training.metofficeweather.forecast.Root;
import training.metofficeweather.forecast.DV;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class LocationList {
    public void locationList() {
        Client metClient = (Client) ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        //Client metClient = ClientBuilder.newClient();
        String name = metClient.target("http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/sitelist?key=74919905-673a-4436-8f8c-4c0f7f8bf9c3")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        Gson gson = new Gson();
        Root root = gson.fromJson(name, Root.class);
        Locations locations = root.getLocations();
        Location[] locations1 = locations.getLocations();
        for (int i = 0; i < locations1.length; i++) {
            System.out.println(locations1[i].getName() + ", region: " + locations1[i].getId());
        }
    }
}