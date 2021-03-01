package lessons;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {

    public static int solution(int[] A) {

        int unique = 0;
        Set duplicates = new HashSet();

        for (int i = 0; i < A.length; i++) {
            if (duplicates.add(A[i])) {
                unique = A[i];
            }
        }

        return unique;
    }

    public static void main(String[] args) {
        int array[] = new int[] {9, 3, 9, 3, 9, 7, 9};
        System.out.println(solution(array));
    }
}
