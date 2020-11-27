import java.util.Arrays;
import java.util.Scanner;

public class DynamicArrayDemo2 {

    public static int[] numbers = {10,20,30,40,50};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println(Arrays.toString(numbers));
            System.out.println("Select a option");
            System.out.println("A. Insert           B. Append Array");
            System.out.println("C. Prepend Array    D. Remove");
            System.out.println("E. Exit");
            System.out.print("> ");
            String option = scanner.next();
            switch (option) {
                case "A": {
                    System.out.print("Please enter the index: ");
                    int index = scanner.nextInt();
                    System.out.print("Please enter the value: ");
                    int value = scanner.nextInt();
                    insert(index, value);
                    break;
                }
                case "B": {
                    System.out.print("Please enter the array size: ");
                    int size = scanner.nextInt();
                    if (size < 1){
                        System.out.println("Failed to append: invalid size");
                        break;
                    }
                    int temp[] = new int[size];
                    for (int i = 0; i < size; i++) {
                        System.out.print("Enter number " +  (i+1) +": ");
                        temp[i] = scanner.nextInt();
                    }
                    appendArray(temp);
                    break;
                }
                case "C": {
                    System.out.print("Please enter the array size: ");
                    int size = scanner.nextInt();
                    if (size < 1){
                        System.out.println("Failed to prepend: invalid size");
                        break;
                    }
                    int temp[] = new int[size];
                    for (int i = 0; i < size; i++) {
                        System.out.print("Enter number " +  (i+1) +": ");
                        temp[i] = scanner.nextInt();
                    }
                    prependArray(temp);
                    break;
                }
                case "D": {
                    System.out.print("Please enter the index: ");
                    int index = scanner.nextInt();
                    remove(index);
                    break;
                }
                case "E": {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Invalid option, please try again");
                }
            }
        }
    }

    public static void insert(int index, int value){
        if (index < 0 || index > (numbers.length -1)){
            System.out.println("Failed to insert: invalid index");
            return;
        }
        int[] temp = new int[numbers.length + 1];
        for (int i = 0; i < temp.length; i++) {
            if (i == index){
                temp[i] = value;
            }else if (i > index){
                temp[i] = numbers[i-1];
            }else{
                temp[i] = numbers[i];
            }
        }
        numbers = temp;
    }

    public static void appendArray(int[] newArray){
        int[] numbers2 = new int[numbers.length + newArray.length];
        for (int i = 0; i < numbers2.length; i++) {
            if (i > (numbers.length - 1)){
                numbers2[i] = newArray[i-numbers.length];
            }else{
                numbers2[i] = numbers[i];
            }
        }
        numbers = numbers2;
    }

    public static void prependArray(int[] newArray){
        int[] numbers2 = new int[numbers.length + newArray.length];
        for (int i = 0; i < numbers2.length; i++) {
            if (i > (newArray.length - 1)){
                numbers2[i] = numbers[i-newArray.length];
            }else{
                numbers2[i] = newArray[i];
            }
        }
        numbers = numbers2;
    }

    public static void remove(int index){
        if (index < 0 || index > (numbers.length -1)){
            System.out.println("Failed to delete: invalid index");
            return;
        }
        int[] temp = new int[numbers.length - 1];
        for (int i = 0; i < temp.length; i++) {
            if (i >= index){
                temp[i] = numbers[i+1];
            }else{
                temp[i] = numbers[i];
            }
        }
        numbers = temp;
    }

}
