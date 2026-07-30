// 1. 최대체력을 넘기면 안됨.
// 2. 연속된 체력을 기록해야 됨.
// 3. 공격을 받으면 연속이 취소됨.
// 4. 공격을 받아 0이하가 되면 바로 -1를 return

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int maxTime = attacks[attacks.length - 1][0];
        int cnt = health;
        int time = 1;
        int idx = 0;
        
        for(int t = 1; t <= maxTime; t++){
            // 공격을 하는 시간
            if(t == attacks[idx][0]){
                cnt -= attacks[idx][1];
                if(cnt <= 0) return -1;
                idx++;
                time = 1;
                continue;
            }
            
            // 회복하는 시간
            cnt += bandage[1];
            if(time == bandage[0]){
                cnt += bandage[2];
                
                time = 0;
            }
            if(cnt > health) cnt = health;
            
            time++;
        }   
        
        answer = cnt;
        
        return answer;
    }
}