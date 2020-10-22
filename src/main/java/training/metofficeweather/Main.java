package training.metofficeweather;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(System.in);
        MetClient client = new MetClient();
        client.locationList();
        System.out.println("Enter location ID");
        String location = scanner.nextLine();
        client.forecast(location);
    }
}	
