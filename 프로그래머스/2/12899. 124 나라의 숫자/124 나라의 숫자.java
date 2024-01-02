class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>0) {
            n--;
            sb.append(getNumber(n));
            n /= 3;
        }
        return sb.reverse().toString();
    }
    
    private int getNumber(int n) {
        int number = 0;
        switch(n%3) {
            case 0:
                number = 1;
                break;
            case 1:
                number = 2;
                break;
            case 2:
                number = 4;
                break;
        }
        return number;
    }
}