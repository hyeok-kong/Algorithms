import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] table = new int[N+1];
        long[] sumTable = new long[N+1];
        long[] remain = new long[M];

        st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++) {
            table[i] = Integer.parseInt(st.nextToken());
            sumTable[i] = sumTable[i-1] + table[i];
        }

        long count = 0;
        for (int i=1;i<=N;i++) {
            int mod = (int)(sumTable[i] % M);
            if (mod == 0) count++;
            remain[mod]++;
        }

        for (int i=0;i<M;i++) {
            if (remain[i] > 1) count += remain[i] * (remain[i]-1) / 2;
        }

        System.out.println(count);
    }
}
