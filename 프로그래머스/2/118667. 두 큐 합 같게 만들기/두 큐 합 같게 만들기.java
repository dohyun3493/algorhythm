import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        boolean flag = true;
        
        // 1. long 타입으로 변경하여 오버플로우 방지
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i = 0; i < queue1.length; i++){
            sum1 += queue1[i];
            sum2 += queue2[i];
            list1.add(queue1[i]);
            list2.add(queue2[i]);
        }
        
        int point1 = 0;
        int point2 = 0;
        
        // 두 큐의 원소가 완전히 교환될 수 있는 최대 횟수는 length * 4
        int maxOp = queue1.length * 4;
        
        while(flag){
            if(sum1 == sum2) break;
            
            // 2. 최대 수행 횟수를 length * 4로 변경
            if(answer > maxOp){
                answer = -1;
                break;
            }
            
            if(sum1 > sum2){
                if(point1 >= list1.size()){
                    answer = -1;
                    break;
                }
                list2.add(list1.get(point1));
                sum2 += list1.get(point1);
                sum1 -= list1.get(point1);
                point1++;
                answer++;
            }
            else if(sum1 < sum2){
                if(point2 >= list2.size()){
                    answer = -1;
                    break;
                }
                list1.add(list2.get(point2));
                sum2 -= list2.get(point2);
                sum1 += list2.get(point2);
                point2++;
                answer++;
            }
        }
        
        return answer;
    }
}