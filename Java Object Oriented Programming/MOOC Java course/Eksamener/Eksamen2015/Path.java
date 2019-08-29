package Eksamener.Eksamen2015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Path {

    List<Segment> segments = new ArrayList<>();

    public Path(Segment... s) {
        Arrays.stream(s).forEach(c -> this.segments.add(c));
    }

    public Segment getSegment(int index) {
        if (index < segments.size()) {
            return segments.get(index);
        }
        return null;
    }

    public int getSize() {
        return this.segments.size();
    }

    public Segment getSegment() {
        return this.segments.get(this.segments.size() - 1);
    }

    public void addSegment(Segment segment) {
        this.segments.add(segment);
    }

    public double getDuration() {
        return this.segments.stream().mapToDouble(Segment::getDuration).sum();
    }

    public double getDistance(Segment fromSegment, Segment toSegment) {
        this.segments.stream().sorted((a, b) -> (int) (a.getLength() - b.getLength()));
        if (!((this.segments.contains(fromSegment) && fromSegment != null)
                || (this.segments.contains(toSegment)) && toSegment != null)) {
            throw new IllegalArgumentException();
        }
        int fromIndex, toIndex;

        if (fromSegment == null) {
            fromIndex = 0;
        } else {
            fromIndex = this.segments.indexOf(fromSegment);
        }

        if (toSegment == null) {
            toIndex = this.getSize();
        } else {
            toIndex = this.segments.indexOf(toSegment);
        }

        double distance = 0;

        for (int i = fromIndex; i < toIndex; i++) {
            distance += this.segments.get(i).getLength();
        }

        return distance;
    }

    public Segment getSegmentAt(double distance, boolean next) {

        if (distance == 0 && !next) {
            return null;
        }

        for (Segment seg : this.segments) {
            distance -= seg.getLength();
            if (distance <= 0) {
                if (next && this.segments.indexOf(seg) != this.segments.size() - 1) {
                    return this.segments.get(this.segments.indexOf(seg) + 1);
                } else if ((next && this.segments.indexOf(seg) == this.segments.size() - 1)) {
                    return null;
                } else {
                    return seg;
                }
            }
        }

        return null;

    }
}