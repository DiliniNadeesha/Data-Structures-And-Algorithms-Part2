import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] numbers = {-3, 0, 10, 5, 100, 2, 5};
        for (int i = numbers.length -1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (numbers[j] > numbers[j+1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1] ;
                    numbers[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(numbers));

    }

}
