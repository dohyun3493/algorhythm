// 완탐으로 하면 시간 터짐.
// 자릿수대로 정렬하면 됨. -> 같으면 밑에 자리수 비교 
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];

        
        for(int i = 0; i < numbers.length; i++){
            arr[i] = Integer.toString(numbers[i]);
        } 
        
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        for(int i = 0; i < arr.length; i++){
            answer += arr[i];
        }
        
        if (arr[0].equals("0")) {
            return "0";
        }
        
        return answer;
    }
}