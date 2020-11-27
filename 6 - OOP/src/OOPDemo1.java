import java.util.Scanner;

public class OOPDemo1 {

    public static void main(String[] args) {
        String[] studentIds = {"S001","S002","S003","S004"};
        String[] studentNames = {"Gaka","Paniya","Anu","Chiki"};

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("Enter the student id to find: ");
            String sId = scanner.next();

            for (int i = 0; i < studentIds.length; i++) {
                if (studentIds[i].equals(sId)) {
                    System.out.println(studentNames[i]);
                    break;
                }
                if (i == (studentIds.length - 1)) {
                    System.out.println("Enter valid student id");
                }
            }
        }
    }

}
