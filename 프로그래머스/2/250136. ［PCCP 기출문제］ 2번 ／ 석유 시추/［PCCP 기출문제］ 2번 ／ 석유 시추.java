// 전형적인 bfs or dfs 문제임.
// 해도 시간 ㄱㅊ나?
import java.util.*;

class Solution {
    boolean[][] visited;
    int[] max;
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};    
    
    void bfs(int row, int col, int[][] land){
        int cnt = 1;
        Queue<int[]> q = new ArrayDeque<>();
        Set<Integer> s = new HashSet<>();
        q.offer(new int[] {row, col});
        s.add(col);
        visited[row][col] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            for(int i = 0; i < 4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                
                if(nr < 0 || nc < 0 || nr >= land.length || nc >= land[0].length) continue;
                if(visited[nr][nc]) continue;
                if(land[nr][nc] == 0) continue;
                
                cnt++;
                q.offer(new int[] {nr, nc});
                s.add(nc);
                visited[nr][nc] = true;
            }
        }
        
        for(Integer idx : s){
            max[idx] += cnt;
        
        }
        
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        visited = new boolean[land.length][land[0].length];
        max = new int[land[0].length];
        
        for(int r = 0; r < land.length; r++){
            for(int c = 0; c < land[0].length; c++){
                if(land[r][c] == 1 && !visited[r][c]) bfs(r, c, land);
            }
        }

        for(int i = 0; i < max.length; i++){
            answer = Math.max(answer, max[i]);
        }
        
        return answer;
    }
}