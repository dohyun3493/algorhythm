class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int[] time = new int[4];
        
        for(int i = 0; i < 4; i++){
            String[] word = {};
            
            if(i == 0){
                word = video_len.split(":");    
            }
            if(i == 1){
                word = pos.split(":");
            }
            if(i == 2){
                word = op_start.split(":");
            }
            if(i == 3){
                word = op_end.split(":");
            }
            
            time[i] = (Integer.parseInt(word[0]) * 60) + Integer.parseInt(word[1]);
        }
        
        // time 0 -> 전체길이, 1 -> 현재시각, 2 -> 시작, 3 -> 끝
        for(int i = 0; i < commands.length; i++){
            int total = time[0];
            int cur = time[1];
            int start = time[2];
            int end = time[3];
            
            if(cur >= start && cur <= end) cur = end;
            if(commands[i].equals("next")){
                cur += 10;
            }else{
                cur -= 10;
            }
            
            if(cur <= 0) cur = 0;
            if(cur >= total) cur = total;
            if(cur >= start && cur <= end) cur = end;
            
            time[1] = cur;
        }
        
        int a = time[1] / 60;
        int b = time[1] % 60;
        
        if(a == 0) answer += "00";
        else if(a < 10){
            answer += "0";
            answer += a;
        }else{
            answer += a;
        }
        
        if(b == 0) answer += ":00";
        else if(b < 10){
            answer += ":0";
            answer += b;
        }else {
            answer += ":";
            answer += b;
        }
        
        return answer;
    }
}