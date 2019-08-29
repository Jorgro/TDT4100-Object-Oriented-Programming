package Eksamener.Eksamen2011;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeagueTable {

    private final List<String> teams;
    private List<MatchResult> results = new ArrayList<>();
    private List<LeagueTableRow> rows = new ArrayList<>();

    public LeagueTable(String... teams) {
        this.teams = new ArrayList<String>(Arrays.asList(teams));
        this.teams.stream().forEach(team -> this.rows.add(new LeagueTableRow(0, team)));
    }

    public void addMatch(MatchResult match) {
        String[] participants = match.getParticipants();
        if (!(teams.contains(participants[0]) && teams.contains(participants[1]))) {
            throw new IllegalArgumentException();
        }
        this.results.add(match);
    }

    public int getParticipantPoints(MatchResult matchResult, String participant) {
        if (!matchResult.isParticipant(participant)) {
            return 0;
        }

        if (matchResult.isWinner(participant)) {
            return 3;
        } else if (matchResult.isDraw()) {
            return 1;
        }
        return 0;
    }

    public void updateRows() {
        for (LeagueTableRow row : this.rows) {
            for (MatchResult match : this.results) {
                row.points += getParticipantPoints(match, row.team);
            }

        }

        Collections.sort(this.rows);
    }

    @Override
    public String toString() {
        String result = "League Table: \n";
        for (MatchResult match : results) {
            result += match.toString() + "\n";
        }

        for (LeagueTableRow row : rows) {
            result += row.toString() + "\n";
        }

        return result.trim();
    }

}