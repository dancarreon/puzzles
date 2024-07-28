package codility.lessons;

public class MinAvgTwoSlice {

    // 90%
    public static int solution(int[] A) {

        double minAverageOfTwo = Integer.MAX_VALUE;
        int minIndexOfTwo = -1;

        double minAverageOfThree = Integer.MAX_VALUE;
        int minIndexOfThree = -1;

        for (int i = 0; i < A.length - 1; i++) {

            double averageOfTwo = ((double) A[i] + A[i + 1]) / 2;

            if (averageOfTwo < minAverageOfTwo) {
                minAverageOfTwo = averageOfTwo;
                minIndexOfTwo = i;
            }

            if (i + 2 < A.length) {

                double averageOfThree = ((double) A[i] + A[i + 1] + A[i + 2]) / 3;

                if (averageOfThree < minAverageOfThree) {
                    minAverageOfThree = averageOfThree;
                    minIndexOfThree = i;
                }
            }
        }

        if (minAverageOfTwo < minAverageOfThree) {
            return minIndexOfTwo;
        }

        if (minAverageOfThree < minAverageOfTwo) {
            return minIndexOfThree;
        }

        if (minIndexOfTwo < minIndexOfThree) {
            return minIndexOfThree;
        }

        return minIndexOfThree;
    }

    // 100%
    public static int solution2(int[] A) {

        int minSumOfTwo = Integer.MAX_VALUE;
        int minIndexOfTwo = -1;

        int minSumOfThree = Integer.MAX_VALUE;
        int minIndexOfThree = -1;

        for (int i = 0; i < A.length - 1; i++) {

            int num1 = A[i];
            int num2 = A[i + 1];
            int sumOfTwo = num1 + num2;

            if (sumOfTwo < minSumOfTwo) {
                minSumOfTwo = sumOfTwo;
                minIndexOfTwo = i;
            }

            if (i < A.length - 2) {

                int num3 = A[i + 2];
                int sumOfThree = num1 + num2 + num3;

                if (sumOfThree < minSumOfThree) {
                    minSumOfThree = sumOfThree;
                    minIndexOfThree = i;
                }
            }
        }

        if (minIndexOfThree == -1) {
            return minIndexOfTwo;
        }

        double averageOfTwo = (double) minSumOfTwo / 2;
        double averageOfThree = (double) minSumOfThree / 3;

        if (averageOfTwo < averageOfThree) {
            return minIndexOfTwo;
        }

        if (averageOfThree < averageOfTwo) {
            return minIndexOfThree;
        }

        return Math.min(minIndexOfTwo, minIndexOfThree);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 2, 2, 5, 1, 5, 8}));
        System.out.println(solution(new int[]{5, 2, 5, 2, 5, 5, 8}));
        System.out.println(solution(new int[]{10, 11, -20, 5}));

        System.out.println(solution2(new int[]{4, 2, 2, 5, 1, 5, 8}));
        System.out.println(solution2(new int[]{5, 2, 5, 2, 5, 5, 8}));
        System.out.println(solution2(new int[]{10, 11, -20, 5}));
    }
}
