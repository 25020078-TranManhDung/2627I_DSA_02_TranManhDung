public class InsertionSortPart1 {
    public static void insertIntoSorted(int[] a) {
        int n = a.length;
        int e = a[n-1];
        int i = n - 2;

        while (i >= 0 && a[i] > e) {
            a[i + 1] = a[i];
            printArray(a);
            i--;
        }

        a[i + 1] = e;
        printArray(a);
    }

    public static void printArray(int[] a) {
        for (int num : a) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 3};

        System.out.println("Quá trình thực thi:");
        insertIntoSorted(arr);
    }
}
