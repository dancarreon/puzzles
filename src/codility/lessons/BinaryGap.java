package codility.lessons;

import java.util.ArrayList;
import java.util.List;

public class BinaryGap {

    public static int solution(int N) {

        int binaryGap = 0;
        List<Integer> counterList = new ArrayList();
        String binary = Integer.toBinaryString(N);

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                if (binaryGap > 0) {
                    counterList.add(binaryGap);
                    binaryGap = 0;
                }
            } else {
                binaryGap++;
            }
        }

        if (counterList.size() > 0) {
            return counterList.stream().mapToInt(Integer::intValue).max().getAsInt();
        } else {
            return 0;
        }
    }

    public static String toBinary(String binary, int number) {
        int quotient = number / 2;
        int remainder = number % 2;
        if (quotient == 0) {
            return String.valueOf(remainder).concat(binary);
        } else {
            return toBinary(String.valueOf(remainder).concat(binary), quotient);
        }
    }

    public static int solution2(int N) {

        String binary = toBinary("", N);
        int gap = 0;
        int zeroCounter = 0;

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                zeroCounter++;
            } else {
                if (zeroCounter > gap) {
                    gap = zeroCounter;
                }
                zeroCounter = 0;
            }
        }
        return gap;
    }

    // gives 100%
    public static int smallestSolution(int N) {

        String binary = Integer.toBinaryString(N);

        String[] splitBinary = binary.split("1");

        int longestGap = 0;
        int index = 0;

        for (String s : splitBinary) {

            int gapLength = s.length();
            int onePosition = index + gapLength + 1;

            if (onePosition < binary.length() && binary.charAt(onePosition) == '1') {
                if (gapLength > longestGap) {
                    longestGap = gapLength;
                }
                index = onePosition;
            }
        }

        return longestGap;
    }

    public static void main(String[] args) {
        System.out.println(solution(1041));
        System.out.println(solution2(1041));
        System.out.println(smallestSolution(1041));
    }
}
