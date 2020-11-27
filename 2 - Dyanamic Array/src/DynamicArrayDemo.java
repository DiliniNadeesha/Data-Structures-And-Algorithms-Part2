import java.util.Arrays;
import java.util.Scanner;

public class DynamicArrayDemo {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        while(true){
            System.out.println(Arrays.toString(numbers));
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please select an option");
            System.out.println("A. Append       B. Prepend");
            System.out.println("C. Insert       D. Remove");
            System.out.println("E. Sort         F. Exit");
            System.out.print("> ");
            String option = scanner.nextLine();

            switch (option) {
                case "A": {
                    System.out.print("Enter a value to append: ");
                    int value = scanner.nextInt();
                    int[] temp = new int[numbers.length + 1];
                    for (int i = 0; i < numbers.length; i++) {
                        temp[i] = numbers[i];
                    }
                    numbers = temp;
                    numbers[numbers.length - 1] = value;
                    break;
                }
                case "B": {
                    System.out.print("Enter a value to append: ");
                    int value = scanner.nextInt();
                    int[] temp = new int[numbers.length + 1];
                    for (int i = 0; i < numbers.length; i++) {
                        temp[i + 1] = numbers[i];
                    }
                    numbers = temp;
                    numbers[0] = value;
                    break;
                }
                case "C": {
                    System.out.print("Enter the index: ");
                    int index = scanner.nextInt();
                    System.out.print("Enter the value: ");
                    int value = scanner.nextInt();
                    int[] temp = new int[numbers.length + 1];
                    for (int i = 0; i < temp.length; i++) {
                        if (i == index) {
                            temp[i] = value;
                        } else if (i > index) {
                            temp[i] = numbers[i - 1];
                        } else {
                            temp[i] = numbers[i];
                        }
                    }
                    numbers = temp;
                    break;
                }
                case "D": {
                    System.out.print("Enter the index to remove: ");
                    int removeIndex = scanner.nextInt();
                    int[] temp = new int[numbers.length - 1];
                    for (int i = 0; i < temp.length; i++) {
                        if (i >= removeIndex) {
                            temp[i] = numbers[i + 1];
                        } else {
                            temp[i] = numbers[i];
                        }
                    }
                    numbers = temp;
                    break;
                }
                case "E":
                    System.out.println("To-do: sort");
                    break;
                case "F":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option is selected, please try again");
            }
            System.out.println(Arrays.toString(numbers));
        }
    }

}
