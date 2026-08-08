import java.util.*;

class Solution {
    // u, v 분리
    String[] splitUV(String p){
        String u = "";
        String v = "";
        int cnt1 = 0;
        int cnt2 = 0;
        
        for(int i = 0; i < p.length(); i++){
            if(cnt1 != 0 && cnt1 == cnt2) break;
            u += p.charAt(i);
            
            if(p.charAt(i) == '(') cnt1++;
            if(p.charAt(i) == ')') cnt2++;
        }
        
        for(int i = cnt1 + cnt2; i < p.length(); i++) v += p.charAt(i);
        
        return new String[] {u, v};
    }
    
    // 올바른 괄호인지 확인 -> stack으로 확인
    boolean check(String u){
        Stack<Character> s = new Stack<>();
        
        if(u.charAt(0) == ')') return false;
        if(u.charAt(0) == '(') s.add(u.charAt(0));
        
        for(int i = 1; i < u.length(); i++){
            if(u.charAt(i) == '(') s.add(u.charAt(i));
            if(u.charAt(i) == ')'){
                if(s.size() == 0) return false;
                else s.pop();
            }
        }
        
        return true;
    }
    
    // 시뮬레이션
    String find(String p){
        if (p.isEmpty()) return "";
        
        String[] tmp = splitUV(p);
        String u = tmp[0];
        String v = tmp[1];
        
        if(check(u)){
            return u += find(v);
        }else{
            String word = "(";
            word += find(v);
            word += ")";
            
            // u의 첫 번째 문자와 마지막 문자 제거, 방향 뒤집기
            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') word += ")";
                else if (u.charAt(i) == ')') word += "(";
            }
            
            return word;
        }
    }
    
    public String solution(String p) {
        return find(p);
    }
}