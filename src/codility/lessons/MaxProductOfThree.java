package codility.lessons;

import java.util.Arrays;

public class MaxProductOfThree {

    // 44%
    public static int solution(int[] A) {
        Arrays.sort(A);
        return (A[A.length - 1] * A[A.length - 2] * A[A.length - 3]);
    }

    // 44%
    public static int solution2(int[] A) {

        Arrays.sort(A);
        //System.out.println(Arrays.toString(A));
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < A.length - 1; i += 3) {

            int num1 = A[i], num2 = A[i + 1], num3 = A[i + 2];

            if (num1 < 0 && num2 < 0 && A[A.length - 1] > 0) {
                maxProduct = num1 * num2 * A[A.length - 1];
            } else {
                int product = num1 * num2 * num3;
                if (product > maxProduct) {
                    maxProduct = product;
                }
            }
        }

        return maxProduct;
    }

    // 100%
    public static int solution3(int[] A) {
        Arrays.sort(A);
        int product = (A[A.length - 1] * A[A.length - 2] * A[A.length - 3]);

        if (A[0] < 0 && A[1] < 0) {
            int newProduct = A[0] * A[1] * A[A.length - 1];
            if (newProduct > product) {
                product = newProduct;
            }
        }

        return product;
    }

    public static void main(String[] args) {
        //System.out.println(solution(new int[]{-3, 1, 2, -2, 5, 6})); //60
        System.out.println(solution3(new int[]{-3, 1, 2, -2, 5, 6})); //60
        System.out.println(solution3(new int[]{10, 10, 10})); //1000
        System.out.println(solution3(new int[]{-5, 5, -5, 4})); //125
        System.out.println(solution3(new int[]{4, 5, 1, 0})); //20
    }
}
