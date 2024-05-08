import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[] enter;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        graph = new ArrayList[N+1];
        enter = new int[N+1];
        for (int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i=0;i<M;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            enter[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=1;i<=N;i++) {
            if (enter[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int n = q.poll();
            System.out.print(n + " ");
            for (Integer i : graph[n]) {
                enter[i]--;
                if (enter[i] == 0) q.add(i);
            }
        }
    }
}