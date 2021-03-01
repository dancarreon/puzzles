package toptaltest;

// Board with 2 rows and N Columns
public class Q2 {

    public static String solution(int U, int L, int[] C) {

        int length = C.length;
        long uArray[] = new long[length];
        long lArray[] = new long[length];

        long uCounter = U;
        long lCounter = L;

        boolean toggleUse = true;

        for (int i = 0; i < length; i++) {
            if (C[i] == 2) {
                if (uCounter > 0) {
                    uArray[i] = 1;
                    uCounter--;
                }
                if (lCounter > 0) {
                    lArray[i] = 1;
                    lCounter--;
                }
            } else if (C[i] == 1) {
                if (toggleUse) {
                    if (uCounter > 0) {
                        uArray[i] = 1;
                        uCounter--;
                    }
                    toggleUse = false;
                } else {
                    if (lCounter > 0) {
                        lArray[i] = 1;
                        lCounter--;
                    }
                    toggleUse = true;
                }
            } else if (C[i] == 1) {
                uArray[i] = 0;
                lArray[i] = 0;
            }
        }

        String solution = "";

        for (int i = 0; i < uArray.length; i++) {
            solution += uArray[i];
        }

        solution = solution.concat(",");

        for (int i = 0; i < lArray.length; i++) {
            solution += lArray[i];
        }

        if (uCounter == 0 && lCounter == 0) {
            return solution;
        } else {
            return "IMPOSSIBLE";
        }
    }

    public static void main(String[] args) {

        /*
        int U = 3;
        int L = 2;
        int C[] = new int[] {2, 1, 1, 0, 1};
        */
        /*
        int U = 2;
        int L = 3;
        int C[] = new int[] {0, 0, 1, 1, 2};
        */
        int U = 2;
        int L = 2;
        int C[] = new int[] {2, 0, 2, 0};

        System.out.println(solution(U, L, C));
    }
}
