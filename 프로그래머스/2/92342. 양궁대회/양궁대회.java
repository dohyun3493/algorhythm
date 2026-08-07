import java.util.*;

class Solution {
    int[] answer;
    List<Integer> list = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    
    void dfs(int target, int cnt, int idx, int[] info){
        if(target == cnt){
            int[] arr = new int[11];
            int peach = 0;
            int lion = 0;
            int diff = 0;
            
            for(int i = 0; i < list.size(); i++){
                arr[list.get(i)]++;
            }
            
            for(int i = 0; i < 11; i++){
                if (info[i] == 0 && arr[i] == 0) continue;
                if (arr[i] > info[i]) {
                    lion += 10 - i;
                } else {
                    peach += 10 - i;
                }
            }
            
            diff = lion - peach;
            
            if(diff > max){
                max = diff;
                
                for(int i = 0; i < 11; i++){
                    answer[i] = arr[i];
                }
            }
            
            if (diff == max && diff > 0) {
                if (isBetter(arr, answer)) {
                    for (int i = 0; i < 11; i++) {
                        answer[i] = arr[i];
                    }
                }
            }
            
            return;
        }
        
        for(int i = idx; i <= 10; i++){
            list.add(i);
            dfs(target, cnt + 1, i, info);
            list.remove(list.size() - 1);
        }    
    }
    
    boolean isBetter(int[] newArr, int[] currentAnswer) {
        for (int i = 10; i >= 0; i--) {
            if (newArr[i] != currentAnswer[i]) {
                if (newArr[i] > currentAnswer[i]) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    
    public int[] solution(int n, int[] info) {
        answer = new int[11];
        
        dfs(n, 0, 0, info);
        
        if (max <= 0) {
            return new int[]{-1};
        }
        
        return answer;
    }
}