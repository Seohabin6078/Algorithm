import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        // 1번째 단어의 길이가 1인 경우 체크
        if(words[0].length() == 1) {
            return new int[]{1, 1};
        }
        
        // 2번째부터 단어의 길이, 이전 단어와 이어지는지 체크, 중복되는지(set의 add의 boolean 값을 이용)
        for(int i=1; i<words.length; i++) {
            String cur = words[i];
            char first = cur.charAt(0);
            String pre = words[i-1];
            char last = pre.charAt(pre.length()-1);
            if(cur.length() == 1 || first != last || list.contains(cur)) {
                return new int[]{(i%n)+1, (i/n)+1};
            }
            list.add(cur);
        }
        return new int[]{0, 0};
    }
}