import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack stack = new Stack();
        
        for(int i=0;i<s.length();i++) {
            char chr = s.charAt(i);
            if (chr == '(') stack.add('(');
            else {
                if (stack.size() == 0) {
                    answer = false;
                    break;
                }
                if ((char)stack.pop() != '(') {
                    answer = false;
                    break;
                }
            }
        }
        if (stack.size() != 0) answer = false;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.

        return answer;
    }
}