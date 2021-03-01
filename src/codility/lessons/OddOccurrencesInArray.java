package codility.lessons;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {

    public static int solution(int[] A) {

        Map<Integer, Integer> duplicates = new HashMap<Integer, Integer>();

        for (int i = 0; i < A.length; i++) {
            if (duplicates.containsKey(A[i])) {
                int value = duplicates.get(A[i]);
                duplicates.put(A[i], ++value);
            } else {
                duplicates.put(A[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry:  duplicates.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int array[] = new int[] {9, 3, 9, 3, 9, 7, 9};
        System.out.println(solution(array));
    }
}
