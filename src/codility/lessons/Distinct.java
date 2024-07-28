package codility.lessons;

import java.util.HashSet;
import java.util.Set;

public class Distinct {

    public static int solution(int[] A) {

        Set<Integer> uniques = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            uniques.add(A[i]);
        }

        return uniques.size();
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 1, 2, 3, 1};
        System.out.println(solution(array));
    }
}
