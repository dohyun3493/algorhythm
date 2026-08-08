import java.util.*;

class Solution{
    public int solution(int []A, int []B){
        int answer = 0;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        
        for(int i = 0; i < A.length; i++){
            pq1.offer(A[i]);
            pq2.offer(B[i]);
        }
        
        while(!pq1.isEmpty()) answer += pq1.poll() * pq2.poll();
        
        return answer;
    }
}