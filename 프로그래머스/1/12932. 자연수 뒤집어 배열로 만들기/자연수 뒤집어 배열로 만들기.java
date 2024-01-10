import java.util.ArrayList;
class Solution {
    public int[] solution(long n) {
        ArrayList<Integer> list = new ArrayList<>();
        while(n>=1) {
            list.add((int)(n%10));
            n /= 10;
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            answer[i] = (int)list.get(i);
        }
        return answer;
    }
}