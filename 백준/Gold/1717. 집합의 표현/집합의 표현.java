import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[N+1];
        for (int i=0;i<=N;i++) {
            arr[i] = i;
        }

        for (int i=0;i<M;i++) {
            int query = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (query == 0) {
                union(a, b);
            } else {
                if (isSame(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x != y) {
            arr[y] = x;
        }
    }

    private static int find(int a) {
        if (a == arr[a]) {
            return a;
        } else {
            return arr[a] = find(arr[a]);
        }
    }

    private static boolean isSame(int a, int b) {
        return find(a) == find(b);
    }
}