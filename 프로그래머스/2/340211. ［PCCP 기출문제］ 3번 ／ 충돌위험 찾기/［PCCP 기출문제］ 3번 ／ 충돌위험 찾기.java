import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        List<List<int[]>> list = new ArrayList<>();
        
        for(int i = 0; i < routes.length; i++) list.add(new ArrayList<>());
        
        // 이동 경로 만드는 부분
        for(int i = 0; i < routes.length; i++){
            int from = routes[i][0];
            
            for(int j = 1; j < routes[i].length; j++){
                int to = routes[i][j];
                
                // from -> to로 가는 거리를 list.get(i).add(new int[] {row, col}) 하면 될 듯?
                int fromX = points[from - 1][0];
                int fromY = points[from - 1][1];
                int toX = points[to - 1][0];
                int toY = points[to - 1][1];
                int diffX = Math.abs(fromX - toX);
                int diffY = Math.abs(fromY - toY);
                
                if(j == 1) list.get(i).add(new int[] {fromX, fromY});                
                
                for(int idx = 0; idx < diffX; idx++){
                    if(fromX > toX) fromX -= 1;
                    else fromX += 1;
                    list.get(i).add(new int[] {fromX, fromY});
                }
                
                for(int idx = 0; idx < diffY; idx++){
                    if(fromY > toY) fromY -= 1;
                    else fromY += 1;
                    list.get(i).add(new int[] {fromX, fromY});
                }
                
                from = to;
            }
        }
        
        
        // 이동하는 로직
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i).size());
        }
        
        for(int i = 0; i < max; i++){
            int[][] maze = new int[101][101];
            
            for(int idx = 0; idx < list.size(); idx++){
                if(list.get(idx).size() > i){
                    int row = list.get(idx).get(i)[0];
                    int col = list.get(idx).get(i)[1];
                    maze[row][col]++;                    
                }
            }
            
            for(int r = 0; r < 101; r++){
                for(int c = 0; c < 101; c++){
                    if(maze[r][c] >= 2) answer++;
                }
            }
            
        }
        
        return answer;
    }
}