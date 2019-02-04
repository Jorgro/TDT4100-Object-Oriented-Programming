package reference;


public enum Rating {
    BAD(-5), 
    MEDIOCRE(-3),
    NOT_WATCHED(0),
    NEUTRAL(1),
    FINE(3),
    GOOD(5);


    private int value;

    private Rating(int number) {
        this.value = number;
    }

    public int getValue() {
        return this.value;
    }
}