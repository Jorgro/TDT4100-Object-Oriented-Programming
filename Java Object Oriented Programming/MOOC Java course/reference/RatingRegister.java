package reference;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingRegister {

    private Map<Film, List<Rating>> films;

    public RatingRegister() {
        this.films = new HashMap<Film, List<Rating>>();

    }

    public void addRating(Film film, Rating rating) {
        if (this.films.containsKey(film)) {
            this.films.get(film).add(rating);
        }
        //strengt tatt overflødig hashmap da man 
        //bare kan legge til rating inne i selve film objektet
        
    }

    public List<Rating> getRatings(Film film) {
        if (this.films.containsKey(film)) {
            return this.films.get(film);
        }
        return null;
    }

    public Map<Film, List<Rating>> filmRatings() {
        return this.films;
    }

    public static void main(String[] args) {
        Film theBridgesOfMadisonCounty = new Film("The Bridges of Madison County");
        Film eraserhead = new Film("Eraserhead");
    
        RatingRegister reg = new RatingRegister();
        reg.addRating(eraserhead, Rating.BAD);
        reg.addRating(eraserhead, Rating.BAD);
        reg.addRating(eraserhead, Rating.GOOD);
    
        reg.addRating(theBridgesOfMadisonCounty, Rating.GOOD);
        reg.addRating(theBridgesOfMadisonCounty, Rating.FINE);
    
        System.out.println("All ratings: " + reg.filmRatings());
        System.out.println("Ratings for Eraserhead: " + reg.getRatings(eraserhead));
    }
}