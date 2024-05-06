package codility.lessons;

import java.util.*;

public class FrogRiverOne {

    public static int solution(int X, int[] A) {

        Set path = new HashSet();

        for (int i = 0; i < A.length; i++) {
            if (path.add(A[i]) && path.size() == X) {
                return i;
            }
        }

        return -1;
    }

    public static int solution2(int X, int[] A) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
            if (set.size() == X) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]
                {1, 3, 1, 3, 2, 1, 3};
        //{2, 2, 2, 2, 2};
        //{1, 3, 1, 4, 2, 3, 5, 4};
        System.out.println(solution(3, array));
        System.out.println(solution2(3, array));
    }
}
