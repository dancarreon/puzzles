package codility.lessons;

public class PassingCars {

    // 100% score
    public static int solution(int[] A) {

        int zeroCounter = 0;
        int totalInteractions = 0;

        for (int num : A) {
            if (totalInteractions > 1000000000) {
                return -1;
            }
            if (num == 0) {
                zeroCounter++;
            }
            if (num == 1) {
                if (zeroCounter > 0) {
                    totalInteractions += zeroCounter;
                }
            }
        }

        return totalInteractions;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 0, 1, 1};
        System.out.println(solution(array));
    }
}
