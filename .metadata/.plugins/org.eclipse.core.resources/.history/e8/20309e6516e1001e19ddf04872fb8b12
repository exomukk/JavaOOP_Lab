import java.util.Arrays;
import java.util.Scanner;

public class SumArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int size = scanner.nextInt();

        int[] array = new int[size];

        System.out.println("Enter the numbers in array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);
        System.out.println("Sorted Array: " + Arrays.toString(array));

        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        System.out.println("Sum: " + sum);

        double average = (double) sum / array.length;
        System.out.println("Average: " + average);
    }
}
