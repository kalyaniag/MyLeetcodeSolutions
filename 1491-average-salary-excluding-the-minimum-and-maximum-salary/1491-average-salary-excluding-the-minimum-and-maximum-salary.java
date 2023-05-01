class Solution {
    public double average(int[] salary) {
        Arrays.sort(salary);
        int n= salary.length;
        double ans=0;
        
        for(int i=1;i<n-1;i++){
            ans += salary[i];
            
        }
        return ans/(n-2);
    }
}