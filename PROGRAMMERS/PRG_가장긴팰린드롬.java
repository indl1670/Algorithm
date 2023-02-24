import java.io.*;
import java.util.*;

class Solution
{
    public int solution(String s)
    {
        // 가장 긴 팰린드롬 길이 찾기 => 긴 부분문자열부터 팰린드롬 확인
        int answer = 0;
        
        // 1. 시작-끝 부터 팰린드롬 확인(-> s <-)
        // 2. 팰린드롬이 아닐 경우 시작 위치+1 후 1번 반복
        // 3. 팰린드롬이 아닐 경우 끝 위치-1 후 2번 반복
        
        for(int i = s.length()-1; i > 0; i--) { // 문자열 끝 위치
            for(int j = 0; j + i < s.length(); j++) { // 문자열 시작 위치
                boolean isPalindrome = true; // 팰린드롬 확인
                for(int k = 0; k <= i / 2; k++) { // 팰린드롬을 검사할 횟수(앞/뒤가 동일한 팰린드롬이므로 부분문자열 전체를 탐색할 필요 X => 부분 문자열의 반까지만 팰린드롬 확인)
                    
                    // (시작위치+k) 와 (끝위치-k) 문자 비교
                    if(s.charAt(j + k) != s.charAt(i + j - k)) { // 두 문자가 일치하지 않을 경우
                        isPalindrome = false; // 팰린드롬 아님
                        break; // 시작 위치 증가 or 끝 위치 감소
                    }
                }
                // 문자열의 경우 index 0부터 시작하므로 끝 위치+1 == 팰린드롬 길이
                if(isPalindrome) return i+1;
            }
        }
        return 1;
    }
}