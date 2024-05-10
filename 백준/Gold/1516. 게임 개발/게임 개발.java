import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static int[] time;
    static int[] enter;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        graph = new ArrayList[N+1];
        time = new int[N+1];
        enter = new int[N+1];

        for (int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=1;i<=N;i++) {
            time[i] = sc.nextInt();
            while (true) {
                int n = sc.nextInt();
                if (n == -1) break;
                graph[n].add(i);
                enter[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=1;i<=N;i++) {
            if (enter[i] == 0) q.add(i);
        }

        int[] result = new int[N+1];
        while (!q.isEmpty()) {
            int n = q.poll();
            for (Integer i : graph[n]) {
                enter[i]--;
                result[i] = Math.max(result[i], result[n] + time[n]);
                if (enter[i] == 0) q.add(i);
            }
        }

        for (int i=1;i<=N;i++) {
            System.out.println(result[i] + time[i]);
        }
    }
}