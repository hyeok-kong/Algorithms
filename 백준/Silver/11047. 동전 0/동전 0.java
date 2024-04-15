import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        for (int i=0;i<N;i++) {
            A[i] = sc.nextInt();
        }

        int sum = 0, count = 0;
        for (int i=N-1;i>=0;i--) {
            if (M == 0) break;
            if (A[i] > M) continue;
            int c = (M / A[i]);
            count += c;
            M -= c * A[i];
        }

        System.out.println(count);
    }
}