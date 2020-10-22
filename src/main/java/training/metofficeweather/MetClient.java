package training.metofficeweather;

import com.google.gson.Gson;
import org.glassfish.jersey.jackson.JacksonFeature;
import training.metofficeweather.sitelist.Location;
import training.metofficeweather.sitelist.Locations;
import training.metofficeweather.sitelist.Root;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

public class MetClient {
    public void locationList() throws IOException {
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
    public void forecast(String locationId) {
        Client metClient = (Client) ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        String link = ("http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/"+locationId+"?res=daily&key=74919905-673a-4436-8f8c-4c0f7f8bf9c3");
        String locationForecast = metClient.target(link).request(MediaType.TEXT_PLAIN).get(String.class);
        Gson gson = new Gson();
        Root root = gson.fromJson(locationForecast, Root.class);
        Locations locations = root.getLocations();
        Location[] locations1 = locations.getLocations();
        System.out.println();
    }
}
