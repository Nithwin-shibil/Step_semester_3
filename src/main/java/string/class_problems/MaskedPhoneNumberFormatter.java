package string.class_problems;

/**
 * Week 2 (Live Session) - Problem 4 : Masked Phone Number Formatter
 */
public class MaskedPhoneNumberFormatter {

    static String maskPhoneNumber(String phone) {
        if (phone.length() != 10) {
            return "Invalid phone number";
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder masked = new StringBuilder();
        masked.append("XXXXXX");                       // hide the first 6 digits
        masked.append(phone.substring(6));             // keep the last 4 digits
        masked.insert(6, "-");                         // readability separator

        return masked.toString();
    }

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210"));
        System.out.println(maskPhoneNumber("98765"));
    }
}
