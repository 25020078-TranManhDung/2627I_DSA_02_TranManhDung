public class CountingSort1 {
    public static int[] countingSort(int[] a) {
        int[] freq = new int[100];

        for (int num : a) {
            freq[num]++;
        }

        return freq;
    }

    public static void printArray(int[] a) {
        for (int count : a) {
            System.out.print(count + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 2, 1, 99, 0, 5, 5};

        int[] result = countingSort(arr);

        System.out.println("Mảng tần suất xuất hiện (từ 0 đến 99):");
        printArray(result);
    }
}
