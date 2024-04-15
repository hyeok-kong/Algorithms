import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = sc.nextInt();
        for (int i=0;i<N;i++) {
            pq.add(sc.nextInt());
        }

        int sum = 0, result = 0;
        while (pq.size() != 1) {
            int n = pq.poll();
            int m = pq.poll();
            pq.add(n + m);
            result += n + m;

        }

        System.out.println(result);
    }
}