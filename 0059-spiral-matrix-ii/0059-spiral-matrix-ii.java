class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr=new int[n][n];
        int i=0,j=0,k=0,l=0,half=n/2,count=1;
        while(count!=(n*n+1))
        {
            if(k==0 && l==0)
            {
                while(j<n && arr[i][j]==0)
                {
                    arr[i][j]=count++;
                    j++;
                }
                i++;
                j--;
                k=1;
            }
            else if(k==1 && l==0)
            {
                while(i<n && arr[i][j]==0)
                {
                    arr[i][j]=count++;
                    i++;
                }
                j--;
                i--;
                l=1;
            }
            else if(k==1 && l==1)
            {
                while(j>=0 && arr[i][j]==0)
                {
                   arr[i][j]=count++;
                    j--; 
                }
                i--;
                j++;
                k=0;
            }
            else //if(k==0 && l==1)
            {
                while(i>=0 && arr[i][j]==0)
                {
                   arr[i][j]=count++;
                    i--; 
                }
                j++;
                i++;
                l=0;
            }
        }
        return arr;
    }
}