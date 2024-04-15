import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> positives = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negatives = new PriorityQueue<>();
        ArrayList<Integer> numbers = new ArrayList<>();

        int N = sc.nextInt();
        int number;
        for (int i=0;i<N;i++) {
            number = sc.nextInt();
            if (number > 0) {
                positives.add(number);
            } else {
                negatives.add(number);
            }
        }

        while (!positives.isEmpty()) {
            int n = positives.poll();
            if (positives.isEmpty()) {
                numbers.add(n);
                break;
            }
            int m = positives.poll();
            if (n == 1 || m == 1) {
                numbers.add(n);
                positives.add(m);
            } else {
                numbers.add(n * m);
            }
        }

        while (!negatives.isEmpty()) {
            int n = negatives.poll();
            if (negatives.isEmpty()) {
                numbers.add(n);
                break;
            }
            int m = negatives.poll();
            numbers.add(n * m);
        }

        int result = 0;
        for (int num : numbers) {
            result += num;
        }
        System.out.println(result);
    }
}