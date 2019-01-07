package birdwatchers_database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RingingCentre {

    private Map<Bird, List<String>> observations;

    public RingingCentre() {
        this.observations = new HashMap<Bird, List<String>>();
    }

    public void observe(Bird bird, String place) {
        if (!this.observations.containsKey(bird)) {
            this.observations.put(bird, new ArrayList<String>());
        }
        this.observations.get(bird).add(place);

    }

    public void observations(Bird bird) {
        if (!this.observations.containsKey(bird)) {
            System.out.println(bird + " observations: 0");
        } else {
            System.out.println(bird + " observations: " + this.observations.get(bird).size());
            for (String place : this.observations.get(bird)) {
                System.out.println(place);
            }
        }

    }

    public static void main(String[] args) {
        RingingCentre kumpulaCentre = new RingingCentre();

        kumpulaCentre.observe( new Bird("Rose Starling", "Sturnus roseus", 2012), "Arabia" );
        kumpulaCentre.observe( new Bird("Rose-Coloured Starling", "Sturnus roseus", 2012), "Vallila" );
        kumpulaCentre.observe( new Bird("European Herring Gull", "Larus argentatus", 2008), "Kumpulanmäki" );
        kumpulaCentre.observe( new Bird("Rose Starling", "Sturnus roseus", 2008), "Mannerheimintie" );
    
        kumpulaCentre.observations( new Bird("Rose-Coloured Starling", "Sturnus roseus", 2012 ) );
        System.out.println("--");
        kumpulaCentre.observations( new Bird("European Herring Gull", "Larus argentatus", 2008 ) );
        System.out.println("--");
        kumpulaCentre.observations( new Bird("European Herring Gull", "Larus argentatus", 1980 ) );
    }
}