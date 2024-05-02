import java.util.*;

public class Main {
    static int[] arr;
    static int[][] path;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] route = new int[M];
        path = new int[N+1][N+1];
        arr = new int[N+1];
        for (int i=1;i<=N;i++) {
            arr[i] = i;
            for (int j=1;j<=N;j++) {
                path[i][j] = sc.nextInt();
            }
        }
        for (int i=0;i<M;i++) {
            route[i] = sc.nextInt();
        }

        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) {
                if (path[i][j] == 1) {
                    union(arr[i], arr[j]);
                }
            }
        }

        int root = find(route[0]);
        for (int i=1;i<M;i++) {
            if (find(route[i]) != root) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static void union(int a, int b) {
        find(a);
        find(b);
        if (arr[a] != arr[b]) {
            arr[b] = a;
        }
    }

    private static int find(int x) {
        if (x == arr[x]) return x;
        else return arr[x] = find(arr[x]);
    }
}