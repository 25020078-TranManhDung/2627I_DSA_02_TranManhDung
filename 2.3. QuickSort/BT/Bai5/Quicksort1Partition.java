import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quicksort1Partition {
    public static List<Integer> quickSort(List<Integer> arr) {
        if (arr.isEmpty() || arr == null) {
            return new ArrayList<>();
        }

        int pivot = arr.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int num : arr) {
            if (num < pivot) {
                left.add(num);
            }
            else if (num > pivot) {
                right.add(num);
            }
            else {
                equal.add(num);
            }
        }

        List<Integer> result = new ArrayList<>();
        result.addAll(left);
        result.addAll(equal);
        result.addAll(right);

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so luong phan tu n: ");
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            List<Integer> arr = new ArrayList<>();

            System.out.println("Nhap cac phan tu cua mang: ");
            for (int i = 0; i < n; i++) {
                arr.add(scanner.nextInt());
            }

            List<Integer> result = quickSort(arr);

            System.out.print("Ket qua sau khi phan hoach: ");
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i != result.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        } else {
            System.out.println("Dau vao khong hop le.");
        }

        scanner.close();
    }
}
