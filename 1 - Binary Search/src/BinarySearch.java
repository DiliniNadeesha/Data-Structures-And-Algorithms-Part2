import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {

        int[] numbers = {1,3,5,7,9,10,15};

        System.out.println(Arrays.toString(numbers));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number to search: ");
        int searchValue = scanner.nextInt();

        int startingIndex = 0;
        int lastIndex = numbers.length-1;

        while(true){
            int middleIndex = (startingIndex + lastIndex)/2;
            if (searchValue < numbers[middleIndex]){
                lastIndex = middleIndex-1;
            }else if (searchValue > numbers[middleIndex]){
                startingIndex = middleIndex+1;
            }else{
                System.out.println(searchValue + "'s index is : " + middleIndex);
                break;
            }
            if (startingIndex > lastIndex){
                System.out.println("Not Found");
                break;
            }
        }

    }

}
