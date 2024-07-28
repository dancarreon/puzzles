package codility.lessons;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OddOccurrencesInArray {

    public static int solution(int[] A) {

        Map<Integer, Integer> duplicates = new HashMap<Integer, Integer>();

        for (int j : A) {
            if (duplicates.containsKey(j)) {
                int value = duplicates.get(j);
                duplicates.put(j, ++value);
            } else {
                duplicates.put(j, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : duplicates.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }
        return 0;
    }

    // gives 100% score
    public static int solution2(int[] A) {

        Set<Integer> unpaired = new HashSet<>();

        for (int number : A) {
            if (unpaired.contains(number)) {
                unpaired.remove(number);
            } else {
                unpaired.add(number);
            }
        }

        return unpaired.toArray(new Integer[0])[0];
    }

    public static void main(String[] args) {
        int[] array = new int[]{9, 3, 9, 3, 9, 7, 9};
        System.out.println(solution(array));
        System.out.println(solution2(array));
    }
}
