class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] sums = new int[sequence.length+1];

        for (int i=1;i<sequence.length+1;i++) {
            sums[i] = sums[i-1] + sequence[i-1];
        }

        int front = 0;
        int rear = 0;
        int f = 0;
        int r = 0;
        while (r <= sequence.length) {
            if (front > rear) {
                break;
            }
            int now = sums[r] - sums[f];
            if (now == k) {
                if (rear - front == 0 || rear - front > r - f) {
                    front = f;
                    rear = r;
                }
                r++;
            } else if (now < k) {
                r++;
            } else {
                f++;
            }
        }

        return new int[]{front, rear-1};
    }
}