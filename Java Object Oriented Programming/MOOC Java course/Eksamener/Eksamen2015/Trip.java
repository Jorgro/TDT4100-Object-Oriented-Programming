package Eksamener.Eksamen2015;

public class Trip {

    private final Path expected;
    private final Path registered = new Path();

    public Trip(Path expected) {
        this.expected = expected;
    }

    public void registerSegment(double distance, double duration) {

        if (this.registered.getSize() == this.expected.getSize()) {
            throw new IllegalArgumentException();

        } else if (expected.getDistance(expected.getSegment(0),
                expected.getSegment(registered.getSize())) != distance) {
            throw new IllegalArgumentException();
        }

        distance -= registered.getDistance(null, null);
        duration -= registered.getDuration();

        registered.addSegment(new Segment(distance, duration));
    }

}