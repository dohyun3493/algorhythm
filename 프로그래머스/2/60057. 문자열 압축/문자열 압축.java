import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        
        if(s.length() == 1) return 1;
        
        for(int size = 1; size < s.length(); size++){
            List<String> ans = new ArrayList<>();
            int idx = 0;
            String prev = "";
            int cnt = 1;
            
            while(idx < s.length() - size + 1){
                int start = idx;
                int end = (idx + size) - 1;
                String word = "";

                for(int i = start; i <= end; i++){
                    word += s.charAt(i);     
                }

                if(prev.equals(word)){
                    cnt++;
                }else{
                    if(cnt == 1) ans.add(prev);
                    else ans.add(Integer.toString(cnt) + prev);
                    cnt = 1;
                }
                
                prev = word;
                idx = end + 1;

                if(idx >= s.length() - size + 1){
                    if(cnt == 1) ans.add(prev);
                    else ans.add(Integer.toString(cnt) + prev);

                    for(int j = idx; j < s.length(); j++) ans.add("" + s.charAt(j));
                }
            }
            
            String tmp = "";
            for(int i = 0; i < ans.size(); i++){
                tmp += ans.get(i);
            }
            min = Math.min(min, tmp.length());
        }
        
        answer = min;
        
        return answer;
    }
}