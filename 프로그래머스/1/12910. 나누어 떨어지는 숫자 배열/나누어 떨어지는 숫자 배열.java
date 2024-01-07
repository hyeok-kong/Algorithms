import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        for(int num:arr) {
            if(num%divisor == 0) {
                answer.add(num);
            }
        }
        if (answer.size() == 0) {
            int[] ret = {-1};
            return ret;
        }
        int[] ret = new int[answer.size()];
        for (int i=0;i<answer.size();i++) {
            ret[i] = answer.get(i);
        }
        Arrays.sort(ret);
        return ret;
    }
}