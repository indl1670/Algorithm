package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2531_회전초밥 {
	static int N, D, K, C, cnt = 0;
	static int[] dishes;
	static Queue<Integer> sushi = new ArrayDeque<>();
	static Queue<Integer> select = new ArrayDeque<>(); 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 접시 수
		D = Integer.parseInt(st.nextToken()); // 초밥 가짓수
		K = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
		C = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		dishes = new int[D+1]; // 0 dummy
		dishes[C]++; // 쿠폰으로 먹을 수 있는 초밥 종류
		
		for (int i = 0; i < N; i++) {
			sushi.offer(Integer.parseInt(br.readLine()));
		}
		
		for (int i = 0; i < N+K-1; i++) {
			int eat = sushi.poll();
			dishes[eat]++;
			select.offer(eat); // 고객이 선택한 초밥
			sushi.offer(eat); // 컨베이어 벨트이므로 다시 큐에 삽입
			
			if (select.size() == K) { // 이벤트 충족 시
				int sum = 0;
				for (int j = 1; j <= D; j++) {
					if (dishes[j] > 0) sum++; // 먹은 초밥 종류
				}
				cnt = Math.max(cnt, sum); // 최댓값 저장
				
				int nEat = select.poll();
				dishes[nEat]--; // 제외된 접시 이전 상태로 되돌리기
			}
		}
		
		System.out.println(cnt);
	}

}
