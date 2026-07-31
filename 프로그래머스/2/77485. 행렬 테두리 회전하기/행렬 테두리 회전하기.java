import java.util.*;

class Solution {
    int[][] maze;
    int min = Integer.MAX_VALUE;
    List<Integer> ans = new ArrayList<>();
    
    // 회전시키는 로직 
    void rotate(int[] arr){
        int prev1 = maze[arr[0]][arr[3]];
        int prev2 = maze[arr[2]][arr[3]];
        int prev3 = maze[arr[2]][arr[1]];
        
        // -> 방향 col이 이동
        for(int col = arr[3]; col > arr[1]; col--){
            maze[arr[0]][col] = maze[arr[0]][col - 1];
        }
        
        // 밑 방향
        for(int row = arr[2]; row > arr[0]; row--){
            maze[row][arr[3]] = maze[row - 1][arr[3]];
        }
        
        // <- 방향
        for(int col = arr[1]; col < arr[3]; col++){
            maze[arr[2]][col] = maze[arr[2]][col + 1];
        }
        
        // 윗 방향
        for(int row = arr[0]; row < arr[2]; row++){
            maze[row][arr[1]] = maze[row + 1][arr[1]];
        }
        
        maze[arr[0] + 1][arr[3]] = prev1;
        maze[arr[2]][arr[3] - 1] = prev2;
        maze[arr[2] - 1][arr[1]] = prev3;
    }
    
    // 최솟값 구하기
    void simulation(int[] arr){
        for(int col = arr[1]; col <= arr[3]; col++){
            min = Math.min(min, maze[arr[0]][col]);
        }
        for(int row = arr[0]; row <= arr[2]; row++){
            min = Math.min(min, maze[row][arr[3]]);
        }
        for(int col = arr[3]; col >= arr[1]; col--){
            min = Math.min(min, maze[arr[2]][col]);
        }
        for(int row = arr[2]; row >= arr[0]; row--){
            min = Math.min(min, maze[row][arr[1]]);
        }
        
        ans.add(min);
        min = Integer.MAX_VALUE;
    }
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        maze = new int[rows + 1][columns + 1];
        
        int num = 1;
        
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                maze[i][j] = num++; 
            }
        }

        for(int i = 0; i < queries.length; i++){
            // 회전 및 값 구하기
            rotate(queries[i]);
            // 최솟값
            simulation(queries[i]);
        }
        
        answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}