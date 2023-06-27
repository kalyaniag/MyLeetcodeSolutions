class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> rst = new ArrayList<>();
        if (k <= 0 || nums1.length == 0 || nums2.length == 0) return rst;

        Queue<List<Integer>> queue = initQueue(k);
        int m = nums1.length, n = nums2.length;
        for (int i = 0; i < m && i <= k; i++) {
            queue.offer(Arrays.asList(nums1[i], nums2[0], 0));
        }
        
        while(!queue.isEmpty() && k-- != 0) {
            List<Integer> node = queue.poll();
            rst.add(Arrays.asList(node.get(0), node.get(1)));
            int tailIndex = node.get(2) + 1;
            if (tailIndex >= n) continue;
            queue.offer(Arrays.asList(node.get(0), nums2[tailIndex], tailIndex));
        }
        
        return rst;
    }
    
    private PriorityQueue<List<Integer>> initQueue(int k) {
        return new PriorityQueue<>(k, new Comparator<List<Integer>>() {
            public int compare(List<Integer> a, List<Integer> b) {
                return a.get(0) + a.get(1) - b.get(0) - b.get(1);
            }
        });
    }
}