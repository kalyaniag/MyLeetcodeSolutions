class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length; 
        Boolean[] states = new Boolean[n];

        for (int i = 0; i < n; i++) { // some nodes has 0 edge, so try all 
            if (states[i] != null) continue; // skip visited starting node
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.offer(i);
            states[i] = true;
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int next : graph[curr]) {
                    if (states[next] != null) {
                        if (states[next] == states[curr]) return false;
                        continue;
                    }
                    states[next] = !states[curr];
                    queue.offer(next);
                }
            }
        }
        return true;
    }
}