import java.util.Arrays;
import java.util.Scanner;

public class SumArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//      Nhập kích thước của mảng
        System.out.println("Enter the size of the array:");
        int size = scanner.nextInt();

        int[] array = new int[size];

//      Nhập mảng
        System.out.println("Enter the numbers in array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

//      Dùng hàm sort để sort mảng
        Arrays.sort(array);
        System.out.println("Sorted Array: " + Arrays.toString(array));

//      Tính tổng các số trong mảng
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        System.out.println("Sum: " + sum);

//      Tính trung bình
        double average = (double) sum / array.length;
        System.out.println("Average: " + average);
    }
}
