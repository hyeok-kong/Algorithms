import java.util.*;

public class Main {
    static int[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new int[N];
        for (int i=0;i<N;i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        int M = sc.nextInt();
        for (int i=0;i<M;i++) {
            System.out.println(search(sc.nextInt()));
        }
    }

    private static int search(int num) {
        int start, end, mid;
        start = 0;
        end = A.length - 1;

        while (start <= end) {
            mid = (start + end) / 2;
            if (A[mid] == num) {
                return 1;
            } else if(A[mid] < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }
}