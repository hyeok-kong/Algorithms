import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, V, M;
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        int from, to;
        for (int i=0;i<M;i++) {
            from = sc.nextInt();
            to = sc.nextInt();
            list[from].add(to);
            list[to].add(from);
        }

        for (int i=1;i<=N;i++) {
            Collections.sort(list[i]);
        }

        DFS(V);
        System.out.println();
        for (int i=1;i<=N;i++) {
            visited[i] = false;
        }
        BFS(V);
    }

    static void DFS(int v) {
        System.out.print(v + " ");
        visited[v] = true;
        for (int i : list[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    static void BFS(int v) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int node = q.remove();
            System.out.print(node + " ");
            for (int i : list[node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}