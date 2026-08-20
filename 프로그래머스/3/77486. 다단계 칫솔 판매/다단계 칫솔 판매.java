// 수익금 나눈거 알아야 됨.

import java.util.*;

class Solution {
    int[] answer;
    Map<String, String> p = new HashMap<>();
    Map<String, Integer> idx = new HashMap<>();
    
    
    void simulation(String cur, String parent, int cost){
        int value = cost / 10;
        answer[idx.get(cur)] += (cost - value);
        
        
        if(parent.equals("-") || value == 0) return;
        
        simulation(parent, p.get(parent), value);
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];
        
        for(int i = 0; i < enroll.length; i++){
            p.put(enroll[i], referral[i]);
            idx.put(enroll[i], i);
        }
        
        for (int i = 0; i < seller.length; i++) {
            simulation(seller[i], p.get(seller[i]), amount[i] * 100);
        }

        return answer;
    }
}