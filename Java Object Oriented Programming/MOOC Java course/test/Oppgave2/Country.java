package test.Oppgave2;

import java.util.Arrays;

public class Country {
    private String name;
    private int inhabitants;
    private int squareMeters;
    

    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        name = name.toLowerCase();
        String[] s = name.split("");

        if (Arrays.stream(s).allMatch(c -> "qwertyuiopåasdfghjkløæzxcvbnm".contains(c))) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Kan ikke ha bare ha alfabetiske bokstaver i navnet.");
        }
    }

    /**
     * @return the inhabitants
     */
    public int getInhabitants() {
        return inhabitants;
    }

    /**
     * @param inhabitants the inhabitants to set
     */
    public void setInhabitants(int inhabitants) {
        if (inhabitants > 0) {
            this.inhabitants = inhabitants;
        } else {
            throw new IllegalArgumentException("Må ha minst 1 innbygger");
        }
    }

    /**
     * @return the squareMeters
     */
    public int getSquareMeters() {
        return squareMeters;
    }

    /**
     * @param squareMeters the squareMeters to set
     */
    public void setSquareMeters(int squareMeters) {
        if (squareMeters > 0) {
            this.squareMeters = squareMeters;
        }  else {
            throw new IllegalArgumentException("Må ha minst 1 kvadratmeter.");
        }
    }

    public void immigration(int number)  {
        if (number > 0) {
            this.inhabitants += number;
        } else {
            throw new IllegalArgumentException();
        }
        
        
        //uklar oppgavetekst: må vi ta hensyn til ulovlig input (number < 0)?
    }

    public void emigration(int number) {
        if (number > 0 && this.inhabitants - number >= 0) {
            this.inhabitants -= number;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void immigration(int number, Country otherCountry) {
        this.immigration(number);
        otherCountry.emigration(number);

    }

    public Country union(Country country) {
        int inhabitants = this.getInhabitants() + country.getInhabitants();
        int squareMeters = this.getSquareMeters() + country.getSquareMeters();

        Country union = new Country();
        union.setName(this.getName());
        union.setSquareMeters(squareMeters);
        union.setInhabitants(inhabitants);
        return union;
    }

}