class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        int max = -1;
        
        // 1. times에서 최댓값 구하기.
        for(int i = 0; i  < times.length; i++){
            if(max < times[i]){
                max = times[i];
            }
        }
        
        long lowTime = 1;
        long maxTime = (long)n * max;
        
        while(lowTime <= maxTime){
            long cnt = 0;
            long mid = (lowTime + maxTime) / 2;
            
            for(int i = 0; i < times.length; i++){
                cnt += mid / times[i];
            }
            
            // case 1) n보다 큰 경우 -> 시간을 줄여야 됨.
            if(cnt >= n){
                answer = mid;
                maxTime = mid - 1;
            }
            
            // case 2) n보다 작은 경우 -> 시간을 늘려야 됨.
            if(cnt < n){
                lowTime = mid + 1;
            }
            
        }
        
        return answer;

    }
}