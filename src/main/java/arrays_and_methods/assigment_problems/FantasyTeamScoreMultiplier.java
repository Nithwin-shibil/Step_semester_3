package arrays_and_methods.assigment_problems;

import java.util.Arrays;

/**
 * Week 5 - Problem 1 (Easy) : Fantasy Team Score Multiplier
 * Arrays are passed by reference, so changing playerScores[i] here changes the
 * caller's array too - which is exactly why this method returns nothing.
 */
public class FantasyTeamScoreMultiplier {

    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] = playerScores[captainIndex] * 2;        // captain  -> 2x
        playerScores[viceCaptainIndex] = playerScores[viceCaptainIndex] * 1.5;  // vice    -> 1.5x
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores));
    }
}
