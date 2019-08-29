package Eksamener.Eksamen2011;

public class LeagueTableRow implements Comparable<LeagueTableRow> {

    public int points;
    public final String team;

    public LeagueTableRow(int points, String team) {
        this.points = points;
        this.team = team;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    @Override
    public int compareTo(LeagueTableRow row) {
        return -(this.points - row.points);
    }

    @Override
    public String toString() {
        return this.team + " " + this.points;
    }
}