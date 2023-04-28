public final class Solution {
    public final int numSimilarGroups(final String[] A) {
        if (A.length < 2) {
            return A.length;
        }

        int groups = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == null) {
                continue;
            }

            String s = A[i];
            A[i] = null;
            groups++;
            depthFirstSearch(A, s);

        }

        return groups;
    }

    private static final void depthFirstSearch(final String[] A, final String s) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == null) {
                continue;
            }

            if (areSimilar(s, A[i])) {
                final String temp = A[i];
                A[i] = null;
                depthFirstSearch(A, temp);
            }
        }
    }

    private static final boolean areSimilar(final String a, final String b) {
        int n = 0;
        int i = 0;

        while (n <= 2 && i < a.length()) {
            if (a.charAt(i) != b.charAt(i)) {
                n++;
            }

            i++;
        }

        return n == 2 || n == 0;

    }
}
