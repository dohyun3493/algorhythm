import java.util.*;

// U R D L 순서대로 dir 배열 생성
// arr[11][11][4]로 3차원 배열 생성
// (0, 0) -> (5, 5)

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[][] dir = {{-1, 0}, {0, 1},{1, 0}, {0, -1}};
        boolean[][][] visited = new boolean[11][11][4]; 
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[] {5, 5});
    
        for(int i = 0; i < dirs.length(); i++){
            int[] cur = q.poll();
            int r = cur[0];
            int c=  cur[1];
            int nr = r;
            int nc = c;
            int a = -1;
            int a_r = -1;
            
            if(dirs.charAt(i) == 'U'){
                nr += dir[0][0];
                nc += dir[0][1];
                a = 0;
                a_r = 2;
            }
            if(dirs.charAt(i) == 'R'){
                nr += dir[1][0];
                nc += dir[1][1];
                a = 1;
                a_r = 3;
            }
            if(dirs.charAt(i) == 'D'){
                nr += dir[2][0];
                nc += dir[2][1];
                a = 2;
                a_r = 0;
            }
            if(dirs.charAt(i) == 'L'){
                nr += dir[3][0];
                nc += dir[3][1];
                a = 3;
                a_r = 1;
            }
            if(nr < 0 || nc < 0 || nr >= 11 || nc >= 11){
                q.offer(new int[] {r, c});
                continue;
            }
            if(!visited[nr][nc][a] && !visited[r][c][a_r]) answer++;
            
            q.offer(new int[] {nr, nc});
            visited[nr][nc][a] = true;
            visited[r][c][a_r] = true;
        }
        
        return answer;
    }
}