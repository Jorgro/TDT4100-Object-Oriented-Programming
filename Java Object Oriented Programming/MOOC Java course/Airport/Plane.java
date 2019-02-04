package Airport;

import java.util.ArrayList;
import java.util.Scanner;

public class Plane {

    private String ID;
    private int capacity;
    private ArrayList<String[]> airflights;

    public Plane(String ID, int capacity) {
        this.ID = ID;
        this.capacity = capacity;
        this.airflights = new ArrayList<String[]>();
    }

    public String toString() {
        return this.ID + " (" + Integer.toString(this.capacity) + " ppl)";
    }

    public void addFlight(Scanner reader) {
        System.out.println("Give departure airport code: ");
        String departure = reader.nextLine();

        System.out.println("Give destination airport code: ");
        String destination = reader.nextLine();

        String[] airflight = {departure, destination};
        this.airflights.add(airflight);
    }

    public String getID() {
        return this.ID;
    }

    public void printFlights() {
        for (String[] array : this.airflights) {
            System.out.println(this + " (" + array[0] + "-" + array[1] + ")");
        }
    }
}