package codility.tests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrecedingDivisors {

    public static int[] solution(int[] A) {

        int[] result = new int[A.length];
        Map<Integer, Integer> divisors = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (!divisors.isEmpty()) {
                int totalDivisors = 0;
                for (Map.Entry<Integer, Integer> divisor : divisors.entrySet()) {
                    if (A[i] % divisor.getKey() == 0) {
                        totalDivisors += divisor.getValue();
                    }
                }
                result[i] = totalDivisors;
            }

            if (divisors.containsKey(A[i])) {
                divisors.put(A[i], divisors.get(A[i]) + 1);
            } else {
                divisors.put(A[i], 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 4, 3, 6}))); // 0, 1, 0, 2
        System.out.println(Arrays.toString(solution(new int[]{8, 4, 2}))); // 0, 0, 0
        System.out.println(Arrays.toString(solution(new int[]{7, 8, 7, 8, 8}))); // 0, 0, 1, 1, 2
        System.out.println(Arrays.toString(solution(new int[]{8, 1, 3, 7, 21, 2, 14}))); // 0, 0, 1, 1, 3, 1, 3
    }
}
