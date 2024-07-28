package codility.lessons;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GenomicRangeQuery {

    // 62%
    public static int[] solution(String S, int[] P, int[] Q) {

        int[] result = new int[P.length];

        for (int i = 0; i < P.length; i++) {
            int start = P[i];
            int end = Q[i] + 1;
            char[] DNACopy = Arrays.copyOfRange(S.toCharArray(), start, end);
            Arrays.sort(DNACopy);
            result[i] = DNACopy[0];
        }

        for (int i = 0; i < result.length; i++) {
            switch (result[i]) {
                case 'A': result[i] = 1; break;
                case 'C': result[i] = 2; break;
                case 'G': result[i] = 3; break;
                case 'T': result[i] = 4; break;
            }
        }

        return result;
    }

    // 75%
    public static int[] solution2(String S, int[] P, int[] Q) {

        int[] result = new int[P.length];

        for (int i = 0; i < P.length; i++) {
            int start = P[i];
            int end = Q[i] + 1;

            String slice = S.substring(start, end);

            if (slice.contains("A")) {
                result[i] = 1;
            } else if (slice.contains("C")) {
                result[i] = 2;
            } else if (slice.contains("G")) {
                result[i] = 3;
            }  else if (slice.contains("T")) {
                result[i] = 4;
            }
        }

        return result;
    }

    // 62%
    public static int[] solution3(String S, int[] P, int[] Q) {

        int[] result = new int[P.length];

        for (int i = 0; i < P.length; i++) {
            int start = P[i];
            int end = Q[i] + 1;

            Set<Character> set = new HashSet<>();

            for (char c : S.substring(start, end).toCharArray()) {
                set.add(c);
            }

            if (set.contains('A')) {
                result[i] = 1;
            } else if (set.contains('C')) {
                result[i] = 2;
            } else if (set.contains('G')) {
                result[i] = 3;
            }  else if (set.contains('T')) {
                result[i] = 4;
            }
        }

        return result;
    }

    // 75%
    public static int[] solution4(String S, int[] P, int[] Q) {

        int[] result = new int[P.length];

        for (int i = 0; i < P.length; i++) {

            int start = P[i];
            int end = Q[i] + 1;
            String subSequence = S.substring(start, end);

            if (subSequence.indexOf('A') > -1) {
                result[i] = 1;
            } else if (subSequence.indexOf('C') > -1) {
                result[i] = 2;
            } else if (subSequence.indexOf('G') > -1) {
                result[i] = 3;
            } else if (subSequence.indexOf('T') > -1) {
                result[i] = 4;
            }
        }

        return result;
    }

    // 62%
    public static int[] solution5(String S, int[] P, int[] Q) {

        int[][] seenMatrix = new int[S.length()][4];
        int[] result = new int[P.length];

        for (int i = 0; i < S.length(); i++) {
            if (i > 0) {
                seenMatrix[i] = Arrays.copyOf(seenMatrix[i - 1], 4);
            }
            switch (S.charAt(i)) {
                case 'A': seenMatrix[i][0] += 1; break;
                case 'C': seenMatrix[i][1] += 1; break;
                case 'G': seenMatrix[i][2] += 1; break;
                case 'T': seenMatrix[i][3] += 1; break;
            }
        }

        //System.out.println(Arrays.deepToString(seenMatrix));

        for (int i = 0; i < P.length; i++) {

            int start = P[i];
            int end = Q[i];
            int r = 4;

            for (int j = 0; j < 3; j++) {
                if (seenMatrix[start][j] != seenMatrix[end][j]) {
                    r = j + 1;
                    break;
                }
            }
            result[i] = r;
        }

        return result;
    }

    // 100%
    public static int[] solution6(String S, int[] P, int[] Q) {

        int[][] counters = new int[S.length() + 1][4];
        int a = 0;
        int c = 0;
        int g = 0;
        int t = 0;

        for (int i = 0; i < S.length(); i++) {
            switch (S.charAt(i)) {
                case 'A': a++; break;
                case 'C': c++; break;
                case 'G': g++; break;
                case 'T': t++; break;
            }
            counters[i + 1][0] = a;
            counters[i + 1][1] = c;
            counters[i + 1][2] = g;
            counters[i + 1][3] = t;
        }

        //System.out.println(Arrays.deepToString(counters));
        int[] result = new int[P.length];

        for (int i = 0; i < P.length; i++) {

            int start = P[i];
            int end = Q[i] + 1;

            for (int j = 0; j < 4; j++) {
                if (counters[start][j] != counters[end][j]) {
                    result[i] = j + 1;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})));
        //System.out.println(Arrays.toString(solution2("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})));
        //System.out.println(Arrays.toString(solution3("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})));
        System.out.println(Arrays.toString(solution4("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})));
        System.out.println(Arrays.toString(solution5("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})));
        System.out.println(Arrays.toString(solution6("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})));
    }
}
