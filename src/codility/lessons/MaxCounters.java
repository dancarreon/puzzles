package codility.lessons;

import java.util.Arrays;

public class MaxCounters {

    public static int[] solution(int N, int[] A) {

        int[] counters = new int[N];

        int maxValue = 0;
        int maxCounter = 0;

        for (int i = 0; i < A.length; i++) {

            int operation = A[i];

            if ((operation >= 1) && (operation  <= N)) {

                int position = A[i] - 1;
                int value = counters[position];

                if (value >= maxCounter) {
                    counters[position] = value + 1;
                } else {
                    counters[position] = maxCounter + 1;
                }

                if (counters[position] > maxValue) {
                    maxValue = counters[position];
                }
            } else if (operation == (N + 1)) {
                maxCounter = maxValue;
            }
        }

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < maxCounter) {
                counters[i] = maxCounter;
            }
        }

        return counters;
    }

    public static void main(String[] args) {
        int[] array = //{1, 11, 1, 12, 1, 13, 1, 14, 1, 15, 1, 16, 1, 17, 1, 18, 1, 19, 1, 20};
                {3, 4, 4, 6, 1, 4, 4};
        //{2, 1, 1, 2, 1};
        System.out.println(Arrays.toString(solution(5, array)));
    }
}
