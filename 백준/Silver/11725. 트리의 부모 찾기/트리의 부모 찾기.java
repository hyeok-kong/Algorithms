import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] answer;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        tree = new ArrayList[N+1];
        answer = new int[N+1];
        visited = new boolean[N+1];
        for (int i=1;i<=N;i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i=1;i<N;i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            tree[n1].add(n2);
            tree[n2].add(n1);
        }

        DFS(1);
        for (int i=2;i<=N;i++) {
            System.out.println(answer[i]);
        }
    }

    static void DFS(int n) {
        visited[n] = true;
        for (Integer i : tree[n]) {
            if (!visited[i]) {
                answer[i] = n;
                DFS(i);
            }
        }
    }
}