package string.class_problems;

/**
 * Week 2 (Live Session) - Problem 5 : Bank Transaction Reference Generator & Validator
 * Valid reference = 3 letters (bank code) + 6 digits (ddMMyy) + 5 digits (sequence) = 14 chars.
 */
public class BankTransactionReferenceValidator {

    static String normalizeReference(String raw) {
        String trimmed = raw.trim();

        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        // Uppercase ONLY the first 3 characters, leave the rest untouched.
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: the remaining 11 characters must be digits";
            }
        }

        StringBuilder display = new StringBuilder();
        display.append("[").append(reference.substring(0, 3)).append("] ");
        display.append("DATE: ").append(reference, 3, 5).append("/")
               .append(reference, 5, 7).append("/").append(reference, 7, 9);
        display.append(" | SEQ: ").append(reference.substring(9));

        return display.toString();
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(normalizeReference("  hdf03022600042  ")));
        System.out.println(validateAndFormat(normalizeReference("12F03022600042")));
    }
}
