package codility.lessons;

import java.util.Arrays;

public class Triangle {

    // 93%
    public static int solution(int[] A) {
        Arrays.sort(A);

        for (int i = A.length - 1; i >= 0; i--) {
            if (i + 2 <= A.length - 1) {
                int Q = A[i];
                int R = A[i + 1];
                int P = A[i + 2];
                if ((P + Q > R) && (Q + R > P) && (R + P > Q)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    // 100%
    public static int solution2(int[] A) {
        Arrays.sort(A);
        long[] longA = new long[A.length];

        int index = 0;
        for (Integer i : A) {
            longA[index++] = i;
        }

        for (int i = longA.length - 1; i >= 2; i--) {
            if (longA[i - 1] + longA[i - 2] > longA[i]) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] { 10, 2, 5, 1, 8, 20 })); // 1
        System.out.println(solution(new int[] { 10, 50, 5, 1 })); // 0
        System.out.println(solution(new int[] { 5, 3, 3 })); // 1
    }
}
