import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] carr = s.toCharArray();
        Arrays.sort(carr);
        for (int i=carr.length-1;i>=0;i--) {
            answer += carr[i];
        }
        return answer;
    }
}