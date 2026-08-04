import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        int ans = 1;
        List<Integer> arr = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < progresses.length; i++){
            progresses[i] = 100 - progresses[i];
        }
        
        for(int i = 0; i < speeds.length; i++){
            if(progresses[i] % speeds[i] == 0){
                progresses[i] /= speeds[i];
            }else{
                progresses[i] = (progresses[i] / speeds[i]) + 1;
            }
        }
        
        for(int i = 1; i < progresses.length; i++){
            q.offer(progresses[i]); 
        } 
        
        int tmp = progresses[0];
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            if(tmp < cur){
                arr.add(ans);
                ans = 1;
                tmp = cur;
            }else{
                ans++;
            }
        }
        
        arr.add(ans);
        
        answer = new int[arr.size()];
        
        for(int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}