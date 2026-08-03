// 1. 현재 단어 w를 넣는다. -> 있으면 그 뒤의 글자를 본다.
// 2. 다음 단어 w를 넣는다. -> 그 단어가 해당이 안되면 그 단어의 idx 출력하고 w + c 를 Map에 put
// -> 단어가 있으면 위를 반복
import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        int[] answer = {};
        Map<String, Integer> m = new HashMap<>();
        
        // 1번 과정
        for(int i = 0; i < 26; i++){
            String tmp = "" + (char)('A' + i);
            m.put(tmp, i + 1);
        }

        String word = "";
        int idx = 0;
        int cnt = 27;
        
        while(idx < msg.length()){
            String key = word + msg.charAt(idx);
            
            if(m.containsKey(key)){
                word = key;
                if(idx == msg.length() - 1){
                    list.add(m.get(key));
                }
            }else{
                list.add(m.get(word));
                m.put(key, cnt++);
                word = "";
                continue;
            }
            
            idx++;
        }
        
        answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);    
        }
       
        
        return answer;
    }
}