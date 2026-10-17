public class sortTwoValues {
    public static void sortTwoValues(int[] a) {
        if (a.length <= 1) return;

        int minVal = a[0];
        for (int k = 1; k < a.length; k++) {
            if (a[k] != a[0]) {
                minVal = Math.min(a[0], a[k]);
                break;
            }
        }

        int i = 0;
        int j = a.length - 1;

        while (i < j) {
            while (i < j && a[i] == minVal) {
                i++;
            }

            while (i < j && a[j] != minVal) {
                j--;
            }

            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 1, 2, 1, 2, 2, 1};
        System.out.print("Truoc khi sap xep: ");
        for (int val : arr1) System.out.print(val + " ");
        System.out.println();

        sortTwoValues(arr1);

        System.out.print("Sau khi sap xep: ");
        for (int val : arr1) System.out.print(val + " ");
        System.out.println();

        System.out.println("--------------------");

        int[] arr2 = {9, 5, 9, 9, 5, 5, 9};
        System.out.print("Truoc khi sap xep: ");
        for (int val : arr2) System.out.print(val + " ");
        System.out.println();

        sortTwoValues(arr2);

        System.out.print("Sau khi sap xep: ");
        for (int val : arr2) System.out.print(val + " ");
        System.out.println();
    }
}
