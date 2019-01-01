package Airport;

import java.util.ArrayList;
import java.util.Scanner;

public class Airport {

    private ArrayList<Plane> planes;
    private ArrayList<String[]> airflights;
    private Scanner reader;

    public Airport(Scanner reader) {
        this.planes = new ArrayList<Plane>();
        this.airflights = new ArrayList<String[]>();
        this.reader = reader;

    }

    private void addPlane() {

        String ID = this.planeID();
        System.out.println("Give plane capacity: ");
        int capacity = Integer.parseInt(reader.nextLine());

        this.planes.add(new Plane(ID, capacity));
    }

    private void addFlight() {
        String ID = this.planeID();
        Plane plane = this.findPlane(ID);
        plane.addFlight(reader);

    }

    private String planeID() {
        System.out.println("Give plane ID: ");
        String ID = reader.nextLine();
        return ID;
    }

    private void printPlanes() {
        for (Plane plane : this.planes) {
            System.out.println(plane);
        }
    }

    private void printFlights() {
        for (Plane plane : this.planes) {
            plane.printFlights();
        }
    }

    private void printPlane() {

        String ID = this.planeID();
        Plane plane = this.findPlane(ID);
        System.out.println(plane);
    }

    private Plane findPlane(String ID) {
        for (Plane plane : this.planes) {
            if (plane.getID().equals(ID)) {
                return plane;
            }
        }
        return null;
    }

    public void start() {

        String line = "\n-------------------------";
        String airportPanel = "Airport panel" + line;

        String menu1 = "Choose operation:" + "\n[1] Add airplane" + "\n[2] Add flight" + "\n[x] Exit" + "\n> ";
        System.out.println(airportPanel);
        String userInput = "";

        while (true) {
            System.out.print(menu1);
            userInput = this.reader.nextLine();
            if (userInput.equals("1")) {
                this.addPlane();
            } else if (userInput.equals("2")) {
                this.addFlight();
            } else if (userInput.equals("x")) {
                break;
            }
        }
        String flightService = "Flight service" + line;

        System.out.println(flightService);

        String menu2 = "Choose operation:" + "\n[1] Print planes" + "\n[2] Print flights" + "\n[3] Print plane info"
                + "\n[x] Quit" + "\n> ";

        while (true) {
            System.out.print(menu2);
            userInput = this.reader.nextLine();
            if (userInput.equals("1")) {
                this.printPlanes();
            } else if (userInput.equals("2")) {
                this.printFlights();
            } else if (userInput.equals("x")) {
                break;
            } else if (userInput.equals("3")) {
                this.printPlane();
            }
        }

    }

}