import java.util.*;

class Solution {
    String findHead(String file){
        String word = "";
        
        for(int i = 0; i < file.length(); i++){
            if(file.charAt(i) >= '0' && file.charAt(i) <= '9') break;                
            word += file.charAt(i);
        }

        return word;
    }
    
    int findNum(String file){
        String word = "";
        
        for(int i = 0; i < file.length(); i++){
            if(!word.equals("")){
                if(!(file.charAt(i) >= '0' && file.charAt(i) <= '9')) break;
            }
            if(file.charAt(i) >= '0' && file.charAt(i) <= '9') word += file.charAt(i); 
        }
        
        return Integer.parseInt(word);
    }
    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        // 정렬
        Arrays.sort(files, (o1, o2) -> {
            // 1. head 기준으로 정렬
            String head1 = findHead(o1).toLowerCase();
            String head2 = findHead(o2).toLowerCase();
            
            if(!head1.equals(head2)){
                return head1.compareTo(head2);
            }
            
            // 2. number 기준으로 정렬
            int num1 = findNum(o1);
            int num2 = findNum(o2);
            
            return Integer.compare(num1, num2);
        });
        
        for(int i = 0; i < answer.length; i++) answer[i] = files[i];
        
        return answer;
    }
}