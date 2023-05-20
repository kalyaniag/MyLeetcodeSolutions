class Solution {
  class Node {
    public String parent;
    public double ratio;
    public Node(String parent, double ratio) {
      this.parent = parent;
      this.ratio = ratio;
    }
  }
  
  class UnionFindSet {
    private Map<String, Node> parents = new HashMap<>();
    
    public Node find(String s) {
      if (!parents.containsKey(s)) return null;
      Node n = parents.get(s);
      if (!n.parent.equals(s)) {
        Node p = find(n.parent);
        n.parent = p.parent;
        n.ratio *= p.ratio;
      }
      return n;
    }
    
    public void union(String A, String B, double ratio) {
      boolean hasA = parents.containsKey(A);
      boolean hasB = parents.containsKey(B);
      if (!hasA && !hasB) {
        parents.put(A, new Node(B, ratio));
        parents.put(B, new Node(B, 1.0));
      } else if (!hasA) {
        parents.put(A, new Node(B, ratio));
      } else if (!hasB) {
        parents.put(B, new Node(A, 1.0 / ratio));      
      } else {
        Node rA = find(A);
        Node rB = find(B);
        parents.put(rA.parent, 
          new Node(rB.parent, ratio / rA.ratio * rB.ratio));        
      }
    }
  }
  
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries)  {
    UnionFindSet u = new UnionFindSet();
    
    for (int i = 0; i < equations.size(); ++i)
      u.union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
    
    double[] ans = new double[queries.size()];
    
    for (int i = 0; i < queries.size(); ++i) {      
      Node rx = u.find(queries.get(i).get(0));
      Node ry = u.find(queries.get(i).get(1));
      if (rx == null || ry == null || !rx.parent.equals(ry.parent))
        ans[i] = -1.0;
      else
        ans[i] = rx.ratio / ry.ratio;
    }
    return ans;
  }
}