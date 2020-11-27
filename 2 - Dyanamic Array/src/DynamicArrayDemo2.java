import java.util.Arrays;
import java.util.Scanner;

public class DynamicArrayDemo2 {

    public static void main(String[] args) {

        int[] num1 = {10, 20, 30, 40, 50};
        int[] num2 = {60, 70, 80};
        int[] result = new int[num1.length + num2.length];

        System.out.println("Num1 = " + Arrays.toString(num1));
        System.out.println("Num2 = " + Arrays.toString(num2));
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select an option");
        System.out.println("A. Append");
        System.out.println("B. Prepend");
        System.out.println("C. Insert");
        System.out.println("D. Exit");
        System.out.print("> ");
        String option = scanner.nextLine();
        switch (option){
            case "A":
                break;
            case "B":
                break;
            case "C":
                int index;
                boolean invalid;
                do {
                    System.out.print("Enter the index: ");
                    index = scanner.nextInt();
                    invalid = index < 0 || index > (num1.length-1);
                    if (invalid) {
                        System.out.println("Invalid index, please try again");
                    }
                }while(invalid);

                for (int i = 0; i < result.length; i++) {

                    if (i >= index && i < (index + num2.length)){
                        result[i] = num2[i - index];
                    }else if (i >= (index + num2.length)){
                        result[i] = num1[i - num2.length];
                    }else{
                        result[i] = num1[i];
                    }
                }

                break;
            case "D":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
        System.out.println("Result =" + Arrays.toString(result));

    }

}
