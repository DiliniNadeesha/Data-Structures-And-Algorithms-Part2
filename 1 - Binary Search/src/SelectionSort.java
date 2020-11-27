import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] numbers = {1, -3, 0, 10, 5, 5, 2, 100};
        for (int j = 0; j < numbers.length; j++) {
            int minIndex = j;
            for (int i = j+1; i < numbers.length; i++) {
                if (numbers[minIndex] > numbers[i]){
                    minIndex = i;
                }
            }
            int temp = numbers[j];
            numbers[j] = numbers[minIndex];
            numbers[minIndex] = temp;
        }
        System.out.println(Arrays.toString(numbers));
    }

}
