import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int count;
    static int remove;
    static int root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        tree = new ArrayList[N];
        visited = new boolean[N];
        for (int i=0; i<N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i=0; i<N; i++) {
            int p = sc.nextInt();
            if (p == -1) {
                root = i;
            } else {
                tree[i].add(p);
                tree[p].add(i);
            }
        }
        remove = sc.nextInt();
        if (remove == root) {
            System.out.println(0);
        } else {
            DFS(root);
            System.out.println(count);
        }

    }

    private static void DFS(int n) {
        visited[n] = true;
        int c = 0;
        for (Integer i : tree[n]) {
            if (!visited[i] && i != remove) {
                c++;
                DFS(i);
            }
        }
        if (c == 0) {
            count++;
        }
    }
}