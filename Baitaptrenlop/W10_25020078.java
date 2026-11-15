public class W10_25020078 {

    public static int[] findMaxMin(int[] A, int low, int high) {
        if (low == high) {
            return new int[]{A[low], A[low]};
        }

        if (high == low + 1) {
            if (A[low] > A[high]) {
                return new int[]{A[low], A[high]};
            } else {
                return new int[]{A[high], A[low]};
            }
        }

        int mid = (low + high) / 2;

        int[] leftHalf = findMaxMin(A, low, mid);
        int[] rightHalf = findMaxMin(A, mid + 1, high);

        int finalMax = Math.max(leftHalf[0], rightHalf[0]);
        int finalMin = Math.min(leftHalf[1], rightHalf[1]);

        return new int[]{finalMax, finalMin};
    }

    public static void main(String[] args) {
        int[] A = {3, 15, 67, 28, 50, 45, 69, 32, 93, 71};

        int[] result = findMaxMin(A, 0, A.length - 1);

        System.out.print("Dãy A: ");
        for (int num : A) System.out.print(num + " ");

        System.out.println("\n\nKết quả từ phương pháp Chia để trị:");
        System.out.println("Giá trị lớn nhất (Max): " + result[0]);
        System.out.println("Giá trị nhỏ nhất (Min): " + result[1]);
    }
}
