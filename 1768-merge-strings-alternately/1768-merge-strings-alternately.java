class Solution {
    public String mergeAlternately(String word1, String word2) {
    
    int i = 1, j = 0, m = word1.length(), n = word2.length();
    
    char[] result = new char[m+n];
    
    result[0] = word1.charAt(0);
    
    while( i < m && j < n ){
        if( j < i ){
            result[i+j] = word2.charAt(j++); 
        }else{
            result[i+j] = word1.charAt(i++);                 
        }
    }
    
    while( i < m ) result[i+j] = word1.charAt(i++);
    while( j < n ) result[i+j] = word2.charAt(j++);
    
    return new String(result);
    
}
}