import java.util.*;

class Solution {
    int[] direction = {0, 1, 2, 3};
    
    int bfs(int sr, int sc, int er, int ec, String[] board, boolean[][] visited){
        int rowSize = board.length;
        int colSize = board[0].length();
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(sr, sc, 0));
        visited[sr][sc] = true;
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            int r = cur.row;
            int c = cur.col;
            int d = cur.depth;
            
            if(r == er && c == ec) return d;
            
            for(int i = 0; i < 4; i++){
                //여기서 이동하는 로직하나 더 짜야될 듯.. 귀찮아
                int[] result = simulation(r, c, i, board);
                int nr = result[0];
                int nc = result[1];
                
                if(nr < 0 || nc < 0 || nr >= rowSize || nc >= colSize) continue;
                if(visited[nr][nc] == true) continue;
                
                q.offer(new Node(nr, nc, d + 1));
                visited[nr][nc] = true;
            }
        }
        
        return -1;
    }
    
    int[] simulation(int row, int col, int dir, String[] board){
        int[] result = new int[2];
        
        if(dir == 0){
            result[0] = 0;
            result[1] = col;
            for(int i = row; i >= 0; i--){
                if(board[i].charAt(col) == 'D'){
                    result[0] = i + 1;
                    break;
                }
            }
        }else if(dir == 1){
            result[0] = row;
            result[1] = board[0].length() - 1;
            for(int i = col; i < board[0].length(); i++){
                if(board[row].charAt(i) == 'D'){
                    result[1] = i - 1;
                    break;
                }
            }
        }else if(dir == 2){
            result[0] = board.length - 1;
            result[1] = col;
            for(int i = row ; i < board.length; i++){
                if(board[i].charAt(col) == 'D'){
                    result[0] = i - 1;     
                    break;
                }
            }
        }else{
            result[0] = row;
            result[1] = 0;
            for(int i = col; i >= 0; i--){
                if(board[row].charAt(i) == 'D'){
                    result[1] = i + 1;
                    break;
                }
            }
        }
        
        return result;
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
    
    public int solution(String[] board) {
        int answer = 0;
        int[][] arr = new int[2][2];
        boolean[][] visited = new boolean[board.length][board[0].length()];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length(); j++){
                if(board[i].charAt(j) == 'R'){
                    arr[0][0] = i;
                    arr[0][1] = j;
                }
                if(board[i].charAt(j) == 'G'){
                    arr[1][0] = i;    
                    arr[1][1] = j;
                }
                
            }
        }
        
        answer = bfs(arr[0][0], arr[0][1], arr[1][0], arr[1][1], board, visited);
        
        return answer;
    }
}