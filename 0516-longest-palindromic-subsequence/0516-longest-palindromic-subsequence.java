class Solution {
    public int longestPalindromeSubseq(String s) {

    int n = s.length();
    
    int[][] dp = new int[n+1][n+1];
    for( int i = 0; i < dp.length; i++ ) Arrays.fill(dp[i], -1);
    return find( n, n, s, new StringBuilder(s).reverse().toString(), dp );
    
}

private int find( int i, int j, String s1, String s2, int[][] dp ){
    
    if( i == 0  || j == 0 ) return 0;
    
    if( dp[i][j] != -1 ) return dp[i][j];
    
    if( s1.charAt(i-1) == s2.charAt(j-1) ){
        return dp[i][j] = 1 + find(i-1, j-1, s1, s2, dp);
    } else{
        return dp[i][j] = 0 + Math.max( find(i-1, j, s1, s2, dp), find(i, j-1, s1, s2, dp) );
    }
    
}
}