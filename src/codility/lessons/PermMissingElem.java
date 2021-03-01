package codility.lessons;

public class PermMissingElem {

    public static int solution(int[] A) {

        long N = A.length + 1;
        long total = (N * (N + 1)) / 2;
        long sum = 0L;

        for (int i : A) {
            sum += i;
        }

        return (int)(total - sum);
    }

    public static void main(String[] args) {
        int array[] = new int[] {2, 3, 1, 5};
        System.out.println(solution(array));
    }
}
