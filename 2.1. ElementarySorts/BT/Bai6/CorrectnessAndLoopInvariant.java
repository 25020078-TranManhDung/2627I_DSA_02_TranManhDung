public class CorrectnessAndLoopInvariant {
    public static void insertionSort(int[] a) {
        int n = a.length;

        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > value) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = value;
        }

        printArray(a);
    }

    public static void printArray(int[] a) {
        for (int n : a) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {7, 4, 3, 5, 6, 2};

        System.out.println("Kết quả sau khi sắp xếp:");
        insertionSort(arr);
    }
}
