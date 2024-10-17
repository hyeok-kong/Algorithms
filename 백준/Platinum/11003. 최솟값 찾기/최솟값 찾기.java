import java.io.*;
import java.util.*;

public class Main {

    static class Num {
        int index;
        int number;

        public Num(int index, int number) {
            this.index = index;
            this.number = number;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Num[] numArr = new Num[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            numArr[i] = new Num(i, Integer.parseInt(st.nextToken()));
        }

        Deque<Num> deque = new ArrayDeque<>();
        for (int i=0;i<N;i++) {
            while (!deque.isEmpty() && numArr[i].number < deque.getLast().number) {
                deque.removeLast();
            }

            deque.addLast(numArr[i]);
            if (i - deque.getFirst().index >= L) {
                deque.removeFirst();
            }

            bw.write(deque.getFirst().number + " ");
        }

        bw.flush();
        bw.close();
    }
}