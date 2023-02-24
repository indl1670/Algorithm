import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // k: 고를 귤의 개수
        // tangerine[]: 수확한 귤
        int answer = 0; // 서로 다른 귤 종류의 수의 최솟값

        // 귤 크기에 따른 개수 정보 저장
        HashMap<Integer, Integer> tang = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++) {
            int tang_size = tangerine[i];
            if (tang.get(tang_size) == null) { // 처음 보는 귤 종류일 경우 1로 초기화
                tang.put(tang_size, 1);
            } else { // Map에 이미 저장된 귤의 종류일 경우 해당 종류 귤의 value+1
                tang.put(tang_size, tang.get(tang_size)+1);
            }
        }
        
        // HashMap 정렬을 위한 리스트 생성
        List<Integer> tang_list = new ArrayList<>(tang.keySet());
        // value의 값이 큰 순서대로 정렬
        tang_list.sort((o1, o2) -> tang.get(o2).compareTo(tang.get(o1)));
        
        // key값(== 귤 종류)에 따라 많은 종류의 귤부터 선택
        for(int key : tang_list) {
            if (k <= 0) break; // k개의 귤을 다 골랐을 경우 종료
            k -= tang.get(key); // 고른 귤의 개수만큼 차감
            answer++; // 귤 종류 수 증가
        }

        return answer;
    }
}