class Solution {
    int answer = 0;
    
    void dfs(int cnt, int n, int sum, int[] numbers, int target){
        if(cnt == n){
            if(sum == target) answer++;
            
            return;
        }
        
        // + 기호
        dfs(cnt + 1, n, sum + numbers[cnt], numbers, target);
        // - 기호
        dfs(cnt + 1, n, sum - numbers[cnt], numbers, target);
    }
    
    public int solution(int[] numbers, int target) {
        dfs(0, numbers.length, 0, numbers, target);
        
        return answer;
    }
}