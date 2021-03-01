package codility.lessons;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {

    public static int solution(int[] A) {

        int length = A.length;

        Set uniques = new HashSet();

        for (int i = 0; i < length; i++) {
            uniques.add(A[i]);
        }

        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (!uniques.contains(i)) {
                return i;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        //int array[] = new int[]{1, 3, 6, 4, 1, 2};
        //int array[] = new int[]{1, 2, 3};
        //int array[] = new int[]{-1, -3};
        int array[] = new int[]{-1000000, -1000000};
        System.out.println(solution(array));
    }
}
