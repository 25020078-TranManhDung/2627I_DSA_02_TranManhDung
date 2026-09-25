import java.io.*;
import java.util.*;

class Result {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;

        for (int h : h1) sum1 += h;
        for (int h : h2) sum2 += h;
        for (int h : h3) sum3 += h;

        int i1 = 0, i2 = 0, i3 = 0;

        while (true) {
            if (i1 == h1.size() || i2 == h2.size() || i3 == h3.size()) {
                return 0;
            }

            if (sum1 == sum2 && sum1 == sum3) {
                return sum1;
            }

            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= h1.get(i1);
                i1++;
            }
            else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= h2.get(i2);
                i2++;
            }
            else if (sum3 >= sum1 && sum3 >= sum2) {
                sum3 -= h3.get(i3);
                i3++;
            }
        }
    }
}
