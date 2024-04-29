import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int X = sc.nextInt();

        graph = new ArrayList[N+1];
        distance = new int[N+1];

        for (int i=1;i<N+1;i++) {
            graph[i] = new ArrayList<>();
            distance[i] = -1;
        }
        for (int i=0;i<M;i++) {
            graph[sc.nextInt()].add(sc.nextInt());
        }

        BFS(X);

        boolean isK = false;
        for (int i=1;i<N+1;i++) {
            if (distance[i]==K) {
                System.out.println(i);
                isK = true;
            }
        }
        if (!isK) {
            System.out.println(-1);
        }
    }

    private static void BFS(int x) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(x);
        distance[x]++;
        int now;
        while (!q.isEmpty()) {
            now = q.poll();
            for (int i : graph[now]) {
                if (distance[i] == -1) {
                    distance[i] = distance[now]+1;
                    q.add(i);
                }
            }
        }
    }
}