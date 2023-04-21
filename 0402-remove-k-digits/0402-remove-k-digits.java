class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num.length() - k);
        for(char c: num.toCharArray()) 
        {
            while(sb.length()>0 && k>0 && sb.charAt(sb.length()-1)>c) 
            {
                sb.setLength(sb.length()-1);
                k--;
            }
            if(!(sb.length()==0 && c=='0'))sb.append(c);
        }
        if(k>0) sb.setLength(sb.length()-Math.min(k,sb.length())); 
        return sb.length()==0?"0":sb.toString();
    }
}
