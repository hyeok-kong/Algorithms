import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static char[] A;
    static char[] B;
    static long[][] AB;
    static ArrayList<Character> word;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.next().toCharArray();
        B = sc.next().toCharArray();
        AB = new long[A.length+1][B.length+1];

        word = new ArrayList<>();

        for (int i=1;i<=A.length;i++) {
            for (int j=1;j<=B.length;j++) {
                if (A[i-1] == B[j-1]) {
                    AB[i][j] = AB[i-1][j-1] + 1;
                } else {
                    AB[i][j] = Math.max(AB[i-1][j], AB[i][j-1]);
                }
            }
        }

        System.out.println(AB[A.length][B.length]);
        read(A.length, B.length);
        for (int i=word.size();i>0;i--) {
            System.out.print(word.get(i-1));
        }
    }

    private static void read(int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }
        if (A[i-1] == B[j-1]) {
            word.add(A[i-1]);
            read(i-1, j-1);
        } else {
            if (AB[i-1][j] > AB[i][j-1]) {
                read(i-1, j);
            } else {
                read(i, j-1);
            }
        }
    }
}