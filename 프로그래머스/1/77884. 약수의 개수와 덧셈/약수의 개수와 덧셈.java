class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int number=left;number<=right;number++) {
            int count = getCount(number);
            if(count%2==0) answer += number;
            else answer -= number;
        }
        return answer;
    }
    
    private int getCount(int number) {
        int count = 1;
        for(int i=1;i<number;i++) {
            if(number%i==0) count++;
        }
        return count;
    }
}