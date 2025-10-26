class Solution {

    static long count = 0;

    public long solution(int n, long l, long r) {
        dfs(n, l, r, (long) Math.pow(5, n));
        
        return count;
    }

    static void dfs(int n, long l, long r, long blockSize) {
        if (n == 0) {
            count += 1;
            return;
        }

        long sub = blockSize / 5;

        for (int i = 0; i < 5; i++) {
            long start = i * sub + 1;
            long end = (i + 1) * sub;

            if (end < l || r < start) {
                continue;
            }
            if (i == 2) {
                continue;
            }

            if (l <= start && end <= r) {
                count += pow4(n - 1);
            } else {
                long ll = Math.max(l, start) - start + 1;
                long rr = Math.min(r, end) - start + 1;
                dfs(n - 1, ll, rr, sub); 
            }
        }
    }

    static long pow4(int n) {
        long cnt = 1;
        
        while (n-- > 0) {
            cnt *= 4;
        }
        
        return cnt;
    }
}