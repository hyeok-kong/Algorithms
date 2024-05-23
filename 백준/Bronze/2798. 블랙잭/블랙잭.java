import java.util.Scanner;

public class Main {
    static boolean[] visited;
    static int answer;
    static int min = Integer.MAX_VALUE;
    static int N;
    static int M;
    static int[] cards;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        cards = new int[N];

        for (int i=0;i<N;i++) {
            cards[i] = sc.nextInt();
        }

        for (int i=0;i<N;i++) {
            for (int j=i+1;j<N;j++) {
                for (int k=j+1;k<N;k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum > M) continue;
                    if (Math.abs(sum - M) < min) {
                        min = Math.abs(sum - M);
                        answer = sum;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
