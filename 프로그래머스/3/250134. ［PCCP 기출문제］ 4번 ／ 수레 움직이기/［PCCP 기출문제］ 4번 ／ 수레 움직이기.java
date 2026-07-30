import java.util.*;

class Solution {
    boolean[][] Rvisited;
    boolean[][] Bvisited;
    int n, m;
    int[] startR = new int[2];
    int[] startB = new int[2];
    int[] endR = new int[2];
    int[] endB = new int[2];
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int min = Integer.MAX_VALUE;
    
    void dfs(int rowR, int colR, int rowB, int colB, int cnt, int[][] maze){
        if(cnt >= min) return;

        boolean isRArrived = (rowR == endR[0] && colR == endR[1]);
        boolean isBArrived = (rowB == endB[0] && colB == endB[1]);

        if(isRArrived && isBArrived){
            min = Math.min(min, cnt);
            return;
        } 
        
        List<int[]> nextR = new ArrayList<>();
        if(isRArrived) {
            nextR.add(new int[]{rowR, colR}); 
        } else {
            for(int i = 0; i < 4; i++){
                int nr = rowR + dir[i][0];
                int nc = colR + dir[i][1];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && maze[nr][nc] != 5 && !Rvisited[nr][nc]){
                    nextR.add(new int[]{nr, nc});
                }
            }
        }

        List<int[]> nextB = new ArrayList<>();
        if(isBArrived) {
            nextB.add(new int[]{rowB, colB});
        } else {
            for(int j = 0; j < 4; j++){
                int nr = rowB + dir[j][0];
                int nc = colB + dir[j][1];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && maze[nr][nc] != 5 && !Bvisited[nr][nc]){
                    nextB.add(new int[]{nr, nc});
                }
            }
        }

        for(int[] nr : nextR){
            for(int[] nb : nextB){
                if(nr[0] == nb[0] && nr[1] == nb[1]) continue;

                if(nr[0] == rowB && nr[1] == colB && nb[0] == rowR && nb[1] == colR) continue;

                Rvisited[nr[0]][nr[1]] = true;
                Bvisited[nb[0]][nb[1]] = true;

                dfs(nr[0], nr[1], nb[0], nb[1], cnt + 1, maze);
                
                //백트래킹
                if(!isRArrived) Rvisited[nr[0]][nr[1]] = false;
                if(!isBArrived) Bvisited[nb[0]][nb[1]] = false;
            }
        }
    }
    
    public int solution(int[][] maze) {
        min = Integer.MAX_VALUE; // 테스트 케이스별 min 값 초기화
        
        n = maze.length;
        m = maze[0].length;
        
        Rvisited = new boolean[n][m];
        Bvisited = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maze[i][j] == 1){
                    startR[0] = i; startR[1] = j;
                } else if(maze[i][j] == 2){
                    startB[0] = i; startB[1] = j;
                } else if(maze[i][j] == 3){
                    endR[0] = i; endR[1] = j;
                } else if(maze[i][j] == 4){
                    endB[0] = i; endB[1] = j;
                }
            }
        }

        Rvisited[startR[0]][startR[1]] = true;
        Bvisited[startB[0]][startB[1]] = true;
        
        dfs(startR[0], startR[1], startB[0], startB[1], 0, maze);
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}