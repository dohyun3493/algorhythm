// set을 이용해서 할 순 있겠는뎅
// set에 넣는다고 쳐봐 그러면 set의 크기만큼 돌면서 -> pq에 넣으면서 두 개만 answer에 넣으면 되는거 아닌가?
import java.util.*;

class Solution {
    class Node{
        String genre;
        int cnt;
        
        Node(String genre, int cnt){
            this.genre = genre;
            this.cnt = cnt;
        }
    }
    
    class Node2{
        int idx;
        int cnt;
        
        Node2(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
    }
    
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> m = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.cnt, o1.cnt));
        
        for(int i = 0; i < genres.length; i++){
            if(m.containsKey(genres[i])){
                m.replace(genres[i], m.get(genres[i]) + plays[i]);
            }else{
                m.put(genres[i], plays[i]);
            }
        }
        
        for(String key : m.keySet()){
            pq.offer(new Node(key, m.get(key)));
        }
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            String genre = cur.genre;
            PriorityQueue<Node2> pq2 = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.cnt, o1.cnt));
            
            for(int i = 0; i < genres.length; i++){
                if(genres[i].equals(genre)){
                    pq2.offer(new Node2(i, plays[i]));
                }
            }
            
            if(pq2.size() < 2){
                answer.add(pq2.poll().idx);
            }else{
                answer.add(pq2.poll().idx);
                answer.add(pq2.poll().idx);
            }
        }
        
        return answer;
    }
}