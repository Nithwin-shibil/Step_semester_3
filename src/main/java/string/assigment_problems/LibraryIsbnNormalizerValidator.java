package string.assigment_problems;

/**
 * Week 2 - Problem 4 : Library ISBN Normalizer & Validator
 * Valid code = 3 letters (publisher) + 4 digits (year) + 6 digits (catalog) = 13 chars.
 */
public class LibraryIsbnNormalizerValidator {

    static String normalizeCode(String raw) {
        String trimmed = raw.trim();

        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        // Uppercase ONLY the first 3 characters (publisher code), leave the rest untouched.
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: the remaining 10 characters must be digits";
            }
        }

        StringBuilder display = new StringBuilder();
        display.append("[").append(code.substring(0, 3)).append("] ");
        display.append("YEAR: ").append(code, 3, 7);
        display.append(" | CATALOG: ").append(code.substring(7));

        return display.toString();
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(normalizeCode("  pen2026004251  ")));
        System.out.println(validateAndFormat(normalizeCode("12N2026004251")));
    }
}
