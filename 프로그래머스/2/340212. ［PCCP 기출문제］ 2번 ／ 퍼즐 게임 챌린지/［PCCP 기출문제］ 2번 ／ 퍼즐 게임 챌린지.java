// n은 300000 이하
// 최솟값이여서 완탐으로 할 경우 bfs로 진행해야됨.
// 난이도 <= 숙련도 -> time_cur만큼
// 난이도 > 숙련도 -> (난이도 - 숙련도) * (현재 + 이전) + 현재
// (diffs[i] - answer) * (times[i] + times[i - 1]) + times[i] 
// diffs[0] 가 1인 이유가 있을까? -> times[i - 1]이 없기 때문
// 이분탐색으로 하면 될 거 같은데? -> diff로 이분탐색하는듯

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int left = 1;
        int right = 0;
        
        for(int i = 0; i < diffs.length; i++) {
            right = Math.max(right, diffs[i]);
        }
        
        int mid = 0; 
        int check = 2;
        int min = Integer.MAX_VALUE;
        
        while(left <= right){
            long cnt = 0;
            mid = (left + right) / 2;
            
            for(int i = 0; i < diffs.length; i++){
                if(diffs[i] <= mid){
                    cnt += times[i];
                }else{
                    cnt += (diffs[i] - mid) * (times[i] + times[i - 1]) + times[i];
                }
            }
            
            if(cnt <= limit){
                min = Math.min(min, mid);
                right = mid - 1;
            }else{
                left = mid + 1;
            }
            
        }
        
        answer = min;
        
        return answer;
    }
}