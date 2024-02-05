import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int times = Integer.parseInt(br.readLine().split(" ")[1]);
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int length = numbers.length;

        int[] sumArray = new int[length+1];
        sumArray[0] = 0;
        sumArray[1] = numbers[0];
        for (int i=1;i<length;i++) {
            sumArray[i+1] = sumArray[i] + numbers[i];
        }

        for (int i=0;i<times;i++) {
            int[] fromto = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            System.out.println(sumArray[fromto[1]] - sumArray[fromto[0]-1]);
        }
    }
}