package Eksamener.Eksamen2011;

public class MatchResult {

    private final String homeTeam;
    private final String awayTeam;
    private int homePoints = 0;
    private int awayPoints = 0;

    public MatchResult(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public void addPoints(String team, int points) {
        if (!isParticipant(team)) {
            throw new IllegalArgumentException();
        }

        if (team.equals(homeTeam)) {
            homePoints += points;
        } else {
            awayPoints += points;
        }
    }

    public boolean isParticipant(String participant) {
        return (homeTeam.equals(participant) || awayTeam.equals(participant));
    }

    public boolean isDraw() {
        return homePoints == awayPoints;
    }

    public boolean isWinner(String participant) {
        if (!isParticipant(participant)) {
            throw new IllegalArgumentException();
        }

        if (participant.equals(homeTeam)) {
            return homePoints > awayPoints;
        }
        return awayPoints > homePoints;
    }

    public String[] getParticipants() {
        return new String[] { homeTeam, awayTeam };
    }

    @Override
    public String toString() {
        return this.homeTeam + " - " + this.awayTeam + ": " + this.homePoints + " : " + this.awayPoints;
    }
}