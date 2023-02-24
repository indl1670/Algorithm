class Solution {
    public int solution(int n) {
        int answer = 1; // 최소값 == 자기 자신
				
				// 시작점이 n의 절반보다 클 경우 합이 무조건 n보다 커짐(n=15인 상태에서 시작점이 8일 경우 무조건 15보다 커지게됨)
        for(int i = 1; i <= n/2; i++) { 
            int sum = i;
            for(int j = i + 1; sum < n; j++) { // 합이 n보다 작은 경우에만 +
                sum += j;
            }
            if(sum == n) answer++; // 합이 n일 경우 answer 증가
        }
        return answer;
    }
}