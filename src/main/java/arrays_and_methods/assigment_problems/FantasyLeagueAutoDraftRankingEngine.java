package arrays_and_methods.assigment_problems;

import java.util.Arrays;

/**
 * Week 5 - Problem 5 (Advanced) : Fantasy League Auto-Draft Ranking Engine
 *
 * Draft rules chosen:
 *   - Experience-only rule : matchesPlayed >= 10  (fitness is irrelevant at this level)
 *   - Combined rule        : matchesPlayed >= 5 AND not injured
 * A player is draftable if EITHER rule passes.
 */
public class FantasyLeagueAutoDraftRankingEngine {

    static final int EXPERIENCE_ONLY_THRESHOLD = 10;
    static final int COMBINED_MATCH_THRESHOLD = 5;

    // Overload 1: established players qualify on matches alone.
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= EXPERIENCE_ONLY_THRESHOLD;
    }

    // Overload 2: newer players must be reasonably experienced AND currently fit.
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= COMBINED_MATCH_THRESHOLD && !injured;
    }

    static String draftAndRank(Player[] players) {
        Player[] draftable = new Player[players.length];
        int count = 0;

        for (int i = 0; i < players.length; i++) {
            Player p = players[i];
            if (isDraftable(p.getMatchesPlayed())
                    || isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftable[count] = p;
                count++;
            }
        }

        draftable = Arrays.copyOf(draftable, count);
        Arrays.sort(draftable);          // compareTo does the whole ranking - no manual sort loop

        StringBuilder ranking = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            ranking.append(i + 1).append(". ").append(draftable[i].getName());
            if (i < draftable.length - 1) {
                ranking.append(" | ");
            }
        }
        return ranking.toString();
    }

    public static void main(String[] args) {
        Player[] squad = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(squad));
    }
}

/**
 * Encapsulated player record. Fields are private; access is through getters only.
 */
class Player implements Comparable<Player> {

    private final String name;
    private final int matchesPlayed;
    private final double battingAverage;   // used as the fantasy-points score
    private final boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public boolean isInjured() {
        return injured;
    }

    // Descending order: the higher average must come FIRST, so "other" is compared first.
    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }
}
