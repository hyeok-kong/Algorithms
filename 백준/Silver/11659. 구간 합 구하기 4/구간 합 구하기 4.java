import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int dataCount = Integer.parseInt(st.nextToken());
        int queryCount = Integer.parseInt(st.nextToken());
        long[] sumArr = new long[dataCount+1];

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<dataCount;i++) {
            sumArr[i+1] = sumArr[i] + Integer.parseInt(st.nextToken());
        }

        for (int i=0;i<queryCount;i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            System.out.println(sumArr[to] - sumArr[from-1]);
        }

    }
}
