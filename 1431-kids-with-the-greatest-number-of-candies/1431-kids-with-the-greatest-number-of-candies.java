class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) 
    {
        List<Boolean> values= new ArrayList<>();
        int max=candies[0];
        int n=candies.length;

        for(int i=1;i<n;i++)
        {
            if(candies[i]>max)
            {
                max=candies[i];
            }
        }
        for(int i=0;i<n;i++)
        {
            values.add(candies[i]+ extraCandies>=max);
        }

        return values;
    }
}