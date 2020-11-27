import java.util.Scanner;

public class OOPDemo3 {

    public static String[][] students = {
            {"S001", "Gaka", "200"},
            {"S002", "Paniya", "450"},
            {"S003", "Anu", "350"},
            {"S004", "Chiki", "450"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter an option: ");
            System.out.println("A. Search Student       B. Obtain Total Marks");
            System.out.println("C. Obtain Max Marks     D. Obtain Min Marks");
            System.out.println("E. Add New Student      F. Print All Details");
            System.out.println("G. Remove a Student     H. Exit");
            System.out.print("> ");
            String option = scanner.next();
            switch (option) {
                case "A":
                    searchStudent();
                    break;
                case "B":
                    obtainTotalMarks();
                    break;
                case "C":
                    obtainMaxMarks();
                    break;
                case "D":
                    obtainMinMarks();
                    break;
                case "E":
                    addNewStudent();
                    break;
                case "F":
                    printAllDetails();
                    break;
                case "G":
                    removeStudent();
                    break;
                case "H":
                    System.exit(0);
                default:
                    System.out.println("Invalid option, please try again");
            }
        }
    }

    public static void searchStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student id: ");
        String sId = scanner.next();
        for (int i = 0; i < students.length; i++) {
            if (sId.equals(students[i][0])) {
                System.out.println("------------------------");
                System.out.println("|" + students[i][0] + "\t|" + students[i][1] + "\t\t|" + students[i][2] + "|");
                System.out.println("------------------------");
                break;
            }
            if (i > (students.length - 1)) {
                System.out.println("Failed to search: invalid id");
            }
        }
    }

    public static void obtainTotalMarks() {
        int totalMarks = 0;
        for (int i = 0; i < students.length; i++) {
            totalMarks += Integer.parseInt(students[i][2]);
        }
        System.out.println("-------------------");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("-------------------");
    }

    public static void obtainMaxMarks() {
        int max = Integer.parseInt(students[0][2]);
        for (int i = 1; i < students.length; i++) {
            if (max < Integer.parseInt(students[i][2])) {
                max = Integer.parseInt(students[i][2]);
            }
        }
        // We have obtained the max marks
        System.out.println("------------------------");
        for (int i = 0; i < students.length; i++) {
            if (max == Integer.parseInt(students[i][2])) {
                System.out.println("|" + students[i][0] + "\t|" + students[i][1] + "\t\t|" + students[i][2] + "|");
            }
        }
        System.out.println("------------------------");
    }

    public static void obtainMinMarks() {
        int min = Integer.parseInt(students[0][2]);
        for (int i = 1; i < students.length; i++) {
            if (min > Integer.parseInt(students[i][2])) {
                min = Integer.parseInt(students[i][2]);
            }
        }
        // We have obtained the max marks
        System.out.println("------------------------");
        for (int i = 0; i < students.length; i++) {
            if (min == Integer.parseInt(students[i][2])) {
                System.out.println("|" + students[i][0] + "\t|" + students[i][1] + "\t\t|" + students[i][2] + "|");
            }
        }
        System.out.println("------------------------");
    }

    public static void addNewStudent() {

        Scanner scanner = new Scanner(System.in);
        boolean exist;
        String sId;
        do {
            System.out.print("Enter new student id: ");
            sId = scanner.next();
            exist = existsStudent(sId);
            if (exist) {
                System.out.println("Student id already exists, please try again");
            }
        } while (exist);
        System.out.print("Enter new student name: ");
        String name = scanner.next();
        name += scanner.nextLine();
        System.out.print("Enter new total marks: ");
        int marks = scanner.nextInt();

        String[][] tempStudents = new String[students.length + 1][];

        for (int i = 0; i < students.length; i++) {
            tempStudents[i] = students[i];
        }

/*        tempStudents[tempStudents.length - 1] = new String[3];
        tempStudents[tempStudents.length - 1][0] = sId;
        tempStudents[tempStudents.length - 1][1] = name;
        tempStudents[tempStudents.length - 1][2] = marks + "";*/

        tempStudents[tempStudents.length - 1] = new String[]{sId, name, marks + ""};

        students = tempStudents;

    }

    public static void printAllDetails() {
        System.out.println("|ID\t\t| Name\t\t|Marks");
        System.out.println("------------------------");
        for (int i = 0; i < students.length; i++) {
            System.out.println("|" + students[i][0] + "\t|" + students[i][1] + "\t\t|" + students[i][2] + "|");
        }
        System.out.println("------------------------");
    }

    public static void removeStudent() {

        Scanner scanner = new Scanner(System.in);
        boolean exist;
        String sId;

        System.out.print("Enter student id: ");
        sId = scanner.next();
        exist = existsStudent(sId);
        if (!exist) {
            System.out.println("Invalid student id, please try again");
            return;
        }

        String[][] tempStudents = new String[students.length - 1][];

        boolean flag = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i][0].equals(sId)) {
                flag = true;
                continue;
            }
            tempStudents[i - ((flag) ? 1 : 0)] = students[i];
        }
        students = tempStudents;
    }

    public static boolean existsStudent(String studentId) {
        for (int i = 0; i < students.length; i++) {
            if (students[i][0].equals(studentId)) {
                return true;
            }
        }
        return false;
    }
}
