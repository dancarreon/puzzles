package lessons;

public class FrogJmp {

    public static int counter = 0;

    public static int solution(int X, int Y, int D) {
        if (X < Y) {
            counter++;
        } else {
            return counter;
        }
        return solution(X + D, Y, D);
    }

    public static int solution100(int X, int Y, int D) {
        return (int) Math.ceil((double)(Y - X) / D);
    }

    public static void main(String[] args) {
        //System.out.println(solution(3, 999111321, 7));
        System.out.println(solution100(3, 999111321, 7));
    }
}
