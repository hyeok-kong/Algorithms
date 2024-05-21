import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] array = new int[2][N+1];
        int[] D = new int[21];
        for (int i=1;i<=N;i++) {
            array[0][i] = sc.nextInt();
            array[1][i] = sc.nextInt();
        }

        for (int i=N;i>=1;i--) {
            if (i + array[0][i] > N+1) {
                D[i] = D[i+1];
            } else {
                D[i] = Math.max(D[i+1], D[i + array[0][i]] + array[1][i]);
            }
        }
        System.out.println(D[1]);
    }
}