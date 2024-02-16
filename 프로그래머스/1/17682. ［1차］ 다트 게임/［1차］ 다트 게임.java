

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        String[] darts = dartResult.split("");
        int[] scores = new int[3];
        int scoreIdx = 0;
        for (int i=0;i<darts.length;i+=2) {
            int score;
            if (darts[i+1].equals("S") || darts[i+1].equals("D") || darts[i+1].equals("T")) {
                score = Integer.parseInt(darts[i]);
            } else {
                score = Integer.parseInt(darts[i] + darts[i+1]);
                i++;
            }
            switch (darts[i+1]) {
                case "D" -> {
                    score = (int) Math.pow(score, 2);
                }
                case "T" -> {
                    score = (int) Math.pow(score, 3);
                }
            }
            scores[scoreIdx] = score;
            
            if (i+2 > darts.length-1) break;
            
            if (darts[i+2].equals("*") || darts[i+2].equals("#")) {
                int optionIdx = scoreIdx==0?0:scoreIdx-1;
                if (darts[i+2].equals("*")) {
                    scores[optionIdx] *= 2;
                    if (scoreIdx > 0) {
                        scores[scoreIdx] *= 2;
                    }
                } else {
                    scores[scoreIdx] *= -1;
                }
                i++;
            }
            scoreIdx++;
        }
        
        for (int score : scores) {
            answer += score;
        }
        return answer;
    }
}