package training.metofficeweather;
import training.metofficeweather.forecast.Forecast;
import training.metofficeweather.sitelist.LocationList;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(System.in);
        LocationList locationClient = new LocationList();
        locationClient.locationList();
        System.out.println("Enter location ID");
        String location = scanner.nextLine();
        Forecast forecastClient = new Forecast();
        forecastClient.forecast(location);
    }
}	
