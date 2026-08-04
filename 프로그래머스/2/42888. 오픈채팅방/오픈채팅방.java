import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] cmd = new String[record.length];
        String[] id = new String[record.length];
        String[] name = new String[record.length];
        String[] answer = {};
        List<String> tmp = new ArrayList<>();
        
        for(int i = 0; i < record.length; i++){
            String[] arr = record[i].split(" ");
            
            cmd[i] = arr[0];
            id[i] = arr[1];
            if(arr.length == 3){
                name[i] = arr[2];
            }else name[i] = "";
        }
        
        Map<String, String> m = new HashMap<>();
        
        // enter 이름 넣기 or 변경, change 이름 변경
        for(int i = 0; i < cmd.length; i++){
            if(cmd[i].equals("Enter") || cmd[i].equals("Change")){
                m.put(id[i], name[i]);
            }
        }
        
        for(int i = 0; i < cmd.length; i++){
            String key = id[i];
            
            if(cmd[i].equals("Enter")){
                tmp.add(m.get(key) + "님이 " + "들어왔습니다.");
            }
            
            if(cmd[i].equals("Leave")){
                tmp.add(m.get(key) + "님이 " + "나갔습니다.");
            }
        }
        
        answer = new String[tmp.size()];
        
        for(int i = 0; i < tmp.size(); i++){
            answer[i] = tmp.get(i);
        }
        
        return answer;
    }
}