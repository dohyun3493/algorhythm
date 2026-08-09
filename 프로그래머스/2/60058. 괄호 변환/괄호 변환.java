import java.util.*;

class Solution {
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
    
    boolean check(String u){
        Stack<Character> s = new Stack<>();
        
        for(int i = 0; i < u.length(); i++){
            if(u.charAt(i) == '(') s.add('(');
            if(u.charAt(i) == ')'){
                if(s.size() == 0) return false;
                else s.pop();
            }
        }
        
        return true;
    }
    
    String simulation(String p){
        String[] tmp = splitUV(p);
        String u = tmp[0];
        String v = tmp[1];
        
        if(u.equals("")) return "";
        
        if(check(u)){
            return u += simulation(v);            
        }else{
            String word = "(";
            word += simulation(v);
            word += ")";
            
            for(int i = 1; i < u.length() - 1; i++){
                if(u.charAt(i) == '(') word += ')';
                if(u.charAt(i) == ')') word += '(';
            }
            
            return word;
        }
    }
    
    public String solution(String p) {
        return simulation(p);
    }
}