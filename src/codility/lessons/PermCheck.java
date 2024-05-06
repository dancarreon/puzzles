package codility.lessons;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PermCheck {

    public static int solution(int[] A) {

        Arrays.sort(A);

        Set<Integer> uniques = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (!uniques.add(A[i])) {
                return 0;
            }
        }

        if (A[A.length - 1] != A.length) {
            return 0;
        }

        return 1;
    }

    // 100 score
    public static int solution2(int[] A) {

        Arrays.sort(A);
        Set<Integer> uniques = new HashSet<>();

        for (int num : A) {
           if (!uniques.add(num)) {
               return 0;
           }
        }

        if (A[A.length - 1] != A.length) {
            return 0;
        }

        return 1;
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 7, 3, 2, 7, 3, 1, 10, 8};
        //{4, 3, 1};
        //System.out.println(solution(array));
        System.out.println(solution2(array));
    }
}
