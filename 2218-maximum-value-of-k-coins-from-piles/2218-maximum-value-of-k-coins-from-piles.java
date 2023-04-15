class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        /***
        dp[i][j] represents that the maximmum total that using first i piles and j coins
        dp[i][j] = max(dp[i-1][j], dp[i-1][j-m]+sum(m))
        ***/
        int n = piles.size();
        int[][] dp = new int[n+1][k+1];
        // induction rule:
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                int sum = 0;
                dp[i][j] = dp[i-1][j];
                int picked = 1;
                for(int v: piles.get(i-1)) {
                    if(j-picked < 0) {
                        break;
                    }
                    sum += v;
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-picked]+sum);
                    picked++;
                }
            }
        }
        return dp[n][k];
        
    }
}
