class Solution {
    boolean[] visited;
    boolean[] arr;
    int answer;
    
    void dfs(int cnt, String sum, int target, String numbers){
        if(cnt == target){
            System.out.println(sum);
            if(simulation(Integer.parseInt(sum))) answer++;
            
            return;
        }
        
        for(int i = 0; i < numbers.length(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(cnt + 1, sum + numbers.charAt(i) ,target, numbers);
            visited[i] = false;
        }
    }
    
    boolean simulation(int num){
        if(num == 0 || num == 1) return false;
        if(arr[num]) return false;
        
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0) {
                arr[num] = true;
                return false;
            }
        }
         
        arr[num] = true;
        
        return true;
    }
    
    public int solution(String numbers){
        answer = 0;
        visited = new boolean[numbers.length()];
        arr = new boolean[10000000];
        
        for(int i = 1; i <= numbers.length(); i++){
            dfs(0, "", i, numbers);
        }
        
        return answer;
    }
}