import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static LinkedList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        graph = new LinkedList[N + 1];
        for (int i=0;i<=N;i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i=1;i<=M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        
        for (int i=1;i<=N;i++) {
            Collections.sort(graph[i]);
        }

        DFS(V);

        visited = new boolean[N+1];
        System.out.println();

        BFS(V);
    }

    private static void DFS(int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for (Integer i : graph[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    private static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");

            for (Integer i : graph[now]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}