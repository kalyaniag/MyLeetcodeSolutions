class Solution {
public String predictPartyVictory(String senate) {
    	  //R and D can be thought of as two objects, each of which has its own attributes that are ban and ban others.
    	  
    	  int banR=0;
    	  int banD=0;
    	  char[] newsen=new char[senate.length()];
    	  for(int i=0;i<senate.length();i++) {
    		  newsen[i]=senate.charAt(i);
    	  }
    	  while(true) {
    		  for(int i=0;i<senate.length();i++) {
    			  if(newsen[i]=='R') {
    				  if(banR==0) {
    					  banD++;
    				  }else {
    					  banR--;
    					  newsen[i]='X';
    				  }
    			  }else if(newsen[i]=='D') {
    				  if(banD==0) {
    					  banR++;
    				  }else {
    					  banD--;
					  newsen[i]='X';
    				  }
    			  }
    		  }
              boolean existD=false,existR=false;
              for(int i=0;i<newsen.length;i++){
                  if(newsen[i]=='R'){
                      existR=true;
                  }if(newsen[i]=='D'){
                      existD=true;
                  }
              }
              if(existD==false){
                  return "Radiant";
              }if(existR==false){
                  return "Dire";
              }
    	  }
      }
}
