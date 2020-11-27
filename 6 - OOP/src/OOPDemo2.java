import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.util.Scanner;

public class OOPDemo2 {

    public static String[] studentIds = {"S001", "S002", "S003", "S004"};
    public static String[] studentNames = {"Gaka", "Paniya", "Anu", "Chiki"};
    public static int[] totalMarks = {200, 400, 200, 450};

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
        for (int i = 0; i < studentIds.length; i++) {
            if (sId.equals(studentIds[i])) {
                System.out.println("-------------------");
                System.out.println(studentIds[i] + " |" + totalMarks[i] + "\t|" + studentNames[i]);
                System.out.println("-------------------");
                break;
            }
            if (i == (studentIds.length - 1)) {
                System.out.println("Failed to search: invalid id");
            }
        }
    }

    public static void obtainTotalMarks() {
        int totalMarks = 0;
        for (int i = 0; i < studentIds.length; i++) {
            totalMarks += OOPDemo2.totalMarks[i];
        }
        System.out.println("-------------------");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("-------------------");
    }

    public static void obtainMaxMarks() {
        int max = totalMarks[0];
        for (int i = 1; i < totalMarks.length; i++) {
            if (max < totalMarks[i]) {
                max = totalMarks[i];
            }
        }
        // We have obtained the max marks
        System.out.println("-------------------");
        for (int i = 0; i < totalMarks.length; i++) {
            if (max == totalMarks[i]) {
                System.out.println(studentIds[i] + " |" + totalMarks[i] + "\t|" + studentNames[i]);
            }
        }
        System.out.println("-------------------");
    }

    public static void obtainMinMarks() {
        int min = totalMarks[0];
        for (int i = 1; i < totalMarks.length; i++) {
            if (min > totalMarks[i]) {
                min = totalMarks[i];
            }
        }
        // We have obtained the min marks
        System.out.println("-------------------");
        for (int i = 0; i < totalMarks.length; i++) {
            if (min == totalMarks[i]) {
                System.out.println(studentIds[i] + " |" + totalMarks[i] + "\t|" + studentNames[i]);
            }
        }
        System.out.println("-------------------");
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

        String[] tempNames = new String[studentNames.length + 1];
        String[] tempIds = new String[tempNames.length];
        int[] tempMarks = new int[tempIds.length];

        for (int i = 0; i < studentIds.length; i++) {
            tempIds[i] = studentIds[i];
            tempNames[i] = studentNames[i];
            tempMarks[i] = totalMarks[i];
        }

        tempNames[tempNames.length - 1] = name;
        tempIds[tempNames.length - 1] = sId;
        tempMarks[tempNames.length - 1] = marks;

        studentIds = tempIds;
        studentNames = tempNames;
        totalMarks = tempMarks;

    }

    public static void printAllDetails() {
        System.out.println("|ID\t\t| Name\t\t|Marks");
        System.out.println("------------------------");
        for (int i = 0; i < studentIds.length; i++) {
            System.out.println("|" + studentIds[i] + "\t|" + studentNames[i] + "\t\t|" + totalMarks[i] + "|");
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

        String[] tempNames = new String[studentNames.length - 1];
        String[] tempIds = new String[tempNames.length];
        int[] tempMarks = new int[tempIds.length];

        boolean flag = false;
        for (int i = 0; i < studentIds.length; i++) {
            if (studentIds[i].equals(sId)) {
                flag = true;
                continue;
            }
            tempIds[i - ((flag) ? 1 : 0)] = studentIds[i];
            tempNames[i - ((flag) ? 1 : 0)] = studentNames[i];
            tempMarks[i - ((flag) ? 1 : 0)] = totalMarks[i];
        }

        studentIds = tempIds;
        studentNames = tempNames;
        totalMarks = tempMarks;
    }

    public static boolean existsStudent(String studentId) {
        for (int i = 0; i < studentIds.length; i++) {
            if (studentIds[i].equals(studentId)) {
                return true;
            }
        }
        return false;
    }
}
