package string.assigment_problems;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Week 2 - Problem 5 : Stop-Word-Filtered Word Frequency Report
 */
public class StopWordFilteredWordFrequency {

    static final String[] STOP_WORDS = {"the", "was", "and", "a", "is", "of", "in"};

    private static boolean isStopWord(String word) {
        for (int i = 0; i < STOP_WORDS.length; i++) {
            if (STOP_WORDS[i].equals(word)) {
                return true;
            }
        }
        return false;
    }

    static void printFilteredWordFrequency(String feedback) {
        // 1. Normalise: lowercase and strip the common punctuation marks.
        String cleaned = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .replace("?", "")
                .replace(";", "")
                .replace(":", "");

        // 2. Split on any run of whitespace.
        String[] words = cleaned.trim().split("\\s+");

        // 3. Count each surviving word. LinkedHashMap keeps first-seen order so ties look stable.
        Map<String, Integer> frequency = new LinkedHashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.isEmpty() || isStopWord(word)) {
                continue;
            }
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        // 4. Sort by count, highest first.
        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(frequency.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
