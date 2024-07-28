package codility.lessons;

import java.util.Arrays;

public class PermMissingElem {

    public static int solution(int[] A) {

        long N = A.length + 1;
        long total = (N * (N + 1)) / 2;
        long sum = 0L;

        for (int i : A) {
            sum += i;
        }

        return (int) (total - sum);
    }

    // scores 100
    public static int solution2(int[] A) {

        Arrays.sort(A);

        int missingInt = 1;

        for (int i : A) {
            if (i != missingInt) {
                return missingInt;
            } else {
                missingInt++;
            }
        }

        return missingInt;
    }

    public static void main(String[] args) {
        int array[] = new int[]{2, 3, 1, 5};
        System.out.println(solution(array));
        System.out.println(solution2(array));
    }
}
