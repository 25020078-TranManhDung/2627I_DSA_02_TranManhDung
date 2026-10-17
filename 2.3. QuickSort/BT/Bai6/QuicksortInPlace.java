import java.util.Scanner;

public class QuicksortInPlace {
    public static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo;

        for (int j = lo; j < hi; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, hi);
        printArray(arr);
        return i;
    }

    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pi = partition(arr, lo, hi);
            quickSort(arr, lo, pi - 1);
            quickSort(arr, pi + 1, hi);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so luong phan tu n: ");
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];

            System.out.println("Nhap cac phan tu cua mang: ");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println("Ket qua sau tung buoc phan hoach:");
            quickSort(arr, 0, n - 1);
        }

        scanner.close();
    }
}
