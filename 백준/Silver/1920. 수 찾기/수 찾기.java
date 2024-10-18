import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        int queryCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<queryCount;i++) {
            System.out.println(search(Integer.parseInt(st.nextToken())));
        }
    }

    private static int search(int n) {
        int start = 0; int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == n) {
                return 1;
            } else if (arr[mid] > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 0;
    }
}