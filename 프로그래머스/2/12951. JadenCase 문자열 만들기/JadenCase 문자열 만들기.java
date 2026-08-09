import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] word = s.split(" ", -1); 
        
        for (int i = 0; i < word.length; i++) {
            if (word[i].length() == 0) {
                answer.append("");
            } else {
                char[] arr = word[i].toCharArray();
                
                if (arr[0] >= 'a' && arr[0] <= 'z') {
                    arr[0] = (char)(arr[0] - 32);
                }
                
                for (int idx = 1; idx < arr.length; idx++) {
                    if (arr[idx] >= 'A' && arr[idx] <= 'Z') {
                        arr[idx] = (char)(arr[idx] + 32);
                    }
                }
                
                answer.append(new String(arr));
            }
            
            if (i != word.length - 1) {
                answer.append(" ");
            }
        }
        
        return answer.toString();
    }
}