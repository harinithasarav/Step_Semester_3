public class SrmStudent {

    static String collegeName;
    static String academicYear;

    String name;

    // Static block - runs only once
    static {
        collegeName = "SRM University";
        academicYear = "2026-2027";

        System.out.println("College info loaded");
    }

    public SrmStudent(String name) {
        this.name = name;
    }

    public void printConfirmation() {
        System.out.println(
            "Student record created: " + name
        );
    }

    public static void main(String[] args) {

        String[] names = {
            "Ravi",
            "Meera",
            "Karthik",
            "Divya",
            "Anitha"
        };

        for (String name : names) {

            SrmStudent student =
                new SrmStudent(name);

            student.printConfirmation();
        }
    }
}