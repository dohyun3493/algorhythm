// 다중집합에 대해서 자카드 유사도를 구하는 문제
// 그냥 차라리 초반에 알파벳이 아니면 전부 버려야 될듯?
import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        Set<String> s = new HashSet<>();
        
        // 두 문장씩 끊기 -> 집합 만들기
        for(int i = 0; i < str1.length() - 1; i++){
            String tmp = "";
            if(str1.charAt(i) >= 'A' && str1.charAt(i) <= 'Z'){
                if(str1.charAt(i + 1) >= 'A' && str1.charAt(i + 1) <= 'Z'){
                    tmp += str1.charAt(i);
                    tmp += str1.charAt(i + 1);
                    list1.add(tmp);
                    s.add(tmp);
                }
            }         
        }
        
        for(int i = 0; i < str2.length() - 1; i++){
            String tmp = "";
            if(str2.charAt(i) >= 'A' && str2.charAt(i) <= 'Z'){
                if(str2.charAt(i + 1) >= 'A' && str2.charAt(i + 1) <= 'Z'){
                    tmp += str2.charAt(i);
                    tmp += str2.charAt(i + 1);
                    list2.add(tmp);
                    s.add(tmp);
                }
            }
        }
        
        int union = 0;
        int intersect = 0;
        
        // 다중집합 처리 -> 자카드 유사도 계산하면 끝
        for(String w : s){
            int cnt1 = 0;
            int cnt2 = 0;
            
            for(int i = 0; i < list1.size(); i++){
                if(w.equals(list1.get(i))) cnt1++;
            }
            
            for(int i = 0; i < list2.size(); i++){
                if(w.equals(list2.get(i))) cnt2++;
            }
            
            union += Math.max(cnt1, cnt2);
            intersect += Math.min(cnt1, cnt2);
        }
        
        if(union == 0) return 65536;
        double ans = (double)intersect / (double)union;
        ans = Math.floor(ans * (double)65536);
        answer = (int)ans;
        
        return answer;
    }
}