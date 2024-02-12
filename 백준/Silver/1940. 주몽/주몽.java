import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(nums);
        
        int start = 0, end = nums.length-1;
        int sum = 0, count = 0;
        while (start < end) {
            sum = nums[start] + nums[end];
            if (sum < M) start++;
            else if (sum > M) end--;
            else if (sum == M) {
                start++;
                end--;
                count++;
            }
        }
        System.out.println(count);
    }
}