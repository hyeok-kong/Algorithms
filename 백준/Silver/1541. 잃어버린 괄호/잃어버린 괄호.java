import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] split = input.split("-");
        int result = sum(split[0]);
        for (int i=1; i<split.length; i++) {
            result -= sum(split[i]);
        }

        System.out.println(result);
    }

    public static int sum(String exp) {
        String[] split = exp.split("[+]");
        int sum = 0;
        for (int i=0;i<split.length;i++) {
            sum += Integer.parseInt(split[i]);
        }
        return sum;
    }
}