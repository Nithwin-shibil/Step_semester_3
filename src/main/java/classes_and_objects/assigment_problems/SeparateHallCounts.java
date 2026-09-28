package classes_and_objects.assigment_problems;

/**
 * Week 3 - L2 : Two Objects, Two Separate Occupancy Counts
 * Each ExamHall keeps its own seatsFilled, so changing hallA leaves hallB alone.
 */
public class SeparateHallCounts {

    static class ExamHall {
        String hallName;
        int seatsFilled;
    }

    public static void main(String[] args) {
        ExamHall hallA = new ExamHall();
        hallA.hallName = "Block-3 Hall A";
        ExamHall hallB = new ExamHall();
        hallB.hallName = "Block-3 Hall B";

        hallA.seatsFilled++;
        hallA.seatsFilled++;
        hallA.seatsFilled++;
        hallA.seatsFilled++;

        System.out.println(hallA.hallName + " seatsFilled: " + hallA.seatsFilled);
        System.out.println(hallB.hallName + " seatsFilled: " + hallB.seatsFilled);
    }
}
