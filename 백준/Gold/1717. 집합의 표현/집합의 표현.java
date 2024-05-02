import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int main;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[N+1];
        for (int i=1;i<=N;i++) {
            arr[i] = i;
        }

        for (int i=0;i<M;i++) {
            int oper = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (oper == 0) {
                union(a, b);
            } else {
                find(a);
                find(b);
                if (arr[a] == arr[b]) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            arr[b] = a;
        }
    }

    private static int find(int a) {
        if (a == arr[a]) return a;
        else return arr[a] = find(arr[a]);
    }
}