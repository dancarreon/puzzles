package toptaltest;

import java.util.LinkedList;
import java.util.List;

// Bob the Adventurer glass pointer
public class Q1 {

    public static class Point2D {
        public int x = 0;
        public int y = 0;
    }

    public static int solution(Point2D[] A) {

        int length = A.length;
        int laserCount = 1;

        List xValues = new LinkedList();
        List yValues = new LinkedList();

        for (int i = 0; i < length; i++) {
            xValues.add(A[i].x);
            yValues.add(A[i].y);
        }

        for (int i = 0; i < length; i++) {
            laserCount++;

            int y = (2) * A[i].x + A[i].y;

            //System.out.println(y);

            if (xValues.contains(A[i].x) && yValues.contains(y)) {
                laserCount--;
            }
        }

        return laserCount;
    }

    public static void main(String[] args) {
        Point2D A[] = new Point2D[5];

        for (int i = 0; i < A.length; i++) {
            A[i] = new Point2D();
        }

        A[0].x = -1; A[0].y = -2; //(statue 0)
        A[1].x =  1; A[1].y =  2; //(statue 1)
        A[2].x =  2; A[2].y =  4; //(statue 2)
        A[3].x = -3; A[3].y =  2; //(statue 3)
        A[4].x =  2; A[4].y = -2; //(statue 4)

        System.out.println(solution(A));
    }
}
