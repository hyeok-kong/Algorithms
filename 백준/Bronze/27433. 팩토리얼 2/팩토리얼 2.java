import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        long answer = factorial(N);
        System.out.println(answer);
    }

    private static long factorial(long n) {
        if (n <= 1) return 1L;
        else return n * factorial(n-1);
    }
}
