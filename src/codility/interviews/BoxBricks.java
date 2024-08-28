package codility.interviews;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BoxBricks {

    public static int solution(int[] A) {

        Map<Integer, Integer> boxes = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] - 10;
            if (A[i] > 0) {
                boxes.put(i, A[i]);
            }
        }

        boxes.forEach((integer, integer2) -> System.out.println(integer + " " + integer2));
        System.out.println(Arrays.toString(A));

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{7, 15, 10, 8})); // 7
    }
}
