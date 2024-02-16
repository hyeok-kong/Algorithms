import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            switch (command) {
                case "push" -> q.add(Integer.parseInt(st.nextToken()));
                case "pop" -> {
                    if (q.isEmpty()) sb.append(-1);
                    else sb.append(q.remove());
                }
                case "size" -> sb.append(q.size());
                case "empty" -> sb.append(q.isEmpty()?1:0);
                case "front" -> {
                    if (q.isEmpty()) sb.append(-1);
                    else sb.append(q.peekFirst());
                }
                case "back" -> {
                    if (q.isEmpty()) sb.append(-1);
                    else sb.append(q.peekLast());
                }
            }
            if (!command.equals("push")) sb.append("\n");
        }
        System.out.println(sb);
    }
}