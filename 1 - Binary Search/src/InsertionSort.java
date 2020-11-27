import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] numbers = {2, -3, 0, 5, 1, 10, 13};
//        int[] numbers = {-3, 2, 0, 5, 1, 10, 13};

        for (int i = 1; i < numbers.length ; i++) {

            int insertion = numbers[i];
            int insertionPoint =i;
            for (int j = i; j > 0 && insertion < numbers[j - 1]; j--) {
                numbers[j] = numbers[j - 1];
                insertionPoint = j - 1;
            }
            numbers[insertionPoint] = insertion;

        }

        System.out.println(Arrays.toString(numbers));
    }

}
