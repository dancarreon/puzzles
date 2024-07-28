package codility.lessons;

public class CountDiv {

    // gives 100%
    public static int solution2(int A, int B, int K) {
        return (B / K) - (A / K) + (A % K == 0 ? 1 : 0);
    }

    public static void main(String[] args) {
        // A = 6, B = 11, K = 2 => expects 3
        // A = 11, B = 345, K = 17 => expects 20
        // A = B in {0,1}, K = 11 => expects 1
        // A = 10, B = 10, K in {5,7,20} => expects 1
        // A = 100, B=123M+, K=2
        // A = 0, B = MAXINT, K in {1,MAXINT}
        System.out.println(solution2(6, 11, 2));
        System.out.println(solution2(11, 345, 17));
    }
}
