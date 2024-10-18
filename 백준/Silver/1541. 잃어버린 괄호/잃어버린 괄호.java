import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();

        String[] majorExp = exp.split("-");

        int result = sum(majorExp[0]);
        for (int i=1;i<majorExp.length;i++) {
            result -= sum(majorExp[i]);
        }

        System.out.println(result);
    }

    private static int sum(String exp) {
        int result = 0;
        String[] split = exp.split("\\+");

        for (String s : split) {
            result += Integer.parseInt(s);
        }
        return result;
    }
}