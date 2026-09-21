/**
 * Thời gian chạy: O(N)
 */

import edu.princeton.cs.algs4.StdOut;

public class LocalMinimumMatrix {

    public static int[] findLocalMinimum(int[][] a) {
        if (a == null || a.length == 0) return null;
        return search(a, 0, a.length - 1, 0, a[0].length - 1);
    }

    private static int[] search(int[][] a, int rowStart, int rowEnd, int colStart, int colEnd) {
        // Điều kiện dừng an toàn
        if (rowStart > rowEnd || colStart > colEnd) return null;

        int midR = rowStart + (rowEnd - rowStart) / 2;
        int midC = colStart + (colEnd - colStart) / 2;

        int minVal = Integer.MAX_VALUE;
        int minR = -1;
        int minC = -1;

        // B1: Tìm phần tử nhỏ nhất trên Hàng giữa
        for (int c = colStart; c <= colEnd; c++) {
            if (a[midR][c] < minVal) {
                minVal = a[midR][c];
                minR = midR;
                minC = c;
            }
        }

        // B2: Tìm phần tử nhỏ nhất trên Cột giữa
        for (int r = rowStart; r <= rowEnd; r++) {
            if (a[r][midC] < minVal) {
                minVal = a[r][midC];
                minR = r;
                minC = midC;
            }
        }

        // B3: Kiểm tra 4 hàng xóm của phần tử nhỏ nhất vừa tìm được trên chữ thập
        boolean isLocalMin = true;
        int smallerR = -1, smallerC = -1;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Lên, Xuống, Trái, Phải

        for (int[] dir : directions) {
            int nr = minR + dir[0];
            int nc = minC + dir[1];

            // Đảm bảo không vượt quá biên giới của ma trận tổng
            if (nr >= 0 && nr < a.length && nc >= 0 && nc < a[0].length) {
                if (a[nr][nc] < minVal) {
                    isLocalMin = false;
                    smallerR = nr;
                    smallerC = nc;
                    break;
                }
            }
        }

        if (isLocalMin) {
            return new int[]{minR, minC};
        }

        // B4: Thu hẹp vào góc phần tư chứa ô nhỏ hơn
        if (smallerR < midR && smallerC < midC) {
            return search(a, rowStart, midR - 1, colStart, midC - 1); // Nửa trên, trái
        } else if (smallerR < midR && smallerC > midC) {
            return search(a, rowStart, midR - 1, midC + 1, colEnd);   // Nửa trên, phải
        } else if (smallerR > midR && smallerC < midC) {
            return search(a, midR + 1, rowEnd, colStart, midC - 1);   // Nửa dưới, trái
        } else {
            return search(a, midR + 1, rowEnd, midC + 1, colEnd);     // Nửa dưới, phải
        }
    }

    public static void main(String[] args) {
        int[][] a = {
                {30, 29, 28, 27, 26},
                {25, 24, 23, 22, 21},
                {20, 19,  4, 18, 17},
                {15, 14, 13, 12, 11},
                {10,  9,  8,  7,  6}
        };

        int[] result = findLocalMinimum(a);

        if (result != null) {
            StdOut.println("Tìm thấy cực tiểu tại tọa độ: [" + result[0] + "][" + result[1] + "]");
            StdOut.println("Giá trị: " + a[result[0]][result[1]]);
        }
    }
}
