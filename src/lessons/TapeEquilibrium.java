package lessons;

public class TapeEquilibrium {

    public static int solution2(int[] A) {

        int N = A.length;
        int min = Integer.MAX_VALUE;
        int totalSum = 0;

        for (int i = 0; i < N; i++) {
            totalSum += A[i];
        }

        for (int P = 0; P < N - 1; P++) {

            long part1 = 0;

            if (P < (P + 1)) {
                part1 += A[P];
            }

            long diff = Math.abs(part1 - (totalSum - part1));

            if (diff < min) {
                min = (int) diff;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        //int array[] = new int[] {3, 1, 2, 4, 3};
        int array[] = new int[] {-1000, 1000};
        System.out.println(solution2(array));
    }
}
