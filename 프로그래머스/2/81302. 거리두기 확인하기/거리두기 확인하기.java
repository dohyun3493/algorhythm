import java.util.*;

class Solution {
    List<int[]> list = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    int simulation(String[] arr){
        for(int i = 0; i < list.size(); i++){
            // j가 목표 위치이긴 해
            for(int j = i + 1; j < list.size(); j++){
                // bfs 돌리면 되나? 목표치가 결국 
                int targetRow = list.get(j)[0];
                int targetCol = list.get(j)[1];
                Queue<Node> q = new ArrayDeque<>();
                boolean[][] visited = new boolean[5][5];
                q.offer(new Node(list.get(i)[0], list.get(i)[1], 0));
                visited[list.get(i)[0]][list.get(i)[1]] = true;
                
                while(!q.isEmpty()){
                    Node cur = q.poll();
                    int row = cur.row;
                    int col = cur.col;
                    int depth = cur.depth;
                    
                    if(row == targetRow && col == targetCol){
                        if(depth <= 2){
                            return 0;
                        }
                    }
                    
                    for(int idx = 0; idx < 4; idx++){
                        int nr = row + dir[idx][0];
                        int nc = col + dir[idx][1];
                        
                        if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5) continue;
                        if(arr[row].charAt(col) == 'X') continue;
                        if(visited[nr][nc]) continue;
                        
                        q.offer(new Node(nr, nc, depth + 1));
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        
       return 1; 
    }
    
    class Node{
        int row;
        int col;
        int depth;
        
        Node(int row, int col, int depth){
            this.row = row;
            this.col = col;
            this.depth = depth;
        }
    }
    
    public int[] solution(String[][] places) {
        int[] answer = {};
        
        for(int i = 0; i < places.length; i++){
            for(int row = 0; row < places[i].length; row++){
                for(int col = 0; col < places[i][row].length(); col++){
                    if(places[i][row].charAt(col) == 'P') list.add(new int[] {row, col});
                }
               
            }
            ans.add(simulation(places[i]));
            list.clear();
        }
        
        answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}