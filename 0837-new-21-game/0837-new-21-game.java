class Solution {
    public double new21Game(int N, int K, int W) {
        double[] dp = new double[N + W + 1];
        for (int i = K; i <= N; i++)
            dp[i] = 1.0;
        double sum = Math.min(N - K + 1, W);
        for (int i = K - 1; i >= 0; i--) {
            dp[i] = sum / W;
            sum -= dp[i + W] - dp[i];
        }
        return dp[0];
    }
}
