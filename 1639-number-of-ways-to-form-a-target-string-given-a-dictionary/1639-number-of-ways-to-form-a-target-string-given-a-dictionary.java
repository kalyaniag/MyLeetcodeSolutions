class Solution {
    public int numWays(String[] words, String target) {
        final int MOD = (int)1e9 + 7;
        int lw = words[0].length(), lt = target.length();
        long[] dpa = new long[lw];
        long[][] n26 = new long[lw][26];
        for (String w : words) {
            for (int i = 0; i < lw; ++i) {
                ++n26[i][w.charAt(i) - 'a'];
            }
        }
        // System.out.println(Arrays.deepToString(n26));
        int c = target.charAt(0) - 'a';
        for (int j = 0; j <= lw - lt; ++j) {
            dpa[j] = n26[j][c];
            if (j > 0) dpa[j] += dpa[j - 1];
        }
        // System.out.println(Arrays.toString(dpa));
        for (int i = 1; i < lt; ++i) {
            c = target.charAt(i) - 'a';
            for (int j = lw - (lt - i); j >= i; --j) {
                dpa[j] = dpa[j - 1] * n26[j][c];
                dpa[j] %= MOD;
            }
            for (int j = i + 1; j <= lw - (lt - i); ++j) {
                dpa[j] += dpa[j - 1];
                dpa[j] %= MOD;
            }
        // System.out.println(Arrays.toString(dpa));
        }
        return (int)dpa[lw - 1];
    }
}
