class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        // 첫 문자인지 판별
        boolean isFirstLetter = true;
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // 첫 문자가 아닌 나며지 문자들 => 소문자
            if (Character.isUpperCase(ch)) {
                ch = Character.toLowerCase(ch);
            }
            
            // 첫 문자인 경우 => 대문자
            if (isFirstLetter) {
                ch = Character.toUpperCase(ch);
            }
            
            // 문자열 추가
            answer.append(ch);
            
            // 공백 뒤 문자 = 첫 문자 = 대문자
            if (ch == ' ') {
                isFirstLetter = true;
            } else { // 그 외 나머지 문자 = 소문자
                isFirstLetter = false;
            }
        }
        
        
        return answer.toString();
    }
}