package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1208_Flatten {
	static int D, ans;
	// 우선순위가 낮은 숫자 순
	static PriorityQueue<Integer> max = new PriorityQueue<>();
	// 우선순위가 높은 숫자 순
	static PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			// 우선순위 큐 초기화
			max.clear();
			min.clear();
			
			// 덤프 횟수
			D = Integer.parseInt(br.readLine());
			
			// 상자 높이 배열 저장
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				int box = Integer.parseInt(st.nextToken());
				max.offer(box);
				min.offer(box);
			}
			
			// 덤프 시작
			Dump(0);
			
			System.out.println("#" + tc + " " + ans);
		}

	}
	static void Dump(int depth) {
		if (depth == D) { // 덤프 횟수 모두 소진 시 종료
			ans = min.peek() - max.peek(); // 상자 높이의 최댓값과 최솟값 차이
			return;
		}
		
		// 높이가 가장 낮은 상자
		int tempMin = max.poll();
		// 높이가 가장 높은 상자
		int tempMax = min.poll();
		
		// 높이가 가장 높은 상자 -1
		min.offer(tempMax - 1);
		// 높이가 가장 낮은 상자 + 1
		max.offer(tempMin + 1);
		
		// 덤프 횟수 1 소진
		Dump(depth+1);
	}

}
