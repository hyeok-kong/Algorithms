import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new ArrayDeque<>();
        int N = sc.nextInt();
        for (int i=1;i<=N;i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            q.remove();
            q.add(q.remove());
        }

        System.out.println(q.remove());
    }
}