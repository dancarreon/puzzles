package lessons;

import java.util.Arrays;

public class CyclicRotation {

    public static int[] solution(int[] A, int K) {

        int len = A.length;
        int rotated[] = new int[A.length];

        for (int i = 0; i < len; i++) {
            rotated[(i + K) % (len)] = A[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        int A[] = new int[] {1, 2, 3, 4};
        int K = 4;

        int solution[] = (solution(A, K));
        Arrays.stream(solution).forEach(System.out::print);
    }
}
