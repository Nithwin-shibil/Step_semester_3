package encapsulation_and_access_control.assigment_problems;

/**
 * Week 7 - Problem 3 : The Password Checker
 * The password is stored privately and final - there is no getter that
 * ever returns it, only a derived strength label.
 */
public class PasswordChecker {

    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int length = password.length();
        boolean hasDigit = false;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                hasDigit = true;
                break;
            }
        }

        if (length < 6) {
            return "Weak";
        } else if (length < 10) {
            return hasDigit ? "Medium" : "Weak";
        } else {
            return hasDigit ? "Strong" : "Medium";
        }
    }

    public static void main(String[] args) {
        PasswordChecker pc = new PasswordChecker("abcd");
        System.out.println(pc.getStrength());          // Weak

        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println(pc2.getStrength());          // Medium (no digit)

        PasswordChecker pc3 = new PasswordChecker("abcdefgh12");
        System.out.println(pc3.getStrength());          // Strong (10+ chars with a digit)
    }
}
