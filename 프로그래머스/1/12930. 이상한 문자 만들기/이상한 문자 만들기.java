class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        s += " z";
        String[] carr = s.split(" ");

        for (int i=0;i< carr.length-1;i++) {
            String arr = carr[i];
            if (arr.isEmpty()) {
                sb.append(" ");
                continue;
            }
            arr = arr.toLowerCase();
            char[] charArray = arr.toCharArray();
            for (int j=0;j<charArray.length;j++) {
                char temp = j%2==0 ? (char) (charArray[j] - 32) : charArray[j];
                sb.append(temp);
            }
            sb.append(" ");
        }
        answer = sb.toString();
        if (answer.endsWith(" ")) {
            answer = answer.substring(0, answer.length()-1);
        }
        return answer;
    }
}