package classes_and_objects.assigment_problems;

/**
 * Week 6 - M4 : Exam Hall Ticket Reference Management
 * Demonstrates reference semantics: "copy" points at the SAME object as "priya",
 * so changing a field through copy is visible through priya too. "separate" is a
 * genuinely different object, so == is false even with identical field values.
 */
public class HallTicket {

    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {
        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya;              // same object, just a second reference to it
        copy.seatNumber = 45;

        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));

        HallTicket separate = new HallTicket("Priya", 45);   // a genuinely new object
        System.out.println("separate == priya: " + (separate == priya));
    }
}
